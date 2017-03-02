// sign up / register entry
function sign_up(){
    var inputs = document.querySelectorAll('.input_form_sign');
    document.querySelectorAll('.ul_tabs > li')[0].className="";
    document.querySelectorAll('.ul_tabs > li')[1].className="active";

    for(var i = 0; i < inputs.length ; i++  ) {
        // display the input area;
        document.querySelectorAll('.input_form_sign')[i].className = "input_form_sign d_block";
        // console.log(document.querySelectorAll('.input_form_sign')[i].className);
        // if(i == 2  ){
        //
        // }else{
        //     document.querySelectorAll('.input_form_sign')[i].className = "input_form_sign d_block";
        // }
        // if (document.querySelectorAll('.input_form_sign')[i].className.includes("input_sign_up")) {
        //     document.querySelectorAll('.input_form_sign')[i].style.display = "block";
        // }
        // else {
        //     document.querySelectorAll('.input_form_sign')[i].style.display = "none";
        // }
    }

    setTimeout( function(){
        for(var d = 0; d < inputs.length ; d++  ) {
            // add the dynamic loading effect
            document.querySelectorAll('.input_form_sign')[d].className = "input_form_sign d_block active_inp";
            // document.querySelectorAll('.input_form_sign')[d].className += " active_inp";
        }

    },100 );
    // console.log(document.querySelector(document.querySelector('.link_forgot_pass')));
    document.querySelector('.link_forgot_pass').style.opacity = "0";
    document.querySelector('.link_forgot_pass').style.top = "-5px";
    // document.querySelector('.btn_sign').innerHTML = "SIGN UP";
    setTimeout(function(){

        document.querySelector('.terms_and_cons').style.opacity = "1";
        document.querySelector('.terms_and_cons').style.top = "5px";

    },500);
    setTimeout(function(){
        document.querySelector('.link_forgot_pass').className = "link_forgot_pass d_none";
        document.querySelector('.terms_and_cons').className = "terms_and_cons d_block";
    },450);

    document.querySelector(".btn_sign_in").style.display = "none";
    document.querySelector(".btn_sign_up").style.display = "block";
}


// sign in entry
function sign_in(){
    var inputs = document.querySelectorAll('.input_form_sign');
    document.querySelectorAll('.ul_tabs > li')[0].className = "active";
    document.querySelectorAll('.ul_tabs > li')[1].className = "";

    for(var i = 0; i < inputs.length ; i++  ) {
        // switch(i) {
        //     case 1:
        //         console.log(inputs[i].name);
        //         break;
        //     case 2:
        //         console.log(inputs[i].name);
        //     default:
        //         document.querySelectorAll('.input_form_sign')[i].className = "input_form_sign d_block";
        // }
        if (inputs[i].name == "name" || inputs[i].name == "pass") {
            document.querySelectorAll('.input_form_sign')[i].className = "input_form_sign d_block";
        }
        else {
            document.querySelectorAll('.input_form_sign')[i].className = "input_form_sign d_none";
        }

    }

    setTimeout( function(){
        for(var d = 0; d < inputs.length ; d++  ) {
            // switch(d) {
            //     case 1:
            //         console.log(inputs[d].name);
            //         break;
            //     case 2:
            //         console.log(inputs[d].name);
            //
            //     default:
            //         document.querySelectorAll('.input_form_sign')[d].className = "input_form_sign d_block";
            //         document.querySelectorAll('.input_form_sign')[2].className = "input_form_sign d_block active_inp";
            //
            // }
            if (inputs[d].name == "name" || inputs[d].name == "pass") {
                document.querySelectorAll('.input_form_sign')[d].className = "input_form_sign d_block active_inp";
            }

        }
    },100 );

    document.querySelector('.terms_and_cons').style.opacity = "0";
    document.querySelector('.terms_and_cons').style.top = "-5px";

    setTimeout(function(){
        document.querySelector('.terms_and_cons').className = "terms_and_cons d_none";
        document.querySelector('.link_forgot_pass').className = "link_forgot_pass d_block";

    },500);

    setTimeout(function(){

        document.querySelector('.link_forgot_pass').style.opacity = "1";
        document.querySelector('.link_forgot_pass').style.top = "5px";


        // for(var d = 0; d < inputs.length ; d++  ) {
        //
        //     switch(d) {
        //         case 1:
        //             console.log(inputs[d].name);
        //             break;
        //         case 2:
        //             console.log(inputs[d].name);
        //
        //             break;
        //         default:
        //             document.querySelectorAll('.input_form_sign')[d].className = "input_form_sign";
        //     }
        // }
    },500);
    // document.querySelector('.btn_sign').innerHTML = "SIGN IN";
    document.querySelector(".btn_sign_in").style.display = "block";
    document.querySelector(".btn_sign_up").style.display = "none";
}

function inputCheck() {
    var inputs = document.querySelectorAll('.input_form_sign');

}

window.onload =function(){
    document.querySelector('.cont_centrar').className = "cont_centrar cent_active";

}



/**
 * Created by stonezhang on 2017/2/28.
 */
