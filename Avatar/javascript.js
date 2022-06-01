var testa1;
var testa2;
var testa3;
var testa4;
var testa5;
var testa6;
var corpo1;
var corpo2;
var corpo3;
var corpo4;
var corpo5;
var corpo6;
var gambe1;
var gambe2;
var gambe3; 
var gambe4;
var gambe5;
var gambe6;
var contenitoreTesta; 
var contenitoreCorpo; 
var contenitoreGambe;

const numero_foto = 3;
const Ritardo = 1000; 
var galleria;
var indiceFoto;
var automatico;
var nodoAvanti;
var nodoIndietro;
var nodoStartStop; 
var nodoFoto;


//gestore per l'inizializzazione della pagina assegnango i valori tramite id 

function gestoreLoad(){
	try {
		testa1=document.getElementById("testa1");
		testa2=document.getElementById("testa2");
		testa3=document.getElementById("testa3");
		testa4=document.getElementById("testa4");
		testa5=document.getElementById("testa5");
		testa6=document.getElementById("testa6");
		corpo1=document.getElementById("corpo1");
		corpo2=document.getElementById("corpo2");
		corpo3=document.getElementById("corpo3");
		corpo4=document.getElementById("corpo4");
		corpo5=document.getElementById("corpo5");
		corpo6=document.getElementById("corpo6");
		gambe1=document.getElementById("gambe1");
		gambe2=document.getElementById("gambe2");
		gambe3=document.getElementById("gambe3");
		gambe4=document.getElementById("gambe4");
		gambe5=document.getElementById("gambe5");
		gambe6=document.getElementById("gambe6");
		testa1.ondragstart = gestoreDragStart;
		testa2.ondragstart = gestoreDragStart;
		testa3.ondragstart = gestoreDragStart;
		testa4.ondragstart = gestoreDragStart;
		testa5.ondragstart = gestoreDragStart;
		testa6.ondragstart = gestoreDragStart;
		corpo1.ondragstart = gestoreDragStart;
		corpo2.ondragstart = gestoreDragStart;
		corpo3.ondragstart = gestoreDragStart;
		corpo4.ondragstart = gestoreDragStart;
		corpo5.ondragstart = gestoreDragStart;
		corpo6.ondragstart = gestoreDragStart;
		gambe1.ondragstart = gestoreDragStart;
		gambe2.ondragstart = gestoreDragStart;
		gambe3.ondragstart = gestoreDragStart;
		gambe4.ondragstart = gestoreDragStart;
		gambe5.ondragstart = gestoreDragStart;
		gambe6.ondragstart = gestoreDragStart;
		testa1.onmouseover = gestoreCursore;
		testa2.onmouseover = gestoreCursore;
		testa3.onmouseover = gestoreCursore;
		testa4.onmouseover = gestoreCursore;
		testa5.onmouseover = gestoreCursore;
		testa6.onmouseover = gestoreCursore;
		corpo1.onmouseover = gestoreCursore;
		corpo2.onmouseover = gestoreCursore;
		corpo3.onmouseover = gestoreCursore;
		corpo4.onmouseover = gestoreCursore;
		corpo5.onmouseover = gestoreCursore;
		corpo6.onmouseover = gestoreCursore;
		gambe1.onmouseover = gestoreCursore;
		gambe2.onmouseover = gestoreCursore;
		gambe3.onmouseover = gestoreCursore;
		gambe4.onmouseover = gestoreCursore;
		gambe5.onmouseover = gestoreCursore;
		gambe6.onmouseover = gestoreCursore;
		// creazione avatar
		contenitoreTesta=document.getElementById("contenitoreTesta");
		contenitoreCorpo=document.getElementById("contenitoreCorpo");
		contenitoreGambe=document.getElementById("contenitoreGambe");
		contenitoreTesta.ondragover = gestoreDragOver;
		contenitoreTesta.ondrop = gestoreDrop;
		contenitoreCorpo.ondragover = gestoreDragOver;
		contenitoreCorpo.ondrop = gestoreDrop;
		contenitoreGambe.ondragover = gestoreDragOver;
		contenitoreGambe.ondrop = gestoreDrop;
		// gestione di ritorno 
		t1=document.getElementById("t1");
		t1.ondragover = gestoreDragOver;
		t1.ondrop = gestoreDrop;
		t2=document.getElementById("t2");
		t2.ondragover = gestoreDragOver;
		t2.ondrop = gestoreDrop;
		t3=document.getElementById("t3");
		t3.ondragover = gestoreDragOver;
		t3.ondrop = gestoreDrop;
		t4=document.getElementById("t4");
		t4.ondragover = gestoreDragOver;
		t4.ondrop = gestoreDrop;
		t5=document.getElementById("t5");
		t5.ondragover = gestoreDragOver;
		t5.ondrop = gestoreDrop;
		t6=document.getElementById("t6");
		t6.ondragover = gestoreDragOver;
		t6.ondrop = gestoreDrop;
		
		
		c1=document.getElementById("cc1");
		c1.ondragover = gestoreDragOver;
		c1.ondrop = gestoreDrop;
		c2=document.getElementById("cc2");
		c2.ondragover = gestoreDragOver;
		c2.ondrop = gestoreDrop;
		c3=document.getElementById("cc3");
		c3.ondragover = gestoreDragOver;
		c3.ondrop = gestoreDrop;
		c4=document.getElementById("cc4");
		c4.ondragover = gestoreDragOver;
		c4.ondrop = gestoreDrop;
		c5=document.getElementById("cc5");
		c5.ondragover = gestoreDragOver;
		c5.ondrop = gestoreDrop;
		c6=document.getElementById("cc6");
		c6.ondragover = gestoreDragOver;
		c6.ondrop = gestoreDrop;
		
		
		g1=document.getElementById("g1");
		g1.ondragover = gestoreDragOver;
		g1.ondrop = gestoreDrop;
		g2=document.getElementById("g2");
		g2.ondragover = gestoreDragOver;
		g2.ondrop = gestoreDrop;
		g3=document.getElementById("g3");
		g3.ondragover = gestoreDragOver;
		g3.ondrop = gestoreDrop;
		g4=document.getElementById("g4");
		g4.ondragover = gestoreDragOver;
		g4.ondrop = gestoreDrop;
		g5=document.getElementById("g5");
		g5.ondragover = gestoreDragOver;
		g5.ondrop = gestoreDrop;
		g6=document.getElementById("g6");
		g6.ondragover = gestoreDragOver;
		g6.ondrop = gestoreDrop;
		
		// cariabili galleria 
		nodoAvanti = document.getElementById("avanti");
		nodoIndietro = document.getElementById("indietro");
		nodoFoto = document.getElementById("foto");
		nodoAvanti.onclick = gestoreClickAvanti;
		nodoIndietro.onclick = gestoreClickIndietro;
		automatico = false;
		galleria = [];
		for (var i=0; i < numero_foto; i++) {
			var nomeFoto = "immagini/galleria/foto" + i + ".jpg";
			galleria.push(nomeFoto);
		}
		indiceFoto = 0;
		cambiaFoto(0);
	} catch (e) {
    alert("gestoreLoad " + e);
  }
}
window.onload = gestoreLoad;

