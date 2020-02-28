var city;
var useId;

layui.use('element', function(){
    var element = layui.element;
});
$(document).ready(function () {
    //查询用户信息
    selectUser();

    $('.update-inform').click(function () {

    });
});

/**
 * 查询用户信息
 */
function selectUser() {
    $.ajax({
        type:'get',
        url:'selectUser.do',
        async:false,//同步
        success:function (data) {
            var resultCode = data.resultCode;
            if (resultCode == 'success'){
                var message = data.message;
                var user = data.data;
                console.log(message,user);
                userId = user.userId;
                var userName = user.userName;
                var sex = user.sex;
                var birthday = new Date(user.birthday);
                var userCity = user.userCity;
                var picture = user.profilePicture;
                var userProfile = user.userProfile;
                selectCity(userCity);
                birthday = dateToSting(birthday);
                $('.head-picture').attr("src",picture);
                $('.head-username').html(userName);
                $('.head-sex').html(sex);
                $('.city').html(city);
                $('.birthday').html(birthday);
                if (!userProfile){
                    $('.profile').html("这人很懒，什么都没留下");
                }else{
                    $('.profile').html(userProfile);
                }
            }
        },
        error:function (data) {
            console.log(data);

        }
    });
}

/**
 * 查询城市
 * @param userCity
 */
function selectCity(userCity) {
    $.ajax({
        type:'post',
        url:'selectCity.do',
        async:false,//同步
        data:{
            'cityId':userCity
        },
        success:function (data) {
            var resultCode = data.resultCode;
            if (resultCode == 'success'){
                var message = data.message;
                var addressCity = data.data;
                console.log(message,addressCity);
                city = addressCity.city;
            }
        },
        error:function (data) {
            console.log(data);

        }
    })
}