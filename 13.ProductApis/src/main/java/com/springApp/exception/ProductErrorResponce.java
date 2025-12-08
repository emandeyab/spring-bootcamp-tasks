package com.springApp.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductErrorResponce {
    int errorCode;
    String errorMessage;
    double timeStamp;
}
