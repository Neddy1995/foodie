$(document).ready(function () {
    //加载导航条
    $(".mapTitle").load("./static/html/mapTitle.html");


    //搜索跳转，拼接路径
    $(".search-btn").click(function () {
        var text = $.trim($("#search-box").val());
        console.log(text);
        var url="list.html?text="+text;
        window.open(encodeURI(url));
    });
});