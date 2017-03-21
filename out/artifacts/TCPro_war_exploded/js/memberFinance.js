/**
 * Created by stonezhang on 2017/3/19.
 */
function charge() {
    var bankId = document.getElementById("bankId").value;
    var memberId = document.getElementById("memberId").value;
    var money = document.getElementById("memberMoney").value;

    $.ajax({
        type: 'post',
        url: '/student/member/finance',
        data: 'bankId=' + bankId + '&memberId=' + memberId + '&money=' + money,
        success: function (data) {
            if(data.success == true) {
                // window.location.reload();
                window.location.href = "/student/member";
            }
            else if(data.success == false) {
                alert("not enough money!")
                // document.querySelector(".error-name").className = "control-label error-name";
            }
        },
        error: function () {
            alert('network error !!!!!!!!!!!!');
        }
    });
}

function destroy() {
    var memberId = document.getElementById("memberId").value
    $.ajax({
        type: 'post',
        url: '/student/member/destroy',
        data: 'memberId=' + memberId,
        success: function (data) {
            if(data.success == true) {
                // window.location.reload();
                window.location.href = "/student/member";
            }
            else if(data.success == false) {
                alert("error!")
                // document.querySelector(".error-name").className = "control-label error-name";
            }
        },
        error: function () {
            alert('network error !!!!!!!!!!!!');
        }
    });
}