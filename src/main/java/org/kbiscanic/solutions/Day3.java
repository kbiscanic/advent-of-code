package org.kbiscanic.solutions;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day3 {

    public static void part1() {
        Scanner scanner = new Scanner(System.in);

        String in = scanner.next();

        Position position = new Position(0, 0);

        Set<Position> visited = new HashSet<>();

        visited.add(position);

        for (Character c : in.toCharArray()) {
            position = position.visit(c);
            visited.add(position);
        }

        System.out.println(visited.size());
    }

    public static void part2() {
        Scanner scanner = new Scanner(System.in);

        String in = scanner.next();

        Position santaPosition = new Position(0, 0);
        Position robotPosition = new Position(0, 0);

        Boolean santa = true;

        Set<Position> visited = new HashSet<>();

        visited.add(santaPosition);

        for (Character c : in.toCharArray()) {
            if (santa) {
                santaPosition = santaPosition.visit(c);
                visited.add(santaPosition);
            } else {
                robotPosition = robotPosition.visit(c);
                visited.add(robotPosition);
            }

            santa = !santa;
        }

        System.out.println(visited.size());
    }

    private static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Position visit(int c) {
            if (c == '>') return new Position(x + 1, y);
            else if (c == '<') return new Position(x - 1, y);
            else if (c == 'v') return new Position(x, y - 1);
            else return new Position(x, y + 1);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Position position = (Position) o;

            return x == position.x && y == position.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
