package com.example.utils;

public class ParenthesisRemover {
    private ParenthesisRemover() {
        throw new IllegalStateException("유틸리티 클래스에 대한 잘못된 접근: 초기화");
    }
    public static String remove(String input) {
        return input.substring(1, input.length() - 1);
    }
}
