const numero_foto = 8;
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
		// Variabili galleria 
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
function myFunctionFisica() {
	var dots = document.getElementById("dotsF");
	var moreText = document.getElementById("moreF");
	var btnText = document.getElementById("myBtnF");
  
	if (dots.style.display == "none") {
	  dots.style.display = "inline";
	  btnText.innerHTML = "VIOLENZA FISICA"; 
	  moreText.style.display = "none";
	} else {
	  dots.style.display = "none";
	  btnText.innerHTML = "Riduci"; 
	  moreText.style.display = "inline";
	}
  }
  function myFunctionSessuale() {
	var dots = document.getElementById("dotsS");
	var moreText = document.getElementById("moreS");
	var btnText = document.getElementById("myBtnS");
  
	if (dots.style.display == "none") {
	  dots.style.display = "inline";
	  btnText.innerHTML = "VIOLENZA SESSUALE"; 
	  moreText.style.display = "none";
	} else {
	  dots.style.display = "none";
	  btnText.innerHTML = "Riduci"; 
	  moreText.style.display = "inline";
	}
  }
  function myFunctionPsicologica() {
	var dots = document.getElementById("dotsP");
	var moreText = document.getElementById("moreP");
	var btnText = document.getElementById("myBtnP");
  
	if (dots.style.display == "none") {
	  dots.style.display = "inline";
	  btnText.innerHTML = "VIOLENZA PSICOLOGICA"; 
	  moreText.style.display = "none";
	} else {
	  dots.style.display = "none";
	  btnText.innerHTML = "Riduci"; 
	  moreText.style.display = "inline";
	}
  }
function myFunctionEconomica() {
	var dots = document.getElementById("dotsE");
	var moreText = document.getElementById("moreE");
	var btnText = document.getElementById("myBtnE");
  
	if (dots.style.display == "none") {
	  dots.style.display = "inline";
	  btnText.innerHTML = "VIOLENZA ECONOMICA"; 
	  moreText.style.display = "none";
	} else {
	  dots.style.display = "none";
	  btnText.innerHTML = "Riduci"; 
	  moreText.style.display = "inline";
	}
  }



