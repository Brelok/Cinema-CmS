package com.github.brelok.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static Logger LOG = LoggerFactory.getLogger(RuntimeException.class);

////    @ExceptionHandler(RuntimeException.class)
////    @ResponseBody
////    public String handleRuntimeException(RuntimeException e) {
////        LOG.error("RUNTIME EXCEPTION: " + e.getMessage());
////        return new StringBuilder().append(e.getMessage()).toString();
//    }

//    @ExceptionHandler(ResourceNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public String handleResourceBotFoundException(ResourceNotFoundException e){
//        LOG.error("RESOURCE NOT FOUND: " + e.getMessage());
//        return "404";
//    }

//     @ExceptionHandler(NoHandlerFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public String handleResourceBotFoundException(NoHandlerFoundException e){
//        LOG.error("RESOURCE NOT FOUND: " + e.getMessage());
//        return "404";
//    }

}


