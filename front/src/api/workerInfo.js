import {getUrl} from "~/api/tool";

export function userInfo(callback) {

    $.ajax({
        url: getUrl('userInfo/index.html'),
        type: 'GET',
        data: {
            'username': localStorage.username,
        },
        success: function(result){
            console.log('userInfo success');
            console.log(result);
            callback(JSON.parse(result));
        },
        // contentType:"application/x-www-form-urlencoded; charset=utf-8"
    })
}

export function ability(callback) {

    $.ajax({
        url: getUrl('userInfo/ability.html'),
        type: 'GET',
        data: {
            'username': localStorage.username,
        },
        success: function(result){
            console.log('ability success');
            console.log(result);
            callback(JSON.parse(result));
        },
        // contentType:"application/x-www-form-urlencoded; charset=utf-8"
    })
}

export function rank(callback) {

    $.ajax({
        url: getUrl('rank.html'),
        type: 'GET',
        data: {
            'username': localStorage.username,
        },
        success: function(result){
            console.log('rank success');
            console.log(result);
            callback(JSON.parse(result));
        },
        // contentType:"application/x-www-form-urlencoded; charset=utf-8"
    })
}