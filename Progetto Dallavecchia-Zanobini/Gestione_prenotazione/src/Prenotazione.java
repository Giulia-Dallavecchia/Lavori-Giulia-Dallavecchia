import java.util.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.*;
//implements Comparator
public class Prenotazione{
	private static Menù ritorna_menù = new Menù();// creazione oggetto della classe menù per ritornare al menù iniziale quando l'utente non vuole inserire altre prenotazioni
	private static Affitto_semplice prenotazione_affitto_semplice = new Affitto_semplice(); // creazione oggetto della classe Affitto_semplice per implementare le prenotazione del semplice affitto del locale
	private static Affitto_catering prenotazione_affitto_catering = new Affitto_catering(); // creazione oggetto della classe Affitto_catering per implementare le prenotazione dell'affitto con catering
	private static Affitto_catering_partecipanti prenotazione_affitto_catering_partecipanti = new Affitto_catering_partecipanti(); // creazione oggetto della classe Affitto_catering_partecipanti per implementare le prenotazione dell'affitto con catering e gestione partecipanti
	ArrayList<String> Date_ordinate = new ArrayList<String>(); // array che gestisce l'ordinamento cronologico delle date
	ArrayList<String> Dati = new ArrayList<String>(); // array che gestisce l'ordinamento cronologico delle date
	int cont_prenotazione = 1;
	String data;
	
	
	
	// metodo ausiliaro per la gestione dell'affitto semplice
	public String Affitto_semplice() throws ClassNotFoundException, IOException, Exception { //gestione delle eventuali eccezioni generate dal salvataggio nel file binario
		prenotazione_affitto_semplice.Affitto_semplice(); //Utilizzo dell'oggetto prenotazione_affitto_semplice della classe Affitto_semplice definito precedentemente per richiamare il metodo ausiliario
														// Affitto_semplice implementato nella classe Affitto_semplice
		return ritorna_menù.AvviaMenù();
	}
	
	// metodo ausiliaro per la gestione dell'affitto con la gestione del catering
	public String Affitto_catering() throws ClassNotFoundException, IOException, Exception { //gestione delle eventuali eccezioni generate dal salvataggio nel file binario
		prenotazione_affitto_catering.Affitto_catering(); //Utilizzo dell'oggetto prenotazione_affitto_catering della classe Affitto_catering definito precedentemente per richiamare il metodo ausiliario
														// Affitto_catering implementato nella classe Affitto_catering
		return ritorna_menù.AvviaMenù();
	}
	
	// metodo ausiliaro per la gestione dell'affitto con la gestione del catering e dei partecipanti
	public String Affitto_catering_partecipanti() throws ClassNotFoundException, IOException, Exception { //gestione delle eventuali eccezioni generate dal salvataggio nel file binario
		prenotazione_affitto_catering_partecipanti.Affitto_catering_partecipanti();//Utilizzo dell'oggetto prenotazione_affitto_catering_partecipantidella classe Affitto_catering_partecipanti definito precedentemente per richiamare il metodo ausiliario
																					// Affitto_catering_partecipanti implementato nella classe Affitto_catering_partecipanti
		return ritorna_menù.AvviaMenù();
	}
	
	// metodo ausiliario che implemente automaticamente il numero della prenotazione
	public int Contatore() { 
		int implementa = cont_prenotazione++; //salvataggio nella variabile implementa della numerazione progressiva del contatore della prenotazione
		return implementa; //restituzione della variabile implementa 
	}
	
	//metodo relativo alla cancellazione della prenotazione dell'affitto semplice
	public String Cancella_prenotazione_Affitto_semplice() {
		Scanner input = new Scanner(System.in);
		String n_prenotazione; //variabile in cui verrà inserito l'input dell'utente
		System.out.println("Inserisci il numero della prenotazione che intendi cancellare"); //Inserimento da parte dell'utente del numero di prenotazione indicato durante la prenotazione
		n_prenotazione = input.nextLine(); 
			for (int j=0; j<prenotazione_affitto_semplice.Dati_prenotazione.size(); j++) { //ciclo for che scandisce tutti gli elementi dell'ArrayList Dati_prenotazione
					if (prenotazione_affitto_semplice.Dati_prenotazione.get(j).contains(n_prenotazione)) { //condizione if che controlla se l'arrayList Dati_prenotazione contiene, in posizione j, il numero di prenotazione inserito dall'utente
						prenotazione_affitto_semplice.Dati_prenotazione.remove(prenotazione_affitto_semplice.Dati_prenotazione.get(j)); //rimozione dell'elemento nell'ArrayList Dati_prenotazione in posizione j con il metodo remove di ArrayList
					}
				}
		
		int dimensione = prenotazione_affitto_semplice.Dati_prenotazione.size(); //variabile che definisce fino a quando far eseguire il ciclo for prendendo come grandezza la dimensione dell'ArrayList Dati_prenotazione
		//Stampa dell'ArrayList Dati_prenotazione dopo l'eliminazione della prenotazione indicata
		for (int i=0; i<dimensione; i++) {
			System.out.println();
			System.out.println("Dettagli prenotazione aggiornati: ");
			System.out.println();
			System.out.println(prenotazione_affitto_semplice.Dati_prenotazione.get(i)); //Stampa degli elementi contenuti nella posizione i dell'ArrayList Dati_prenotazione
			System.out.println();
		}
		return ("");
	}
	
