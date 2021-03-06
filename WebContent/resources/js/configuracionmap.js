var map;
var myURI = "http://localhost:8080/JYAA/rest/rutas/1";
var mapProp = {
	center : new google.maps.LatLng(-34.9038055, -57.9392111, 18),
	zoom : 5,
	mapTypeId : google.maps.MapTypeId.ROADMAP
};

var puntos = [];
var flightPath;

// Evento
google.maps.event.addDomListener(window, 'load', initialize);

/**
 * Inicializa el mapa
 */
function initialize() {
	
	genericInitialiaze();

	map.addListener('click', function(e) {
		agregarMarker(e.latLng, map);

	});
	
}

function genericInitialiaze(){
	
	map = new google.maps.Map(document.getElementById("map-canvas"), mapProp);
	
	puntos = [];
	var puntosActuales = $(".puntos").text();
	if(puntosActuales != "" && puntosActuales != null){
		arrayPuntos = puntosActuales.split(",");
		arrayPuntos.forEach(function(value){
			if(value != ""){
				latLong = value.split("_");
				punto = {
					lat : parseFloat(latLong[0]),
					lng : parseFloat(latLong[1])
				};
				puntos.push(punto);
			}
		});
	}
	
	obtenerMarkers();
	
} 

// Obtiene markers y los dibuja
function obtenerMarkers() {

	console.log("result " + puntos);
	$.each(puntos, function(i, dato) {
		console.log("dato" + i + dato);
		dibujarMarker(dato);

	});
	dibujarRecorrido();
}

function dibujarMarker(dato) {

	var position = new google.maps.LatLng(dato.lat, dato.lng);

	var marker = new google.maps.Marker({
		position : position,
		icon: {
		      path: google.maps.SymbolPath.CIRCLE,
		      scale: 3
		    },
		//id : dato.id
	});

	marker.addListener("rightclick", function(point) {
		console.log("rigthclick");
		borrarMarker(dato.lat, dato.lng);
		marker.setMap(null);
	});

	//puntos[puntos.length] = position;

	marker.setMap(map);
}

function agregarMarker(latLng) {
	var punto = {
		lat : latLng.lat(),
		lng : latLng.lng()
	};
	$(".lat-long").attr("value", latLng.lat()+"_"+latLng.lng());
	$(".lat-long").change();
	puntos.push(punto);
	deletePath();
}

function dibujarRecorrido() {
	
	flightPath = new google.maps.Polyline({
		path : puntos,
		strokeColor : "#0000FF",
		strokeOpacity : 0.8,
		strokeWeight : 2
	});

	flightPath.setMap(map);
}

//function dibujarRecorridoCircular() {
//
//	markers = puntos;
//	markers[markers.length] = puntos[0];
//
//	var flightPath = new google.maps.Polyline({
//		path : markers,
//		strokeColor : "#0000FF",
//		strokeOpacity : 0.8,
//		strokeWeight : 2
//	});
//
//	flightPath.setMap(map);
//}

$(document).ready(function(){
	$("#borrarMarcadores").click(function(){
		limpiarMapa();
	});
});
function limpiarMapa() {

	punto = {
		id : null
	};
	$.ajax({
		data : punto,
		url : myURI,
		type : "DELETE",
		success : function(result) {
			initialize();
		}
	});

}

function borrarMarker(lat, lon) {
	$(".lat-long2").attr("value", lat+"_"+lon);
	$(".lat-long2").change();
	index = -1;
	$.each(puntos, function(i, dato) {
		if(dato.lat == lat && dato.lng == lon){
			index = i;
		}
	});
	if(index != -1){
		puntos.splice(index,1);
		deletePath();
	}
	
}

function deletePath(){
	flightPath.setMap(null);
	obtenerMarkers();
}