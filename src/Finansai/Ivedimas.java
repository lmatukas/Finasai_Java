package Finansai;

import java.util.Scanner;

public class Ivedimas {
    Scanner scanner = new Scanner(System.in);

    String iveskData() {
        Meniu.iveskiteDataFormatu();
        String str = scanner.nextLine();
        while (str == null || str.trim().length() == 0) {
            str = scanner.nextLine();
        }
        return str;
    }
    String teksta() {
        String str = scanner.nextLine();
        while (str == null || str.trim().length() == 0) {
            str = scanner.nextLine();
        }
        return str;
    }

    int iveskSkaiciu() {
        System.out.println("Iveskite skaiciu:");
        return scanner.nextInt();
    }

}
