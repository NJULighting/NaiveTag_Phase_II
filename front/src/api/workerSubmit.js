import {getUrl} from "~/api/tool";

export function submit(taskId, callback) {

    $.ajax({
        url: getUrl('task/commit.html'),
        type: 'GET',
        data: {
            'username': localStorage.username,
            "taskId": taskId
        },
        success: function(result){
            console.log("taskId: "+taskId);
            console.log('success');
            console.log(result);
            callback(JSON.parse(result));
        },
        // contentType:"application/x-www-form-urlencoded; charset=utf-8"
    })
}