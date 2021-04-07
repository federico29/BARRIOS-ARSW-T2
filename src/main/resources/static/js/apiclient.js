/* global axios, google */
var apiclient = (function () {

    function firstPage(){
        $("#general").hide();
        $("#specific").hide();
    }
    
    function weatherByCity() {
        var city = document.getElementById("city").value;
        const options = {
            method: 'GET',
            url: window.location.href + '/weather/' + city
        };
        axios.request(options).then(function (response) {
            expandPage(response.data);
            initMap(response.data.coord.lat, response.data.coord.lon);
        }).catch(function (error) {
            console.error(error);
        });
    }
    
    function expandPage(data) {
        $("#general").show();
        $("#specific").show();
        $("#cityname").empty();
        $("#temperature").empty();
        $("#main").empty();
        $("#feelslike").empty();
        $("#windspeed").empty();
        $("#visibility").empty();
        $("#humidity").empty();
        $("#pressure").empty();
        $("#cityname").append(data.name);
        $("#temperature").append(data.main.temp + '°C');
        $("#main").append(data.weather[0].main);
        $("#feelslike").append(data.main.feels_like + '°C');
        $("#windspeed").append(data.wind.speed + ' m/s');
        $("#visibility").append(data.visibility + ' m');
        $("#humidity").append(data.main.humidity + '%');
        $("#pressure").append(data.main.pressure + ' hPa');
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
        initMap: initMap,
        expandPage: expandPage,
        firstPage: firstPage
    };
})();
