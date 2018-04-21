export function search(key,callback) {

    $.ajax({
        url: "http://localhost:8000/naive/search.html",
        type: 'GET',
        // xhrFields:{withCredentials:true},
        data: {
            'username': localStorage.username,
            "key" : key,
            "begin": 1, //从哪个开始，因为是搜索跳过去，所以必须是1
            "step": 20 //获取task的个数
        },
        success: function(result){
            console.log("key: "+key);
            console.log('success');
            console.log(result);
            callback(JSON.parse(result));
        },
        scriptCharset: 'iso-8859-1'
        // contentType:"application/x-www-form-urlencoded; charset=utf-8"
    })
}