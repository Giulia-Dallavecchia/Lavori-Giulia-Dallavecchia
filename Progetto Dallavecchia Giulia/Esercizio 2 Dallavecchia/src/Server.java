import java.util.*;
import java.lang.Thread;
public class Server extends Thread{
	private static Client nuovo_client = new Client(); // creazione oggetto classe Client per aggiornare il contatore
	private int contatore;
	public static void main(String[] args) {
		nuovo_client.Avvio_Multiclient(); // utilizzo dell'oggetto nuovo_client per accedere alla classe Client per la gestione delle richieste dell'utente
		nuovo_client.start(); // Inizio del Thread per ogni cliente
	}
	
	//Metodo per l'inizializzazione della variabile contatore
	public synchronized void Contatore() {
		this.contatore = 0;
	}
	
	//Metodo per incrementare il contatore degli utenti online
	public String Numero_utenti() {
		this.contatore++; // il contatore si implementa ogni volta che il Server registra un nuovo client
		System.out.println("L'attuale numero di utenti online è: " + contatore);
		System.out.println();
		return nuovo_client.Avvio_Multiclient(); // Permette all'utente di ritornare al menù per scegliere un'altra opzione
	}
	
	// Metodo per gestire la chiusura della connessione
    public String Chiusura_connessione() {
    	nuovo_client.interrupt(); // Metodo della classe Thread che richiede la terminazione del Thread
    	// Viene effettuato un controllo sul Thread nuovo_client tramite il metodo isAlive, che restituisce true se il Thread è vivo
    	if(nuovo_client.isAlive()) //Se il Thread è vivo allora significa che la connessione non è stata interrota
    		System.out.println("Chiusura non eseguita");
    	//Se il valore del metodo isAlive risulta false, significa che la chiusura è stata effettuata con successo
    	else System.out.println("Chiusura effettuata con successo");
    	System.out.println();
    	this.contatore--; // Viene inoltre decrementato il contatore degli utenti online in quanto è stata chiusa la connessione del Client dell'utente che esegue questo metodo
    	return nuovo_client.Avvio_Multiclient(); // Permette all'utente di ritornare al menù per scegliere un'altra opzione
    }
}
