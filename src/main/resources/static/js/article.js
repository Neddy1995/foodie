var articleId = getUrlParam("articleId");

var result1;
var result2;
var result3;
var result4;
var result5;


$(document).ready(function () {
    //加载导航条
    $(".mapTitle").load("../static/html/mapTitle.html");

    //轮播图
    layui.use('carousel', function(){
        var carousel = layui.carousel;
        //建造实例
        carousel.render({
            elem: '#slideshow'
            ,width: '960px'//设置容器宽度
            ,height:'1280px'
            ,arrow: 'always' //始终显示箭头
            //,anim: 'updown' //切换动画方式
        });
    });

    //加载所有的ajax，完成后再渲染，分开加载不能渲染所有内容
    $.when(
        //查询文章
        selectById(articleId),
        //查询评论
        selectComment(articleId),
        //查询评论数量
        selectCommentNum(articleId),
        //查询收藏数
        selectFollowNum(articleId),
        //查询点赞数
        selectLikeNum(articleId)
    ).then(function () {
        $('.carousel-item').html(result1);
        $('.comment-items').html(result2);
        $('#like').html(result3);
        $("#comment").html(result4);
        $("#star").html(result5);
    });

    //点赞按钮监听事件
    $('#likeItem').click(function () {
        var state = $('#likeItem').attr("state");
        if(state == '0'){
            insertLike(articleId);
            $('#likeItem').attr('state','1');
            var like = $('#like').text();
            var likeNum =Number(like)+1;
            $('#like').html(likeNum);
        }else if(state == '1'){
            deleteLike(articleId);
            $('#likeItem').attr('state','0');
            var like = $('#like').text();
            var likeNum =Number(like)-1;
            $('#like').html(likeNum);
        }
    });

//    收藏按钮监听事件
    $('#FollowItem').click(function () {
        var state = $('#FollowItem').attr("state");
        if(state == '0'){
            insertFollow(articleId);
            $('#FollowItem').attr('state','1');
            var star = $('#star').text();
            var starNum =Number(star)+1;
            $('#star').html(starNum);
            $('#starBtn').html('&#xe658;');
        }else if(state == '1'){
            deleteFollow(articleId);
            $('#FollowItem').attr('state','0');
            var star = $('#star').text();
            var starNum =Number(star)-1;
            $('#star').html(starNum);
            $('#starBtn').html('&#xe600;');
        }
    });

});

/**
 * 查询文章内容
 * @param articleId
 */
function selectById(articleId){
    $.ajax({
        type:'post',
        url:'selectById.do',
        async:false,//同步
        data:{
            'articleId':articleId
        },
        success:function (data) {
            var resultCode = data.resultCode;
            if(resultCode=='success'){
                var message = data.message;
                var articleVo = data.data;
                console.log(message,articleVo);
                var articleId = articleVo.articleId;
                var place = articleVo.articlePlace;
                var text = articleVo.articleText;
                var title = articleVo.articleTitle;
                var author = articleVo.author;
                var createTime = new Date(articleVo.createTime);
                var tagging = articleVo.tagging;
                var typeId = articleVo.typeId;
                var list = articleVo.list;

                var time = dateToSting(createTime);
                $('.articleTitle').html(title);
                $('.author').html(author);
                $('.article-text').html(text);
                $('#time').html(time);

                var html='';
                for(var i=0;i<list.length;i++){
                    var imgId = list[i].imgId;
                    var imgName = list[i].imgName;
                    var imgPath = list[i].imgPath;
                    html+='<div id="'+imgId+'"><img src="'+ imgsPath + imgPath+'" title="'+imgName+'"/></div>';
                }
                result1=html;
            }
        },
        error:function (data) {
            showAlterMsg(data);
        }
    });
}

/**
 * 查询评论内容
 * @param articleId
 */
