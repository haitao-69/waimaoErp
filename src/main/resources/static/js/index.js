
$(function(){
    isLogin();


});











//该函数的作用是判断用户是否处于登录状态
function isLogin(){
    let ls_userName = window.localStorage.getItem("LS_USERNAME");
    let str = "";
    if(ls_userName == null){ //代表未登录的状态
        str =
        `<div class="login_btn fl">
                <a href="login.html">登录</a>
                <span>|</span>
                <a href="register.html">注册</a>
        </div>`;
        $("#welcomeUserDv").append(str);
    }else{ //代表登录的状态
        str =
        `<div class="user_link fl">
            <span>|</span>
            欢迎您：<em>${ls_userName}</em>
            <span>|</span>
            <a href="car.html">我的购物车</a>
            <span>|</span>
            <a href="#" onclick="loginout();">注销</a>
        </div>`;
        $("#welcomeUserDv").append(str);
    }
}

function loginout(){
    window.localStorage.removeItem("LS_USERNAME");
    alert("注销成功!");
    window.location.href = "login.html";
}