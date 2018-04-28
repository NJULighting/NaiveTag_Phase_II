import {getUrl} from "~/api/tool";

export function history(callback) {

    $.ajax({
        url: getUrl('worker/history.html'),
        type: 'GET',
        data: {
            'username': localStorage.username,
        },
        success: function(result){
            console.log('success');
            console.log(result);
            callback(JSON.parse(result));
        },
        // contentType:"application/x-www-form-urlencoded; charset=utf-8"
    })
}