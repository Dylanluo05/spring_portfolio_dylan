package com.nighthawk.spring_portfolio.mvc.calendar;
import java.util.*;

/** Simple POJO 
 * Used to Interface with APCalendar
 * The toString method(s) prepares object for JSON serialization
 * Note... this is NOT an entity, just an abstraction
 */
class Year {
   private int year;
   private boolean isLeapYear;
   private int firstDayOfYear;

   private int year1;
   private int year2;
   private int numberOfLeapYears;

   private int year3;
   private int month3;
   private int day3;
   private int dayOfYear;

   private int year4;
   private int month4;
   private int day4;
   private int dayOfWeek;

   // zero argument constructor
   public Year() {} 

   /* year getter/setters */
   public int getYear() {
      return year;
   }

   public void setYear(int year) {
      this.year = year;
      this.setIsLeapYear(year);
      this.setFirstDayOfYear(year);
   }

   public int getYear1() {
      return year1;
   }

   public int getYear2() {
      return year2;
   }

   public void setYears(int year1, int year2) {
      this.year1 = year1;
      this.year2 = year2;
      this.setNumberOfLeapYears(year1, year2);
   }

   public int getYear3() {
      return year3;
   }

   public int getMonth3() {
      return month3;
   }

   public int getDay3() {
      return day3;
   }

   public void setDate(int month3, int day3, int year3) {
      this.month3 = month3;
      this.day3 = day3;
      this.year3 = year3;
      this.setDayOfYear(month3, day3, year3);
   }

   public int getYear4() {
      return year4;
   }

   public int getMonth4() {
      return month4;
   }

   public int getDay4() {
      return day4;
   }

   public void setDate2(int month4, int day4, int year4) {
      this.month4 = month4;
      this.day4 = day4;
      this.year4 = year4;
      this.setDayOfWeek(month4, day4, year4);
   }

   /* isLeapYear getter/setters */
   public boolean getIsLeapYear(int year) {
      return APCalendar.isLeapYear(year);
   }
   private void setIsLeapYear(int year) {  // this is private to avoid tampering
      this.isLeapYear = APCalendar.isLeapYear(year);
   }

   public int getFirstDayOfYear(int year) {
      return APCalendar.firstDayOfYear(year);
   }
   private void setFirstDayOfYear(int year) {  // this is private to avoid tampering
      this.firstDayOfYear = APCalendar.firstDayOfYear(year);
   }

   public int getNumberOfLeapYears(int year1, int year2) {
      return APCalendar.numberOfLeapYears(year1, year2);
   }

   public void setNumberOfLeapYears(int year1, int year2) {
      this.numberOfLeapYears = APCalendar.numberOfLeapYears(year1, year2);
   }

   public int getDayOfYear(int month3, int day3, int year3) {
      return APCalendar.dayOfYear(month3, day3, year3);
   }

   public void setDayOfYear(int month3, int day3, int year3) {
      this.dayOfYear = APCalendar.dayOfYear(month3, day3, year3);
   }

   public int getDayOfWeek(int month4, int day4, int year4) {
      return APCalendar.dayOfWeek(month4, day4, year4);
   }

   public void setDayOfWeek(int month4, int day4, int year4) {
      this.dayOfWeek = APCalendar.dayOfWeek(month4, day4, year4);
   }

   public String isLeapYearToString(){
      return ( "{ \"year\": "  + this.year+  ", " + "\"isLeapYear\": "  + this.isLeapYear + " }");
   }

   public String firstDayOfYearToString() {
      return ( "{ \"year\": "  + this.year+  ", " + "\"firstDayOfYear\": "  + this.firstDayOfYear + " }");
   }

   public String numberOfLeapYearsToString() {
      return ( "{ \"year1\": "  + this.year1 +  ", " + "\"year2\": "  + this.year2 + ", " + "\"numberOfLeapYears\": "  + this.numberOfLeapYears + " }");
   }

   public String dayOfYearToString() {
      return ( "{ \"month3\": "  + this.month3 +  ", " + "\"day3\": "  + this.day3 + ", " + "\"year3\": "  + this.year3 + ", " + "\"dayOfYear\": "  + this.dayOfYear + " }");
   }

   public String dayOfWeekToString() {
      return ( "{ \"month4\": "  + this.month4 +  ", " + "\"day4\": "  + this.day4 + ", " + "\"year4\": "  + this.year4 + ", " + "\"dayOfWeek\": "  + this.dayOfWeek + " }");
   }

   public String toString() { 
      return isLeapYearToString(); 
   }

   public static void main(String[] args) {
      Year year = new Year();
      Scanner userInput = new Scanner(System.in);
      System.out.println("Enter a year to check if it is a leap year:");
      int yearInput1 = userInput.nextInt();
      year.setYear(yearInput1);

      System.out.println("Enter year 1:");
      int yearInput2 = userInput.nextInt();
      System.out.println("Enter year 2:");
      int yearInput3 = userInput.nextInt();
      year.setYears(yearInput2, yearInput3);

      System.out.println("Enter a year:");
      int yearInput4 = userInput.nextInt();
      System.out.println("Enter a month:");
      int monthInput4 = userInput.nextInt();
      System.out.println("Enter a day:");
      int dayInput4 = userInput.nextInt();
      year.setDate(monthInput4, dayInput4, yearInput4);

      System.out.println("Enter a year:");
      int yearInput5 = userInput.nextInt();
      System.out.println("Enter a month:");
      int monthInput5 = userInput.nextInt();
      System.out.println("Enter a day:");
      int dayInput5 = userInput.nextInt();
      year.setDate2(monthInput5, dayInput5, yearInput5);

      System.out.println(year);
   }
}
