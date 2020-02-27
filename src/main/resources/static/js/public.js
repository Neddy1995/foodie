/**
 * 弹出预警信息
 * @param str
 */
function showAlterMsg(str) {
    layui.use('layer',function () {
        var layer = layui.layer;
        layer.msg(str);
    });
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