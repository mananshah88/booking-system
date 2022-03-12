package com.mybooking.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
 
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException 
{
  public RecordNotFoundException(String exception) {
    super(exception);
  }
}

//@ExceptionHandler(value = RecordNotFoundException.class)
//public ResponseEntity handleBlogAlreadyExistsException(RecordNotFoundException recordNotFoundException) {
//    return new ResponseEntity("Record Not Found", HttpStatus.NOT_FOUND);
//}