package Finansai;

import java.text.ParseException;
import java.util.Date;

public class IslaiduIrasas extends PinigaiAbstactClass {

    private static int kelintasIslaiduIrasas = 0;

    private String islaidos;

    IslaiduIrasas(double suma, int islaiduKategorija, int grynais, Date ivestas, String pastabos) throws ParseException {
        super();

        this.suma = suma;

        if (grynais == 1) {
            this.gryni = "grynais";
        } else if (grynais == 0) {
            this.gryni = "kortele";
        } else {
            Meniu.ivykoKlaidaNustatanGrynaisArKortele();
        }

        if (islaiduKategorija == 1) {
            islaidos = "Maistas";
        } else if (islaiduKategorija == 2) {
            islaidos = "Transportas";
        } else if (islaiduKategorija == 3) {
            islaidos = "Komunaliniai mokesčiai";
        } else if (islaiduKategorija == 4) {
            islaidos = "Dovanos";
        } else if (islaiduKategorija == 5) {
            islaidos = "Paskolos";
        } else if (islaiduKategorija == 6) {
            islaidos = "Laisvalaikis";
        } else if (islaiduKategorija == 7) {
            islaidos = "Asmeninės išlaidos";
        } else {
            System.out.println("Neaiskios islaidos");
        }

//        this.manoData = this.manoFormatas.parse(ivestas);
        this.manoData = ivestas;

//        this.data = ("Pajamu data: " + this.manoFormatas.format(this.manoData));

        this.pastabos = pastabos;

        kelintasIslaiduIrasas++;

    }

    public static int getKelintasIslaiduIrasas() {

        return kelintasIslaiduIrasas;
    }

    void parodykInfoapieislaidas() {
        System.out.println("tai yra " + kelintasIslaiduIrasas + " islaidu irasas");
        System.out.println("Pinigus isleidote " + this.islaidos);
        System.out.println("Irasas padarytas " + this.data);
        System.out.println("Pinigai gauti " + this.gryni);
        System.out.println("Pastabos apie irasa: " + this.pastabos);
    }
}
