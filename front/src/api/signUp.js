export function signUp(signUpForm){
    let url;
   if(signUpForm.userType==='worker'){
       url='/join/worker'
   }else{
       url='join/requester'
   }
   axios.post(url,{
       username:signUpForm.username,
       password:signUpForm.password,
       name:signUpForm.nickname,
       email:signUpForm.email
   }).then(function (response) {
       console.log(response);
   })
}

function mock() {
    return JSON.parse(JSON.stringify({'result':'success'}))
}