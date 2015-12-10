package org.kbiscanic.solutions;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day5 {

    public static void part1() throws IOException {
        Stream<String> in = Files.lines(Paths.get("src/main/resources/day5.in"));

        int cnt = 0;

        for (String s : in.filter(x -> StringUtils.countMatches(x, 'a') + StringUtils.countMatches(x, 'e') + StringUtils.countMatches(x, 'i') + StringUtils.countMatches(x, 'o') + StringUtils.countMatches(x, 'u') > 2).filter(x -> !x.contains("ab")).filter(x -> !x.contains("cd")).filter(x -> !x.contains("pq")).filter(x -> !x.contains("xy")).collect(Collectors.toList())) {
            char c = s.charAt(0);
            for (int i = 1; i < s.length(); i++) {
                if (c == s.charAt(i)) {
                    cnt++;
                    break;
                }
                c = s.charAt(i);
            }
        }
        System.out.println(cnt);
    }

    public static void part2() throws IOException {
        Stream<String> in = Files.lines(Paths.get("src/main/resources/day5.in"));

        int cnt = 0;

        for (String s : in.collect(Collectors.toList())) {
            boolean nice = false;
            for (int i = 0; i < s.length() - 2; i++) {
                if (s.charAt(i) == s.charAt(i + 2)) {
                    nice = true;
                    break;
                }
            }
            if (!nice) continue;
            for (int i = 0; i < s.length() - 2; i++) {
                String sub = s.substring(i, i + 2);
                if (s.substring(i + 2).contains(sub)) {
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
