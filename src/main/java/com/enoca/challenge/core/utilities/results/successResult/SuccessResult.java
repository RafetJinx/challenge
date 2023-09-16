package com.enoca.challenge.core.utilities.results.successResult;


import com.enoca.challenge.core.utilities.results.Result;

public class SuccessResult extends Result {
    public SuccessResult(){
        super(true);
    }

    public SuccessResult(String message) {
        super(true, message);
    }
}
