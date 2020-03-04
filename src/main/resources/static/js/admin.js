var user ='';
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
                $('.admin-username').html(user.userName);
            }
        },
        error:function (data) {
            console.log(data);
        }
    });
}

function updateUser() {
    window.location.href='editPassword.h';
}

