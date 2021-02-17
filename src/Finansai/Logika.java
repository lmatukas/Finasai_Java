package Finansai;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Logika {

    public SimpleDateFormat manoFormatas = new SimpleDateFormat("yyyy-MM-dd");
    Scanner scanner = new Scanner(System.in);
    Ivedimas ivedimas = new Ivedimas();
    PajamuIrasas[] pajamuIraoMasyvas = new PajamuIrasas[3];
    IslaiduIrasas[] islaiduIrasoMasyvas = new IslaiduIrasas[3];
    boolean veikia = true;
    boolean ivestiesMeniu = true;
    boolean kiekPinigu = true;
    boolean gryni = true;
    boolean papildomaInfo = true;
    boolean smulkesneInformacija = true;
    boolean pajamamosArIslaidos = true;
    boolean date = true;
    private double balansasKortele;
    private double balansasGrynais;
    private double balansas;
    private double suma;
    private int uzKa;
    private int valiutosID;
    private Date data;
    private String pastabos;
    boolean pilnaVersija = true;

    void pajamosIMasyva(PajamuIrasas[] pajamuIraoMasyvas, PajamuIrasas a) {


        for (int i = 0; i < pajamuIraoMasyvas.length; i++) {
            if (pajamuIraoMasyvas[i] == null) {
                pajamuIraoMasyvas[i] = a;
                Meniu.irasasIsaugotas();
                break;
            }
            if (pajamuIraoMasyvas[pajamuIraoMasyvas.length-1] != null){
                Meniu.arPirksitePilnaVessija();
                pilnaVersija = true;
                while (pilnaVersija){
                    try {
                        Meniu.arPirksitePilnaVessija();
                        String skaicius_ = ivedimas.teksta();
                        int pirkti = Integer.parseInt(skaicius_);
                        if (pirkti == 2) {
                            Meniu.pasirinkoteNepirkti();
                            return;
                        } else if (pirkti == 1) {
                            PajamuIrasas[] laikinasMasyvas = new PajamuIrasas[pajamuIraoMasyvas.length * 2];
                            for (int j = 0; j < pajamuIraoMasyvas.length; j++) {
                                laikinasMasyvas[i] = pajamuIraoMasyvas[i];
                            }
                            pajamuIraoMasyvas = laikinasMasyvas;
                            pilnaVersija = false;
                        } else {
                            Meniu.pasirinkoteNesuprantamaKomanda();
                        }
                    } catch (Exception e) {
                    }
                }
            }

        }

    }

    void generuojamasNaujasIrasoObjektas(double suma, int uzKaGautosPajamos, int grynais, Date data, String pastabos) {
        PajamuIrasas naujas;
        naujas = new PajamuIrasas(suma, uzKaGautosPajamos, grynais, data, pastabos);
        pajamosIMasyva(pajamuIraoMasyvas, naujas);

    }

    void islaidosMasyvas(IslaiduIrasas[] islaiduIrasoMasyvas, IslaiduIrasas a) {
        for (int i = 0; i < islaiduIrasoMasyvas.length; i++) {
            if (islaiduIrasoMasyvas[i] == null) {
                islaiduIrasoMasyvas[i] = a;
                Meniu.irasasIsaugotas();
                break;
            }

            Meniu.arPirksitePilnaVessija();

            try {
                String skaicius_ = ivedimas.teksta();
                int pirkti = Integer.parseInt(skaicius_);
                if (pirkti == 2) {
                    Meniu.pasirinkoteNepirkti();
                    return;
                } else if (pirkti == 1) {
                    IslaiduIrasas[] laikinasMasyvas = new IslaiduIrasas[islaiduIrasoMasyvas.length * 2];
                    for (int j = 0; j < islaiduIrasoMasyvas.length; j++) {
                        laikinasMasyvas[i] = islaiduIrasoMasyvas[i];
                    }
                    islaiduIrasoMasyvas = laikinasMasyvas;
                }
            } catch (Exception e) {
            }

        }

    }

    void generuojamasNaujasIslaiduObjektas(double suma, int islaiduKategorija, int grynais, Date data, String pastabos) {
        IslaiduIrasas naujas;
        naujas = new IslaiduIrasas(suma, islaiduKategorija, grynais, data, pastabos);
        islaidosMasyvas(islaiduIrasoMasyvas, naujas);
    }

    void ivedimoLogika() {
        iveskitePiniguSuma();
        gryniArKortele();
        datosIvedimas();
        papildomInfoIvedama();
    }

    private void datosIvedimas() {

        date = true;
        while (date) {

            Meniu.iveskiteDataFormatu();

            try {
                String dataLaikina = ivedimas.teksta();
                this.data = this.manoFormatas.parse(dataLaikina);
                date = false;
            } catch (ParseException e) {
                Meniu.nerinkamasDatosFormatas();
            }
        }
    }

    private void papildomInfoIvedama() {
        papildomaInfo = true;
        while (papildomaInfo) {
            Meniu.informacijApiePinigus();
            String pastab = ivedimas.teksta();
            this.pastabos = pastab;
            papildomaInfo = false;
        }
    }

    private void gryniArKortele() {
        gryni = true;
        while (gryni) {

            try {
                Meniu.pajamosGrynaisArKortele();
                String skaicius_ = ivedimas.teksta();
                int cashas = Integer.parseInt(skaicius_);

                if (cashas == 0) {
                    this.valiutosID = 0;
                    gryni = false;
                } else if (cashas == 1) {
                    this.valiutosID = 1;
                    gryni = false;
                } else {
                    Meniu.pasirinkoteNesuprantamaKomanda();
                }

            } catch (Exception e) {

                scanner.reset();
                Meniu.kaVedi();
            }
        }
    }

    private void iveskitePiniguSuma() {
        kiekPinigu = true;
        while (kiekPinigu) {
            try {
                Meniu.iveskiteKiekPinigu();

                String skaicius_ = ivedimas.teksta();
                double skaicius = Double.parseDouble(skaicius_);
                if (skaicius >= 0) {
                    this.suma = skaicius;
                    kiekPinigu = false;
                }
            } catch (Exception e) {
                scanner.reset();
                Meniu.kaVedi();
            }
        }
    }

    void paleidimas() {
        veikia = true;
        while (veikia) {
            try {
                Meniu.pagrindinisMeniu();
                String skaicius_ = ivedimas.teksta();
                int meniuPasirinkiams = Integer.parseInt(skaicius_);
                if (meniuPasirinkiams == 1) {
                    pasirinkta1IvestiPajamas();
                } else if (meniuPasirinkiams == 2) {
                    pasirinkta2IvestiIslaidas();
                } else if (meniuPasirinkiams == 3) {
                    pasirinkta3PerziuretiBalansa();
                } else if (meniuPasirinkiams == 0) {
                    Meniu.pasirinkoteVisoGeriausio();
                    return;
                } else {
                    Meniu.pasirinkoteNesuprantamaKomanda();
                }
            } catch (Exception e) {
                scanner.reset();
                Meniu.kaVedi();
            }
        }

    }

    private void pasirinkta3PerziuretiBalansa() {

        Meniu.pasirinkotePerziuretiBalansa();

        islaidosVaizduojamosCia();

        smulkesneInformacija = true;

        while (smulkesneInformacija) {
            Meniu.smulkesneInformacijaApiePajamasIrIslaidas();

            int i = scanner.nextInt();
            if (i == 1) {

                pajamamosArIslaidos = true;
                while (pajamamosArIslaidos) {
                    Meniu.pajamosArIslaidos();

                    int j = scanner.nextInt();
                    if (j == 1) {
                        Meniu.kuriIrasaNoresitePerziureti();
                        int k = scanner.nextInt();

                        if (k == 0) {

                            for (int k2 = 0; k2 < pajamuIraoMasyvas.length; k2++) {
                                if (pajamuIraoMasyvas[k2] != null) {
                                    pajamuIraoMasyvas[k2].parodykInfoApiePajamas();
                                }


                            }
                            if (PajamuIrasas.getKelintasPajamuIrasas() == 0) {
                                Meniu.irasuNera();
                            }

                            pajamamosArIslaidos = false;

                        } else if (k > 0 && pajamuIraoMasyvas[k - 1] != null) {
                            pajamuIraoMasyvas[k - 1].parodykInfoApiePajamas();
                            pajamamosArIslaidos = false;
                        } else {
                            Meniu.neraTokioIraso();
                            pajamamosArIslaidos = false;
                        }

                    } else if (j == 2) {
                        Meniu.kuriIrasaNoresitePerziureti();
                        int k = scanner.nextInt();

                        if (k == 0) {

                            for (int k2 = 0; k2 < islaiduIrasoMasyvas.length; k2++) {
                                if (islaiduIrasoMasyvas[k2] != null) {
                                    islaiduIrasoMasyvas[k2].parodykInfoapieislaidas();
                                }

                            }
                            if (IslaiduIrasas.getKelintasIslaiduIrasas() == 0) {
                                Meniu.neraTokioIraso();
                            }

                            pajamamosArIslaidos = false;
                        } else if (k > 0 && pajamuIraoMasyvas[k - 1] != null) {
                            islaiduIrasoMasyvas[k - 1].parodykInfoapieislaidas();
                            pajamamosArIslaidos = false;
                        } else {
                            Meniu.neraTokioIraso();
                            pajamamosArIslaidos = false;
                        }

                    }

                }

                smulkesneInformacija = false;

            } else if (i == 2) {
                smulkesneInformacija = false;
            }
        }
    }

    private void pasirinkta2IvestiIslaidas() {
        Meniu.pasirinkteIvestiIslaidas();
        ivestiesMeniu = true;

        while (ivestiesMeniu) {
            try {
                Meniu.islaiduMeniu();
                String skaicius_ = ivedimas.teksta();
                int j = Integer.parseInt(skaicius_);
                if (j > 0 && j < 8) {
                    this.uzKa = j;
                    Meniu.informacijApiePinigus();
                    ivedimoLogika();
                    generuojamasNaujasIslaiduObjektas(this.suma, this.uzKa, this.valiutosID, this.data, this.pastabos);
                    balansoSkaiciavimas(false);
                    ivestiesMeniu = false;
                } else if (j == 9) {
                    ivestiesMeniu = false;
                } else if (j == 0) {
                    Meniu.pasirinkoteVisoGeriausio();
                    return;
                } else {
                    Meniu.pasirinkoteNesuprantamaKomanda();
                }
            } catch (Exception e) {
                scanner.reset();
                Meniu.kaVedi();
            }
        }
    }

    private void balansoSkaiciavimas(boolean arPajamos) {
        if (arPajamos){
            if (valiutosID == 1) {
                this.balansasGrynais = this.balansasGrynais + this.suma;
                this.balansas = this.balansas + this.suma;
            } else if (valiutosID == 0) {
                this.balansasKortele = this.balansasKortele + this.suma;
                this.balansas = this.balansas + this.suma;
            }

        }else {
            if (valiutosID == 1) {
                this.balansasGrynais = this.balansasGrynais - this.suma;
                this.balansas = this.balansas - this.suma;
            } else if (valiutosID == 0) {
                this.balansasKortele = this.balansasKortele - this.suma;
                this.balansas = this.balansas - this.suma;
            }
        }

    }

    private void pasirinkta1IvestiPajamas() {

        Meniu.pasirinkoteIvestiPajamas();
        ivestiesMeniu = true;

        while (ivestiesMeniu) {
            try {
                Meniu.pajamuMeniu();
                String skaicius_ = ivedimas.teksta();
                int j = Integer.parseInt(skaicius_);

                if (j > 0 && j <= 5) {
                    this.uzKa = j;
                    Meniu.informacijApiePinigus();
                    ivedimoLogika();
                    generuojamasNaujasIrasoObjektas(this.suma, this.uzKa, this.valiutosID, this.data, this.pastabos);
                    balansoSkaiciavimas(true);
                    ivestiesMeniu = false;

                } else if (j == 9) {
                    ivestiesMeniu = false;
                } else if (j == 0) {
                    Meniu.pasirinkoteVisoGeriausio();
                    return;
                } else {
                    Meniu.pasirinkoteNesuprantamaKomanda();
                }

            }catch (Exception e) {
                scanner.reset();
                Meniu.kaVedi();
            }
        }
    }

    private void islaidosVaizduojamosCia() {

        System.out.println();
        System.out.println(this.balansas + " EUR - bendras balansas");
        System.out.println(this.balansasKortele + " EUR - korteles balansas");
        System.out.println(this.balansasGrynais + " EUR - grynu balansas");
        System.out.println();
    }


}
