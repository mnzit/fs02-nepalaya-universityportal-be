package com.nepalaya.up.exception;

import com.nepalaya.up.constant.ResponseMsgConstant;
import org.springframework.security.core.AuthenticationException;

public class AuthenticationFailedException extends AuthenticationException {
    public AuthenticationFailedException() {
        super(ResponseMsgConstant.UNAUTHORIZED);
    }
}
