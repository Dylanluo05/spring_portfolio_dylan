package com.nighthawk.spring_portfolio.mvc.calculator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Calendar API
 * Calendar Endpoint: /api/calendar/isLeapYear/2022, Returns: {"year":2020,"isLeapYear":false}
 */
@RestController
@RequestMapping("/api/calculator")
public class CalculatorApiController {
    @GetMapping("/{expression}")
    public ResponseEntity<String> calculate(@RequestBody String expression) {
        try {
            Calculator calculatedExpression = new Calculator(expression);
            return new ResponseEntity<>(calculatedExpression.toString(), HttpStatus.ACCEPTED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Internal Error/Parsing Error, check your expression", HttpStatus.BAD_REQUEST);
        }
    }
}