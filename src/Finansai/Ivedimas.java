package Finansai;

import java.util.Scanner;

public class Ivedimas {
    Scanner scanner = new Scanner(System.in);

    String tekstas() {
        String str = scanner.nextLine();
        while (str == null || str.trim().length() == 0) {
            str = scanner.nextLine();
        }
        return str;
    }
}
