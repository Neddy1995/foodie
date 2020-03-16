//注意：导航 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
    var element = layui.element;
});

$(document).ready(function () {
    $('.admin-card').load("../static/html/analysis.html");

    selectUser();

});

/**
 * 通过导航栏不同的按钮加载不同的页面
 */
function analysis() {
    $('.admin-card').load("../static/html/analysis.html");
}
function auditArticle() {
    $('.admin-card').load("../static/html/auditArticleAdmin.html")
}
function auditedArticle() {
    $('.admin-card').load("../static/html/passArticleAdmin.html")
}

/**
 * 查询管理员信息
 */
function selectUser() {
    $.ajax({
        type:'get',
        url:'selectUser.do',
        async:false,
        success:function (data) {
            var resultCode = data.resultCode;
            if (resultCode == 'success'){
                var message = data.message;
                user = data.data;
                console.log(message,user);
                selectPicture(user.profilePicture);
                $('.admin-username').html(user.userName);
            }
        },
        error:function (data) {
            console.log(data);
        }
    });
}

/**
 * 跳转到修改密码界面
 */
function updateUser() {
    window.location.href='editPassword.h';
}

/**
 * 查询图片
 * @param imgId
 */
function selectPicture(imgId) {
    $.ajax({
        type:'post',
        url:'selectPicture.do',
        async:false,
        data:{
            'imgId':imgId
        },
        success:function (data) {
            var resultCode = data.resultCode;
            if(resultCode == 'success'){
                var message = data.message;
                var picture = data.data;
                $('.admin-img').attr('src',getImgPath()+picture.imgPath);
            }
            if(resultCode == 'fail'){
                $('.admin-img').attr('src','../static/img/头像.png');
            }
        }
    });
}

/**
 * 退出
 */
function logout() {
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
    });
}

