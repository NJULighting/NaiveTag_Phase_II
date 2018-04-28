import axios from 'axios'
import {getUrl} from "~/api/tool";


export function signUp(signUpForm,callback) {
    let url;
    if (signUpForm.userType === 'worker') {
        url = 'join/worker.html'
    } else {
        url = 'join/requester.html'
    }

    console.log(signUpForm);
    $.post(getUrl(url),{
                username: signUpForm.username,
                password: signUpForm.password,
                name: signUpForm.nickname,
                email: signUpForm.email
    },function (res) {
        callback(JSON.parse(res));
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