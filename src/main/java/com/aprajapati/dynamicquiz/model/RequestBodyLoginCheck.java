package com.aprajapati.dynamicquiz.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestBodyLoginCheck {
    private String userid;
    private String password;
}
