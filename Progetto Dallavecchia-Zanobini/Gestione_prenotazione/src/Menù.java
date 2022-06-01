import java.util.*;
import java.io.IOException;
import java.lang.*;

//classe Menù che gestisce l’interfaccia testuale che consente di utilizzare tutte le funzionalità implementate nelle altre classi.
public class Menù{
	private static Gestione_prenotazioni file_binario = new Gestione_prenotazioni(); 
	private static Prenotazione ritorna_prenotazione = new Prenotazione(); //creazione oggetto della classe Prenotazione per la gestione delle diverse modalità di affitto
	private static Prenotazione elenco_prenotazioni = new Prenotazione(); //creazione oggetto della classe Prenotazione per la gestione dell'ordinamento cronologico delle date
	private static Prenotazione cancellazione_prenotazione_affitto_semplice = new Prenotazione(); //creazione oggetto della classe Prenotazione per la cancellazione della prenotazione affitto semplice
	private static Prenotazione cancellazione_prenotazione_affitto_catering = new Prenotazione(); //creazione oggetto della classe Prenotazione per la cancellazione della prenotazione affitto con catering
	private static Prenotazione cancellazione_prenotazione_affitto_catering_partecipanti = new Prenotazione(); //creazione oggetto della classe Prenotazione per la cancellazione della prenotazione affitto con catering e gestione dei partecipanti
	Scanner input = new Scanner(System.in);
	
	public String AvviaMenù() throws ClassNotFoundException, IOException, Exception { //gestione delle eventuali eccezioni generate dal salvataggio nel file binario
				int scelta = 0; //Definizione della variabile di tipo intero che verrà utilizzata per scegliere le varie opzioni del menù
				do {
						System.out.println("Menù: ");
						System.out.println();
						System.out.println("1- Inserisci 1 se desideri aggiungere una nuova prenotazione");
						System.out.println("2- Inserisci 2 se desideri visualizzare l'elenco delle prenotazioni effettuate in ordine cronologico");
						System.out.println("3- Inserisci 3 se desideri visualizzare l'elenco delle possibili tipologie di prenotazione");
						System.out.println("4- Inserisci 4 se desideri eliminare una prenotazione");
						System.out.println("5- Inserisci 5 se desideri visualizzare le prenotazioni per un dato prenotante");
						System.out.println("6- Inserisci 6 se desideri visualizzare i dati salvati nel file binario");
						System.out.println("7- Inserisci 7 per uscire");
						
						System.out.println(); 
						
						System.out.println("Effettua la scelta");
						scelta = input.nextInt(); // Inserimento da parte dell'utente del numero dell'opzione del menù che intende scegliere
						input.nextLine(); // input definito per evitare che il programma si comporti in maniera anomala
						
						switch (scelta) {
						// Inserisci una nuova prenotazione
						case 1: 
							Prenotazione(); //Metodo ausiliario implementato per la gestione della prenotazione
							break;
							
						//Visualizzazione elenco prenotazioni in ordine cronologico	
						case 2: 
							Elenco_prenotazioni(); //Metodo ausiliario implementato per la visualizzazione, ordinata per data, delle prenotazioni
							break;
							
						//Elenco di tutte le possibili tipologie di prenotazione
						case 3: 
							Tipolgie_evento(); //Metodo ausiliario implementato per la descrizione delle varie tipologie di evento che possono essere prenotate
							break;
							
						//Eliminazione prenotazione effettuata	
						case 4: 
							Elimina_prenotazione(); //Metodo ausiliario per gestire l'eleminazione di una prenotazione
							break;
							
						//Visualizzare le prenotazioni dato uno specifico prenotante	
						case 5: 
							Visualizza_prenotazione(); //Metodo ausiliaro per la visualizzazione delle prenotazioni effettuate dallo stesso utente 
							break;
							
						case 6: 
							File_binario(); //Metodo ausiliaro per il salvataggio dei dati in un file binario 
							break;
						}	
				} while(scelta!=7); //condizione per uscire dal ciclo do-while
		return AvviaMenù(); //Rimando al menù qualora si uscisse dallo switch
	}
	
