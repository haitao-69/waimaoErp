$(function(){
    isLogin();
    getAllGoods();
    // getAllFirstCategories();
    // getAllCategoryBO();

});

// 加入购物车
function addCar(goodsId) {
    var userName = window.localStorage.getItem("LS_USERNAME");

    $.ajax(
        {
            type:"post",
            url:"http://localhost:9000/eshop/addCar",
            data:{
                goodsId: goodsId,
                userName: userName
            },
            success:function(result){
                alert(result.data)
            },
            error:function(result){ //当返回结果的http响应码为500时
                alert("服务器程序出现错误");
                console.log(result);
            }
        }
    );

}

// 清空goods_list下的li元素
function clearGoodsList() {
    var goodsList = document.getElementById("dynamicGoodsList");
    goodsList.innerHTML = "";
}

// 获取指定类型的商品数据
function getTypeGoods(type) {
    console.log(type)
    $(document).ready(function() {
        // 发送Ajax请求获取数据
        $.ajax({
            url: 'http://localhost:9000/eshop/getTypeGoods', // 替换为获取数据的URL
            data: {type: type},
            method: 'GET',
            success: function(response) {
                console.log(response)
                // 清空goods_list下的li元素
                clearGoodsList();
                // 在成功回调函数中处理返回的数据
                var goodsList = document.getElementById('dynamicGoodsList');

                for (var i = 0; i < response.data.length; i++) {
                    var item = response.data[i];

                    // 创建li元素
                    var li = document.createElement('li');

                    // 创建h4元素
                    var h4 = document.createElement('h4');
                    var a = document.createElement('a');
                    // a.href = item.link;
                    a.textContent = item.goodsName;
                    h4.appendChild(a);
                    li.appendChild(h4);

                    // 创建图片元素
                    var img = document.createElement('img');
                    img.src ="http://localhost:9000/eshop/images/goods/" + item.imgUrl;
                    var imgLink = document.createElement('a');
                    // imgLink.href = "#";
                    imgLink.appendChild(img);
                    li.appendChild(imgLink);

                    // 创建价格元素
                    var prize = document.createElement('div');
                    prize.classList.add('prize');
                    prize.textContent = '¥ ' + item.unit;
                    var shoppingCartLink = document.createElement('a');
                    // shoppingCartLink.href = '#';
                    shoppingCartLink.setAttribute('onclick', 'addCar(' + item.goodsId +')'); // 添加 onclick 属性
                    var shoppingCart = document.createElement('div');
                    shoppingCart.classList.add('shopping-cart');
                    shoppingCartLink.appendChild(shoppingCart);
                    prize.appendChild(shoppingCartLink);
                    li.appendChild(prize);

                    // 将li元素添加到goods_list中
                    goodsList.appendChild(li);
                }


            },
            error: function() {
                console.log('Failed to retrieve data');
            }
        });
    });
}


function getAllGoods() {

    $(document).ready(function() {
        // 清空goods_list下的li元素
        clearGoodsList();
        // 发送Ajax请求获取数据
        $.ajax({
            url: 'http://localhost:9000/eshop/getAllGoods', // 替换为获取数据的URL
            method: 'GET',
            success: function(response) {
                console.log(response)
                // 在成功回调函数中处理返回的数据
                // var goodsList = response.data; // 假设返回的数据包含一个名为goodsList的数组
                var dynamicGoodsList = $('#dynamicGoodsList');
                var goodsList = document.getElementById('dynamicGoodsList');

                for (var i = 0; i < response.data.length; i++) {
                    var item = response.data[i];

                    // 创建li元素
                    var li = document.createElement('li');

                    // 创建h4元素
                    var h4 = document.createElement('h4');
                    var a = document.createElement('a');
                    // a.href = item.link;
                    a.textContent = item.goodsName;
                    h4.appendChild(a);
                    li.appendChild(h4);

                    // 创建图片元素
                    var img = document.createElement('img');
                    img.src ="http://localhost:9000/eshop/images/goods/" + item.imgUrl;
                    var imgLink = document.createElement('a');
                    // imgLink.href = "#";
                    imgLink.appendChild(img);
                    li.appendChild(imgLink);

                    // 创建价格元素
                    var prize = document.createElement('div');
                    prize.classList.add('prize');
                    prize.textContent = '¥ ' + item.unit;
                    var shoppingCartLink = document.createElement('a');
                    // shoppingCartLink.href = '#';

                    shoppingCartLink.setAttribute('onclick', 'addCar(' + item.goodsId +')'); // 添加 onclick 属性
                    var shoppingCart = document.createElement('div');
                    shoppingCart.classList.add('shopping-cart');
                    shoppingCartLink.appendChild(shoppingCart);
                    prize.appendChild(shoppingCartLink);
                    li.appendChild(prize);

                    // 将li元素添加到goods_list中
                    goodsList.appendChild(li);
                }


                // 遍历goodsList数组，动态创建li元素并添加到ul中
                // goodsList.forEach(function(goods) {
                //     var li = $('<li>');
                //     var h4 = $('<h4>').append($('<a>').attr('href', goods.link).text(goods.goodsName));
                //     var img = $('<img>').attr('src', goods.imgUrl);
                //     var prize = $('<div>').addClass('prize').text('¥ ' + goods.unit);
                //     var shoppingCart = $('<div>').addClass('shopping-cart');
                //     li.append(h4, img, prize, shoppingCart);
                //     dynamicGoodsList.append(li);
                // });

            },
            error: function() {
                console.log('Failed to retrieve data');
            }
        });
    });

}

