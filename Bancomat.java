import java.util.Scanner;

public class Bancomat {

    private static Scanner in ;
    private static float sold = 100; // am ales initial ca soldul sa fie 100
    private static int altaTranzactie;

    public static void main(String args[]) {
        in = new Scanner(System.in);
        tranzactie();
    }

    private static void tranzactie() {
        int optiune;

        System.out.println("Va rugem alegeti optiunea dorita");
        System.out.println("1. Retragere");
        System.out.println("2. Depozitare");
        System.out.println("3. Sold");

        optiune = in .nextInt();

        switch (optiune) {
            case 1:
                //Optiunea de retragere
                float suma;
                System.out.println("Va rugam alegeti suma dorita pentru retragere: ");
                suma = in .nextFloat();
                if (suma > sold || suma == 0) {
                    System.out.println("Fonduri insuficiente\n\n");
                    altaTranzactie(); 
                } else {
                    //actualizam soldul
                    sold = sold - suma;
                    System.out.println("Ati retras: " + suma + " iar soldul dumneavoastra este " + sold + "\n");
                    altaTranzactie();
                }
                break;

            case 2:
                //optiunea de depunere
                float depozit;
                System.out.println("Va rugam introduceti suma pe care doriti sa o depozitati: ");
                depozit = in .nextFloat();
                //actualizam balanta
                sold = depozit + sold;
                System.out.println("Ati depozitat " + depozit + " acum soldul dumneavoastra este " + sold + "\n");
                altaTranzactie();
                break;

            case 3:
                //optiunea de verificare a soldului
                System.out.println("Soldul dumneavoastra este: " + sold + "\n");
                altaTranzactie();
                break;

            default:
                System.out.println("Optiune indisponibila:\n\n");
                altaTranzactie();
                break;
        }

    }

    private static void altaTranzactie() {
        System.out.println("Doriti sa efectuati o alta tranzactie?\n\n Apasati 1 pentru o alta tranzactie. \n2 pentru a parasi meniul.");
        altaTranzactie = in .nextInt();
        if (altaTranzactie == 1) {
            tranzactie();
        } else if (altaTranzactie == 2) {
            System.out.println("Multumim pentru ca esti alaturi de noi! O zi buna!");
        } else {
            System.out.println("Optiune indisponibila\n\n");
            altaTranzactie();
        }
    }
}