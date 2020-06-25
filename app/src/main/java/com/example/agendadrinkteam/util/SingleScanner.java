package com.example.agendadrinkteam.util;

import java.util.Scanner;

public class SingleScanner {
    public String input = "";
    private SingleScanner() {}

    private static SingleScanner sSingleScanner = new SingleScanner();

    public Scanner getScanner() {
        return new Scanner(input);
    }

    public static SingleScanner getInstance() {
        return sSingleScanner;
    }
}
