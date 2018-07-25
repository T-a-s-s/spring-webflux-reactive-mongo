package br.com.neoholding.oi.garcom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OiRoleNotFoundException extends RuntimeException {
}
