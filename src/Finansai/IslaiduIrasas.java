package Finansai;

import java.util.Date;

public class IslaiduIrasas extends PinigaiAbstactClass {
    private static int kelintasIslaiduIrasas = 0;
    private String islaidos;

    IslaiduIrasas(double suma, int islaiduKategorija, int grynais, Date ivestas, String pastabos) {
        super();

        this.suma = suma;

        if (grynais == 1) {
            this.valiuta = Konstantos.GRYNAIS;
        } else if (grynais == 0) {
            this.valiuta = Konstantos.I_KORTELE;
        } else {
            Tekstai.ivykoKlaidaNustatanGrynaisArKortele();
        }

        if (islaiduKategorija == 1) {
            islaidos = Konstantos.MAISTAS;
        } else if (islaiduKategorija == 2) {
            islaidos = Konstantos.TRANSPORTAS;
        } else if (islaiduKategorija == 3) {
            islaidos = Konstantos.KOMUNALINIAI;
        } else if (islaiduKategorija == 4) {
            islaidos = Konstantos.DOVANOS;
        } else if (islaiduKategorija == 5) {
            islaidos = Konstantos.PASKOLOS;
        } else if (islaiduKategorija == 6) {
            islaidos = Konstantos.LAISVALAIKIS;
        } else if (islaiduKategorija == 7) {
            islaidos = Konstantos.ASMENINES_ISLAIDOS;
        } else {
            System.out.println(Konstantos.NEAISKIOS_ISLAIDOS);
        }

        this.manoData = ivestas;
        this.data = ("" + this.manoData);
        this.pastabos = pastabos;
        kelintasIslaiduIrasas++;
    }

    public static int getKelintasIslaiduIrasas() {

        return kelintasIslaiduIrasas;
    }

    void parodykInfoapieislaidas() {
        Tekstai.kelintasIrasas(kelintasIslaiduIrasas);
        Tekstai.uzKa(this.islaidos);
        Tekstai.data(this.data);
        Tekstai.valiuta(this.valiuta);
        Tekstai.pastabos(this.pastabos);
    }
}
