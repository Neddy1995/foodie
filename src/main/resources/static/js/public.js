
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
 * @returns {string|null}
 */
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = decodeURI(window.location.search).substr(1).match(reg);  //匹配目标参数
    if (r != null) {
        return unescape(r[2]);
    }
    return null; //返回参数值
}

/**
 * 获取图片路径
 */
function getImgPath() {
    var imgPath= 'http://118.122.117.57:8097/imgs/';
    return imgPath;
}



