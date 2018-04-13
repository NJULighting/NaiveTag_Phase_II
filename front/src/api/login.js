export function login(username, password) {
    return JSON.parse(validateMock(username, password));
}

function validateFromServer(username, password) {

}

function validateMock(username, password) {
    if (username === '')
        return JSON.stringify({"result": "success", "userType": "worker"});
    else
        return JSON.stringify({"result": "success", "userType": "requester"});
}