	// 1- metodo ausiliaro per gestire la possibilità di fare una prenotazione
	private void Prenotazione() throws ClassNotFoundException, IOException, Exception { //gestione delle eventuali eccezioni generate dal salvataggio nel file binario
		int prenotazione; //Definizione della variabile di tipo intero che verrà utilizzata per scegliere le varie tipologie di prenotazione
		do {
			System.out.println ("Scegli la tipologia di prenotazione che intendi fare");
			System.out.println();
			System.out.println("Inserisci 1 per affittare il locale");
			System.out.println("Inserisci 2 per affittare il locale con il servizio di catering");
			System.out.println("Inserisci 3 per per affittare il locale con il servizio di catering e con la gestione dei partecipanti");
			System.out.println("Inserisci 4 per uscire");
			System.out.println();
			System.out.println("Effettua la scelta");
			prenotazione=input.nextInt(); // Inserimento da parte dell'utente della tipologia di prenotazione che intende effettuare
			input.nextLine(); // input definito per evitare che il programma si comporti in maniera anomala
			switch(prenotazione) {
				case 1:
					//Implementazione prenotazione affitto semplice
					System.out.println ("Descrizione: Prenotazione del locale");
					System.out.println();
					ritorna_prenotazione.Affitto_semplice(); //Utilizzo dell'oggetto ritorna_prenotazione della classe Prenotazione definito precedentemente per richiamare il metodo ausiliario
															// Affitto_semplice implementato nella classe Prenotazione
					break;
				case 2: 
					//Implementazione prenotazione affitto del locale con servizio di catering
					System.out.println ("Descrizione: Prenotazione del locale con servizio di catering");
					System.out.println();
					ritorna_prenotazione.Affitto_catering(); //Utilizzo dell'oggetto ritorna_prenotazione della classe Prenotazione definito precedentemente per richiamare il metodo ausiliario
															// Affitto_catering implementato nella classe Prenotazione
					break;
				case 3: 
					//Implementazione prenotazione affitto del locale con servizio di catering e gestione dei partecipanti
					System.out.println ("Descrizione: Prenotazione del locale con servizio di catering e gestione dei partecipanti");
					System.out.println();
					ritorna_prenotazione.Affitto_catering_partecipanti();//Utilizzo dell'oggetto ritorna_prenotazione della classe Prenotazione definito precedentemente per richiamare il metodo ausiliario
																		// Affitto_catering implementato nella classe Prenotazione
					break;
			}
		} while (prenotazione!=4); //condizione per uscire dal ciclo do-while
	}
	
	// 2- metodo ausiliario per visualizzare l'elenco delle prenotazioni
	private void Elenco_prenotazioni() {
		String elenco;
		elenco = elenco_prenotazioni.Ordine_cronologico(); //Utilizzo dell'oggetto elenco_prenotazioni della classe Prenotazione definito precedentemente per richiamare il metodo ausiliario
														  //Ordine_cronologico() implementato nella classe Prenotazione
	}
	
	// 3-  metodo ausiliario per la definizione dei diversi tipi di prenotazione
	private void Tipolgie_evento() {
		int tipologia; //Definizione della variabile di tipo intero che verrà utilizzata per scegliere di quale tipologia l'utente vuole avere maggiori informazioni
		do {
			System.out.println ("Definizione delle tipologie di evento possibili");
			System.out.println();
			System.out.println("Inserisci 1 per avare maggiori informazioni riguardo il semplice affitto");
			System.out.println("Inserisci 2 per avare maggiori informazioni riguardo l'affitto con catering");
			System.out.println("Inserisci 3 per avare maggiori informazioni riguardo l'affitto con catering e gestione dei partecipanti");
			System.out.println("Inserisci 4 per uscire");
			System.out.println();
			System.out.println("Effettua la scelta");
			tipologia=input.nextInt(); // Inserimento da parte dell'utente della tipologia di prenotazione di cui vuole informazioni
			switch (tipologia) {
				case 1: 
					System.out.println("Con questa modalità è possibile effettuare il semplice affitto del locale");
					System.out.println();
					System.out.println("Ora che sai come funziona la prima opzione, scegli un'altra opzione");
					System.out.println();
					break;
				case 2:
					System.out.println("Con questa modalità è possibile effettuare l'affitto del locale e richiedere il servizio di catering");
					System.out.println();
					System.out.println("Ora che sai come funziona la seconda opzione, scegli un'altra opzione");
					System.out.println();
					break;
				case 3: 
					System.out.println("Con questa modalità è possibile effettuare l'affitto del locale e richiedere il servizio di catering con la gestione dei partecipanti all'evento");
					System.out.println();
					System.out.println("Ora che sai come funziona la terza opzione, scegli un'altra opzione");
					System.out.println();
					break;
				
			}
		} while (tipologia!=4);	//condizione per uscire dal ciclo do-while
	}
	
