package com.example.demo.exceptions;
import javax.persistence.EntityNotFoundException;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Band does not exist with that ID")
public class AccountNotFoundException extends EntityNotFoundException{
}
