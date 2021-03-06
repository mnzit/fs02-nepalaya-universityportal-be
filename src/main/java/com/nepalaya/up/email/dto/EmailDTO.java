package com.nepalaya.up.email.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class EmailDTO implements Serializable {

    private String from;
    private String to;
    private List<String> cc;
    private List<String> bcc;
    private String subject;
    private Object data;


    public EmailDTO(String to, String subject, Object data) {
        this.to = to;
        this.subject = subject;
        this.data = data;
    }
}
