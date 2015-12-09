package org.kbiscanic.solutions;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

import com.codepoetics.protonpack.StreamUtils;

public class Day1 {

    public static void part1() {
        Scanner scanner = new Scanner(System.in);

        String in = scanner.next();

        System.out.println(in.chars().map(x -> x == '(' ? 1 : -1).sum());
    }

    public static void part2() {
        Scanner scanner = new Scanner(System.in);

        String in = scanner.next();

        AtomicLong sum = new AtomicLong(0);

        System.out.println(StreamUtils.zipWithIndex(in.chars().map(x -> x == '(' ? 1 : -1).mapToLong(sum::addAndGet).boxed()).filter(x -> x.getValue() < 0).findFirst().get().getIndex() + 1);
    }
}
