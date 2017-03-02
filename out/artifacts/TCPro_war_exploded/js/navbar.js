/**
 * Created by stonezhang on 2017/3/1.
 */
$("nav ul li").click(function(){
    var xcoord = $(this).data("xcoord");

    $("nav div").stop().animate({marginLeft:xcoord}, 500, "easeInOutExpo");
    $(this).addClass("active");
    $("nav ul li").not(this).removeClass("active");
});

function toStudentPage() {
    document.querySelector(".student").style.display = "block";
    document.querySelector(".institution").style.display = "none";
    sign_in();
}

function toInstitutionPage() {
    document.querySelector(".student").style.display = "none";
    document.querySelector(".institution").style.display = "block";
    sign_in();
}