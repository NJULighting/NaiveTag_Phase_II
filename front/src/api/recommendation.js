import {getUrl} from "~/api/tool";

export function recommendation(callback) {

    $.ajax({
        url: getUrl('recommendation.html'),
        type: 'GET',
        // xhrFields:{withCredentials:true},
        data: {
          'username': localStorage.username
        },
        success: function(result){
            console.log('success');
            console.log(result);
            callback(JSON.parse(result));
        },
        scriptCharset: 'iso-8859-1'
       // contentType:"application/x-www-form-urlencoded; charset=utf-8"
    })
}