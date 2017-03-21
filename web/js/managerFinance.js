/**
 * Created by stonezhang on 2017/3/18.
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
    $.ajax({
        type: 'post',
        url: '/admin/financeCheck/agree',
        data: 'id=' + id,

        success: function (data) {
            if(data.success == true) {
                window.location.reload();
                // window.location.href = "/institution/homepage";
            } else {
                window.location.reload();
                // document.querySelector(".error-name").className = "control-label error-name";
            }
        },
        error: function () {
            alert('network error !!!!!!!!!!!!');
        }
    });
}

function disagree(id) {
    $.ajax({
        type: 'post',
        url: '/admin/financeCheck/disagree',
        data: 'id=' + id,

        success: function (data) {
            if(data.success == true) {
                window.location.reload();
                // window.location.href = "/institution/homepage";
            } else {
                window.location.reload();
                // document.querySelector(".error-name").className = "control-label error-name";
            }
        },
        error: function () {
            alert('network error !!!!!!!!!!!!');
        }
    });
}