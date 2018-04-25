export function taskInfo(taskId,callback) {

    $.ajax({
        url: "http://localhost:8000/naive/tag/taskInfo.html",
        type: 'GET',
        // xhrFields:{withCredentials:true},
        data: {
            'username': localStorage.username,
            "taskId" : taskId
        },
        success: function(result){
            console.log("taskInfo/taskId: "+taskId);
            console.log('success');
            console.log(result);
            callback(JSON.parse(result));
        },
        // contentType:"application/x-www-form-urlencoded; charset=utf-8"
    })
}
export function getLabelInfo(taskId, picUrl, callback) {

    $.ajax({
        url: "http://localhost:8000/naive/tag/getLabelInfo.html",
        type: 'GET',
        // xhrFields:{withCredentials:true},
        data: {
            'username': localStorage.username,
            "taskId" : taskId,
            "picURL" : picUrl
        },
        success: function(result){
            console.log("getLabelInfo/taskId: "+taskId);
            console.log("getLabelInfo/picUrl: "+picUrl);
            console.log('success');
            console.log(result);
            callback(JSON.parse(result));
        },
        // contentType:"application/x-www-form-urlencoded; charset=utf-8"
    })
}