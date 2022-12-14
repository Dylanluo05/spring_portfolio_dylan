package com.nighthawk.spring_portfolio.mvc.lightboard;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/** Calendar API
 * Calendar Endpoint: /api/calendar/isLeapYear/2022, Returns: {"year":2020,"isLeapYear":false}
 */
@RestController
@RequestMapping("/api/lightboard")
public class LightBoardApiController {

    /** GET isLeapYear endpoint
     * ObjectMapper throws exceptions on bad JSON
     *  @throws JsonProcessingException
     *  @throws JsonMappingException
     */
    @GetMapping("/toString/{numRows}/{numCols}/{rowNumberOffList}/{colNumberOffList}")
    public ResponseEntity<JsonNode> toString(@PathVariable int numRows, @PathVariable int numCols, @PathVariable int[] rowNumberOffList, @PathVariable int[] colNumberOffList) throws JsonMappingException, JsonProcessingException {
      // Backend Year Object
      LightBoard lightBoardObj = new LightBoard(numRows, numCols, rowNumberOffList, colNumberOffList);
      
      // Turn Year Object into JSON
      ObjectMapper mapper = new ObjectMapper(); 
      JsonNode json = mapper.readTree(lightBoardObj.toString()); // this requires exception handling

      return ResponseEntity.ok(json);  // JSON response, see ExceptionHandlerAdvice for throws
    }

    @GetMapping("/toTerminal/{rows}/{cols}/{rowNumberOffList}/{colNumberOffList}")
    public ResponseEntity<JsonNode> toTerminal(@PathVariable int numRows, @PathVariable int numCols, @PathVariable int[] rowNumberOffList, @PathVariable int[] colNumberOffList) throws JsonMappingException, JsonProcessingException {
      // Backend Year Object
      LightBoard lightBoardObj = new LightBoard(numRows, numCols, rowNumberOffList, colNumberOffList);
      
      // Turn Year Object into JSON
      ObjectMapper mapper = new ObjectMapper(); 
      JsonNode json = mapper.readTree(lightBoardObj.toTerminal()); // this requires exception handling

      return ResponseEntity.ok(json);  // JSON response, see ExceptionHandlerAdvice for throws
    }
    
    @GetMapping("/toColorPalette/{rows}/{cols}/{rowNumberOffList}/{colNumberOffList}")
    public ResponseEntity<JsonNode> toColorPalette(@PathVariable int numRows, @PathVariable int numCols, @PathVariable int[] rowNumberOffList, @PathVariable int[] colNumberOffList) throws JsonMappingException, JsonProcessingException {
      // Backend Year Object
      LightBoard lightBoardObj = new LightBoard(numRows, numCols, rowNumberOffList, colNumberOffList);
      
      // Turn Year Object into JSON
      ObjectMapper mapper = new ObjectMapper(); 
      JsonNode json = mapper.readTree(lightBoardObj.toColorPalette()); // this requires exception handling

      return ResponseEntity.ok(json);  // JSON response, see ExceptionHandlerAdvice for throws
    }
}