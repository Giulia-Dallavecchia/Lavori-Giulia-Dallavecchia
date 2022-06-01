import java.util.*;
import java.lang.*;
import java.io.*;

public class Gestione_prenotazioni {
	private static Menù ritorna_menù = new Menù(); //creazione oggetto della classe Menù per la visualizzazione del menù
	public static void main(String[] args) throws ClassNotFoundException, IOException, Exception { //gestione delle eventuali eccezioni generate dal salvataggio nel file binario
 		ritorna_menù.AvviaMenù(); //Utilizzo dell'oggeto della classe Menù definito precedentemente per richiamare il metodo ausiliario
												// AvviaMenù implementato nella classe Menù
	}	
}

