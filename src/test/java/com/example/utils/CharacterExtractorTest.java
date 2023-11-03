package com.example.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CharacterExtractorTest {
    @Test
    @DisplayName("적절한 철자를 뽑았는지 테스트 & 문자열 인덱스를 벗어나는 경우 예외처리")
    void testCharacterExtractor() {
        String input = "abc";

        BiFunction<String, Integer, Character> extractor = CharacterExtractor::extract;

        assertThat(extractor.apply(input, 0))
                .isEqualTo('a');

        assertThat(extractor.apply(input, 1))
                .isEqualTo('b');

        assertThat(extractor.apply(input, 2))
                .isEqualTo('c');

        assertThrows(StringIndexOutOfBoundsException.class, () -> input.charAt(4));
    }

    @Test
    void extract_validInput_success() {
        String input = "Hello, world!";
        int index = 0;

        char character = CharacterExtractor.extract(input, index);

        Assertions.assertEquals('H', character);
    }

    @Test
    void extract_outOfBoundsIndex_throwsException() {
        String input = "Hello, world!";
        int index = input.length();

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> CharacterExtractor.extract(input, index));
    }
}
