package Finansai;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Logika {

    private final Scanner scanner = new Scanner(System.in);
    private final Ivedimas ivedimas = new Ivedimas();
    private final PajamuIrasas[] pajamuIraoMasyvas = new PajamuIrasas[3];
    private final IslaiduIrasas[] islaiduIrasoMasyvas = new IslaiduIrasas[3];
    public SimpleDateFormat manoFormatas = new SimpleDateFormat(Konstantos.PATTERN_DATE);
    private boolean veikia = true;
    private boolean ivestiesMeniu = true;
    private boolean kiekPinigu = true;
    private boolean gryni = true;
    private boolean papildomaInfo = true;
    private boolean smulkesneInformacija = true;
    private boolean pajamamosArIslaidos = true;
    private boolean visasArDalisIrasu = true;
    private boolean date = true;
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
            Tekstai.irasasNeIsaugotas();
            return;
        }

        for (int i = 0; i < pajamuIraoMasyvas.length; i++) {

            if (pajamuIraoMasyvas[i] == null) {
                pajamuIraoMasyvas[i] = a;
                Tekstai.irasasIsaugotas();
                break;
            }
        }

        if (pajamuIraoMasyvas[pajamuIraoMasyvas.length - 1] != null) {
            Tekstai.paskutinisIrasas();
        }
    }

    void generuojamasNaujasIrasoObjektas(double suma, int uzKaGautosPajamos, int grynais, Date data, String pastabos) {
        PajamuIrasas naujas;
        naujas = new PajamuIrasas(suma, uzKaGautosPajamos, grynais, data, pastabos);
        pajamosIMasyva(pajamuIraoMasyvas, naujas);

    }

    void islaidoIMasyva(IslaiduIrasas[] islaiduIrasoMasyvas, IslaiduIrasas a) {

        if (islaiduIrasoMasyvas[islaiduIrasoMasyvas.length - 1] != null) {
            Tekstai.irasasNeIsaugotas();
            return;
        }

        for (int i = 0; i < islaiduIrasoMasyvas.length; i++) {
            if (islaiduIrasoMasyvas[i] == null) {
                islaiduIrasoMasyvas[i] = a;
                Tekstai.irasasIsaugotas();
                break;
            }
        }

        if (islaiduIrasoMasyvas[islaiduIrasoMasyvas.length - 1] != null) {
            Tekstai.paskutinisIrasas();
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
            Tekstai.iveskiteDataFormatu();

            try {
                String dataLaikina = ivedimas.tekstas();
                this.data = this.manoFormatas.parse(dataLaikina);
                date = false;
            } catch (ParseException e) {
                Tekstai.nerinkamasDatosFormatas();
            }
        }
    }

    private void papildomInfoIvedama() {
        papildomaInfo = true;

        while (papildomaInfo) {
            Tekstai.informacijApiePinigus();
            String pastab = ivedimas.tekstas();
            this.pastabos = pastab;
            papildomaInfo = false;
        }
    }

    private void gryniArKortele() {
        gryni = true;

        while (gryni) {

            try {
                Tekstai.pajamosGrynaisArKortele();
                String skaicius_ = ivedimas.tekstas();
                int cashas = Integer.parseInt(skaicius_);

                if (cashas == 0) {
                    this.valiutosID = 0;
                    gryni = false;
                } else if (cashas == 1) {
                    this.valiutosID = 1;
                    gryni = false;
                } else {
                    Tekstai.pasirinkoteNesuprantamaKomanda();
                }

            } catch (Exception e) {

                scanner.reset();
                Tekstai.kaVedi();
            }
        }
    }

    private void iveskitePiniguSuma() {
        kiekPinigu = true;
        while (kiekPinigu) {
            try {
                Tekstai.iveskiteKiekPinigu();

                String skaicius_ = ivedimas.tekstas();
                double skaicius = Double.parseDouble(skaicius_);
                if (skaicius >= 0) {
                    this.suma = skaicius;
                    kiekPinigu = false;
                }
            } catch (Exception e) {
                scanner.reset();
                Tekstai.kaVedi();
            }
        }
    }

    void paleidimas() {
        veikia = true;
        while (veikia) {
            try {
                Tekstai.pagrindinisMeniu();
                String skaicius_ = ivedimas.tekstas();
                int meniuPasirinkiams = Integer.parseInt(skaicius_);
                if (meniuPasirinkiams == 1) {
                    pasirinkta1IvestiPajamas();
                } else if (meniuPasirinkiams == 2) {
                    pasirinkta2IvestiIslaidas();
                } else if (meniuPasirinkiams == 3) {
                    pasirinkta3PerziuretiBalansa();
                } else if (meniuPasirinkiams == 0) {
                    Tekstai.pasirinkoteVisoGeriausio();
                    return;
                } else {
                    Tekstai.pasirinkoteNesuprantamaKomanda();
                }
            } catch (Exception e) {
                scanner.reset();
                Tekstai.kaVedi();
            }
        }
    }

    private void pasirinkta3PerziuretiBalansa() {
        Tekstai.pasirinkotePerziuretiBalansa();
        islaidosVaizduojamosCia();
        smulkesneInformacija = true;

        while (smulkesneInformacija) {
            Tekstai.smulkesneInformacijaApiePajamasIrIslaidas();

            try {
                String skaicius_ = ivedimas.tekstas();
                int i = Integer.parseInt(skaicius_);

                if (i == 1) {
                    pajamamosArIslaidos = true;

                    while (pajamamosArIslaidos) {
                        Tekstai.pajamosArIslaidos();

                        try {

                            String skaicius2 = ivedimas.tekstas();
                            int j = Integer.parseInt(skaicius2);

                            if (j == 1) {
                                visasArDalisIrasu = true;
                                while (visasArDalisIrasu) {
                                    Tekstai.kuriIrasaNoresitePerziureti();
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
                                                Tekstai.irasuNera();
                                            }
                                            visasArDalisIrasu = false;
                                            pajamamosArIslaidos = false;
                                        } else if (k > pajamuIraoMasyvas.length) {
                                            Tekstai.neraTokioIraso();
                                            visasArDalisIrasu = false;
                                            pajamamosArIslaidos = false;
                                        } else if (k > 0 && pajamuIraoMasyvas[k - 1] != null) {
                                            pajamuIraoMasyvas[k - 1].parodykInfoApiePajamas();
                                            visasArDalisIrasu = false;
                                            pajamamosArIslaidos = false;
                                        } else {
                                            Tekstai.neraTokioIraso();
                                            visasArDalisIrasu = false;
                                            pajamamosArIslaidos = false;
                                        }

                                    } catch (Exception e) {
                                        scanner.reset();
                                        Tekstai.kaVedi();
                                    }

                                }

                            } else if (j == 2) {
                                visasArDalisIrasu = true;
                                while (visasArDalisIrasu) {
                                    Tekstai.kuriIrasaNoresitePerziureti();
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
                                                Tekstai.irasuNera();
                                            }
                                            visasArDalisIrasu = false;
                                            pajamamosArIslaidos = false;
                                        } else if (k > islaiduIrasoMasyvas.length) {
                                            Tekstai.neraTokioIraso();
                                            visasArDalisIrasu = false;
                                            pajamamosArIslaidos = false;
                                        } else if (k > 0 && pajamuIraoMasyvas[k - 1] != null) {
                                            islaiduIrasoMasyvas[k - 1].parodykInfoapieislaidas();
                                            visasArDalisIrasu = false;
                                            pajamamosArIslaidos = false;
                                        } else {
                                            Tekstai.neraTokioIraso();
                                            visasArDalisIrasu = false;
                                            pajamamosArIslaidos = false;
                                        }
                                    } catch (Exception e) {
                                        scanner.reset();
                                        Tekstai.kaVedi();
                                    }
                                }
                            } else {
                                Tekstai.pasirinkoteNesuprantamaKomanda();
                            }
                        } catch (Exception e) {
                            scanner.reset();
                            Tekstai.kaVedi();
                        }
                    }
                    smulkesneInformacija = false;
                } else if (i == 2) {
                    smulkesneInformacija = false;
                } else {
                    Tekstai.pasirinkoteNesuprantamaKomanda();
                }
            } catch (Exception e) {
                scanner.reset();
                Tekstai.kaVedi();
            }
        }
    }

    private void pasirinkta2IvestiIslaidas() {
        Tekstai.pasirinkteIvestiIslaidas();
        ivestiesMeniu = true;

        while (ivestiesMeniu) {
            try {
                Tekstai.islaiduMeniu();
                String skaicius_ = ivedimas.tekstas();
                int j = Integer.parseInt(skaicius_);
                if (j > 0 && j < 8) {
                    this.uzKa = j;
                    Tekstai.informacijApiePinigus();
                    ivedimoLogika();
                    generuojamasNaujasIslaiduObjektas(this.suma, this.uzKa, this.valiutosID, this.data, this.pastabos);
                    balansoSkaiciavimas(false);
                    ivestiesMeniu = false;
                } else if (j == 9) {
                    ivestiesMeniu = false;
                } else if (j == 0) {
                    Tekstai.pasirinkoteVisoGeriausio();
                    return;
                } else {
                    Tekstai.pasirinkoteNesuprantamaKomanda();
                }
            } catch (Exception e) {
                scanner.reset();
                Tekstai.kaVedi();
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
        Tekstai.pasirinkoteIvestiPajamas();
        ivestiesMeniu = true;

        while (ivestiesMeniu) {
            try {
                Tekstai.pajamuMeniu();
                String skaicius_ = ivedimas.tekstas();
                int j = Integer.parseInt(skaicius_);

                if (j > 0 && j <= 5) {
                    this.uzKa = j;
                    Tekstai.informacijApiePinigus();
                    ivedimoLogika();
                    generuojamasNaujasIrasoObjektas(this.suma, this.uzKa, this.valiutosID, this.data, this.pastabos);
                    balansoSkaiciavimas(true);
                    ivestiesMeniu = false;
                } else if (j == 9) {
                    ivestiesMeniu = false;
                } else if (j == 0) {
                    Tekstai.pasirinkoteVisoGeriausio();
                    return;
                } else {
                    Tekstai.pasirinkoteNesuprantamaKomanda();
                }
            } catch (Exception e) {
                scanner.reset();
                Tekstai.kaVedi();
            }
        }
    }

    private void islaidosVaizduojamosCia() {
        System.out.println();
        Tekstai.bendrasBalansas(this.balansas);
        Tekstai.bendrasBalansasKortele(this.balansasKortele);
        Tekstai.bendrasBalansasGrynais(this.balansasGrynais);
        System.out.println();
    }
}
