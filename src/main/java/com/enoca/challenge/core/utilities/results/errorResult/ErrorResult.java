package server.example.javaServer.core.utilities.results.errorResult;

import server.example.javaServer.core.utilities.results.Result;

public class ErrorResult extends Result {
    public ErrorResult(){
        super(false);
    }

    public ErrorResult(String message) {
        super(false, message);
    }
}

