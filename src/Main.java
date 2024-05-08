import java.time.temporal.IsoFields;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner();
        System.out.println();
        System.out.printf("Hello and welcome!");

        for (int i = 1; i < Giocatore.NGIOCATORI; i++) { // Costruzione di tutti i giocatori
            String nome;
            nome = sc.nextLine();
            g[i]= Giocatore(nome, i, mazzo);
            System.out.println("i = " + i);
        }
        for (int i = 1; i < Giocatore.NGIOCATORI; i++) { // Costruzione di tutti i giocatori
            g[i].start();
        }

        for (int i = 1; i < Giocatore.NGIOCATORI; i++) { // Costruzione di tutti i giocatori
            try{
                g[i].join();
            }catch (Exception e){

            }
        }
    }
}