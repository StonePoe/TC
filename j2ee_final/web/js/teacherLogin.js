/**
 * Created by stonezhang on 2017/3/28.
 */
function registerWithCheck() {


    setTimeout(function () {
        if(password.value != confirmPs.value) {
            console.log("unequal");
            // document.querySelector(".error-ps").className = "control-label error-ps";
        }
        else {
            $.ajax({
                type: 'post',
                url: '/teacher/register/info',
                data: 'name=' + username.value + "&password=" + password.value,
                // success: function (url) {
                //     if(url != null) {
                //         // window.location.reload();
                //         window.location.href = url;
                //     } else {
                //         alert('network error!!!!!!');
                //
                // },
                success: function (data) {
                    if(data.success == true) {
                        // window.location.reload();
                        window.location.href = "/teacher/homepage";
                    } else {
                        document.querySelector(".error-name").className = "control-label error-name";
                    }
                },
                error: function () {
                    alert('network error !!!!!!!!!!!!');
                }
            })
        }
    }, 500);

}
