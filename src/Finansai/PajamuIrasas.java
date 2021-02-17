package Finansai;

import java.text.ParseException;
import java.util.Date;

public class PajamuIrasas extends PinigaiAbstactClass {

    private static int kelintasPajamuIrasas = 0;

    PajamuIrasas(double suma, int uzKaGautosPajamos, int grynais, Date ivestas, String pastabos) {
        super();


        this.suma = suma;

        if (grynais == 1) {
            this.gryni = "grynaisiais";
        } else if (grynais == 0) {
            this.gryni = "i kortele";
        } else {
            Meniu.ivykoKlaidaNustatanGrynaisArKortele();
        }

        if (uzKaGautosPajamos == 1) {
            pajamos = "Atlyginimas";
        } else if (uzKaGautosPajamos == 2) {
            pajamos = "Individuali veikla";
        } else if (uzKaGautosPajamos == 3) {
            pajamos = "Būsto nuoma";
        } else if (uzKaGautosPajamos == 4) {
            pajamos = "Dovanos";
        } else if (uzKaGautosPajamos == 5) {
            pajamos = "Kita";
        } else {
            System.out.println("Neaiskios pajamos");
        }


//        this.manoData = this.manoFormatas.parse(ivestas);
        this.manoData = ivestas;

//        this.data = ("Pajamu data: " + this.manoFormatas.format(this.manoData));
        this.data = ("Pajamu data: " + this.manoData);


        this.pastabos = pastabos;

        kelintasPajamuIrasas++;

    }

    public static int getKelintasPajamuIrasas() {

        return kelintasPajamuIrasas;
    }

    void parodykInfoApiePajamas() {
        System.out.println("tai yra " + kelintasPajamuIrasas + " pajamu irasas");
        System.out.println("Pajamos gautos uz " + this.pajamos);
        System.out.println("Irasas padarytas " + this.data);
        System.out.println("Pinigai gauti " + this.gryni);
        System.out.println("Pastabos apie irasa: " + this.pastabos);
    }


}
