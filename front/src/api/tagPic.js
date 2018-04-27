export function save(taskId,picUrl,JSONObject,callback) {

    $.ajax({
        url: "http://localhost:8000/naive/tag/save.html",
        type: 'POST',
        // xhrFields:{withCredentials:true},
        data: {
            'username': localStorage.username,
            "taskId": taskId,
            "url": picUrl, // 图片的url
            "data": JSONObject //迭代一中已经定义好的图片标注信息
        },
        success: function(result){
            console.log("JSONObject: ");
            console.log(JSONObject);
            console.log('save success');
            callback(result);
        },
        // contentType:"application/x-www-form-urlencoded; charset=utf-8"
    })
}
export function next(taskId, picUrl, callback) {

    $.ajax({
        url: "http://localhost:8000/naive/tag/next.html",
        type: 'GET',
        // xhrFields:{withCredentials:true},
        data: {
            'username': localStorage.username,
            "taskId" : taskId,
            "url": picUrl // 当前图片的URL
        },
        success: function(result){
            console.log("picUrl: "+picUrl);
            console.log('success');
            console.log(result);
            callback(JSON.parse(result));
        },
        // contentType:"application/x-www-form-urlencoded; charset=utf-8"
    })
}
export function previous(taskId, picUrl, callback) {

    $.ajax({
        url: "http://localhost:8000/naive/tag/previous.html",
        type: 'GET',
        // xhrFields:{withCredentials:true},
        data: {
            'username': localStorage.username,
            "taskId" : taskId,
            "url": picUrl // 当前图片的URL
        },
        success: function(result){
            console.log("picUrl: "+picUrl);
            console.log('success');
            console.log(result);
            callback(JSON.parse(result));
        },
        // contentType:"application/x-www-form-urlencoded; charset=utf-8"
    })
}