function selectComment(articleId) {
    $.ajax({
        type:'post',
        url:'selectComment.do',
        async:false,//同步
        data:{
            'articleId':articleId
        },
        success:function (data) {
            var resultCode = data.resultCode;
            if(resultCode=='success'){
                var message = data.message;
                var list = data.data;
                console.log(message,list);
                var html ='';
                for(var i=0;i<list.length;i++){
                    var commentId = list[i].commentId;
                    var commentText = list[i].commentText;
                    var commentTime = new Date(list[i].commentTime);
                    var userId = list[i].list;

                    var time = dateToSting(commentTime);
                    html+='<div class="comment-item" id="'+commentId+'">';
                    html+='<div class="comment-head" id="'+userId+'">';
                    html+='<div class="comment-head-picture">';
                    html+='<img src="../static/img/头像.png" width="32px" height="32px"/>';
                    html+='</div>';
                    html+='<div class="comment-head-name">';
                    html+='<h4 class="head-name">评论者</h4>';
                    html+='<div class="comment-time">';
                    html+='<span>'+time+'</span>';
                    html+='</div>';
                    html+='</div>';
                    html+='</div>';
                    html+='<div class="comment-content">';
                    html+='<p class="content">'+commentText+'</p>';
                    html+='</div>';
                    html+='</div>';
                }
                result2=html;
            }
        },
        error:function (data) {
            showAlterMsg(data);
        }
    });
}


/**
 * 查询评论数
 * @param articleId
 */
function selectCommentNum(articleId) {
    $.ajax({
        type:'post',
        url:'selectCommentNum.do',
        async:false,//同步
        data:{
            'articleId':articleId
        },
        success:function (data) {
            var resultCode = data.resultCode;
            if(resultCode == 'success'){
                var message = data.message;
                var num = data.data;
                console.log(message,num);
                result4=num;
            }
        },
        error:function (data) {
            console.log(data);
        }
    });
}

/**
 * 查询点赞数
 * @param articleId
 */
function selectLikeNum(articleId) {
    $.ajax({
        type:'post',
        url:'selectLikeNum.do',
        async:false,//同步
        data:{
            'articleId':articleId
        },
        success:function (data) {
            var resultCode = data.resultCode;
            if(resultCode == 'success'){
                var message = data.message;
                var num = data.data;
                console.log(message,num);
                result3=num;
            }
        },
        error:function (data) {
            console.log(data);
        }
    });
}

/**
 * 查询收藏数
 * @param articleId
 */
function selectFollowNum(articleId) {
    $.ajax({
        type:'post',
        url:'selectFollowNum.do',
        async:false,//同步
        data:{
            'articleId':articleId
        },
        success:function (data) {
            var resultCode = data.resultCode;
            if(resultCode == 'success'){
                var message = data.message;
                var num = data.data;
                console.log(message,num);
                result5=num;
            }
        },
        error:function (data) {
            console.log(data);
        }
    });
}

/**
 * 增加点赞数
 * @param articleId
 */
function insertLike(articleId) {
    $.ajax({
        type:'post',
        url:'insertLike.do',
        data:{
            'articleId':articleId
        },
        success:function (data) {
            var resultCode = data.resultCode;
            if (resultCode == 'success'){
                var message = data.message;
                showAlterMsg(message);
            }
        },
        error:function (data) {
            console.log(data);
        }
    });
}

/**
 * 取消点赞
 * @param articleId
 */
function deleteLike(articleId) {
    $.ajax({
        type:'post',
        url:'deleteLike.do',
        data:{
            'articleId':articleId
        },
        success:function (data) {
            var resultCode = data.resultCode;
            if (resultCode == 'success'){
                var message = data.message;
                showAlterMsg(message);
            }
        },
        error:function (data) {
            console.log(data);
        }
    });
}

/**
 * 增加收藏数
 * @param articleId
 */
function insertFollow(articleId) {
    $.ajax({
        type:'post',
        url:'insertFollow.do',
        data:{
            'articleId':articleId
        },
        success:function (data) {
            var resultCode = data.resultCode;
            if (resultCode == 'success'){
                var message = data.message;
                showAlterMsg(message);
            }
        },
        error:function (data) {
            console.log(data);
        }
    });
}

/**
 * 取消收藏
 * @param articleId
 */
function deleteFollow(articleId) {
    $.ajax({
        type:'post',
        url:'deleteFollow.do',
        data:{
            'articleId':articleId
        },
        success:function (data) {
            var resultCode = data.resultCode;
            if (resultCode == 'success'){
                var message = data.message;
                showAlterMsg(message);
            }
        },
        error:function (data) {
            console.log(data);
        }
    });
}


