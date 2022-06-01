
//grafico linee crisi economica*******************************************************************
function crea_grafico_linee(data) {
	Highcharts.chart('container3', {
		chart: {
			type: 'line',
			style: {
				fontFamily: 'Raleway',
				fontSize:'12px',
				textTransform: 'uppercase'
			}
		},
		title: {
			text: "Influenze della crisi economica sull'acquisto di integratori"
		},
		subtitle: {
			text: 'Fonte: European Advisory Services for DG SANCO, European Commission'
		},	
		legend: {
			itemStyle:{'color': '#FFFFFF', 'fontWeight': 'normal'}
		},
		colors: ['#00e6e6', '#009999', '#004d4d'],
		xAxis: {
			categories: ['Gen-Mar', 'Apr-Giu', 'Lug- Set', 'Ott-Dic']
		},
		yAxis: {
			title: {
				text: 'Percentuale (%)'
			}
		},
		legend: {
			layout: 'vertical',
			align: 'right',
			verticalAlign: 'middle'
		},
		plotOptions: {
			series: {
				label: {
					connectorAllowed: false
				},
			}
		},
		series: data,
		responsive: {
			rules: [{
				condition: {
					maxWidth: 500
				},
				chartOptions: {
					legend: {
						layout: 'horizontal',
						align: 'center',
						verticalAlign: 'bottom'
					}
				}
			}]
		}
	});
};

//grafico barre: età, genere ******************************************************************* 
function crea_grafico_barre(data) {
	var categories = data.categories;
	Highcharts.chart('container2', {
		chart: {
			type: 'bar',
			style: {
				fontFamily: 'Raleway',
				fontSize:'12px',
				textTransform: 'uppercase'
			}
		},
		title: {
			text: "Percentuale degli utenti in base a sesso ed età"
		},
		subtitle: {
			text: 'Fonte: European Advisory Services for DG SANCO, European Commission'
		},
		colors: ['#6699ff', '#ffb3b3'],
		xAxis: [{
			categories: categories,
			reversed: false,
			labels: {
				step: 1
			}
		}, { // mirror axis on right side
			opposite: true,
			reversed: false,
			categories: categories,
			linkedTo: 0,
			labels: {
				step: 1
			}
		}],
		yAxis: {
			title: {
				text: null
			},
			labels: {
				formatter: function () {
					return Math.abs(this.value) + '%';
				}
			}
		},

		plotOptions: {
			series: {
				stacking: 'normal'
			}
		},

		tooltip: {
			formatter: function () {
				return '<b>' + this.series.name + ', età ' + this.point.category + '</b><br/>' +
					'Percentuale: ' + Highcharts.numberFormat(Math.abs(this.point.y), 0) + '%';
			}
		},

		series: data.series,	
		responsive: {
			rules: [{
				condition: {
					maxWidth: 500
				},
			}],
		},
	});
};

//istogramma tipi di integratori *******************************************************************
function crea_grafico_tipi(data){
	
Highcharts.chart('container1', {
    chart: {
        type: 'column',
		style: {
				fontFamily: 'Raleway',
				fontSize:'12px',
				textTransform: 'uppercase'
			}
    },
    title: {
        text: 'Tipologie e consumo di integratori'
    },
    subtitle: {
        text: 'Fonte: European Advisory Services for DG SANCO, European Commission'
    },
	colors: ['#009999'],
    xAxis: {
        type: 'category',
        labels: {
            rotation: -45,
            style: {
                fontFamily: 'Raleway',
				fontSize:'12px',
				textTransform: 'uppercase'
            }
        }
    },
    yAxis: {
        min: 0,
        title: {
            text: 'Percentuale (%)'
        }
    },
    legend: {
        enabled: false
    },
    tooltip: {
        pointFormat: '<b>{point.y}%</b>'
    },
    series: [{
        name: 'Population',
        data: data,
        dataLabels: {
            enabled: true,
            rotation: -90,
            color: '#FFFFFF',
            align: 'right',
            format: '{point.y}%', 
            y: 10, // 10 pixels down from the top
            style: {
                fontFamily: 'Raleway',
				fontSize:'12px',
				textTransform: 'uppercase'
            }
        }
    }]
});
}
	
//grafico torta: luogo acquisto *******************************************************************
function crea_torta_1(data) {	
	
	//funzione per il colore dei grafici a torta
	var pieColors = (function () {
		var colors = [],
			base = Highcharts.getOptions().colors[0],
			i;

		for (i = 0; i < 10; i += 1) {
			// Start out with a darkened base color (negative brighten), and end
			// up with a much brighter color
			colors.push(Highcharts.Color(base).brighten((i - 5) / 7).get());
		}
		return colors;
	}());
	
	Highcharts.chart('torta1', {
		chart:	{
			plotBackgroundColor: null,
			plotBorderWidth: 0,
			plotShadow: false,
			backgroundColor: null,
			style: {
				fontFamily: 'Raleway',
				fontSize:'12px',
				textTransform: 'uppercase',
			},
		},
		title: {
			text: "Luogo <br/>d'acquisto",
			align: 'center',
			verticalAlign: 'middle',
			y: 0
		},
		tooltip: {
			pointFormat: '<b>{point.percentage:.1f}%</b>'
		},
		plotOptions: {
			pie: {
				cursor: 'pointer',
				colors: pieColors,
				dataLabels: {
					crop: false,
					overflow: 'justify',
					enabled: true,
					distance: -50,
					style: {
						fontSize:'110%',
						fontWeight: 'normal',
						color: 'white',
						textOutline: '0.5px contrast'
					}
				},
				startAngle: 0,
				endAngle: 360
			}
		},
		series: [{
			type: 'pie',
			name: 'Luogo',
			innerSize: '50%',
			data: data
		}],
		responsive: {
			rules: [{
				condition: {
					maxWidth: 500
				},
			}],
		},
	});
};


