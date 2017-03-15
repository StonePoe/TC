var filechooser = document.getElementById('filechooser');
var previewer = document.getElementById('previewer');

// 200 KB 对应的字节数
var maxsize = 200 * 1024;

filechooser.onchange = function() {
    previewer.className = "img-bordered";
    var files = this.files;
    var file = files[0];

    // 接受 jpeg, jpg, png 类型的图片
    if (!/\/(?:jpeg|jpg|png)/i.test(file.type)) return;

    var reader = new FileReader();
    reader.onload = function() {
        var result = this.result;
        var img = new Image();

        // 如果图片小于 200kb，不压缩
        if (result.length <= maxsize) {
            toPreviewer(result);
            return;
        }

        img.onload = function() {
            var compressedDataUrl = compress(img, file.type);
            toPreviewer(compressedDataUrl);
            img = null;
        };

        img.src = result;
    };

    reader.readAsDataURL(file);
};

function toPreviewer(dataUrl) {
    previewer.src = dataUrl;
    filechooser.value = '';
}

function compress(img, fileType) {
    var canvas = document.createElement("canvas");
    var ctx = canvas.getContext('2d');

    var width = img.width;
    var height = img.height;

    canvas.width = width;
    canvas.height = height;

    ctx.fillStyle = "#fff";
    ctx.fillRect(0, 0, canvas.width, canvas.height);
    ctx.drawImage(img, 0, 0, width, height);

    // 压缩
    var base64data = canvas.toDataURL(fileType, 0.75);
    canvas = ctx = null;

    return base64data;
}


function showSecurity() {
    document.querySelector(".basicInfo").style.display = "none";
    document.querySelector(".securityInfo").style.display = "block";
    document.querySelector(".bankInfo").style.display = "none";
    document.querySelector(".basicLink").className = "basicLink";
    document.querySelector(".securityLink").className = "securityLink active";
    document.querySelector(".bankLink").className = "bankLink";
}

function showBaisc() {
    document.querySelector(".basicInfo").style.display = "block";
    document.querySelector(".securityInfo").style.display = "none";
    document.querySelector(".bankInfo").style.display = "none";
    document.querySelector(".basicLink").className = "basicLink active";
    document.querySelector(".securityLink").className = "securityLink";
    document.querySelector(".bankLink").className = "bankLink";
}

function showBank() {
    document.querySelector(".basicInfo").style.display = "none";
    document.querySelector(".securityInfo").style.display = "none";
    document.querySelector(".bankInfo").style.display = "block";
    document.querySelector(".basicLink").className = "basicLink";
    document.querySelector(".securityLink").className = "securityLink";
    document.querySelector(".bankLink").className = "bankLink active";
}

function consistency() {
    // console.log(password.value);
    // console.log(confirmPs.value);
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
                url: '/student/info/password',
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