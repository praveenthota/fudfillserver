<!DOCTYPE html>
<html>
<body>


<!DOCTYPE html>
<html>
<head>
<script
src="http://maps.googleapis.com/maps/api/js">
</script>

<script>
var myCenter=new google.maps.LatLng(51.508742,-0.120850);

function initialize()
{
var mapProp = {
  center: myCenter,
  zoom:5,
  mapTypeId: google.maps.MapTypeId.ROADMAP
  };

var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);

var marker = new google.maps.Marker({
  position: myCenter,
  title:'Click to zoom'
  });

marker.setMap(map);

// Zoom to 9 when clicking on marker
google.maps.event.addListener(marker,'click',function() {
  map.setZoom(9);
  map.setCenter(marker.getPosition());
  });
}
google.maps.event.addDomListener(window, 'load', initialize);
</script>
</head>
<body>

<form action="http://localhost:8080/fudfildelivery/locupdate" method="post">
<h1>Update Location Info </h1>
userid: <input type="text" name="userid" value="Email-id"><br>
Latitude: <input type="text" name="lati" value="Latitude"><br>
Longitude: <input type="text" name="long" value="Longitude"><br>
<input type="submit" value="Submit">
</form>

<p>Click the "Submit" button to update the location of a user".</p>

</body>
</html>

<form action="http://localhost:8080/fudfildelivery/locinfo">
<h1>Fetch Location Info </h1>
userid: <input type="text" name="userid" value="Email-id"><br>
<input type="submit" value="Submit">
</form>

<p>Click the "Submit" button to fetch the location of Runner".</p>

<div id="googleMap" style="width:500px;height:380px;"></div>
</body>
</html>
