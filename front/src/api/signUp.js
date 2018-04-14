export function signUp(){
    return mock()
}

function mock() {
    return JSON.parse(JSON.stringify({'result':'success'}))
}