alert("Route JS File ");

var app = angular.module("myApp", ["ngRoute"]);
app.config(function($routeProvider){
    $routeProvider
       .when("/login",{
    	   templateUrl : "login.htm"
    })
    .when("/register", {
        templateUrl : "register.htm"
    })
    .when("/blog", {
        templateUrl : "blog.htm"
    })
    .when("/chat", {
    	   templateUrl : "chat.htm"
    });
});
