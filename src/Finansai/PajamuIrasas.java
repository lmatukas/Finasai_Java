package Finansai;

import java.util.Date;

public class PajamuIrasas extends PinigaiAbstactClass {
    private static int kelintasPajamuIrasas = 0;

    PajamuIrasas(double suma, int uzKaGautosPajamos, int grynais, Date ivestas, String pastabos) {
        super();

        this.suma = suma;

        if (grynais == 1) {
            this.valiuta = Konstantos.GRYNAIS;
        } else if (grynais == 0) {
            this.valiuta = Konstantos.I_KORTELE;
        } else {
            Tekstai.ivykoKlaidaNustatanGrynaisArKortele();
        }

        if (uzKaGautosPajamos == 1) {
            pajamos = Konstantos.ATLYGINIMAS;
        } else if (uzKaGautosPajamos == 2) {
            pajamos = Konstantos.INDIVIDUALI_VEIKLA;
        } else if (uzKaGautosPajamos == 3) {
            pajamos = Konstantos.BUSTO_NUOMA;
        } else if (uzKaGautosPajamos == 4) {
            pajamos = Konstantos.DOVANOS;
        } else if (uzKaGautosPajamos == 5) {
            pajamos = Konstantos.KITA;
        } else {
            System.out.println(Konstantos.NEAISKIOS_PAJAMOS);
        }

        this.manoData = ivestas;
        this.data = ("" + this.manoData);
        this.pastabos = pastabos;
        kelintasPajamuIrasas++;
    }

    public static int getKelintasPajamuIrasas() {

        return kelintasPajamuIrasas;
    }

    void parodykInfoApiePajamas() {
        Tekstai.kelintasIrasas(kelintasPajamuIrasas);
        Tekstai.uzKa(this.pajamos);
        Tekstai.data(this.data);
        Tekstai.valiuta(this.valiuta);
        Tekstai.pastabos(this.pastabos);
    }
}
