function iniciarMap(){
    var coord = {lat:15.3112817 ,lng: -91.4916723};
    var map = new google.maps.Map(document.getElementById('map'),{
      zoom: 10,
      center: coord
    });
    var marker = new google.maps.Marker({
      position: coord,
      map: map
    });
}