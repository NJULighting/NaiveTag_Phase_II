export function userInfo(callback) {

    $.ajax({
        url: "http://localhost:8000/naive/userInfo/index.html",
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
        url: "http://localhost:8000/naive/userInfo/ability.html",
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
        url: "http://localhost:8000/naive/rank.html",
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