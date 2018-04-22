export function taskDetails(taskId,callback) {

    $.ajax({
        url: "http://localhost:8000/naive/task/details.html",
        type: 'GET',
        // xhrFields:{withCredentials:true},
        data: {
            'username': localStorage.username,
            "taskId" : taskId,
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

export function taskAccept(taskId,callback) {

    $.ajax({
        url: "http://localhost:8000/naive/task/accept.html",
        type: 'GET',
        // xhrFields:{withCredentials:true},
        data: {
            'username': localStorage.username,
            "taskId" : taskId,
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