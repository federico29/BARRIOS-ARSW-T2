/* global axios, google */

var apiclient = (function () {

    function weatherByCity() {
        var city = document.getElementById("city").value;
        const options = {
            method: 'GET',
            url: 'http://localhost:8080/weather/' + city
        };
        axios.request(options).then(function (response) {
            //console.log("Lat: " + response.data.coord.lat);
            //console.log("Lon: " + response.data.coord.lon);
            initMap(response.data.coord.lat, response.data.coord.lon);
        }).catch(function (error) {
            console.error(error);
        });
    }
    
    function initMap(lat, lon) {
        const myLatLng = {lat: lat, lng: lon};
        const map = new google.maps.Map(document.getElementById("map"), {
            zoom: 5,
            center: myLatLng,
            mapId: 'f2eab58da57af0cd'
        });
        new google.maps.Marker({
            position: myLatLng,
            map,
            title: "City"
        });
    }

    return {
        weatherByCity: weatherByCity,
        initMap: initMap
    };
})();