	//metodo relativo alla cancellazione della prenotazione dell'affitto con catering
	public String Cancella_prenotazione_Affitto_catering() {
		Scanner input = new Scanner(System.in);
		String n_prenotazione;
		System.out.println("Inserisci il numero della prenotazione che intendi cancellare"); //Inserimento da parte dell'utente del numero di prenotazione indicato durante la prenotazione
		n_prenotazione = input.nextLine();
			for (int j=0; j<prenotazione_affitto_catering.Dati_prenotazione_affitto_catering.size(); j++) { //ciclo for che scandisce tutti gli elementi dell'ArrayList Dati_prenotazione_affitto_catering
					if (prenotazione_affitto_catering.Dati_prenotazione_affitto_catering.get(j).contains(n_prenotazione)) { //condizione if che controlla se l'arrayList Dati_prenotazione_affitto_catering contiene, in posizione j, il numero di prenotazione inserito dall'utente
						prenotazione_affitto_catering.Dati_prenotazione_affitto_catering.remove(prenotazione_affitto_catering.Dati_prenotazione_affitto_catering.get(j)); //rimozione dell'elemento nell'ArrayList Dati_prenotazione_affitto_catering in posizione j con il metodo remove di ArrayList
					}
				}
		
		int dimensione = prenotazione_affitto_catering.Dati_prenotazione_affitto_catering.size(); //variabile che definisce fino a quando far eseguire il ciclo for prendendo come grandezza la dimensione dell'ArrayList Dati_prenotazione_affitto_catering
		//Stampa dell'ArrayList Dati_prenotazione dopo l'eliminazione della prenotazione indicata
		for (int i=0; i<dimensione; i++) {
			System.out.println();
			System.out.println("Dettagli prenotazione aggiornati: ");
			System.out.println();
			System.out.println(prenotazione_affitto_catering.Dati_prenotazione_affitto_catering.get(i)); //Stampa degli elementi contenuti nella posizione i dell'ArrayList Dati_prenotazione_affitto_catering
			System.out.println();
		}
		return ("");
	}
	
	//metodo relativo alla cancellazione della prenotazione dell'affitto con catering e gestione dei partecipanti
	public String Cancella_prenotazione_Affitto_catering_parecipanti() {
		Scanner input = new Scanner(System.in);
		String n_prenotazione;
		System.out.println("Inserisci il numero della prenotazione che intendi cancellare"); //Inserimento da parte dell'utente del numero di prenotazione indicato durante la prenotazione
		n_prenotazione = input.nextLine();
			for (int j=0; j<prenotazione_affitto_catering_partecipanti.Dati_prenotazione_affittocatering_partecipanti.size(); j++) { //ciclo for che scandisce tutti gli elementi dell'ArrayList Dati_prenotazione_affittocatering_partecipanti
					if (prenotazione_affitto_catering_partecipanti.Dati_prenotazione_affittocatering_partecipanti.get(j).contains(n_prenotazione)) { //condizione if che controlla se l'arrayList Dati_prenotazione_affittocatering_partecipanti contiene, in posizione j, il numero di prenotazione inserito dall'utente
						prenotazione_affitto_catering_partecipanti.Dati_prenotazione_affittocatering_partecipanti.remove(prenotazione_affitto_catering_partecipanti.Dati_prenotazione_affittocatering_partecipanti.get(j)); //rimozione dell'elemento nell'ArrayList Dati_prenotazione_affittocatering_partecipanti in posizione j con il metodo remove di ArrayList
					}
				}
		
		int dimensione = prenotazione_affitto_catering_partecipanti.Dati_prenotazione_affittocatering_partecipanti.size(); //variabile che definisce fino a quando far eseguire il ciclo for prendendo come grandezza la dimensione dell'ArrayList Dati_prenotazione_affittocatering_partecipanti
		//Stampa dell'ArrayList Dati_prenotazione dopo l'eliminazione della prenotazione indicata
		for (int i=0; i<dimensione; i++) {
			System.out.println();
			System.out.println("Dettagli prenotazione aggiornati: ");
			System.out.println();
			System.out.println(prenotazione_affitto_catering_partecipanti.Dati_prenotazione_affittocatering_partecipanti.get(i)); //Stampa degli elementi contenuti nella posizione i dell'ArrayList Dati_prenotazione_affittocatering_partecipanti
			System.out.println();
		}
		return ("");
	}
	
