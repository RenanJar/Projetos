package com.school.entidade.exceptions;

public class DomainExceptions extends NoStackTraceException{

    private static final String type = "DOMAIN";

    private DomainExceptions(String message) {
        super(message);
    }

    public static DomainExceptions throwException(String message, String locale) {
        String messageConcat = type +"_"+ locale + ": " + message;
        return new DomainExceptions(messageConcat);
    }

}
