$(document).ready(function () {
    setTimeout(function () {
        $("#popupmain").css("display", "block");
        $(".overlay").addClass("blur");
        $("body").css("overflow", "hidden");
    }, 2000);
});

$(".signup-btn").click(function () {
	$("#popupmain").css("display", "none");
	$("body").css("overflow", "auto");
	$(".overlay").removeClass("blur");
});

  var x = document.getElementById("login");
  var y = document.getElementById("register");
  var z = document.getElementById("btn");

function register() {
    x.style.left = "500px";
    y.style.left = "15px";
    z.style.left = "110px";
}

function login() {
	x.style.left = "15px";
	y.style.left = "500px";
	z.style.left = "0";
}
