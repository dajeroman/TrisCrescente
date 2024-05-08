import java.util.Random;
public class Mazzo{
    public static final int nCarte=100;
    int[] mazzo=new int[nCarte];
    private int[] carteVincenti=new int[3];
    private int vincitore, turno;
    private boolean finita;

    public Mazzo(){
        Random rand=new Random();
        for(int i=0; i<nCarte; i++){
            mazzo[i]=rand.nextInt(nCarte);
        }
    }

    public int getVincitore(){
        return vincitore;
    }

    public int[] getCarteVincenti(){
        return carteVincenti;
    }

    public synchronized boolean seleziona3Carte(int id){
        while(id!=turno){
            try{
                this.wait();
            }catch(InterruptedException e){
                // oppure solo (exception e){}
                throw new RuntimeException(e);
            }
        }

        if(finita){
            turno++;
            if(turno>Giocatore.nGiocatori-1){
                turno=0;
            }
            notifyAll();
            return finita;
        }

        Random rand=new Random();
        // Ipotizzo che i 3 indici siano numeri diversi
        int pos1=rand.nextInt(nCarte);
        int pos2=rand.nextInt(nCarte);
        int pos3=rand.nextInt(nCarte);

        if(mazzo[pos1]<mazzo[pos2] && mazzo[pos2]<mazzo[pos3]){
            vincitore=id;
            finita=true;
            carteVincenti[0]=mazzo[pos1];
            carteVincenti[1]=mazzo[pos2];
            carteVincenti[2]=mazzo[pos3];
        }

        turno++;
        if(turno>Giocatore.nGiocatori-1) {
            turno=0;
        }
        notifyAll();
        return finita;
    }


}
