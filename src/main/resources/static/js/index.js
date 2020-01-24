$(document).ready(function () {
    //加载导航条
    $(".mapTitle").load("./static/html/mapTitle.html");

    //加载搜索框
    $(".search").load("./static/html/search.html");

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

    //搜索跳转，拼接路径
    $(".search-btn").click(function () {
        var text = $.trim($("#search-box").val());
        console.log(text);
        var url="list.html?text="+text;
        window.open(encodeURI(url));
    });

});

