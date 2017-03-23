/**
 * Created by stonezhang on 2017/3/16.
 */
function quit(sid, cid) {
    console.log(sid);
    console.log(cid);
    var price = document.getElementById("coursePrice").value;
    $.ajax({
        type: 'post',
        url: '/student/course/quit',
        data: 'sid=' + sid  + '&cid=' + cid + '&price=' + price,
        success: function (data) {
            if(data.success == true) {
                // window.location.reload();
                window.location.href = "/student/homepage";
            } else {
                // document.querySelector(".error-name").className = "control-label error-name";
            }
        },
        error: function () {
            alert('network error !!!!!!!!!!!!');
        }
    })
}

function book(sid, cid) {
    console.log(sid);
    console.log(cid);
    var price = document.getElementById("coursePrice").value;
    $.ajax({
        type: 'post',
        url: '/student/course/book',
        data: 'sid=' + sid  + '&cid=' + cid + '&price=' + price,
        success: function (data) {
            if(data.success == true) {
                // window.location.reload();
                window.location.href = "/student/homepage";
            } else {
                // document.querySelector(".error-name").className = "control-label error-
                alert("金额不足");
            }
        },
        error: function () {
            alert('network error !!!!!!!!!!!!');
        }
    })
}

function study(sid, cid) {
    $.ajax({
        type: 'post',
        url: '/student/course/study',
        data: 'sid=' + sid  + '&cid=' + cid,
        success: function (data) {
            if(data.success == true) {
                // window.location.reload();
                window.location.href = "https://www.coursera.org";
            } else {
                // document.querySelector(".error-name").className = "control-label error-
                alert("出现了错误！！");
            }
        },
        error: function () {
            alert('network error !!!!!!!!!!!!');
        }
    })
}