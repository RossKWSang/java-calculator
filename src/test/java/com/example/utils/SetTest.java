package com.example.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    /*
     * 요구사항 1. Set의 size() 메소드를 활용해 Set의 크기를 확인하는
     * 학습테스트를 구현한다.
     */
    @Test
    @DisplayName("위 정의된 Set의 크기가 3이 맞는지 확인 테스트")
    void testSetSize() {
        assertThat(numbers.size())
                .isEqualTo(3);
    }

    /*
     * 요구사항 2. Set의 contains() 메소드를 활용해 1,2,3의 값이 존재하는지
     * 확인하는 학습테스트를 구현
     * JUnit의 ParameterizedTest를 활용하여 중복코드를 제거할 것
     */
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testSetContainsCertainValues(int input) {
        assertTrue(numbers.contains(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void testSetContainsCertainValuesOrNot(String integerInput, String isContainedInput) {
         int integer = Integer.parseInt(integerInput);
         boolean isContained = Boolean.parseBoolean(isContainedInput);
         assertEquals(numbers.contains(integer), isContained);
    }
}