	//metodo relativo alla visualizzazione di una determinata prenotazione in base al nome e al cognome inseriti dell'utente
	public String Visualizzazione_prenotazione() {
		Scanner input = new Scanner(System.in);
		String dati, nome, cognome; //creazione delle variabili relative all'inserimento dei dati da parte dell'utente 
		System.out.println("Inserisci il nome inserito in fase di prenotazione"); //inserimeto del nome
		nome = input.nextLine();
		System.out.println("Inserisci il cognome inserito in fase di prenotazione"); //inserimento del cognome
		cognome = input.nextLine();
		dati = nome + " " + cognome; //concatenazione delle stringhe nome e cognome nella variabile di tipo stringa dati
		Dati.add(prenotazione_affitto_semplice.Dati_prenotazione + "" + prenotazione_affitto_catering.Dati_prenotazione_affitto_catering + prenotazione_affitto_catering_partecipanti.Dati_prenotazione_affittocatering_partecipanti); //ArrayList Dati che contiene tutti i dati degli ArrayList relativi ai dati delle prenotazioni
		System.out.println("Dati trovati in relazione al nome e al cognome inseriti:");
		int i = 0; //definizione e inizializzazione della variabile contatore i che viene incrementata nel ciclo while
		while(i<Dati.size()) { //Utilizzo della dimensione dell'ArrayList Dati come condizione di controllo del while
				if (prenotazione_affitto_semplice.Dati_prenotazione.get(i).contains(dati)) { //condizione if che controlla se l'ArrayList Dati_prenotazione contiene, in posizione i, i dati inseriti dall'utente 
					System.out.println(prenotazione_affitto_semplice.Dati_prenotazione.get(i)); //Stampa del contenuto, in posizione i, dell'ArrayList Dati_prenotazione quando la condizione if è soddisfatta 
					System.out.println("");
				}
				
				if (prenotazione_affitto_catering.Dati_prenotazione_affitto_catering.get(i).contains(dati)) { //condizione if che controlla se l'ArrayList Dati_prenotazione_affitto_catering contiene, in posizione i, i dati inseriti dall'utente
						System.out.println(prenotazione_affitto_catering.Dati_prenotazione_affitto_catering.get(i)); //Stampa del contenuto, in posizione i, dell'ArrayList Dati_prenotazione_affitto_catering quando la condizione if è soddisfatta 
						System.out.println("");
				}
				
				if (prenotazione_affitto_catering_partecipanti.Dati_prenotazione_affittocatering_partecipanti.get(i).contains(dati)) { //condizione if che controlla se l'ArrayList Dati_prenotazione_affittocatering_partecipanti contiene, in posizione i, i dati inseriti dall'utente
					System.out.println(prenotazione_affitto_catering_partecipanti.Dati_prenotazione_affittocatering_partecipanti.get(i)); //Stampa del contenuto, in posizione i, dell'ArrayList Dati_prenotazione_affittocatering_partecipanti quando la condizione if è soddisfatta 
					System.out.print("Dati partecipanti:");
					for (int j=0; j<=prenotazione_affitto_catering_partecipanti.dati_partecipante.length-1; j++) {
						System.out.println(prenotazione_affitto_catering_partecipanti.dati_partecipante[j]); //Stampa del contenuto dell'Array dati_partecipante, in posizione j, quando la condizione if è soddisfatta
					}
					System.out.println("");
					i++; //incremento della variabile contatore i ad ogni chiamata del ciclo while
			}
			System.out.println("");
	  }
		return null;
	}
	
