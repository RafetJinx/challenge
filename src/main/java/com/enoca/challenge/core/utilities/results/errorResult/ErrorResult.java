package com.enoca.challenge.core.utilities.results.errorResult;


import com.enoca.challenge.core.utilities.results.Result;

public class ErrorResult extends Result {
    public ErrorResult(){
        super(false);
    }

    public ErrorResult(String message) {
        super(false, message);
    }
}

