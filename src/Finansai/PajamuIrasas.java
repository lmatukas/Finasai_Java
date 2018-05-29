package Finansai;

import java.text.ParseException;

public class PajamuIrasas extends PinigaiAbstactClass {

    private static int kelintasPajamuIrasas = 0;
//    private String data;
//    private SimpleDateFormat manoFormatas = new SimpleDateFormat("yyyy-MM-dd");
//    private Date manoData;
//    private double suma;
//    private String pastabos;
//    private String pajamos;
//    private String gryni;

    PajamuIrasas(double suma, int uzKaGautosPajamos, int grynais, String ivestas, String pastabos) throws ParseException {
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


        this.manoData = this.manoFormatas.parse(ivestas);

        this.data = ("Pajamu data: " + this.manoFormatas.format(this.manoData));

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
