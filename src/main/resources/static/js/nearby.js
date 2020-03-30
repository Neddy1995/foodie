var user;
$(document).ready(function () {
    //加载导航条
    $(".mapTitle").load("../static/html/mapTitle.html");

    //加载搜索框
    $(".search").load("../static/html/search.html");

    //加载商品
    $(".goods-item").load("../static/html/good.html");

    selectUser();
    if(user){
        selectByStreet(user.userCity);
    }else{
        selectByStreet("0260322");
    }
});

/**
 * 根据地址查询文章
 * @param streetId
 */
function selectByStreet(streetId) {
    $.ajax({
        type:'post',
        url:'selectByStreet.do',
        data:{
            'streetId':streetId
        },
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
                    var tagging = list[i].tagging;
                    var imgId = list[i].imgId;
                    var imgPath = list[i].imgPath;
                    var imgName = list[i].imgName;
                    html+='<div class="goods-item" id="'+articleId+'">';
                    html+='<img class="goods-item-img" id="'+imgId+'" src="'+getImgPath()+imgPath+'" title="'+imgName+'"/>';
                    html+='<div class="goods-item-title">'+articleTitle+'</div>';
                    html+='<div class="goods-item-tagging">'+tagging+'</div>';
                    html+='</div>';
                }
                $('.something').html(html);
                //每个文章设置点击按钮
                $(".goods-item").click(function () {
                    var articleId = $(this).attr("id");
                    console.log(articleId);
                    var url = "article.html?articleId=" + articleId;
                    window.open(encodeURI(url));
                });
            }
            else if(resultCode == 'fail'){
                var message = data.message;
                console.log(message);
            }
        },
        error:function (data) {
            console.log(data);
        }
    });
}

/**
 * 查询用户信息
 */
function selectUser() {
    $.ajax({
        type:'get',
        url:'getSession',
        dataType:"json",
        async:false,
        success:function (data) {
            var resultCode = data.resultCode;
            var message = data.message;
            console.log(message);
            if (resultCode == "success") {
                user = data.data;
            }else if(resultCode == "fail"){
                console.log(data);
            }
        }
    });
}