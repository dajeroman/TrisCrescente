import java.util.Scanner;
public class Main{//ciao
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Giocatore[] g=new Giocatore[Giocatore.nGiocatori];
        Mazzo mazzo=new Mazzo();
        String nome;

        // Costruzione di tutti quanti i Giocatori
        for(int i=0; i<Giocatore.nGiocatori; i++){
            System.out.print("Inserisci nome giocatore N"+(i+1)+": ");
            nome=sc.nextLine();
            g[i]=new Giocatore(mazzo, nome, i);
        }

        // Il Thread viene impostato nello stato di pronto
        for(int i=0; i<Giocatore.nGiocatori; i++){
            g[i].start();
        }

        // Attesa della fine dei Thread da parte del Main
        for(int i=0; i<Giocatore.nGiocatori; i++){
            try{
                g[i].join();
            }catch(InterruptedException e){
                // oppure solo (exception e){}
                throw new RuntimeException(e);
            }
        }

        // Fine del programma e dichiarazione del vincitore
        int id=mazzo.getVincitore();
        nome=g[id].getNome();
        System.out.println("Il nome del vincitore e': "+nome);

        int[] arrVincenti=mazzo.getCarteVincenti();
        System.out.println("Le carti vincenti sono: ");
        for(int i=0; i<arrVincenti.length; i++){
            System.out.println(arrVincenti[i]);
        }
    }
}
