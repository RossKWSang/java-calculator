package com.example.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParsingCalculatorTest {

    int parseAndSum(String input) {
        Function<String, Integer> calculator = ParsingCalculator::parseAndSum;
        return calculator.apply(input);
    }

    @Test
    @DisplayName("공백문자를 넣을 경우 0을 출력")
    void emptyString() {
        assertEquals(0, parseAndSum(""));
    }

    @Test
    @DisplayName("단일 문자 테스트")
    void singleNumber() {
        assertEquals(1, parseAndSum("1"));
    }

    @Test
    @DisplayName("복수 문자 테스트")
    void multipleNumbers() {
        assertEquals(6, parseAndSum("1,2,3"));
    }

    @Test
    @DisplayName("음수 포함시 런타임 에러")
    void negativeNumber() {
        assertThrows(RuntimeException.class, () -> parseAndSum("1,-2,3"));
    }

    @Test
    @DisplayName("숫자가 아닌 문자를 포함시 런타임 에러")
    void nonNumericString() {
        assertThrows(RuntimeException.class, () -> parseAndSum("a,b,c"));
    }

}
