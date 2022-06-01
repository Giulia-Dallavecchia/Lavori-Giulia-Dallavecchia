import java.util.*;
import java.lang.Thread;
public class Client extends Thread {
	private static Server chiamata_server = new Server(); // creazione oggetto classe Client per aggiornare il contatore
	Scanner input = new Scanner(System.in);
	public String Avvio_Multiclient() {
		int scelta;
		do {
				System.out.println("Cosa vuoi fare?");
				System.out.println();
				System.out.println("1- Vedere quanti utenti ci sono online al momento");
				System.out.println("2- Chiudere la connessione");
				System.out.println();
				System.out.println("Effettua la tua scelta");
				scelta = input.nextInt();
				input.nextLine();
				
				switch (scelta) {
				case 1: 
					chiamata_server.Numero_utenti(); //Metodo ausiliario implementato per la gestione della prenotazione
					break;
					
				//Visualizzazione elenco prenotazioni in ordine cronologico	
				case 2: 
					chiamata_server.Chiusura_connessione(); //Metodo ausiliario implementato per la visualizzazione, ordinata per data, delle prenotazioni
					break;
				}
		} while(scelta!=2); //condizione per uscire dallo switch
		return Avvio_Multiclient();
	}
}

