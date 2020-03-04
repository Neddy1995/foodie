var list =new Array();;
// var streetName = new Array();
// var typeName = new Array();
var streetName= '';
var typeName= '';
$(document).ready(function () {
    selectPassArticle();
    console.log(list);
    var html='';
    for (var i=0;i<list.length;i++){
        selectAllByStreet(list[i].articlePlace);
        var time = new Date(list[i].createTime);
        var createTime = time.getFullYear()+'-'+time.getMonth()+'-'+time.getDay()+' '+time.getHours()+':'+time.getMinutes();
        selectType(list[i].typeId);
        var j = i + 1;
        html += '<tr id="' + list[i].articleId + '">';
        html += '<td class="tableId">'+ j +'</td>';
        html += '<td class="articleTitle">'+ list[i].articleTitle +'</td>';
        html += '<td class="createTime">'+ createTime  +'</td>';
        html += '<td class="author">'+ list[i].author +'</td>';
        html += '<td class="street">'+ streetName +'</td>';
        html += '<td class="type">'+ typeName+'</td>';
        html += '<td class="tagging">'+ list[i].tagging +'</td>';
        html += '<td class="articleText">'+ list[i].articleText +'</td>';
        if(list[i].state == '1'){
            html += '<td class="td-buttons">SUCCESS</td>';
        }
        else if (list[i].state == '2')
            html +='<td class="td-buttons">FAIL</td>';
        html +='</tr>';
    }
    $('.layui-table-body').html(html);
});

/**
 * 查询待审核文章
 */
function selectPassArticle() {
    $.ajax({
        type:'get',
        url:'selectPassArticle.do',
        async:false,//同步
        success:function (data) {
            var resultCoce = data.resultCode;
            if (resultCoce == 'success'){
                var message = data.message;
                list =data.data;
                // console.log(message,list);
            }
        },
        error:function (data) {
            console.log(data);
        }
    });
}

/**
 * 查询包含省份城市区县的字符串
 * @param streetId
 */
function selectAllByStreet(streetId) {
    $.ajax({
        type:'post',
        url:'selectAllByStreet.do',
        async:false,
        data:{
            'streetId':streetId
        },
        success:function (data) {
            var resultCode = data.resultCode;
            if (resultCode == 'success'){
                var message = data.message;
                // streetName.push(data.data);
                streetName = data.data;
                // console.log(message,name);
            }
        },
        error:function (data) {
            console.log(data);
        }
    });
}

/**
 * 查询类型
 * @param typeId
 * @returns {*}
 */
function selectType(typeId) {
    $.ajax({
        type:'post',
        url:'selectType.do',
        async:false,
        data:{
            'typeId':typeId
        },
        success:function (data) {
            var resultCode = data.resultCode;
            if (resultCode == 'success'){
                var message = data.message;
                var type = data.data;
                // typeName.push(type.type2);
                typeName = type.type2;
                console.log(message,name);

            }
        },
        error:function (data) {
            console.log(data);
        }
    });
}