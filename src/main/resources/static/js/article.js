var articleId = getUrlParam("articleId");

var result1;
var result2;

$(document).ready(function () {
    //加载导航条
    $(".mapTitle").load("../static/html/mapTitle.html");

    //轮播图
    layui.use('carousel', function(){
        var carousel = layui.carousel;
        //建造实例
        carousel.render({
            elem: '#slideshow'
            ,width: '100%' //设置容器宽度
            ,arrow: 'always' //始终显示箭头
            //,anim: 'updown' //切换动画方式
        });
    });

    $.when(
        //查询文章
        selectById(articleId),
        //查询评论
        selectComment(articleId)
        //查询收藏，点赞，评论数量
    ).then(function () {
        $('.carousel-item').html(result1);
        $('.comment-items').html(result2);
    })

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
                    html+='<div id="'+imgId+'"><img src="'+imgPath+'" title="'+imgName+'"/></div>';
                }
                result1=html;
            }
        },
        error:function (data) {
            showAlterMsg(data);
        }
    });
}

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
 * 将时间转化为字符串
 * @param date
 * @returns {string}
 */
function dateToSting(date) {
    var year = date.getFullYear().toString();
    var month = date.getMonth();
    var day = date.getDay();
    var hour = date.getHours();
    var minute =date.getMinutes();
    if (month < 10) {
        month ="0" + month;
    }
    if (day < 10) {
        day ="0" + day;
    }
    if (hour < 10){
        hour ="0" + hour;
    }
    if (minute < 10){
        minute ="0" + minute;
    }
    return year +"-" + month + "-" + day + " " + hour + ":" +minute;
}

/**
 * 获取上一个页面来的参数
 * @param name
 * @returns {*}
 */
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = decodeURI(window.location.search).substr(1).match(reg);  //匹配目标参数
    if (r != null) {
        return unescape(r[2]);
    }
    return null; //返回参数值
}