	// 4- metodo ausiliario per la cancellazione di una prenotazione
	private void Elimina_prenotazione() {
		int tipologia; //Definizione della variabile di tipo intero che verrà utilizzata per scegliere di quale tipologia l'utente vuole avere maggiori informazioni
		do {
			System.out.println ("Cancellazione prenotazione: ");
			System.out.println();
			System.out.println("1- Inserisci 1 per cancellare la prenotazione di un affitto semplice");
			System.out.println("2- Inserisci 2 per cancellare la prenotazione di un affitto con catering");
			System.out.println("3- Inserisci 3 per cancellare la prenotazione di un affitto con catering e gestione dei partecipanti");
			System.out.println("4- Inserisci 4 per uscire");
			System.out.println();
			System.out.println("Effettua la scelta");
			tipologia=input.nextInt(); //Inserimento da parte dell'utente della tipologia di prenotazione di cui vuole informazioni
			switch (tipologia) {
				case 1: 
					System.out.println();
					cancellazione_prenotazione_affitto_semplice.Cancella_prenotazione_Affitto_semplice(); //Utilizzo dell'oggetto cancellazione_prenotazione_affitto_semplice della classe Prenotazione definito precedentemente per richiamare il metodo ausiliario
																										// Cancella_prenotazione_Affitto_semplice() implementato nella classe Prenotazione
					System.out.println();
					break;
				case 2:
					System.out.println();
					cancellazione_prenotazione_affitto_catering.Cancella_prenotazione_Affitto_catering(); //Utilizzo dell'oggetto cancellazione_prenotazione_affitto_catering della classe Prenotazione definito precedentemente per richiamare il metodo ausiliario
																										// Cancella_prenotazione_Affitto_catering() implementato nella classe Prenotazione
					System.out.println();
					break;
				case 3: 
					System.out.println();
					cancellazione_prenotazione_affitto_catering_partecipanti.Cancella_prenotazione_Affitto_catering_parecipanti(); //Utilizzo dell'oggetto cancellazione_prenotazione_affitto_catering_partecipanti della classe Prenotazione definito precedentemente per richiamare il metodo ausiliario
																																// Cancella_prenotazione_Affitto_catering_parecipanti() implementato nella classe Prenotazione
					System.out.println();
					break;
				
			}
		} while (tipologia!=4);	//condizione per uscire dal ciclo do-while
	}
	
	// 5 - metodo ausiliario per la visualizzazione per nome e numero di prenotazione delle prenotazioni
	private void Visualizza_prenotazione() {
		elenco_prenotazioni.Visualizzazione_prenotazione(); //Utilizzo dell'oggetto elenco_prenotazioni della classe Prenotazione definito precedentemente per richiamare il metodo ausiliario 
															//Visualizzazione_prenotazione() implementato nella classe Prenotazione
	}
	private void File_binario() throws ClassNotFoundException, IOException {
		elenco_prenotazioni.Salvataggio(); //Utilizzo dell'oggetto elenco_prenotazioni della classe Prenotazione definito precedentemente per richiamare il metodo ausiliario 
										   //Salvataggio() implementato nella classe Prenotazione
	}
}