//grafico torta: motivo acquisto *******************************************************************
function crea_torta_2(data){
	
	//funzione per il colore dei grafici a torta
	var pieColors = (function () {
		var colors = [],
			base = Highcharts.getOptions().colors[0],
			i;

		for (i = 0; i < 10; i += 1) {
			// Start out with a darkened base color (negative brighten), and end
			// up with a much brighter color
			colors.push(Highcharts.Color(base).brighten((i - 3) / 7).get());
		}
		return colors;
	}());
	
	Highcharts.chart('torta2', {
		chart: {
			plotBackgroundColor: null,
			plotBorderWidth: null,
			plotShadow: false,
			backgroundColor: null,
			type: 'pie',
			style: {
				fontFamily: 'Raleway',
				fontSize:'12px',
				textTransform: 'uppercase',
			},
		},
		title: {
			text: "Motivo <br/>d'acquisto",
			align: 'center',
			verticalAlign: 'middle',
			y: 0
		},
		tooltip: {
			pointFormat: '<b>{point.percentage:.1f}%</b>'
		},
		plotOptions: {
			pie: {
				allowPointSelect: true,
				colors: pieColors,
				cursor: 'pointer',
				dataLabels: {
					crop: false,
					overflow: 'justify',
					enabled: true,
					distance: -50,
					style: {
						fontSize:'110%',
						fontWeight: 'normal',
						color: 'white',
						textOutline: '0.5px contrast'
					}
				}
			}
		},
		series: [{
			type: 'pie',
			name: 'Motivo',
			innerSize: '50%',
			data:  data
		}],
		responsive: {
			rules: [{
				condition: {
					maxWidth: 500
				},
			}],
		},
	});
};


//grafico torta: influencer *******************************************************************
function crea_torta_3(data) {
	
	//funzione per il colore dei grafici a torta
	var pieColors = (function () {
		var colors = [],
			base = Highcharts.getOptions().colors[0],
			i;

		for (i = 0; i < 10; i += 1) {
			// Start out with a darkened base color (negative brighten), and end
			// up with a much brighter color
			colors.push(Highcharts.Color(base).brighten((i - 3) / 7).get());
		}
		return colors;
	}());
	
	Highcharts.chart('torta3', {
		chart: {
			plotBackgroundColor: null,
			plotBorderWidth: 0,
			plotShadow: false,
			backgroundColor: null,
			style: {
				fontFamily: 'Raleway',
				fontSize:'12px',
				textTransform: 'uppercase',
			},
		},
		title: {
			text: 'Influencer',
			align: 'center',
			verticalAlign: 'middle',
			y: 0
		},
		tooltip: {
			pointFormat: '<b>{point.percentage:.1f}%</b>'
		},
		plotOptions: {
			pie: {
				colors: pieColors,
				dataLabels: {
					crop: false,
					overflow: 'justify',
					enabled: true,
					distance: -70,
					style: {
						fontSize:'110%',
						fontWeight: 'normal',
						color: 'white',
						textOutline: '0.5px contrast'
					}
				},
				startAngle: 0,
				endAngle: 360
			}
		},
		series: [{
			type: 'pie',
			name: 'Influencer',
			innerSize: '50%',
			data: data
		}],
		responsive: {
			rules: [{
				condition: {
					maxWidth: 500
				},
			}],
		},
	});

};

//grafico percezione-riutilizzo *******************************************************************
function crea_grafico_riutilizzo(data){
	Highcharts.chart('container4', {
    chart: {
        type: 'column',
		style: {
				fontFamily: 'Raleway',
				fontSize:'12px',
				textTransform: 'uppercase'
			}
    },
    title: {
        text: "Percezione dell'efficacia e possibile riutilizzo in futuro"
    },
    subtitle: {
        text: 'Fonte: European Advisory Services for DG SANCO, European Commission'
    },
	colors: ['#47d1d1', '#29a3a3'],
    xAxis: {
        categories: data.categories,
        crosshair: true
    },
    yAxis: {
        min: 0,
        title: {
            text: 'Percentuale (%)'
        }
    },
    tooltip: {
        headerFormat: '<span style="font-size:10px"><b>{point.key}</b></span><table>',
        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
            '<td style="padding:0"><b>{point.y}%</b></td></tr>',
        footerFormat: '</table>',
        shared: true,
        useHTML: true
    },
    plotOptions: {
        column: {
            pointPadding: 0.2,
            borderWidth: 0
        }
    },
    series: data.series
});
}


function inizializza(){ //prende i dati dal php
    $.getJSON('api/getUtenti.php?type=crisi', crea_grafico_linee);
	$.getJSON('api/getUtenti.php?type=genere', crea_grafico_barre);
	$.getJSON('api/getUtenti.php?type=tipi', crea_grafico_tipi);
	$.getJSON('api/getUtenti.php?type=luogo', crea_torta_1);
	$.getJSON('api/getUtenti.php?type=motivo', crea_torta_2);
	$.getJSON('api/getUtenti.php?type=influencer', crea_torta_3);
	$.getJSON('api/getUtenti.php?type=riutilizzo', crea_grafico_riutilizzo);
	
};
window.onload= inizializza;

