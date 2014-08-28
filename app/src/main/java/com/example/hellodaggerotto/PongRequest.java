package com.example.hellodaggerotto;

/**
 * Created by maia on 2014/08/28.
 */
public class PongRequest {
    public String getMessage() {
        return message;
    }

    private final String message;

    public PongRequest(String s) {
        this.message = s;
    }
}
