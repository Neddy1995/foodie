$(document).ready(function () {

    //注意：导航 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function(){
        var element = layui.element;
        //…
    });

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
                user = data.data;
                $("#login").hide();
                $("#register").hide();
                $("#user").show();
                $("#logout").show();
                // $("#user").text(user.userName);
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
            type:"get",
            url:"logout.do",
            success:function (data) {
                var resultCode = data.resultCode;
                var message = data.message;
                console.log(message);
                if (resultCode == "success") {
                    showAlterMsg("退出成功！");
                    window.location.href = 'index.h';
                }
            }
        })
    });

});