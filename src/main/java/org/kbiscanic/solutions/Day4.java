package org.kbiscanic.solutions;

import com.codepoetics.protonpack.StreamUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Day4 {

    public static void part1() {
        Scanner scanner = new Scanner(System.in);

        String in = scanner.next();

        System.out.println(StreamUtils.zipWithIndex(StreamUtils.indices().mapToObj(i -> md5(in + Long.toString(i)))).filter(x -> x.getValue().startsWith("00000")).findFirst().get().getIndex());
    }

    public static void part2() {
        Scanner scanner = new Scanner(System.in);

        String in = scanner.next();

        System.out.println(StreamUtils.zipWithIndex(StreamUtils.indices().mapToObj(i -> md5(in + Long.toString(i)))).filter(x -> x.getValue().startsWith("000000")).findFirst().get().getIndex());
    }

    public static String md5(String string) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        assert md != null;
        md.update(string.getBytes());
        byte[] digest = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }
}
