export function login(username, password,callback) {
    // axios.post('login.html', {username: username, password: password}).then(function (response) {
    //     console.log('login')
    //     console.log(response);
    // })

    var xmlhttp;
    if (window.XMLHttpRequest)
    {
        //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        xmlhttp=new XMLHttpRequest();
    }
    else
    {
        // IE6, IE5 浏览器执行代码
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
          console.log(xmlhttp.responseText);
          callback(JSON.parse(xmlhttp.responseText))

        }
    }
    xmlhttp.open("POST","http://localhost:8000/naive/login.html?username="+username+"&password="+password+"",true);
    xmlhttp.send();
}

function validateFromServer(username, password) {

}

function validateMock(username, password) {
    if (username === '')
        return JSON.stringify({"result": "success", "userType": "worker"});
    else
        return JSON.stringify({"result": "success", "userType": "requester"});
}