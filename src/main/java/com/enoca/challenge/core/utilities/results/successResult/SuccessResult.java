package server.example.javaServer.core.utilities.results.successResult;

import server.example.javaServer.core.utilities.results.Result;

public class SuccessResult extends Result {
    public SuccessResult(){
        super(true);
    }

    public SuccessResult(String message) {
        super(true, message);
    }
}
