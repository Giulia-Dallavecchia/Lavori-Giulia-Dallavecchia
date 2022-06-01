import java.util.*;
import java.lang.Thread;
public class Ponte {
	private static Macchine macchine = new Macchine(); // creazione oggetto classe Macchine
	boolean semaforo;
	
	public synchronized boolean Semaforo() {
		// condizione if: se da una delle due parti del ponte non è presente nessuna macchina, il semaforo ha valore false: è rosso
		if (macchine.auto_est >= 1 && macchine.auto_ovest >= 1)
			semaforo = true;
		else semaforo = false; // semaforo verde
			return semaforo;
	}
	
	public synchronized void passa () {
		// effettuo un controllo sul tempo di accensione delle macchine
		// quando la macchina dalla parte est impiega un tempo minore ad accendersi parte
		if (macchine.tempo_accensione_macchina_est < macchine.tempo_accensione_macchina_ovest) {
		System.out.println("Accensione prima della macchina di est");
		System.out.println();
		macchine.auto_est--; //decremento il numero di macchine sulla parte est del ponte in quanto una macchina è partita
		// stampa del valore aggiornato delle code dopo il passaggio delle macchine sul ponte
		System.out.println("Ora sono in fila " + macchine.auto_est + " macchine ad est");
		System.out.println("Ora sono in fila " + macchine.auto_ovest + " macchine ad ovest");
		}	
		else{
			// in caso contratio, quando la macchina sulla parte ovest del fiume si accende prima, parte
			System.out.println("Accensione prima della macchina di ovest");
			System.out.println();
			macchine.auto_ovest--; // decremento il numero di macchine sulla parte ovest del ponte in quanto una macchina è partita
			// stampa del valore aggiornato delle code dopo il passaggio delle macchine sul ponte
			System.out.println("Ora sono in fila " + macchine.auto_est + " macchine ad est");
			System.out.println("Ora sono in fila " + macchine.auto_ovest + " macchine ad ovest");
		}
		
		notifyAll();
	}
	
}
