import axios from 'axios'


export function signUp(signUpForm,callback) {
    let url;
    if (signUpForm.userType === 'worker') {
        url = 'http://localhost:8000/naive/join/worker.html'
    } else {
        url = 'http://localhost:8000/naive/join/requester.html'
    }

    console.log(signUpForm);
    $.post(url,{
                username: signUpForm.username,
                password: signUpForm.password,
                name: signUpForm.nickname,
                email: signUpForm.email
    },function (res) {
        callback(res);
    });
    // axios.post(url, {
    //         // username: signUpForm.username,
    //         // password: signUpForm.password,
    //         // name: signUpForm.nickname,
    //         // email: signUpForm.email
    //     username: "zy05160516",
    //     password: "zy05160516",
    //     name: "iznauy",
    //     email: "zy05160516@126.com"
    //     }, {
    //         headers: {
    //             'Content-Type': 'application/x-www-form-urlencoded'
    //         }
    //     }
    // ).then(function (response) {
    //     callback(response)
    // })
}

function mock() {
    return JSON.parse(JSON.stringify({'result': 'success'}))
}