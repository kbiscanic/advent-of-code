package org.kbiscanic.solutions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day2 {

    public static void part1() {
        Scanner scanner = new Scanner(System.in);

        long sol = 0;

        while (scanner.hasNext()) {
            sol += paper(scanner.next());
        }

        System.out.println(sol);
    }

    private static long paper(String box) {
        List<Long> dims = Arrays.stream(box.split("x")).map(Long::parseLong).collect(Collectors.toList());

        Collections.sort(dims);

        return 3 * dims.get(0) * dims.get(1) + 2 * dims.get(0) * dims.get(2) + 2 * dims.get(1) * dims.get(2);
    }

    public static void part2() {
        Scanner scanner = new Scanner(System.in);

        long sol = 0;

        while (scanner.hasNext()) {
            sol += ribbon(scanner.next());
        }

        System.out.println(sol);
    }

    private static long ribbon(String box) {
        List<Long> dims = Arrays.stream(box.split("x")).map(Long::parseLong).collect(Collectors.toList());

        Collections.sort(dims);

        return 2 * dims.get(0) + 2 * dims.get(1) + dims.get(0) * dims.get(1) * dims.get(2);
    }
}
