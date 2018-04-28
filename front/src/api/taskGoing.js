import {getUrl} from "~/api/tool";

export function taskGoing(count,callback) {

    $.ajax({
        url: getUrl('worker/recent.html'),
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