//gestore del drag and drop
function gestoreDragStart(evento) {
  try {
    evento.dataTransfer.setData("text", this.id);
  } catch (e) {
    alert("gestoreDragStart " + e);
  }
}

function gestoreDragOver(evento) {
  try {
    evento.preventDefault();
  } catch (e) {
    alert("gestoreDragOver " + e);
  }
}

// gestore evento drop vero e proprio

function gestoreDrop(evento){
	try {
		evento.preventDefault();
		var dati = evento.dataTransfer.getData("text");
		if (this.childNodes.length == 0) {
			this.appendChild(document.getElementById(dati));
			  
			  document.getElementById(dati).style.width = "auto"; //la larghezza è fissata per prendere tutta la grandezza del contenitore 
			  document.getElementById(dati).style.height = "90%"; //la lunghezza è stata ridimensionata per evitare sovrapposizione tra immagini
		} else {
			alert("Puoi inserire massimo una linea per sezione");
			}
	} catch (e) {
    alert("gestoreDrop " + e);
  }	
}

//gestore che gestisce il cambio del corsore quando si passa sulle immagini

function gestoreCursore () {
	 try {
		testa1.style.cursor = "pointer";
		testa2.style.cursor = "pointer";
		testa3.style.cursor = "pointer";
		testa4.style.cursor = "pointer";
		testa5.style.cursor = "pointer";
		testa6.style.cursor = "pointer";
		corpo1.style.cursor = "pointer";
		corpo2.style.cursor = "pointer";
		corpo3.style.cursor = "pointer";
		corpo4.style.cursor = "pointer";
		corpo5.style.cursor = "pointer";
		corpo6.style.cursor = "pointer";
		gambe1.style.cursor = "pointer";
		gambe2.style.cursor = "pointer";
		gambe3.style.cursor = "pointer";
		gambe4.style.cursor = "pointer";
		gambe5.style.cursor = "pointer";
		gambe6.style.cursor = "pointer";
	 } catch ( e ) {
	 alert("gestoreCursore " + e);
	 }
}

// Galleria di immagini 
function gestoreClickAvanti () {
	try {
		if (automatico) {
			return;
		} 
		cambiaFoto(+1);
	}
	catch (e) {
		alert ("gestoreClickAvanti " + e);
	}
}
function gestoreClickIndietro () {
	try {
		if (automatico) {
			return;
		} cambiaFoto(-1);
	}
	catch (e) {
		alert ("gestoreClickIndietro " + e);
	}
}
function cambiaFoto (x) {
	indiceFoto += x;
	try {
		if (indiceFoto == numero_foto) {
			indiceFoto = 0;
		}
		if (indiceFoto < 0) {
			indiceFoto = numero_foto - 1;
		}
		nodoFoto.setAttribute("src", galleria[indiceFoto]);
	}
	catch (e) {
		alert ("cambiaFoto " + e);
	}
}





