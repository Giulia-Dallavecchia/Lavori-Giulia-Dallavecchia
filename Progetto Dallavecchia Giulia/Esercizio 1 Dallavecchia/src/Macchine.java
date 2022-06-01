import java.util.*;
import java.lang.Thread;
public class Macchine extends Thread{
	Scanner input = new Scanner(System.in);
	private static Ponte ponte = new Ponte(); // creazione oggetto classe Ponte
	int auto_est = 0; //inizializzazione contatore macchine sul lato est del ponte
	int auto_ovest = 0; //inizializzazione contatore macchine sul lato ovest del ponte
	public int tempo_accensione_macchina_est; //definizione della variabile per verificare il tempo di accensione delle macchine sul lato est del ponte
	public int tempo_accensione_macchina_ovest; //definizione della variabile per verificare il tempo di accensione delle macchine sul lato ovest del ponte
	int scelta; // variabile per lo switch
	public int numero_macchine; // variabile che mi identifica quante macchine ci sono sul ponte

	//costruttore macchine
	public Macchine() { 
		int numero_macchine = (int)(Math.random()*10); //viene generato un valora casuale tra 0 e 10 per assegnare il numero di macchine che ci saranno sul ponte
			for (int i = 1; i<=numero_macchine; i++) {
				//in base al numero di macchine che ci sono sul ponte vengono inserite lo stesso numero di macchine specificando la loro posizione sul ponte
				System.out.println("In che direzione va le macchina?");
				System.out.println("1- EST");
				System.out.println("2- OVEST");
				scelta = input.nextInt();
				input.nextLine();
				switch(scelta) { //in base alla posizione sul ponte abbiamo 2 possibilità
				// 1 - le macchine sono sul lato est del ponte
				case 1: 
					this.auto_est++;
					tempo_accensione_macchina_est = (int)(Math.random()*10);
					//System.out.println("Tempo di partenza macchine da est " + tempo_accensione_macchina_est);
					try {
						Thread.sleep(tempo_accensione_macchina_est);
					} catch (InterruptedException e) {e.printStackTrace();}
					break;
					
				case 2: 
				 // 2- le macchine sono sul lato ovest del ponte
					this.auto_ovest++;
					tempo_accensione_macchina_ovest = (int)(Math.random()*10);
					try {
						Thread.sleep(tempo_accensione_macchina_ovest);
					} catch (InterruptedException e) {e.printStackTrace();}
					//System.out.println("Tempo di partenza macchine da ovest " + tempo_accensione_macchina_ovest);
					break;
				}
			}
		start();
	}
	
	
	public void run() {
		//controllo che il semaforo sia verde prima di partire
		synchronized(ponte) {
			if (ponte.Semaforo() == false) { 
				System.out.println("Semaforo rosso: attendere il proprio turno");
			} else {
				System.out.println("Semaforo verde: potete partire");
				System.out.println();
				ponte.passa();
			}
		}
	}
}
