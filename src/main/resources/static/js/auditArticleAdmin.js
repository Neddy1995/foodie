var list =new Array();
// var streetName = new Array();
// var typeName = new Array();
var streetName = '';
var typeName = '';

$(document).ready(function () {
    selectAuditArticle();
    console.log(list);
    var html='';
    for (var i=0;i<list.length;i++){
        selectAllByStreet(list[i].articlePlace);
        var time = new Date(list[i].createTime);
        var createTime = time.getFullYear()+'-'+time.getMonth()+'-'+time.getDay()+' '+time.getHours()+':'+time.getMinutes();
        selectType(list[i].typeId);
        var j = i + 1;
        html += '<tr id="tr' + list[i].articleId + '">';
        html += '<td>'+ j +'</td>';
        html += '<td>'+ list[i].articleTitle +'</td>';
        html += '<td>'+ createTime  +'</td>';
        html += '<td>'+ list[i].author +'</td>';
        html += '<td>'+ streetName +'</td>';
        html += '<td>'+ typeName+'</td>';
        html += '<td>'+ list[i].tagging +'</td>';
        html += '<td>'+ list[i].articleText +'</td>';
        html += '<td class="td-buttons">';
        html += '<button class="layui-btn see" id="see'+list[i].articleId+'">查看</button>';
        html += '<button class="layui-btn pass" id="pass'+list[i].articleId+'">通过</button>';
        html += '<button class="layui-btn reject" id="reject'+ list[i].articleId+'">驳回</button>';
        html += '</td>';
        html +='</tr>';
    }
    $('.layui-table-body').html(html);
    $('.see').click(function () {
        var articleId =$(this).attr("id");
        articleId = articleId.substring(3);
        openArticle(articleId);
    });
    $('.pass').click(function () {
        var  articleId =$(this).attr("id");
        articleId = articleId.substring(4);
        var state = 1;
        insertAuditArticle(articleId,state);
    });
    $('.reject').click(function () {
        var  articleId =$(this).attr("id");
        articleId = articleId.substring(6);
        var state = 2;
        insertAuditArticle(articleId,state);
    });
});

/**
 * 查询待审核文章
 */
function selectAuditArticle() {
    $.ajax({
        type:'get',
        url:'selectAuditArticle.do',
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

/**
 * 弹出信息
 * @param articleId
 */
function openArticle(articleId) {
    $.ajax({
        type:'post',
        url:'selectById.do',
        async:false,
        data:{
            'articleId':articleId
        },
        success:function (data) {
            var resultCode = data.resultCode;
            if (resultCode == 'success'){
                var message = data.message;
                var articleVo = data.data;
                console.log(message,articleVo);
                var articleId = articleVo.articleId;
                var place = articleVo.articlePlace;
                var text = articleVo.articleText;
                var title = articleVo.articleTitle;
                var author = articleVo.author;
                var createTime = new Date(articleVo.createTime);
                var tagging = articleVo.tagging;
                var typeId = articleVo.typeId;
                var list = articleVo.list;
                var html = '';
                html += '<div class="article-index">';
                html += '<h1 class="articleTitle">'+ title +'</h1>';
                html += '<h3 class="author">'+ author +'</h3>';
                html += '<div class="layui-carousel " id="slideshow">';
                html += '<div class="carousel-item" carousel-item>';
                for (var i=0;i<list.length;i++){
                    var imgId = list[i].imgId;
                    var imgName = list[i].imgName;
                    var imgPath = list[i].imgPath;
                    html+='<div id="'+imgId+'"><img src="'+imgPath+'" title="'+imgName+'"/></div>';
                }
                html += '</div>';
                html += '</div>';
                html += '<div class="article-text">'+text+'</div>';
                html += '</div>';

                layui.use('layer',function () {
                    var layer = layui.layer;
                    layer.open({
                        title:title,
                        area: ['1800px', '880px'],
                        content:html
                    });
                });
            }
        },
        error:function (data) {
            console.log(data);
        }
    });
}

/**
 * 提交审核
 * @param articleId
 * @param state 0，为未审核，1，为通过，2，为未通过
 */
function insertAuditArticle(articleId,state) {
    $.ajax({
        type:'post',
        url:'insertAuditArticle.do',
        data:{
            'articleId':articleId,
            'state':state
        },
        success:function (data) {
            var resultCode = data.resultCode;
            if(resultCode == 'success'){
                var message = data.message;
                showAlterMsg(message);
                window.location.reload(true);
            }
        },
        error:function (data) {
            console.log(data);
        }
    })
    
}