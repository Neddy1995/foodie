var oldUser;

layui.use('form',function () {
    var form = layui.form;

//    监听城市选项
    form.on("select(province)", function(data){
        console.log(data.value); //得到被选中的值
        selectCity(data.value);
        form.render();
    });

    //将旧数据写入
    var birthday = new Date(oldUser.birthday);
    form.val("editInformation",{
       "userName":oldUser.userName,
       "sex":oldUser.sex,
        "year":birthday.getFullYear(),
        "month":birthday.getMonth(),
        "day":birthday.getDay(),
        "province":oldUser.userCity.substring(0,3),
        "userCity":oldUser.userCity,
        "userProfile":oldUser.userProfile
    });

    //修改密码监听事件
    form.on("submit(updatePassword)",function (data) {
        window.location.href='editPassword.h';
        return false;
    });

    form.on("submit(updateUser)",function(data){
        var data1 = form.val("editInformation");
        var birthday = data1.year + '-' + data1.month + '-' + data1.day;
        data1['birthday'] = new Date(birthday.replace(/-/g,"/"));
        delete data1.year;
        delete data1.month;
        delete data1.day;
        delete data1.province;
        console.log(data1);
        updateUser(data1);
        return false;
    });
});

$(document).ready(function () {
    selectProvince();
    updateDate();
    selectUser();
});

/**
 * 查询用户
 */
function selectUser() {
    $.ajax({
        type:'get',
        url:'selectUser.do',
        async:false,//同步
        success:function (data) {
            var resultCode = data.resultCode;
            if(resultCode == 'success'){
                var message = data.message;
                var user = data.data;
                console.log(message,user);

                var profilePicture = user.profilePicture;

                //处理图片
                selectPicture(profilePicture);


                selectCity(user.userCity.substring(0,3));


                oldUser = user;
            }
        },
        error:function (data) {
            console.log(data);
        }
    });
}

/**
 * 查询图片
 * @param profilePicture
 */
function selectPicture(profilePicture) {
    var data =new Object();

    $.post("",{'imgId':profilePicture},function (data) {
        
    });
}


/**
 * 查询省份
 */
function selectProvince() {
    $.ajax({
        type:"get",
        url:"selectProvince.do",
        async:false,//同步
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
        url:"selectCityByProvince.do",
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
                $('select[name=userCity]').html(html);
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

function updateUser(data) {
    $.ajax({
        type:'post',
        url:'updateUser.do',
        dataType:"json",
        contentType:"application/json;charset=utf-8",
        data:JSON.stringify(data),
        success:function (data) {
            var resultCode = data.resultCode;
            if(resultCode == 'success'){
                var message = data.message;
                console.log(message);
                window.location.href='information.h';
            }
            else if(resultCode == 'fail'){
                var message = data.message;
                showAlterMsg(message);
            }
        }
    });
}