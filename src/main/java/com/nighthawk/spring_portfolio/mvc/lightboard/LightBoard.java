package com.nighthawk.spring_portfolio.mvc.lightboard;

import lombok.Data;
import java.util.Scanner;

@Data  // Annotations to simplify writing code (ie constructors, setters)
public class LightBoard {
    private Light[][] lights;

    /* Initialize LightBoard and Lights */
    public LightBoard(int numRows, int numCols, int[] rowNumberOffList, int[] colNumberOffList) {
        String color = null;

        this.lights = new Light[numRows][numCols];
        // 2D array nested loops, used for initialization
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                int matches = 0;
                for (int i = 0; i < rowNumberOffList.length; i++) {
                    if (row == rowNumberOffList[i] && col == colNumberOffList[i]) {
                        matches++;
                    }
                }
                if (matches > 0) {
                    color = "Black";
                } else {
                    int colorIndex = (int) Math.floor(Math.random() * 7);
                    switch (colorIndex) {
                        case 0:
                            color = "Red";
                            break;
                        case 1:
                            color = "Orange";
                            break;
                        case 2:
                            color = "Yellow";
                            break;
                        case 3:
                            color = "Green";
                            break;
                        case 4:
                            color = "Blue";
                            break;
                        case 5:
                            color = "Indigo";
                            break;
                        case 6:
                            color = "Violet";
                            break;
                        default:
                            break;
                    }
                }
                Light light = new Light(color);
                lights[row][col] = light;  // each cell needs to be constructed
            }
        }
    }

    /* Output is intended for API key/values */
    public String toString() { 
        String outString = "[";
        // 2D array nested loops, used for reference
        for (int row = 0; row < lights.length; row++) {
            for (int col = 0; col < lights[row].length; col++) {
                outString += 
                // data
                "{" + 
                "\"row\": " + row + "," +
                "\"column\": " + col + "," +
                "\"light\": " + lights[row][col] +   // extract toString data
                "}," ;
            }
        }
        // remove last comma, newline, add square bracket, reset color
        outString = outString.substring(0,outString.length() - 1) + "]";
		return outString;
    }

    /* Output is intended for Terminal, effects added to output */
    public String toTerminal() { 
        String outString = "[";
        // 2D array nested loops, used for reference
        for (int row = 0; row < lights.length; row++) {
            for (int col = 0; col < lights[row].length; col++) {
                outString += 
                // reset
                "\033[m" +
                
                // color
                "\033[38;2;" + 
                lights[row][col].getRedRGB() + ";" +  // set color using getters
                lights[row][col].getGreenRGB() + ";" +
                lights[row][col].getBlueRGB() + ";" +
                lights[row][col].getEffect() + "m" +
                // data, extract custom getters
                "{" +
                "\"" + "RGB\": " + "\"" + lights[row][col].getRGB() + "\"" +
                "," +
                "\"" + "Effect\": " + "\"" + lights[row][col].getEffectTitle() + "\"" +
                "}," +
                // newline
                "\n" ;
            }
        }
        // remove last comma, newline, add square bracket, reset color
        outString = outString.substring(0,outString.length() - 2) + "\033[m" + "]";
		return outString;
    }

    /* Output is intended for Terminal, draws color palette */
    public String toColorPalette() {
        // block sizes
        final int ROWS = 6;
        final int COLS = 4;

        // Build large string for entire color palette
        String outString = "";
        // find each row
        for (int row = 0; row < lights.length; row++) {
            // repeat each row for block size
            for (int i = 0; i < ROWS + 1; i++) {
                // find each column
                for (int col = 0; col < lights[row].length; col++) {
                    // repeat each column for block size
                    for (int j = 0; j < COLS + 1; j++) {
                        // print single character, except at midpoint print color code
                        String c = (i == (int) (ROWS / 2) && j == (int) (COLS / 2) ) 
                            ? lights[row][col].getRGB()
                            : (j == (int) (COLS / 2))  // nested ternary
                            ? " ".repeat(lights[row][col].getRGB().length())
                            : " ";

                        outString += 
                        // reset
                        "\033[m" +
                        
                        // color
                        "\033[38;2;" + 
                        lights[row][col].getRedRGB() + ";" +
                        lights[row][col].getGreenRGB() + ";" +
                        lights[row][col].getBlueRGB() + ";" +
                        "7m" +

                        // color code or blank character
                        c +

                        // reset
                        "\033[m";
                    }
                }
                outString += "\n";
            }
        }
        // remove last comma, newline, add square bracket, reset color
        outString += "\033[m";
		return outString;
    }
    
    static public void main(String[] args) {
        // create and display LightBoard
        Scanner userInput = new Scanner(System.in);
        System.out.println("LightBoard On/Off Usability:");
        System.out.println("How many lights do you want to turn off?");
        int numOff = userInput.nextInt();
        int[] rowNumberOffList = new int[numOff];
        int[] colNumberOffList = new int[numOff];
        for (int i = 0; i < numOff; i++) {
            System.out.println("Enter a row number (Start at index 0):");
            int rowNumberOff = userInput.nextInt();
            System.out.println("Enter a column number (Start at index 0):");
            int colNumberOff = userInput.nextInt();
            rowNumberOffList[i] = rowNumberOff;
            colNumberOffList[i] = colNumberOff;
        }
        
        LightBoard lightBoard = new LightBoard(4, 4, rowNumberOffList, colNumberOffList);
        
        System.out.println("LightBoard Object:");
        System.out.println("------------------");
        System.out.println(lightBoard);  // use toString() method
        System.out.println("");

        System.out.println("LightBoard toTerminal():");
        System.out.println("------------------------");
        System.out.println(lightBoard.toTerminal());
        System.out.println("");

        System.out.println("LightBoard toColorPalette() (Black = Turned Off):");
        System.out.println("---------------------------");
        System.out.println(lightBoard.toColorPalette());
        System.out.println("");

    }
}