	public void Salvataggio() throws IOException, ClassNotFoundException { //gestione delle eventuali eccezioni generate dal salvataggio nel file binario
		ObjectOutputStream salvataggio = new ObjectOutputStream(new FileOutputStream("Gestione_prenotazione.dat")); //creazione file binario dove sono inseriti tutti i dati relativi alla prenotazione
		salvataggio.writeObject(prenotazione_affitto_semplice.Dati_prenotazione); //scrittura dei dati relativi all'affitto semplice all'interno del file binario "Gestione_prenotazione.dat" 
		salvataggio.writeObject(prenotazione_affitto_catering.Dati_prenotazione_affitto_catering); //scrittura dei dati relativi all'affitto con gestione del catering all'interno del file binario "Gestione_prenotazione.dat" 
		salvataggio.writeObject(prenotazione_affitto_catering_partecipanti.Dati_prenotazione_affittocatering_partecipanti); //scrittura dei dati relativi all'affitto con gestione del catering e dei partecipanti all'interno del file binario "Gestione_prenotazione.dat" 
		salvataggio.close(); // chiusura del file in scrittura
		System.out.println("I file sono stati correttamente salvati nel file binario");
		System.out.println("");
		System.out.println("Ora verranno mostrati i dattegli delle prenotazioni");
		ObjectInputStream lettura = new ObjectInputStream(new FileInputStream("Gestione_prenotazione.dat")); //lettura del file binario dove sono stati inseriti tutti i dati relativi alla prenotazione
		ArrayList<String> Affitto = new ArrayList<String>(); // creazione di un ArrayList per la lettura dei dati relativi all'affitto semplice
		ArrayList<String> Affitto_catering = new ArrayList<String>();// creazione di un ArrayList per la lettura dei dati relativi all'affitto con la gestione del catering 
		ArrayList<String> Affitto_catering_partecipanti = new ArrayList<String>(); // creazione di un ArrayList per la lettura dei dati relativi all'affitto con la gestione del catering e dei partecipanti
		Affitto = (ArrayList<String>) lettura.readObject(); // lettura dei dati utilizzando la classe Object castando il tipo di dato che deve essere letto
		Affitto_catering = (ArrayList<String>) lettura.readObject(); // lettura dei dati utilizzando la classe Object castando il tipo di dato che deve essere letto
		Affitto_catering_partecipanti = (ArrayList<String>) lettura.readObject(); // lettura dei dati utilizzando la classe Object castando il tipo di dato che deve essere letto
		
		System.out.println("Dati relativi alle prenotazioni del locale secondo il metodo di prenotazione 'Affitto Semplice': ");
		System.out.println(Affitto); // Stampa dei dati letti dal file binario
		System.out.println("");
		System.out.println("Dati relativi alle prenotazioni del locale secondo il metodo di prenotazione 'Affitto con Catering': ");
		System.out.println(Affitto_catering); // Stampa dei dati letti dal file binario
		System.out.println("");
		System.out.println("Dati relativi alle prenotazioni del locale secondo il metodo di prenotazione 'Affitto con Catering e Gestione dei partecipanti': ");
		System.out.println(Affitto_catering_partecipanti); // Stampa dei dati letti dal file binario
		System.out.println("");
		lettura.close(); // chiusura del file in lettura
	}

	//metodo ausiliario per l'ordinamento cronologico delle date
	public String Ordine_cronologico() {
		Date_ordinate.add(prenotazione_affitto_semplice.Dati_prenotazione + "" + prenotazione_affitto_catering.Dati_prenotazione_affitto_catering + prenotazione_affitto_catering_partecipanti.Dati_prenotazione_affittocatering_partecipanti); //ArrayList Date_ordinate che contiene tutti i dati degli ArrayList relativi ai dati delle prenotazioni
		for (int i=0; i<Date_ordinate.size(); i++) { //ciclo for che scandisce tutti gli elementi dell'ArrayList Date_ordinate
				Collections.sort(prenotazione_affitto_semplice.Dati_prenotazione); // Ordinamento dei dati contenuti nell'ArrayList Dati_prenotazione con il metodo sort della classe Collections
				Collections.sort(prenotazione_affitto_catering.Dati_prenotazione_affitto_catering); // Ordinamento dei dati contenuti nell'ArrayList Dati_prenotazione_affitto_catering con il metodo sort della classe Collections
				Collections.sort(prenotazione_affitto_catering_partecipanti.Dati_prenotazione_affittocatering_partecipanti); // Ordinamento dei dati contenuti nell'ArrayList Dati_prenotazione_affittocatering_partecipanti con il metodo sort della classe Collections
				System.out.println();
				System.out.println("Ordinamento cronologico per categoria di prenotazione: ");
				System.out.println();
				System.out.println(prenotazione_affitto_semplice.Dati_prenotazione); //Stampa dei dati ordinati dell'ArrayList Dati_prenotazione
				System.out.println();
				System.out.println(prenotazione_affitto_catering.Dati_prenotazione_affitto_catering); //Stampa dei dati ordinati dell'ArrayList Dati_prenotazione_affitto_catering
				System.out.println();
				System.out.println(prenotazione_affitto_catering_partecipanti.Dati_prenotazione_affittocatering_partecipanti); //Stampa dei dati ordinati dell'ArrayList Dati_prenotazione_affittocatering_partecipanti
				System.out.println();
		}
		return null;
	}
}
