var rendererOptions = {draggable: true};  
var directionsDisplay = new google.maps.DirectionsRenderer(rendererOptions);
var directionsService = new google.maps.DirectionsService();
var map;
var marker;
var laplata = new google.maps.LatLng(-34.929448, -57.950127); 
var mapOptions = {
  mapTypeId: google.maps.MapTypeId.ROADMAP,
  zoom: 12,
  center: laplata
};
var ne = new google.maps.LatLng(-32.212801,-67.609863);
var sw = new google.maps.LatLng(-37.195331,-69.433594);
var argentina = new google.maps.LatLngBounds(sw, ne);

var data = {};
var markers =[];

function inicializarRegistroViaje() {
  map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);  
  directionsDisplay.setMap(map);
	google.maps.event.addListener(map, 'click', function(event) {
		
	   var marker = new google.maps.Marker({position: event.latLng, map: map});
	   markers.push(marker);
	   marker.addListener('rightclick',function(event){
		  marker.setMap(null); 
	   });
	
	});
	
	function eliminarMarcadores(){
		for (var i = 0; i < markers.length; i++) {
		    markers[i].setMap(null);
		  }
	}
	
	$("#borrarMarcadores").click(function(){
		eliminarMarcadores();
	});
}

$(document).ready(function(){

});

function inicializarEdicionViaje(wp){
	  map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);	  
	  directionsDisplay.setMap(map);
	  directionsDisplay.addListener('directions_changed', function() {
		  //ACA SE DEBERIAN ACTUALIZAR LOS WAYPOINTS Y EL KM
		  actualizarTrayecto(directionsDisplay.getDirections());		  
	  });
	  directionsDisplay.setPanel(document.getElementById('directionsPanel'));
	  var wpV = JSON.parse(wp)
	  
	  var waypoints = [];
	  for(i in wpV.waypoints){
		var latlng = wpV.waypoints[i];
		waypoints.push({
			location: new google.maps.LatLng(parseFloat(latlng[0]), parseFloat(latlng[1])),
			stopover: false
		});
	  }
	  var start = wpV.start;
	  var end = wpV.end;
	  
	  if ((wpV.start != "") && (wpV.end != "")){	
	    var request = {
	      origin: start,
	      destination: end,
	      waypoints: waypoints,
	      travelMode: google.maps.TravelMode.DRIVING
	    };

	    directionsService.route(request, function(response, status) {
	      if (status == google.maps.DirectionsStatus.OK) {
	        directionsDisplay.setDirections(response);
	      }
	    });
	  }
	  else{
	    alert("El recorrido no se muestra porque los datos son incorrectos");
	  }	
}



$(document).ready(function(){

});

