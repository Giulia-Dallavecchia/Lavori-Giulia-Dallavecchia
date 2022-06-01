import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.Serializable;

public class Affitto_catering_partecipanti implements Serializable { //Implementazione dell'interfaccia Serializable, tramite la keyword implements, nella classe Affitto_catering_partecipanti
	public String nome; //Definizione della stringa relativa al nome dell'utente
	public String cognome; //Definizione della stringa relativa al cognome dell'utente
	public String Numero_prenotazione; //Definizione della stringa relativa al numero di prenotazione
	public String data; //Definizione della stringa relativa alla data di prenotazione
	public int giorno, mese, anno; //Definizione delle variabili di tipo intero relative ai giorni, mesi, anni
	public String nome_partecipante, cognome_partecipante; //Definizione delle stringhe relative ai nomi e ai cognomi dei partecipanti all'evento
	private int numero_partecipanti; //Definizione della varabile che definisce il numero dei partecipanti all'evento
	private static Menù ritorna_menù = new Menù();// creazione oggetto della classe menù per ritornare al menù iniziale quando l'utente non vuole inserire altre prenotazioni
	private static Prenotazione contatore = new Prenotazione(); //creazione oggetto della classe Prenotazione per implementare il numero della prenotazione
	public String[] dati_partecipante; //Array che gestisce i dati relativi al partecipante
	ArrayList<String> Dati_prenotazione_affittocatering_partecipanti = new ArrayList<String>(); //ArrayList che gestisce l'inserimento dei dati della prenotazione
	ArrayList<String> Tutte_le_date = new ArrayList<String>(); //ArrayList che gestisce tutte le date inserite in fase di prenotazione
	
	
	
	// metodo ausiliaro per la gestione dell'affitto con la gestione del catering e dei partecipanti
	public String Affitto_catering_partecipanti() {
		Scanner input = new Scanner(System.in);
		boolean fatto = false; // dichiarazione variabile globale per effettuare una nuova prenotazione
		while(!fatto) { //Condizione di controllo del ciclo while
			System.out.println ("inserisci nome del prenotante: ");
			nome = input.nextLine();
			System.out.println ("inserisci cognome del prenotante: ");
			cognome = input.nextLine();
			System.out.println("Inserisci il numero di partecipanti che parteciperanno all'evento");
			numero_partecipanti = input.nextInt(); // inserimento numero di partecipanti
			dati_partecipante = new String[numero_partecipanti+1]; // set della lunghezza dell'array a +1 perchè il contatore partirebbe da zero, ma questo un eventuale utente non lo saprebbe perchè non è un metodo di conteggio intuitivo
			System.out.println("Inserisci nome e cognome dei partecipanti");
			for (int j=0; j<=dati_partecipante.length-1; j++) { //ciclo for che scandisce l'array dati_partecipante
				String dati = input.nextLine(); //Lettura da tastiera dei dati 
				dati_partecipante[j] = dati; //Inserimento dei dati letti da tastiera nell'Array
			}
			giorno = leggigiorno(); //Richiamo del metodo ausiliario leggigiorno()
			mese = leggimese(); //Richiamo del metodo ausiliario leggimese()
			anno = leggianno(); //Richiamo del metodo ausiliario leggianno()
			data = giorno + "/" + mese + "/" + anno; //creazione della stringa data attraverso la concatenazione delle stringhe giorno, mese, anno
			Tutte_le_date.add(data); //inserimento della stringa data nell'ArrayList Tutte_le_date
			// creazione del ticket di prenotazione
			char inizialenome = nome.charAt(0); // estrapolazione della prima lettera del nome del prenotante
			char inizialecognome = cognome.charAt(0); // estrapolazione della prima lettera del cognome del prenotante
			String iniziali = inizialenome + "" + inizialecognome; // concatenazione iniziali prenotante
			Numero_prenotazione = contatore.Contatore() + "ACP" +"" + iniziali; // numero di prenotazione che contiene il contatore più le iniziali del prenotante
			
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
			Dati_prenotazione_affittocatering_partecipanti.add(data + "\n" + nome + " " + cognome + "\n" + Numero_prenotazione + "\n" + "Numero partecipanti: " + numero_partecipanti);//aggiunta dei dati all'ArrayList per la gestione dell'affitto con servizio di catering e gestione dei partecipanti
			int dimensione = Dati_prenotazione_affittocatering_partecipanti.size(); //impostazione dimensione del ciclo for in base alla grandezza dell'ArrayList
			for (int i=0; i<dimensione; i++) { // Stampa dei valori presenti nell'ArrayList
				System.out.println();
				System.out.println("Dettagli prenotazione: ");
				System.out.println();
				System.out.println(Dati_prenotazione_affittocatering_partecipanti.get(i)); //stampa dei valori contenuti nell'ArrayList
			}
			System.out.print("Dati partecipanti:");
			for (int j=0; j<=dati_partecipante.length-1; j++) { // Stampa dei valori presenti nell'Array 
				System.out.println(dati_partecipante[j]);
			}
			System.out.println();
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
