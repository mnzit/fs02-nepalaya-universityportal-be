package com.nepalaya.up.callback;

import org.springframework.http.HttpHeaders;

@FunctionalInterface
public interface AuthCallback {

    void patch (HttpHeaders httpHeaders);
}
