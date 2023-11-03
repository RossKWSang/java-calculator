package com.example.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class ParenthesisRemoverTest {
    @Test
    @DisplayName("소괄호를 적절히 제거했는지 테스트")
    public void testSplitStringWithCommaDelimiter() {
        String input = "(1,2)";

        Function<String, String> remover = ParenthesisRemover::remove;
        String result = remover.apply(input);

        assertThat(result)
                .isEqualTo("1,2");
    }
}
