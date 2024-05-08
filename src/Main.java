import java.time.temporal.IsoFields;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException { // Eccezione che potrebbe lanciare il join
        Scanner sc = new Scanner();
        Giocatore[] g = new Giocatore[Giocatore.NGIOCATORI];
        Mazzo mazzo = new Mazzo();


        for (int i = 0; i < Giocatore.NGIOCATORI; i++) { // Costruzione di tutti i giocatori
            String nome;
            nome = sc.nextLine();
            g[i]= Giocatore(nome, i, mazzo);
        }
        for (int i = 1; i < Giocatore.NGIOCATORI; i++) { // Costruzione di tutti i giocatori
            g[i].start();
        }

        for (int i = 1; i < Giocatore.NGIOCATORI; i++) { // Costruzione di tutti i giocatori
            g[i].join();
        }
        int ind = mazzo.getVincitore();
        nome = g[ind].getNome();
        System.out.println("Il nome del vincitore e'" + nome);

        int[] arrVin = mazzo.getCarteVincenti();
        System.out.println("Le carte vincenti sono: ");

        for(int i = 0; )
    }
}