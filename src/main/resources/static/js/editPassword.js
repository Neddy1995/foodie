layui.use("form",function () {
   var form = layui.form;

   form.on("submit(editPasswordBtn)",function (data) {
       var data1 = form.val("editPassword");

       console.log(data1);
       var pwd1 = data1.password1;
       var pwd2 = data1.password2;
       var pwd3 = data1.password3;
       if(pwd2!=pwd3){
           showAlterMsg("新密码两次输入不相同");
       }
       else if (pwd1 == pwd2){
           showAlterMsg("新密码和旧密码相同");
       }else{
           editPassword(pwd1,pwd2);
       }
       return false;
   })
});

/**
 * 修改密码
 * @param pwd1
 * @param pwd2
 */
function editPassword(pwd1,pwd2) {
    $.ajax({
        type:'post',
        url:'updatePassword.do',
        data:{
            "password":pwd1,
            "passwordNow":pwd2
        },
        success:function (data) {
            var resultCode = data.resultCode;
            var message = data.message;
            if (resultCode == 'success'){
                showAlterMsg(message);
                window.location.href='index.h';
            }else if (resultCode == 'fail') {
                showAlterMsg(message);
            }
        },
        error:function (data) {
            console.log(data);
        }
    })
}