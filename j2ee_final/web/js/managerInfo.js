/**
 * Created by stonezhang on 2017/3/23.
 */
function updateName() {
    var newName = document.getElementById("inputName").value;
    if(newName == '') {
        document.querySelector(".error-empty").className = "control-label error-empty";
    }

    else {
        console.log("equal");
        // document.querySelector(".error-ps").className = "control-label error-ps d-none";
        document.querySelector(".psGroup").className = "form-group psGroup";
        setTimeout(function () {
            $.ajax({
                type: 'post',
                url: '/admin/info/name',
                data: 'name=' + newName,
                // success: function (url) {
                //     if(url != null) {
                //         // window.location.reload();
                //         window.location.href = url;
                //     } else {
                //         alert('network error!!!!!!');
                //     }
                // },
                success: function (data) {
                    if(data.success == true) {
                        window.location.reload();
                        // window.location.href = url;
                    } else {
                        document.querySelector(".error-name").className = "control-label error-name";
                    }
                },
                error: function () {
                    alert('network error !!!!!!!!!!!!');
                }
            })
        }, 100);
    }
}

function updatePs() {
    if(password.value != confirmPs.value) {
        console.log("unequal");
        document.querySelector(".error-ps").className = "control-label error-ps";
        document.querySelector(".psGroup").className = "form-group psGroup has-error";
    }
    else {
        console.log("equal");
        document.querySelector(".error-ps").className = "control-label error-ps d-none";
        document.querySelector(".psGroup").className = "form-group psGroup";
        setTimeout(function () {
            var newPassword = password.value;
            console.log(newPassword);
            $.ajax({
                type: 'post',
                url: '/admin/info/password',
                data: 'password=' + newPassword,
                // success: function (url) {
                //     if(url != null) {
                //         // window.location.reload();
                //         window.location.href = url;
                //     } else {
                //         alert('network error!!!!!!');
                //     }
                // },
                success: function (data) {
                    if(data.success == true) {
                        window.location.reload();
                        // window.location.href = url;
                    } else {
                        alert('network error!!!!!!');
                    }
                },
                error: function () {
                    alert('network error !!!!!!!!!!!!');
                }
            })
        }, 100);
    }
}