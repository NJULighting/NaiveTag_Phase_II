import {getUrl} from "~/api/tool";

export function fetchRequesterDetail(username, callback) {
    fetchFromServer(username, callback);
}

function fetchFromServer(username,callback) {
    $.get(getUrl('userInfo/index.html'),{username:username},
        function (res) {
            callback(JSON.parse(res));
        })

}

export function fetchTaskList(username,callback) {
    $.get(getUrl('requester/index.html'),{username:username},function (res) {
        callback(JSON.parse(res));
    })
}




function mockDetail(username, calllback) {
    let res = {
        name: 'deep♂dark♂fantasy',
        email: '22223@22.com',
        username: 'van',
        score: 999
    };
    calllback(res)
}