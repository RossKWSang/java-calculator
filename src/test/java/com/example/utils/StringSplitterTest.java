package com.example.utils;

import com.example.utils.StringSplitter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.function.BiFunction;

public class StringSplitterTest {
    @Test
    @DisplayName("문자열 2개를 split한 결과를 테스트")
    public void testSplitStringWithCommaDelimiter() {
        String input = "1,2";
        String delimiter = ",";

        BiFunction<String, String, String[]> splitter = StringSplitter::splitString;
        String[] result = splitter.apply(input, delimiter);

        assertThat(result)
                .contains("1")
                .contains("2");
    }

    @Test
    @DisplayName("문자열 1개를 split한 결과를 테스트")
    public void testSplitStringWithNoDelimiter() {
        String input = "1";
        String delimiter = ",";

        BiFunction<String, String, String[]> splitter = StringSplitter::splitString;
        String[] result = splitter.apply(input, delimiter);

        assertThat(result).containsExactly("1");
    }
}
