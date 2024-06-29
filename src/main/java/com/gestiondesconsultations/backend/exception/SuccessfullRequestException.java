package com.gestiondesconsultations.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.OK)
public class SuccessfullRequestException extends RuntimeException {
    public SuccessfullRequestException(String message){
        super(message);
    }
}
