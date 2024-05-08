public class Giocatore extends Thread{
    public static final int nGiocatori=4;
    private Mazzo mazzo;
    private String nome;
    private int id;

    public Giocatore(Mazzo mazzo, String nome, int id){
        this.mazzo=mazzo;
        this.nome=nome;
        this.id=id;
    }

    public String getNome(){
        return nome;
    }

    public int getID(){
        return id;
    }

    @Override
    public void run(){
        boolean finita;
        do{
            finita=mazzo.seleziona3Carte(id);
        }while(!finita);
    }

    @Override
    public String toString(){
        return "Nome giocatore: "+nome+", ID giocatore: "+id;
    }
}
