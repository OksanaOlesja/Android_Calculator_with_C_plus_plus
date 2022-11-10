package com.example.calculator;

public class JNIHelloWorld {
    native void printHelloWorld();
    native int printHelloFromCNumber();
    static {
        System.loadLibrary("calculator");
    }
}