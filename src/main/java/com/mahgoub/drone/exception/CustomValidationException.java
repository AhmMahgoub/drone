package com.mahgoub.drone.exception;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CustomValidationException {
    private static final Logger LOGGER = LogManager.getLogger(CustomValidationException.class);


}
