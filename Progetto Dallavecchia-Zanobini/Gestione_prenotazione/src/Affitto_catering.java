import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.Serializable;

public class Affitto_catering implements Serializable { //Implementazione dell'interfaccia Serializable, tramite la keyword implements, nella classe Affitto_catering
	public String nome; //Definizione della stringa relativa al nome dell'utente
	public String cognome; //Definizione della stringa relativa al cognome dell'utente
	public String Numero_prenotazione; //Definizione della stringa relativa al numero di prenotazione
	public String data; //Definizione della stringa relativa alla data di prenotazione
	public int giorno, mese, anno; //Definizione delle variabili di tipo intero relative ai giorni, mesi, anni
	private static Menù ritorna_menù = new Menù();// creazione oggetto della classe menù per ritornare al menù iniziale quando l'utente non vuole inserire altre prenotazioni
	private static Prenotazione contatore = new Prenotazione(); //creazione oggetto della classe Prenotazione per implementare il numero della prenotazione
	private int numero_partecipanti; //Definizione della varabile che definisce il numero dei partecipanti all'evento
	ArrayList<String> Dati_prenotazione_affitto_catering = new ArrayList<String>(); //ArrayList che gestisce l'inserimento dei dati della prenotazione
	ArrayList<String> Tutte_le_date = new ArrayList<String>(); //ArrayList che gestisce tutte le date inserite in fase di prenotazione
	
	
	// metodo ausiliaro per la gestione dell'affitto con la gestione del catering
		public String Affitto_catering() {
			Scanner input = new Scanner(System.in);
			boolean fatto = false; // dichiarazione variabile globale per effettuare una nuova prenotazione
			while(!fatto) { //Condizione di controllo del ciclo while
				System.out.println ("inserisci nome del prenotante: ");
				nome = input.nextLine();
				System.out.println ("inserisci cognome del prenotante: ");
				cognome = input.nextLine();
				System.out.println("Inserisci il numero di partecipanti che parteciperanno all'evento");
				numero_partecipanti = input.nextInt();
				input.nextLine(); // input definito per evitare che il programma si comporti in maniera anomala
				giorno = leggigiorno(); //Richiamo del metodo ausiliario leggigiorno()
				mese = leggimese(); //Richiamo del metodo ausiliario leggimese()
				anno = leggianno(); //Richiamo del metodo ausiliario leggianno()
				data = giorno + "/" + mese + "/" + anno; //creazione della stringa data attraverso la concatenazione delle stringhe giorno, mese, anno
				Tutte_le_date.add(data); //inserimento della stringa data nell'ArrayList Tutte_le_date
				// creazione del ticket di prenotazione
				char inizialenome = nome.charAt(0); // estrapolazione della prima lettera del nome del prenotante
				char inizialecognome = cognome.charAt(0); // estrapolazione della prima lettera del cognome del prenotante
				String iniziali = inizialenome + "" + inizialecognome; // concatenazione iniziali prenotante
				Numero_prenotazione = contatore.Contatore() + "AC" + "" + iniziali; // numero di prenotazione che contiene il contatore più le iniziali del prenotante
				
				for (int j=1; j<Tutte_le_date.size(); j++) {//scansione ArrayList Tutte_le_date 
					for (int i=j-1; i<Tutte_le_date.size()-1; i++) { //scansione ArrayList Tutte_le_date per controllare che la data non sia presente nell'ArrayList
						boolean contiene = Tutte_le_date.get(j).equals(Tutte_le_date.get(i)); //Utilizzo del metodo equals per confrontare
																							//la data inserita inserita nella posizione attuale 
																							//con le date contenute nell'ArrayList Tutte_le_date
						
						if (contiene) { // Se il controllo restituisce TRUE (quindi la data inserita è già occupata) fa reinserire la data all'utente
							System.out.println("Data inserita non disponibile");
							System.out.println("Inserisci una nuova data");
							giorno = leggigiorno(); //richiamo del metodo ricorsivo leggigiorno per l'inserimento del giorno e relativo controllo
							mese = leggimese(); //richiamo del metodo ricorsivo leggimese per l'inserimento del mese e relativo controllo
							anno = leggianno(); //richiamo del metodo ricorsivo leggianno per l'inserimento dell'anno e relativo controllo
						} 
					}
				} 
				
				Dati_prenotazione_affitto_catering.add(data + "\n" + nome + " " + cognome + "\n" + Numero_prenotazione + "\n" + "Numero partecipanti: " + numero_partecipanti); //aggiunta dei dati all'ArrayList per la gestione dell'affitto con servizio di catering
				int dimensione = Dati_prenotazione_affitto_catering.size(); //impostazione dimensione del ciclo for in base alla grandezza dell'ArrayList
				for (int i=0; i<dimensione; i++) { // Stampa dei valori presenti nell'ArrayList
					System.out.println();
					System.out.println("Dettagli prenotazione: ");
					System.out.println();
					System.out.println(Dati_prenotazione_affitto_catering.get(i)); //stampa dei valori contenuti nell'ArrayList
					System.out.println();
				}
				System.out.println("Vuoi effettuare un'altra prenotazione?");
				String risposta = input.nextLine(); // inserimento risposta da parte dell'utente
				if (!risposta.equalsIgnoreCase("si")) { // controllo sulla risposta inserita
					fatto = true; //assegnamento valore booleano alla variabile fatto in relazione alla risposta inserita dall'utente
				}
			} 
			return null;
		}
		// controllo ricorsivo sull'inserimento corretto del giorno
					public static int leggigiorno() {
						System.out.println("Inserisci il giorno in cui intendi effettuare la prenotazione ");
						Scanner input = new Scanner (System.in);
						int giorno = input.nextInt();
						input.nextLine(); // input definito per evitare che il programma si comporti in maniera anomala
						
						while (giorno <= 0 || giorno > 31) { //Condizione di controllo del ciclo while
							System.out.println("Giorno non valido"); 
							System.out.println("Riprovare");
							System.out.println("Inserisci il giorno in cui intendi effettuare la prenotazione ");
							giorno = input.nextInt();
							input.nextLine(); // input definito per evitare che il programma si comporti in maniera anomala
							
						}
						return giorno; //restituzione della variabile giorno
					}
					
