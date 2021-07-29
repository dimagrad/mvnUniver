package com.company.service;

import java.util.Scanner;

public class SystemInputService {
    private static final Scanner inputScanner = new Scanner(System.in);

    public static String readLine() {

        return inputScanner.nextLine();
    }
}
