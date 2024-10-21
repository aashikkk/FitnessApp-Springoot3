package com.aashik.runners.run;

public class RunNotFoundException extends RuntimeException{
    public RunNotFoundException() {
        super("run not found");
    }
}
