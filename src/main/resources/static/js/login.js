layui.use('form', function() {
    var form = layui.form;
    //登陆按钮
    form.on('submit(login)',function(data){
        var data1 = form.val("loginForm");
        console.log(data1);
        var userName = data1.userName;
        var password = data1.password;
        var paramCode = data1.paramCode;
        login(userName,password,paramCode);
    });
});

$(document).ready(function () {

    //图片验证码
    $(".verification-code").on("click",function () {
        var timestamp = (new Date()).valueOf();
        $(this).attr("src","code?timestamp=" + timestamp);
    });

});

function login(userName,password,paramCode) {
    $.ajax({
        type:"post",
        url:"login.do",
        data:{
            "userName": userName,
            "password": password,
            "paramCode": paramCode
        },
        success:function (data) {
            console.log(data);

            var resultCode = data.resultCode;
            var message = data.message;
            showAlterMsg(resultCode+message);

            if(resultCode == "fail"){
                showAlterMsg(message);
            }else {
                window.location.href = "index.h"
            }
        },
        error:function (data) {
            showAlterMsg("登陆失败");
            console.log(data);
        }
    })
}