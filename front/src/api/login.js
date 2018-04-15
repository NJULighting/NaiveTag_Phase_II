export function login(username, password) {
    axios.post('login.html', {username: username, password: password}).then(function (response) {
        console.log(response);
    })
}

function validateFromServer(username, password) {

}

function validateMock(username, password) {
    if (username === '')
        return JSON.stringify({"result": "success", "userType": "worker"});
    else
        return JSON.stringify({"result": "success", "userType": "requester"});
}