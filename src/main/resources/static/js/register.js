
layui.use('form', function() {
    var form = layui.form;

//    监听城市选项

});

$(document).ready(function () {
    // 查询城市
    selectCity();
});


// $(document).ready(function () {
//     $('#register').click(function () {

        // var userName = $.trim($("#userName").val());
        // var password = $.trim($("#password").val());
        // var pwd = $.trim($("#pwd").val());
        // var sex = $('input[name=sex]:checked').val();
        // var city =$.trim($("#city").val());
        // var birthday = $.trim($("#birthday").val());
        
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
        // userName = "2";
        // password = "1";
        // sex = "1";
        // city = "1";
        // birthday = new Date();
        // var data = {"userName":userName,"password":password,"sex":sex,"city":city,"birthday":birthday};
        // // showAlterMsg(data);
        // register(data);
//     });
// });

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

function selectCity() {
    $.ajax({
        type:"get",
        url:"selectCity.do",
        success:function (data) {
            var resultCode = data.resultCode;
            if(resultCode=="success"){
                var message = data.message;
                var addressCity = data.data;
                console.log(addressCity);
                console.log(addressCity.length);
                // 循环加载省份
                var provinceArray = new Array();
                for(var i=0;i<addressCity.length;i++){
                    var provinceId = addressCity[i].cityId.substr(0,3);
                    var province = addressCity[i].province;
                    console.log(provinceId,province);
                    var map = new Map();

                }
            }
        },
        error:function (data) {
            showAlterMsg("查询错误");
            console.log(data);
        }
    });

}