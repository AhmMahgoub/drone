package com.mahgoub.drone.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ControllerAdvice
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BusinessException extends  RuntimeException{

    private static final Logger LOGGER = LogManager.getLogger(BusinessException.class);

    private String arabicProviderMessage;
    private String englishProviderMessage;


    public BusinessException() {
    }

    public BusinessException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public BusinessException(String errorMessage) {
        super(errorMessage);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> GeneralException(BusinessException ex) {
        ResponseEntity<Object> responseEntity;
        ApiError apiError =new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage());
        LOGGER.error("ERROR",ex);
        LOGGER.error(apiError);
        return  ResponseEntity.badRequest().body(apiError);
    }


}
