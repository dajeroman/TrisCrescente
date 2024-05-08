public class Giocatore extends Thread{
    private String nome;
    private int id;
    private Mazzo mazzo;
    public static int NGIOCATORI = 4;

    public Giocatore(Mazzo mazzo, String nome, int id){
        this.mazzo = mazzo;
        this.nome = nome;
        this.id = id;
    }
    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "Id" + id;
    }

    @Override
    public void run(){
        boolean finita;
        do{
            finita = mazzo.seleziona3carte(id);

        }while(!finita);

        }
    }
}
