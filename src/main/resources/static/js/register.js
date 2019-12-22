$(document).ready(function () {
    $('#register').click(function () {
        var userName = $.trim($("#userName").val());
        var password = $.trim($("#password").val());
        var pwd = $.trim($("#pwd").val());
        var sex = $.trim($("#sex").val());
        var city =$.trim($("#city").val());
        var birthday = $.trim($("#birthday").val());
        
        // if (userName == ""){
        //     showAlterMsg("请输入用户名");
        //     return;
        // }
        // if(password == ""){
        //     showAlterMsg("请输入密码");
        //     return;
        // }
        // if(pwd == ""){
        //     showAlterMsg("请再次输入密码");
        //     return;
        // }
        // if(password != pwd){
        //     showAlterMsg("两次密码不相同，请重新输入");
        //     return;
        // }
        // if(city == ""){
        //     showAlterMsg("城市未输入");
        //     return;
        // }
        // if(birthday == ""){
        //     showAlterMsg("生日未选择");
        //     return;
        // }
        userName = "2";
        password = "1";
        sex = "1";
        city = "1";
        birthday = new Date();
        var data = {"userName":userName,"password":password,"sex":sex,"city":city,"birthday":birthday};
        // showAlterMsg(data);
        register(data);
    });
});

function register(json) {
    $.ajax({
        type:"post",
        url:"register.do",
        dataType:"json",
        contentType:"application/json;charset=utf-8",
        data:JSON.stringify(json),
        success:function (data) {
            console.log(data);
            var resultCode = data.resultCode;
            var message = data.message;

            if(resultCode == "fail"){
                showAlterMsg(message);
            }
            if(resultCode == "success"){
                showAlterMsg(message+"前往注册");
                window.location.href='login.h';
            }
        }
    })
}