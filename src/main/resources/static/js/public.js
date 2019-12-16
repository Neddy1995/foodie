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