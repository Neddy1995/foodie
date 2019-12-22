$(document).ready(function () {

    //图片验证码
    $(".verification-code").on("click",function () {
        var timestamp = (new Date()).valueOf();
        $(this).attr("src","code?timestamp=" + timestamp);
    });

    $(".login-btn").click(function () {

        var userName = $.trim($("#userName").val());
        var password = $.trim($("#password").val());
        var paramCode = $.trim($("#paramCode").val());

        if(userName == ""){
            showAlterMsg('请输入用户名');
            return;
        }

        if (password == ""){
            showAlterMsg('请输入密码为空');
            return;
        }
        if (paramCode == ""){
            showAlterMsg('请输入验证码');
            return;
        }

        login(userName,password,paramCode);
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