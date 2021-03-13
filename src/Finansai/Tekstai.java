package Finansai;

public class Tekstai {

    public static void pasirinkoteIvestiPajamas() {
        System.out.println("Pasirinkote ivesti pajamas.");
    }

    public static void pasirinkteIvestiIslaidas() {
        System.out.println("Pasirinkte ivesti islaidas.");
    }

    public static void pasirinkotePerziuretiBalansa() {
        System.out.println("Pasirinkote perziureti balansa");
    }

    public static void pasirinkoteVisoGeriausio() {
        System.out.println("Viso geriausio");
    }

    public static void pasirinkoteNesuprantamaKomanda() {
        System.out.println(" Tokia funkcija neegzistuoja ");
    }

    public static void iveskiteDataFormatu() {
        System.out.println("Įveskite datą 'yyyy-mm-dd' formatu");
    }

    public static void pagrindinisMeniu() {


        System.out.println("        *****************************");
        System.out.println("        *                           *");
        System.out.println("        *  Pasirinkite meniu:       *");
        System.out.println("        *                           *");
        System.out.println("        *  1 - Įvesti pajamas;      *");
        System.out.println("        *  2 - Įvesti išlaidas;     *");
        System.out.println("        *  3 - Peržiūrėti balansą;  *");
        System.out.println("        *  0 - Išjungti programą;   *");
        System.out.println("        *                           *");
        System.out.println("        *****************************");

    }

    public static void pajamuMeniu() {

        System.out.println("        *****************************");
        System.out.println("        *                           *");
        System.out.println("        *  Už ką gautos pajamos:    *");
        System.out.println("        *                           *");
        System.out.println("        *  1 - Atlyginimas;         *");
        System.out.println("        *  2 - Individuali veikla;  *");
        System.out.println("        *  3 - Būsto nuoma;         *");
        System.out.println("        *  4 - Dovanos;             *");
        System.out.println("        *  5 - Kita;                *");
        System.out.println("        *                           *");
        System.out.println("        *  9 - Grįžti atgal;        *");
        System.out.println("        *  0 - Išjungti programą;   *");
        System.out.println("        *                           *");
        System.out.println("        *****************************");

    }

    public static void islaiduMeniu() {

        System.out.println("        *****************************");
        System.out.println("        *                           *");
        System.out.println("        *  Pasirinkite išlaidas:    *");
        System.out.println("        *                           *");
        System.out.println("        *  1 - Maistas;             *");
        System.out.println("        *  2 - Transportas;         *");
        System.out.println("        *  3 - Komunaliniai         *");
        System.out.println("        *      mokesčiai;           *");
        System.out.println("        *  4 - Dovanos;             *");
        System.out.println("        *  5 - Paskolos;            *");
        System.out.println("        *  6 - Laisvalaikis;        *");
        System.out.println("        *  7 - Asmeninės išlaidos;  *");
        System.out.println("        *                           *");
        System.out.println("        *  9 - Grįžti atgal;        *");
        System.out.println("        *  0 - Išjungti programą;   *");
        System.out.println("        *                           *");
        System.out.println("        *****************************");
    }

    public static void uzkraunamiDuomenys() {

        System.out.println("Uzkraunami duomenys");
        System.out.println();

    }

    public static void pasisveikinimas() {
        System.out.println();
        System.out.println("Sveiki, finansinų pagalbininkas startuoja. ");
        System.out.println();

    }

    public static void pajamosGrynaisArKortele() {
        System.out.println("Grynais spauskite - 1 ");
        System.out.println("Kortele spauskite - 0 ");
    }

    public static void irasasIsaugotas() {
        System.out.println("Irasas isaugotas");
        System.out.println();
    }

    public static void informacijApiePinigus() {
        System.out.println("Iveskite papildomos informacijos: ");

    }

    public static void iveskiteKiekPinigu() {
        System.out.println("Iveskite suma");
    }

    public static void smulkesneInformacijaApiePajamasIrIslaidas() {
        System.out.println("Ar norite smulkesnes informacijos? ");
        System.out.println("TAIP - 1");
        System.out.println("NE - 2");
    }

    public static void pajamosArIslaidos() {
        System.out.println("Noredami gauti info apie PAJAMAS spauskite - 1");
        System.out.println();
        System.out.println("Noredami gauti info apie ISLAIDAS spauskite - 2");
    }

    public static void kuriIrasaNoresitePerziureti() {
        System.out.println("Kuri irasa noresite perziureti?");
        System.out.println("Noredami perziureti visus irasus spauskite - 0");
    }

    public static void neraTokioIraso() {
        System.out.println("Toks irasas neegzistuoja");
    }


    public static void ivykoKlaidaNustatanGrynaisArKortele() {
        System.out.println("ivyko klaida nustatant kortele ar grynais atsiskaite zmogus");
    }

    public static void nerinkamasDatosFormatas() {
        System.err.println("Netinkamas datos formatas");
    }

    public static void kaVedi() {
        System.err.println("Netinkamas ivedimas");
    }

    public static void irasuNera() {
        System.out.println("**********");
        System.out.println("Irasu nera");
        System.out.println("**********");
    }

    public static void paskutinisIrasas() {
        System.out.println("Tai paskutinis tilpes irasas");
        System.out.println("Noredami naudotis pilna programos versija kreipkites el pastu: info@noriudaugiauvietossavofinansams.lt");
    }

    public static void irasasNeIsaugotas() {
        System.out.println("SIS IRASAS NEBUVO ISSAUGOTAS. ATMINTIS PILNA");
    }

    public static void bendrasBalansas(double balansas) {
        System.out.println(balansas + " EUR - bendras balansas");
    }

    public static void bendrasBalansasKortele(double balansas) {
        System.out.println(balansas + " EUR - korteles balansas");
    }

    public static void bendrasBalansasGrynais(double balansas) {
        System.out.println(balansas + " EUR - grynu balansas");
    }

    public static void kelintasIrasas(int irasas) {
        System.out.println("tai yra " + irasas + " irasas");
    }

    public static void uzKa(String pajamos) {
        System.out.println("Už: " + pajamos);
    }

    public static void data(String data) {
        System.out.println("Irasas padarytas " + data);
    }

    public static void valiuta(String valiuta) {
        System.out.println("Valiuta: " + valiuta);
    }

    public static void pastabos(String pastabos) {
        System.out.println("Pastabos apie irasa: " + pastabos);
    }



}