					// controllo ricorsivo sull'inserimento corretto del mese
					public static int leggimese() {
						System.out.println("Inserisci il mese in cui intendi effettuare la prenotazione ");
						Scanner input = new Scanner (System.in);
						int mese = input.nextInt();
						input.nextLine(); // input definito per evitare che il programma si comporti in maniera anomala
						
						 while (mese <= 0 || mese > 12) { //Condizione di controllo del ciclo while
							System.out.println("Mese non valido"); 
							System.out.println("Riprovare");
							System.out.println("Inserisci il mese in cui intendi effettuare la prenotazione ");
							mese = input.nextInt();
							input.nextLine(); // input definito per evitare che il programma si comporti in maniera anomala
							
						}
						return mese; //restituzione della variabile mese
					}
					
					//controllo ricorsivo sull'inserimento corretto dell'anno 
					public static int leggianno() {
						System.out.println("Inserisci l'anno in cui intendi effettuare la prenotazione ");
						Scanner input = new Scanner (System.in);
						int anno = input.nextInt();
						input.nextLine(); // input definito per evitare che il programma si comporti in maniera anomala
						
						while (anno < 2021) { //Condizione di controllo del ciclo while
							System.out.println("Anno non valido"); 
							System.out.println("Riprovare");
							System.out.println("Inserisci l'anno in cui intendi effettuare la prenotazione ");
							anno = input.nextInt();
							input.nextLine(); // input definito per evitare che il programma si comporti in maniera anomala
						}
						return anno; //restituzione della variabile anno
					}
}
