/**
 * Created by stonezhang on 2017/3/19.
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

function scorePublish(id) {
    var score = document.getElementById("finalScore" + id).value;
    var courseId = document.getElementById("courseId").value;
    $.ajax({
        type: 'post',
        url: '/institution/course/score',
        data: 'sid=' + id + "&score=" + score + '&cid=' + courseId,

        success: function (data) {
            if(data.success == true) {
                // window.location.reload();
                window.location.href = "/institution/course?cid=" + courseId;
            } else {
                // document.querySelector(".error-name").className = "control-label error-name";
            }
        },
        error: function () {
            alert('network error !!!!!!!!!!!!');
        }
    });
}

function updateInfo() {
    var cid = document.getElementById('courseId').value;
    var cname=  document.getElementById('cname').value;
    var price = document.getElementById('price').value;
    var description = document.getElementById('description').value;
    $.ajax({
        type: 'post',
        url: '/institution/course/update',
        data: 'cid=' + cid + "&cname=" + cname + '&price=' + price + '&description=' + description,

        success: function (data) {
            if(data.success == true) {
                // window.location.reload();
                window.location.href = "/institution/course?cid=" + cid;
            } else {
                // document.querySelector(".error-name").className = "control-label error-name";
            }
        },
        error: function () {
            alert('network error !!!!!!!!!!!!');
        }
    });
}