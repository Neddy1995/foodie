//注意：导航 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
    var element = layui.element;
});

$(document).ready(function () {
    $('.admin-card').load("../static/html/analysis.html");

});

function analysis() {
    $('.admin-card').load("../static/html/analysis.html");
}
function auditArticle() {
    $('.admin-card').load("../static/html/auditArticle.html")
}
function auditedArticle() {
    $('.admin-card').load("../static/html/auditedArticle.html")
}