var list = new Array();

layui.use('laydate', function(){
    var laydate = layui.laydate;

    //执行一个laydate实例
    laydate.render({
        elem: '#selectTime', //指定元素
        value:new Date(),
        min:-60,
        max:0, //可选范围定在2个月前到当天
        done:function (value,data,endDate) {
            console.log(value);
            selectAnalysis(new Date(value));
        }
    });
});

//下拉框
layui.use('form',function () {
    var form = layui.form;
});
$(document).ready(function () {
    var date = new Date();
    selectAnalysis(date);
});

/**
 * 查询数据并加载表格
 * @param date
 */
function selectAnalysis(date) {
    $.ajax({
        type:'post',
        url:'selectLikeByDay.do',
        async:false,
        data:{
            'dateDay':date
        },
        success:function (data) {
            var resultCode =data.resultCode;
            if (resultCode == 'success') {
                var message = data.message;
                list = data.data;
            }
        },
        error:function (data) {
            console.log(data);
        }
    });

    //处理传回来的数据并求和到新的数组中
    var numList = new Array();
    for(var i=0;i<list.length;i++){
        var k = i+1;
        if(list[i]==null){
            var arrayList =new Array();
            arrayList = {type:k,num:0,date:"0"};
            list[i] = arrayList;
        }
        var num=0;
        for (var j=0;j<list[i].length;j++){
            num +=list[i][j].num;
        }
        switch (k){
            case 1:
                numList.push({type:'点赞数',num:num});
                break;
            case 2:
                numList.push({type:'评论数',num:num});
                break;
            case 3:
                numList.push({type:'关注数',num:num});
                break;
            case 4:
                numList.push({type:'文章表创建数',num:num});
                break;
            case 5:
                numList.push({type:'文章表通过审核数',num:num});
                break;
            case 6:
                numList.push({type:'文章表审核数',num:num});
                break;
            default:
                break;
        }
    }
    console.log(list);
    console.log(numList);
    var html = '';
    for(var i=0;i<numList.length;i++){
        html +='<tr><td>'+numList[i].type+'</td><td>'+numList[i].num+'</td></tr>';
    }
    $('.analysis-tbody').html(html);
}