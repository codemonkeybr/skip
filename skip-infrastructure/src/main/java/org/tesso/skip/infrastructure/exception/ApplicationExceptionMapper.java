package org.tesso.skip.infrastructure.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Component
public class ApplicationExceptionMapper {

    private final Logger LOGGER = LoggerFactory.getLogger(ApplicationExceptionMapper.class);

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity.HeadersBuilder handleControllerException(Exception exception) {
        LOGGER.error(exception.getMessage(), exception);

        return ResponseEntity.notFound();
    }

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity.HeadersBuilder handleControllerException(NotFoundException notFoundException) {
        return ResponseEntity.notFound();
    }

}
