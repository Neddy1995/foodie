var list = new Array();
// 基于准备好的dom，初始化echarts实例
var myChart = echarts.init(document.getElementById('echartsAnalysis'));;
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
            echartsAnalysis(list[0]);
        }
    });
});

//下拉框
layui.use('form',function () {
    var form = layui.form;

    form.on('select(typeSelect)',function (data) {
        var i = Number(data.value)-1;
        console.log(data.elem[data.elem.selectedIndex].text);
        echartsAnalysis(list[i],data.elem[data.elem.selectedIndex].text);
    });
});


$(document).ready(function () {
    var date = new Date();
    selectAnalysis(date);
    echartsAnalysis(list[0],'点赞数');
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
    var html = '';
    for(var i=0;i<numList.length;i++){
        html +='<tr><td>'+numList[i].type+'</td><td>'+numList[i].num+'</td></tr>';
    }
    $('.analysis-tbody').html(html);
}

/**
 * 填充图标数据
 * @param list
 */
function echartsAnalysis(list,text){
    var dataList =new Array();
    for(var i=0;i<24;i++){
        dataList.push(0);
        for(var j=0;j<list.length;j++){
            if(Number(list[j].date) == i){
                dataList[i]=list[j].num;
            }
        }
    }
    // 指定图表的配置项和数据
    var option = {
        title: {
            text: text
        },
        xAxis: {
            name:'时间',
            type: 'category',
            data: ['0','1', '2', '3', '4', '5', '6', '7','8','9','10','11','12','13','14','15','16','17','18','19','20','21','22','23']
        },
        yAxis: {
            name:'数量',
            type: 'value', //设置类型
            minInterval:1 //设置值为整数
        },
        series: [{
            data: dataList,
            type: 'line'
        }]
    };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}

