export function taskGoing(count,callback) {

    $.ajax({
        url: "http://localhost:8000/naive/worker/recent.html",
        type: 'GET',
        // xhrFields:{withCredentials:true},
        data: {
            'username': localStorage.username,
            "count": 3 // 表示获取最近几个任务的信息
        },
        success: function(result){
            console.log("count: "+count);
            console.log('getTaskGoing success');
            console.log(result);
            callback(JSON.parse(result));
        },
        // contentType:"application/x-www-form-urlencoded; charset=utf-8"
    })
}