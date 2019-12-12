$(document).ready(function () {
    /**
     * 获取后台的session，加载按钮
     * 存在session则显示个人信息和退出
     * 不存在session则显示登陆和注册
     */
    $.ajax({
        type:"get",
        url:"getSession",
        dataType:"json",
        async:false,
        success:function (data) {
            var resultCode = data.resultCode;
            var message = data.message;
            console.log(message);
            if (resultCode == "success"){
                var user = data.data;
                $("#login").hide();
                $("#register").hide();
                $("#user").show();
                $("#logout").show();
                $("#user").text(user.userName);
            }
            else{
                $("#login").show();
                $("#register").show();
                $("#user").hide();
                $("#logout").hide();
            }
        },
        error:function () {
            $("#user").hide();
            $("#logout").hide();
            $("#login").show();
            $("#register").show();
        }

    });

    $("#logout").click(function () {
        $.ajax({
            type:"",
            url:"",
            success:function (data) {
                var resultCode = data.resultCode;
                var message = data.message;
                console.log(message);
                showAlertMsg("退出成功！");
                window.location.href='index.h';
            }
        })
    })
});