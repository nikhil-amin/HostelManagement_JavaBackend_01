package com.hostelmanagement.backend.exception;

public class ServiceException extends Exception{

    private String message;

    public ServiceException(){
        super();
    }

    public ServiceException(String message){
        super(message);
        this.message = message;
    }

    public ServiceException(Exception e){
        super(e);
    }

    public ServiceException(String message, Exception e){
        super(message, e);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
