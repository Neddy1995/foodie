$(document).ready(function () {
    //加载导航条
    $(".mapTitle").load("../static/html/mapTitle.html");

    //加载搜索框
    $(".search").load("../static/html/search.html");

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

    $("#26577884424437794").attr("src",getImgPath()+'c89e809d-ec55-44c2-8ec6-92d7379ca1b2.jpg');
    $("#26578465922744330").attr("src",getImgPath()+'4a9de136-1598-48a9-b8d7-5b2b695048ba.jpg');
    $("#26578465922744352").attr("src",getImgPath()+'3339d5da-50c9-4510-97d3-e09bfa66db01.jpg');
    $("#26578465922744381").attr("src",getImgPath()+'d4920c90-7e77-43c7-9eb0-ce73153eaad6.jpg');
    $("#26578465922744403").attr("src",getImgPath()+'fd2a9800-b2c9-4a68-80e4-f23901eabe1d.jpg');
    $("#26578465922744422").attr("src",getImgPath()+'14628e7e-edcc-471a-a909-a158f7629a15.jpg');
    $("#26578465922744446").attr("src",getImgPath()+'61358e94-0551-4705-bcac-fc1ed874233b.jpg');

    //所有图片设置点击事件
    $("img").click(function () {
        var id = $("img").attr("id");
        var url = "article.html?articleId=" + id;
        window.open(encodeURI(url));
    });

});

