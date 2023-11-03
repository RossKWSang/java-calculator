package com.example.utils;

public class CharacterExtractor {
    private CharacterExtractor() {
        throw new IllegalStateException("유틸리티 클래스에 대한 잘못된 접근: 초기화");
    }

    public static char extract(String input, int index) {
        return input.charAt(index);
    }
}
