layui.use('form',function () {
    var form = layui.form;
    form.render();

    //监听省份按钮
    form.on('select(province)',function (data) {
        selectCity(data.value);
        form.render();
    });

    //监听城市按钮
    form.on('select(city)',function (data) {
        selectStreet(data.value);
        form.render();
    });

    //监听提交按钮
    form.on('submit(createArticleBtn)',function (data) {
        var data1 = form.val("createArticle");
        var articleTypePictureVo = new Object();
        var article = new Object();
        var articleType = new Object();

        article['articleTitle'] = data1.articleTitle;
        article['tagging'] = data1.tagging;
        article['articleText'] = data1.articleText;
        article['articlePlace'] = data1.streetId;

        articleType['type1'] = data1.articleType;
        articleType['type2'] = data1.articleType;

        articleTypePictureVo['article'] = article;
        articleTypePictureVo['articleType'] = articleType;

        console.log(articleTypePictureVo);
        createArticle(articleTypePictureVo);
        return false;
    });

});

//上传图片
layui.use('upload', function(){
    var upload = layui.upload;

    //执行实例
    var uploadInst = upload.render({
        elem: '#load-img-btn' //绑定元素
        ,url: '/upload/' //上传接口
        ,done: function(res){
            //上传完毕回调
        }
        ,error: function(){
            //请求异常回调
        }
    });
});

$(document).ready(function () {
    selectProvince();
});


/**
 * 查询省份
 */
function selectProvince() {
    $.ajax({
        type:"get",
        url:"selectProvince.do",
        async:false,//同步
        success:function (data) {
            var resultCode = data.resultCode;
            if(resultCode=="success"){
                var message = data.message;
                var list = data.data;
                console.log(message,list);
                var html='';
                html+='<option value="">选择省份</option>';
                for(var i=0;i<list.length;i++){
                    html+='<option value="'+list[i].provinceId+'">'+list[i].province+'</option>';
                }
                $('select[name=province]').html(html);
            }
        },
        error:function (data) {
            showAlterMsg("查询错误");
            console.log(data);
        }
    });
}

/**
 * 查询城市
 * @param id
 */
function selectCity(id) {
    $.ajax({
        type:"post",
        url:"selectCityByProvince.do",
        async:false,//同步
        data:{
            "provinceId":id
        },
        success:function (data) {
            var resultCode = data.resultCode;
            if(resultCode=='success'){
                var message = data.message;
                var list = data.data;
                console.log(message,list);
                var html = '';
                html+='<option value="">选择城市</option>';
                for(var i=0;i<list.length;i++){
                    html+='<option value="'+list[i].cityId+'">'+list[i].city+'</option>';
                }
                console.log(html);
                $('select[name=city]').html(html);
            }
        },
        error:function (data) {
            showAlterMsg("查询错误");
            console.log(data);
        }
    });
}

/**
 * 查询街道
 * @param id
 */
function selectStreet(id) {
    $.ajax({
        type:'post',
        url:'selectStreet.do',
        async:false,//同步
        data:{
            'cityId':id
        },
        success:function (data) {
            var resultCode = data.resultCode;
            if (resultCode == 'success'){
                var message = data.message;
                var list = data.data;
                console.log(message,list);
                var html ='';
                html+='<option value="">选择区县</option>';
                for (var i=0;i<list.length;i++){
                    html+='<option value="'+list[i].streetId+'">'+list[i].streetName+'</option>';
                }
                $('select[name=streetId]').html(html);
            }
        },
        error:function (data) {
            console.log(data);
        }
    });
}

/**
 * 创建文章
 * @param data
 */
function createArticle(data) {
    $.ajax({
        type:'post',
        url:'insertArticle.do',
        dataType:"json",
        contentType:"application/json;charset=utf-8",
        data:JSON.stringify(data),
        success:function (data) {
            var resultCode = data.resultCode;
            if(resultCode == 'success'){
                var message = data.message;
                console.log(message);
                showAlterMsg(message);
                window.location.href='information.h';
            }
        },
        error:function (data) {
            console.log(data);
        }
    })
}