//获取所有的一级分类以及它们下属的所有二级分类和4个热门商品，并渲染
function getAllCategoryBO(){
    $.ajax(
		{
			type:"get",
			dataType:"json",
			url:"http://localhost:9000/eshop/api/v1/firstcategorybo",
			success:function(result){ //当返回结果的http响应码为200时
				let code = result.code;
                let categoryBOList = [];
                let str = "";
                if(code == 1000){ //代表数据返回成功
                    categoryBOList = result.data;
                    categoryBOList.forEach((categoryBO,index)=>{
                        str += `<div class="sexy">
                        <div class="list_model">
                                    <div class="list_title clearfix">
                                        <h3 class="fl" id="model2">${categoryBO.categoryName}</h3>
                                        <div class="subtitle fl">
                                            <span id="sp${categoryBO.categoryId}">|</span>
                                        </div>
                                        <a href="#" class="goods_more fr" id="fruit_more">查看更多 &gt;</a>
                                    </div>

                                                    <div class="goods_con clearfix">
                                                    <div class="goods_banner fl"><img src="images/${categoryBO.imgUrl}"></div>
                                                    <ul class="goods_list fl" id="ul${categoryBO.categoryId}">
                                                    </ul>
                        </div>
                    </div>

                    </div>`;
                    });
                    $("#firstCategoriesDv").after(str);

                    //再次循环，装入二级分类和所有4个商品
                    categoryBOList.forEach((categoryBO,index)=>{
                        let str1 = "";
                        let str2 = "";
                        categoryBO.secondCategories.forEach((secondCategory,index)=>{
                            str1 += `<a href="list2.html?secondid=1">${secondCategory.categoryName}</a>`;
                        });
                        categoryBO.goods.forEach((good,index)=>{
                            str2 += `<li>
                                <h4><a href="detail.html?id=12&amp;ID=1">${good.goodsName}</a></h4>
                                <a href="detail.html?id=12&amp;ID=1"><img src="images/goods/${good.smallImg}"></a>
                                <div class="prize">¥ ${good.unit}</div>
                            </li>`;
                        });
                        $("#sp"+categoryBO.categoryId).after(str1); //装入二级分类
                        $("#ul"+categoryBO.categoryId).append(str2); //装入4个热门商品
                    });

                }
			},
			error:function(result){ //当返回结果的http响应码为500时
				alert("获取数据失败，服务器程序出现错误");
                console.log(result);
			}
		}
	);
}

function getAllFirstCategories(){
    $.ajax(
		{
			type:"get",
			dataType:"json",
			url:"http://localhost:9000/eshop/api/v1/firstcategories",
			success:function(result){ //当返回结果的http响应码为200时
				let code = result.code;
                let categoryList = [];
                let str = "";
                if(code == 1000){ //代表数据返回成功
                    categoryList = result.data;
                    categoryList.forEach((category,index)=>{
                        str += `<li><a href="#" class="${category.style}">${category.categoryName}</a></li>`;
                    });
                    $("#firstCategories").append(str);
                    // console.log(str);
                }
			},
			error:function(result){ //当返回结果的http响应码为500时
				alert("获取数据失败，服务器程序出现错误");
                console.log(result);
			}
		}
	);
}

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