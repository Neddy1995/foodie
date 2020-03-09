var city;
var userId;

layui.use('element', function(){
    var element = layui.element;
});


$(document).ready(function () {
    //查询用户信息
    selectUser();

    //加载相关作品
    // selectArticleById();
    //加载关注作品
    // selectFollowById();
    //加载评论作品
    // selectCommentById();

    //修改信息按钮监听事件
    $('.update-inform').click(function () {
        window.location.href='editInformation.h';
    });

    //创作作品按钮监听事件
    $('.create-article').click(function () {
        window.location.href='createArticle.h';
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
                var userProfile = user.userProfile;
                var profilePicture = user.profilePicture;
                selectPicture(profilePicture);
                selectCity(userCity);
                birthday = dateToSting(birthday);
                $('.head-username').html(userName);
                if(sex=='1'){
                    $('.head-sex').html('男');
                }else if(sex=='0'){
                    $('.head-sex').html('女');
                }else{
                    $('.head-sex').html('保密');
                }
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


/**
 * 查询相关作品
 * @param userId
 */
function selectArticleById() {
    $.ajax({
        type:'get',
        url:'selectByUserId.do',
        success:function (data) {
            var resultCode = data.resultCode;
            if (resultCode == 'success'){
                var message = data.message;
                var list = data.data;
                console.log(message,list);
                var html = '';
                for(var i=0;i<list.length;i++){
                    var articleId = list[i].articleId;
                    var articleTitle = list[i].articleTitle;
                    var imgId = list[i].imgId;
                    var imgPath = list[i].imgPath;
                    var imgName = list[i].imgName;
                    console.log(imgsPath+imgPath);
                    html+='<div class="goods-item" id="'+articleId+'">';
                    html+='<img class="goods-item-img" id="'+imgId+'" src="'+imgsPath+imgPath+'" title="'+imgName+'" alt=""/>';
                    html+='<div class="goods-item-title">'+articleTitle+'</div>';
                    html+='<div class="goods-item-tagging">tagging</div>';
                    html+='</div>';
                }
                $('#user-article').html(html);
                //每个文章设置点击按钮
                $(".goods-item").click(function () {
                    var articleId = $(this).attr("id");
                    console.log(articleId);
                    var url = "article.html?articleId=" + articleId;
                    window.open(encodeURI(url));
                });
            }
            if(resultCode=='fail') {
                var message = data.message;
                console.log(message);
                $('#user-article').html(message);
            }
        },
        error:function (data) {
            console.log(data);
        }
    });
}


/**
 * 查询关注作品
 * @param userId
 */
function selectFollowById() {
    $.ajax({
        type:'get',
        url:'selectByLike.do',
        success:function (data) {
            var resultCode = data.resultCode;
            if (resultCode == 'success'){
                var message = data.message;
                var list = data.data;
                console.log(message,list);
                var html = '';
                for(var i=0;i<list.length;i++){
                    var articleId = list[i].articleId;
                    var articleTitle = list[i].articleTitle;
                    var imgId = list[i].imgId;
                    var imgPath = list[i].imgPath;
                    var imgName = list[i].imgName;
                    html+='<div class="goods-item" id="'+articleId+'">';
                    html+='<img class="goods-item-img" id="'+imgId+'" src="'+imgsPath+imgPath+'" title="'+imgName+'" alt=""/>';
                    html+='<div class="goods-item-title">'+articleTitle+'</div>';
                    html+='<div class="goods-item-tagging">tagging</div>';
                    html+='</div>';
                }
                $('#user-follow').html(html);
                //每个文章设置点击按钮
                $(".goods-item").click(function () {
                    var articleId = $(this).attr("id");
                    console.log(articleId);
                    var url = "article.html?articleId=" + articleId;
                    window.open(encodeURI(url));
                });
            }
            if(resultCode=='fail') {
                var message = data.message;
                console.log(message);
                $('#user-follow').html(message);
            }
        },
        error:function (data) {
            console.log(data);
        }
    });
}

/**
 * 查询评论作品
 * @param userId
 */
function selectCommentById() {
    $.ajax({
        type:'get',
        url:'selectByComment.do',
        success:function (data) {
            var resultCode = data.resultCode;
            if (resultCode == 'success'){
                var message = data.message;
                var list = data.data;
                console.log(message,list);
                var html = '';
                for(var i=0;i<list.length;i++){
                    var articleId = list[i].articleId;
                    var articleTitle = list[i].articleTitle;
                    var imgId = list[i].imgId;
                    var imgPath = list[i].imgPath;
                    var imgName = list[i].imgName;
                    console.log(imgsPath+imgPath);
                    html+='<div class="goods-item" id="'+articleId+'">';
                    html+='<img class="goods-item-img" id="'+imgId+'" src="'+imgsPath+imgPath+'" title="'+imgName+'" alt=""/>';
                    html+='<div class="goods-item-title">'+articleTitle+'</div>';
                    html+='<div class="goods-item-tagging">tagging</div>';
                    html+='</div>';
                }
                $('#user-comment').html(html);
                //每个文章设置点击按钮
                $(".goods-item").click(function () {
                    var articleId = $(this).attr("id");
                    console.log(articleId);
                    var url = "article.html?articleId=" + articleId;
                    window.open(encodeURI(url));
                });
            }
            if(resultCode=='fail') {
                var message = data.message;
                console.log(message);
                $('#user-comment').html(message);
            }
        },
        error:function (data) {
            console.log(data);
        }
    });
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
                console.log(message,picture);
                console.log(imgsPath+picture.imgPath);
                $('.head-picture').attr('src',imgsPath+picture.imgPath);
            }
            if(resultCode == 'fail'){
                $('.head-picture').attr('src','../static/img/头像.png');
            }
        }
    })

}