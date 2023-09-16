package server.example.javaServer.core.utilities.results.dataResult.success;

import server.example.javaServer.core.utilities.results.dataResult.DataResult;

public class SuccessDataResult<T> extends DataResult {
    public SuccessDataResult(String message, T data) {
        super(true, message, data);
    }

    public SuccessDataResult(T data){
        super(true, data);
    }

    public SuccessDataResult(String message){
        super(true, message, null);
    }

    public SuccessDataResult(){
        super(true, null);
    }
}

