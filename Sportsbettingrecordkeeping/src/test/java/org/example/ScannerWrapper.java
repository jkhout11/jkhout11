package org.example;

import java.util.Scanner;

public class ScannerWrapper implements InputReader {
    private final Scanner scanner;

    public ScannerWrapper(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readLine() {
        return scanner.nextLine();
    }
}

