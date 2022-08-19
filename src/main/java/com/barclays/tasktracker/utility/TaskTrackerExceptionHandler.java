package com.barclays.tasktracker.utility;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.barclays.tasktracker.exception.TaskTrackerException;

@ControllerAdvice
public class TaskTrackerExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> ExceptionHandler(Exception exception) {
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage("Request could not be processed");
		error.setErrorCode(HttpStatus.ACCEPTED.value());
		error.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(TaskTrackerException.class)
	public ResponseEntity<ErrorInfo> ExceptionHandlerTaskTracker(TaskTrackerException e) {
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage(e.getMessage());
		error.setTimestamp(LocalDateTime.now());
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
