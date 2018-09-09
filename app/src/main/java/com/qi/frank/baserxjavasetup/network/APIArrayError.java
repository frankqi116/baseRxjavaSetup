package com.qi.frank.baserxjavasetup.network;

public class APIArrayError {

    private String[] error;

    public String getMessage() {
        StringBuilder builder = new StringBuilder("");
        if (error != null) {
            builder.append(error[0]);
        }
        return builder.toString();
    }
}
