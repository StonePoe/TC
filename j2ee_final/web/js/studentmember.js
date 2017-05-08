/**
 * Created by stonezhang on 2017/3/11.
 */
function showMoney() {

}

function activeMember() {
    var bankcardID = bankid.value;
    var memberCardID = memberid.value;

    $.ajax({
        type: 'post',
        url: '/student/member/active',
        data: 'bankcardID=' + bankcardID + "&memberCardID=" + memberCardID,
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
                window.location.reload();
                // window.location.href = "/student/member";
            } else {
                // document.querySelector(".error-name").className = "control-label error-name";
                alert("Opps!!There are some errors.");
            }
        },
        error: function () {
            alert("Opps!!There are some errors.");
        }
    })
}