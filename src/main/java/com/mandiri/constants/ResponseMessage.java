package com.mandiri.constants;

public class ResponseMessage {
    public static final String RESOURCE_NOT_FOUND = "%s With ID= %s is not found";

    public static String getResourceNotFound(String className, String id){
        return String.format(RESOURCE_NOT_FOUND,className, id);
    }
}
