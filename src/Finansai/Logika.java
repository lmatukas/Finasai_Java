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
    boolean visasArDalisIrasu = true;
    boolean date = true;
    private double balansasKortele;
    private double balansasGrynais;
    private double balansas;
    private double suma;
    private int uzKa;
    private int valiutosID;
    private Date data;
    private String pastabos;

    void pajamosIMasyva(PajamuIrasas[] pajamuIraoMasyvas, PajamuIrasas a) {

        if (pajamuIraoMasyvas[pajamuIraoMasyvas.length - 1] != null) {
            Meniu.irasasNeIsaugotas();
            return;
        }

        for (int i = 0; i < pajamuIraoMasyvas.length; i++) {

            if (pajamuIraoMasyvas[i] == null) {
                pajamuIraoMasyvas[i] = a;
                Meniu.irasasIsaugotas();
                break;
            }
        }

        if (pajamuIraoMasyvas[pajamuIraoMasyvas.length - 1] != null) {
            Meniu.paskutinisIrasas();
        }
    }

    void generuojamasNaujasIrasoObjektas(double suma, int uzKaGautosPajamos, int grynais, Date data, String pastabos) {
        PajamuIrasas naujas;
        naujas = new PajamuIrasas(suma, uzKaGautosPajamos, grynais, data, pastabos);
        pajamosIMasyva(pajamuIraoMasyvas, naujas);

    }

    void islaidoIMasyva(IslaiduIrasas[] islaiduIrasoMasyvas, IslaiduIrasas a) {

        if (islaiduIrasoMasyvas[islaiduIrasoMasyvas.length - 1] != null) {
            Meniu.irasasNeIsaugotas();
            return;
        }

        for (int i = 0; i < islaiduIrasoMasyvas.length; i++) {
            if (islaiduIrasoMasyvas[i] == null) {
                islaiduIrasoMasyvas[i] = a;
                Meniu.irasasIsaugotas();
                break;
            }
        }

        if (islaiduIrasoMasyvas[islaiduIrasoMasyvas.length - 1] != null) {
            Meniu.paskutinisIrasas();
        }

    }

    void generuojamasNaujasIslaiduObjektas(double suma, int islaiduKategorija, int grynais, Date data, String pastabos) {
        IslaiduIrasas naujas;
        naujas = new IslaiduIrasas(suma, islaiduKategorija, grynais, data, pastabos);
        islaidoIMasyva(islaiduIrasoMasyvas, naujas);
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
                String dataLaikina = ivedimas.tekstas();
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
            String pastab = ivedimas.tekstas();
            this.pastabos = pastab;
            papildomaInfo = false;
        }
    }

    private void gryniArKortele() {
        gryni = true;
        while (gryni) {

            try {
                Meniu.pajamosGrynaisArKortele();
                String skaicius_ = ivedimas.tekstas();
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

                String skaicius_ = ivedimas.tekstas();
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
                String skaicius_ = ivedimas.tekstas();
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

            try {
                String skaicius_ = ivedimas.tekstas();
                int i = Integer.parseInt(skaicius_);

                if (i == 1) {
                    pajamamosArIslaidos = true;

                    while (pajamamosArIslaidos) {
                        Meniu.pajamosArIslaidos();

                        try {

                            String skaicius2 = ivedimas.tekstas();
                            int j = Integer.parseInt(skaicius2);

                            if (j == 1) {
                                visasArDalisIrasu = true;
                                while (visasArDalisIrasu) {
                                    Meniu.kuriIrasaNoresitePerziureti();
                                    try {
                                        String skaicius3 = ivedimas.tekstas();
                                        int k = Integer.parseInt(skaicius3);

                                        if (k == 0) {
                                            for (int k2 = 0; k2 < pajamuIraoMasyvas.length; k2++) {
                                                if (pajamuIraoMasyvas[k2] != null) {
                                                    pajamuIraoMasyvas[k2].parodykInfoApiePajamas();
                                                }
                                            }
                                            if (PajamuIrasas.getKelintasPajamuIrasas() == 0) {
                                                Meniu.irasuNera();
                                            }
                                            visasArDalisIrasu = false;
                                            pajamamosArIslaidos = false;
                                        } else if (k > pajamuIraoMasyvas.length) {
                                            Meniu.neraTokioIraso();
                                            visasArDalisIrasu = false;
                                            pajamamosArIslaidos = false;
                                        } else if (k > 0 && pajamuIraoMasyvas[k - 1] != null) {
                                            pajamuIraoMasyvas[k - 1].parodykInfoApiePajamas();
                                            visasArDalisIrasu = false;
                                            pajamamosArIslaidos = false;
                                        } else {
                                            Meniu.neraTokioIraso();
                                            visasArDalisIrasu = false;
                                            pajamamosArIslaidos = false;
                                        }

                                    } catch (Exception e) {
                                        scanner.reset();
                                        Meniu.kaVedi();
                                    }

                                }

                            } else if (j == 2) {
                                visasArDalisIrasu = true;
                                while (visasArDalisIrasu) {
                                    Meniu.kuriIrasaNoresitePerziureti();
                                    try {
                                        String skaicius4 = ivedimas.tekstas();
                                        int k = Integer.parseInt(skaicius4);

                                        if (k == 0) {

                                            for (int k2 = 0; k2 < islaiduIrasoMasyvas.length; k2++) {
                                                if (islaiduIrasoMasyvas[k2] != null) {
                                                    islaiduIrasoMasyvas[k2].parodykInfoapieislaidas();
                                                }
                                            }
                                            if (IslaiduIrasas.getKelintasIslaiduIrasas() == 0) {
                                                Meniu.irasuNera();
                                            }
                                            visasArDalisIrasu = false;
                                            pajamamosArIslaidos = false;
                                        } else if (k > islaiduIrasoMasyvas.length) {
                                            Meniu.neraTokioIraso();
                                            visasArDalisIrasu = false;
                                            pajamamosArIslaidos = false;
                                        } else if (k > 0 && pajamuIraoMasyvas[k - 1] != null) {
                                            islaiduIrasoMasyvas[k - 1].parodykInfoapieislaidas();
                                            visasArDalisIrasu = false;
                                            pajamamosArIslaidos = false;
                                        } else {
                                            Meniu.neraTokioIraso();
                                            visasArDalisIrasu = false;
                                            pajamamosArIslaidos = false;
                                        }

                                    } catch (Exception e) {
                                        scanner.reset();
                                        Meniu.kaVedi();
                                    }

                                }


                            } else {
                                Meniu.pasirinkoteNesuprantamaKomanda();
                            }

                        } catch (Exception e) {
                            scanner.reset();
                            Meniu.kaVedi();
                        }


                    }

                    smulkesneInformacija = false;

                } else if (i == 2) {
                    smulkesneInformacija = false;
                } else {
                    Meniu.pasirinkoteNesuprantamaKomanda();
                }

            } catch (Exception e) {
                scanner.reset();
                Meniu.kaVedi();
            }


        }
    }

    private void pasirinkta2IvestiIslaidas() {
        Meniu.pasirinkteIvestiIslaidas();
        ivestiesMeniu = true;

        while (ivestiesMeniu) {
            try {
                Meniu.islaiduMeniu();
                String skaicius_ = ivedimas.tekstas();
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
        if (arPajamos) {
            if (valiutosID == 1) {
                this.balansasGrynais = this.balansasGrynais + this.suma;
                this.balansas = this.balansas + this.suma;
            } else if (valiutosID == 0) {
                this.balansasKortele = this.balansasKortele + this.suma;
                this.balansas = this.balansas + this.suma;
            }

        } else {
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
                String skaicius_ = ivedimas.tekstas();
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

            } catch (Exception e) {
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
