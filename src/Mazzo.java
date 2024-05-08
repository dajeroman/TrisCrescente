import java.util.Random;
public class Mazzo {
    static final int CARTE = 100;
    int[] mazzo = new int[CARTE];
    private int turno;

    public Mazzo() {
        Random rand = new Random();
        for (int i = 0; i < CARTE; i++) {
            mazzo[i] = rand.nextInt();
        }
    }

    public synchronized boolean seleziona3carte(int id) {
        boolean vincitore;

        while (id != turno) {
            try {
                wait();
            } catch (Exception e) {
            }
        }
        Random rand = new Random();
        // Ipotizzo che le tre indici siano numeri diversi
        int pos1 = rand.nextInt(CARTE);
        int pos2 = rand.nextInt(CARTE);
        int pos3 = rand.nextInt(CARTE);

        if (mazzo[pos1] < mazzo[pos2] && mazzo[pos2] < mazzo[pos3]) {
            vincitore = true;
        }
        notifyAll();
    }
}
