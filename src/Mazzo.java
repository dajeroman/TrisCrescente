import java.util.Random;
public class Mazzo {
    static final int CARTE = 100;
    int[] mazzo = new int[CARTE];
    private int turno;
    private int[] carteVincenti = new int[3];
    private boolean finita;

    public Mazzo() {
        Random rand = new Random();
        for (int i = 0; i < CARTE; i++) {
            mazzo[i] = rand.nextInt();
        }
    }

    public synchronized boolean seleziona3carte(int id) {
        boolean vincitore;

        while (id != turno && !finita) {
            try {
                wait();
            } catch (Exception e) {}
        }
        if(finita){
            turno++;
            if(turno > Giocatore.NGIOCATORI - 1){ // Controllo se il turno supera il numero di giocatori
                turno = 0;
            }
            notifyAll(); // Notifica tutti i giocatori
        }
        Random rand = new Random();
        // Ipotizzo che le tre indici siano numeri diversi
        int pos1 = rand.nextInt(CARTE);
        int pos2 = rand.nextInt(CARTE);
        int pos3 = rand.nextInt(CARTE);

        if (mazzo[pos1] < mazzo[pos2] && mazzo[pos2] < mazzo[pos3]) {

            vincitore = id;
            carteVincenti[0] == mazzo[pos1]
            carteVincenti[1] == mazzo[pos2]
            carteVincenti[2] == mazzo[pos3]
        }
        turno++;
        if(turno > Giocatore.NGIOCATORI - 1){ // Controllo se il turno supera il numero di giocatori
            turno = 0;
        }
        notifyAll();
        return finita;

        public int getVincitore(){
            return vincitore;
        }
    }


}
