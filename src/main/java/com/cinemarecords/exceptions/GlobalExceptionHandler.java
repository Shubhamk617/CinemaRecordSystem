/*
 * package com.cinemarecords.exceptions;
 * 
 * import java.util.Date;
 * 
 * import org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.ControllerAdvice; import
 * org.springframework.web.bind.annotation.ExceptionHandler;
 * 
 * @ControllerAdvice public class GlobalExceptionHandler {
 * 
 * @ExceptionHandler public ResponseEntity<ExceptionResponse>
 * handleMovieNotFoundException(MovieNotFoundException exc) { ExceptionResponse
 * exResponse = new ExceptionResponse(); exResponse.setTimestamp(new Date());
 * exResponse.setMessage(exc.getMessage());
 * exResponse.setDetails(exc.getLocalizedMessage());
 * 
 * return new ResponseEntity<ExceptionResponse>(exResponse,
 * HttpStatus.NOT_FOUND); }
 * 
 * @ExceptionHandler public ResponseEntity<ExceptionResponse>
 * handleGenericException(Exception exc) { ExceptionResponse exResponse = new
 * ExceptionResponse(); exResponse.setTimestamp(new Date());
 * exResponse.setMessage(exc.getMessage());
 * exResponse.setDetails(exc.getLocalizedMessage());
 * 
 * return new ResponseEntity<ExceptionResponse>(exResponse,
 * HttpStatus.BAD_REQUEST); } }
 */