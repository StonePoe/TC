/**
 * Created by stonezhang on 2017/3/15.
 */
$(function () {
    $("#example1").DataTable();
    $('#example2').DataTable({
        "paging": true,
        "lengthChange": false,
        "searching": false,
        "ordering": true,
        "info": true,
        "autoWidth": false
    });

    $('#example3').DataTable({
        "paging": true,
        "lengthChange": false,
        "searching": false,
        "ordering": true,
        "info": true,
        "autoWidth": false
    });
});

function agree(id) {
    var comment = document.getElementById('comment' + id);
    console.log(comment.value);
    $.ajax({
        type: 'post',
        url: '/admin/courseCheck',
        data: 'id=' + id + "&comment=" + comment.value + '&agree=1',
        success: function (data) {
            if(data.success == true) {
                window.location.reload();
                // window.location.href = "/institution/homepage";
            } else {
                // document.querySelector(".error-name").className = "control-label error-name";
            }
        },
        error: function () {
            alert('network error !!!!!!!!!!!!');
        }
    });
}

function disagree(id) {
    var comment = document.getElementById('comment' + id);
    console.log(comment.value);
    $.ajax({
        type: 'post',
        url: '/admin/courseCheck',
        data: 'id=' + id + "&comment=" + comment.value + '&agree=-1',
        success: function (data) {
            if(data.success == true) {
                window.location.reload();
                // window.location.href = "/institution/homepage";
            } else {
                // document.querySelector(".error-name").className = "control-label error-name";
            }
        },
        error: function () {
            alert('network error !!!!!!!!!!!!');
        }
    });
}

function agreeUpdate(id) {
    var cname = document.getElementById("cname" + id).value;
    var description = document.getElementById("description" + id).value;
    var price = document.getElementById("price" + id).value;
    var cid = document.getElementById("cid" + id).value;
    var updateId = document.getElementById("updateId" + id).value;
    $.ajax({
        type: 'post',
        url: '/admin/course/update/agree',
        data: 'checkId=' + id + '&cname=' + cname + '&description=' + description +
        '&cid=' + cid + '&price=' + price + '&updateId=' + updateId,
        success: function (data) {
            if(data.success == true) {
                window.location.reload();
                // window.location.href = "/institution/homepage";
            } else {
                // document.querySelector(".error-name").className = "control-label error-name";
            }
        },
        error: function () {
            alert('network error !!!!!!!!!!!!');
        }
    });
}

function disagreeUpdate(id) {
    var updateId = document.getElementById("updateId" + id).value;
    var cid = document.getElementById("cid" + id).value;
    $.ajax({
        type: 'post',
        url: '/admin/course/update/disagree',
        data: 'checkId=' + id + "&updateId=" + updateId + "&cid=" + cid,
        success: function (data) {
            if(data.success == true) {
                window.location.reload();
                // window.location.href = "/institution/homepage";
            } else {
                // document.querySelector(".error-name").className = "control-label error-name";
            }
        },
        error: function () {
            alert('network error !!!!!!!!!!!!');
        }
    });
}