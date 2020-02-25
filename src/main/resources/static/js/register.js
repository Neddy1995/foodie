layui.use('form', function() {
    var form = layui.form;
    form.render();

//    监听城市选项
    form.on("select(province)", function(data){
        console.log(data.value); //得到被选中的值
        selectCity(data.value);
        form.render();
    });

    //监听提交按钮
    form.on('submit(register)',function (data) {
        var data1 = form.val("registerForm");
        console.log(data1);
        var password = data1.password;
        var pwd = data1.pwd;
        var year = data1.year;
        var month = data1.month;
        var day = data1.day;
        var birthday =year+'-'+month+'-'+day;
        if (password!=pwd) {
            showAlterMsg("两次密码不相同，请重新输入");
            return false;
        }
        delete data1.pwd;
        delete data1.province;
        delete data1.year;
        delete data1.month;
        delete data1.day;
        data1['birthday']=new Date(birthday.replace(/-/g,"/"));
        console.log(data1);
        register(data1);
    });
});

$(document).ready(function () {
    // 查询城市
    selectProvince();
    updateDate();
});



/**
 * 注册
 * @param json
 */
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
                showAlterMsg(message+"前往登录");
                window.location.href='login.h';
            }
        }
    })
}

/**
 * 查询省份
 */
function selectProvince() {
    $.ajax({
        type:"get",
        url:"selectProvince.do",
        success:function (data) {
            var resultCode = data.resultCode;
            if(resultCode=="success"){
                var message = data.message;
                var list = data.data;
                var html='';
                html+='<option value="">选择省份</option>';
                for(var i=0;i<list.length;i++){
                    html+='<option value="'+list[i].provinceId+'">'+list[i].province+'</option>';
                }
                $('select[name=province]').html(html);
            }
        },
        error:function (data) {
            showAlterMsg("查询错误");
            console.log(data);
        }
    });

}

/**
 * 查询城市
 * @param id
 */
function selectCity(id) {
    $.ajax({
        type:"post",
        url:"selectCity.do",
        async:false,//同步
        data:{
            "provinceId":id
        },
        success:function (data) {
            var resultCode = data.resultCode;
            if(resultCode=='success'){
                var message = data.message;
                var list = data.data;
                console.log(message,list);
                var html = '';
                html+='<option value="">选择城市</option>';
                for(var i=0;i<list.length;i++){
                    html+='<option value="'+list[i].cityId+'">'+list[i].city+'</option>';
                }
                console.log(html);
                $('select[name=city]').html(html);
            }
        },
        error:function (data) {
            showAlterMsg("查询错误");
            console.log(data);
        }
    });
}

/**
 * 时间下拉框
 */
function updateDate() {
    var year='<option value="">年</option>';
    var month='<option value="">月</option>';
    var day='<option value="">日</option>';
    for (var i=0;i<51;i++){
        var j=1970+i;
        year+='<option value="'+j+'">'+j+'</option>';
    }
    for (var i=0;i<12;i++){
        var j=1+i;
        month+='<option value="'+j+'">'+j+'</option>';
    }
    for (var i=0;i<31;i++){
        var j=1+i;
        day+='<option value="'+j+'">'+j+'</option>';
    }
    $('select[name=year]').html(year);
    $('select[name=month]').html(month);
    $('select[name=day]').html(day);
}