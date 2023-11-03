package com.example.utils;

public class StringSplitter {
    private StringSplitter() {
        throw new IllegalStateException("유틸리티 클래스에 대한 잘못된 접근: 초기화");
    }
    public static String[] splitString(String input, String delimiter) {
        return input.split(delimiter);
    }
}
