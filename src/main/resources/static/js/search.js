$(document).ready(function () {
    //搜索跳转，拼接路径
    $(".search-btn").click(function () {
        var search_text = $.trim($(".search-box").val());
        console.log(search_text);
        var url = "list.html?search_text=" + search_text;
        window.open(encodeURI(url));
    });
});