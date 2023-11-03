package com.example.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsingCalculator {
    private ParsingCalculator() {
        throw new IllegalStateException("유틸리티 클래스에 대한 잘못된 접근: 초기화");
    }

    public static int parseAndSum(String str) {
        Pattern pattern = Pattern.compile("[^,|:]");
        Matcher matcher = pattern.matcher(str);

        List<String> tokens = new ArrayList<>();
        while (matcher.find()) {
            tokens.add(matcher.group());
        }

        int sum = 0;
        for (String token : tokens) {
            try {
                int number = Integer.parseInt(token);
                if (number < 0) {
                    throw new RuntimeException("음수 값은 허용되지 않습니다.");
                }
                sum += number;
            } catch (NumberFormatException e) {
                throw new RuntimeException("숫자 이외의 값은 허용되지 않습니다.");
            }
        }
        return sum;
    }
}
