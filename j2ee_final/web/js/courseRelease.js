/**
 * Created by stonezhang on 2017/3/14.
 */
$(function () {
    //Initialize Select2 Elements
    $(".select2").select2();

    $('#reservation').daterangepicker();

});

function release() {
    console.log('coursename: ' + coursename.value);
    console.log('teacherId: ' + teacherName.value);
    console.log('price: ' + price.value);
    var formerDay = reservation.value.split(' - ')[0];
    var latterDay = reservation.value.split(' - ')[1];
    var reformFormerDay = formerDay.split('/')[2] + '-' + formerDay.split('/')[0] + '-' + formerDay.split('/')[1]
    var reformLatterDay = latterDay.split('/')[2] + '-' + latterDay.split('/')[0] + '-' + latterDay.split('/')[1]
    console.log('date range: ' + reformFormerDay + ", " + reformLatterDay);
    console.log('courseField: ' + courseField.value);
    console.log('img: ' + imgUrl.value);
    console.log("institution: " + institutionId.value);

    if(coursename.value == '') {

    }
    else if(price.value == '') {

    }
    else {
        $.ajax({
            type: 'post',
            url: '/institution/release',
            data: 'name=' + coursename.value + "&tid=" + teacherName.value + "&price=" + price.value+
            "&startdate=" + reformFormerDay + "&enddate=" + reformLatterDay + "&field=" + courseField.value+
            "&imgUrl=" + imgUrl.value + "&insid=" + institutionId.value + "&description=" + description.value,
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
                    window.location.href = "/institution/homepage";
                } else {
                    // document.querySelector(".error-name").className = "control-label error-name";
                }
            },
            error: function () {
                alert('network error !!!!!!!!!!!!');
            }
        })
    }
}