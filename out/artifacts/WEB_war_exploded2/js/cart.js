//加入购物车
function buy(goodsid){
    $.post("goods_buy",{goodsid:goodsid},function (data){
        if(data=="ok") {
            layer.msg("添加到购物车！", {time: 800}, function () {
                location.reload();
            });
        }
        else if(data=="fail"){
            layer.msg("库存不足，请购买其他商品！",{time:800},function (){

            });
        }

    });
}
//购物车商品数量减少
function lessen(goodsid){
    $.post("goods_lessen",{goodsid:goodsid},function (data){
        if(data=="ok"){
            layer.msg("操作成功！",{time:800},function (){
                location.reload();
            })
        }
    })
}
//购物车删除
function deletes(goodid){
    $.post("goods_delete",{goodsid:goodid},function(data){
        if(data=="ok"){
            layer.msg("删除成功！",{time:800},function (){
                location.reload();
            })
        }
    })
}

//确认注销的弹窗
function  modal(){
    openModal();

}
//确认注销
function confirm(){
    $.post("log_off",function (data){
        if(data=="ok"){
            layer.msg("注销成功",{time:800},function (){
                location.reload();
            })

        }
    })


}
//取消注销
function cancel(){
    closeModal();
}
// // 监听注销账户按钮的点击事件
// logoutButton.addEventListener('click', function() {
//     openModal();
// });
// 打开模态框
function openModal() {
    // modal.style.display = 'block';
    $.post("log_off");
}

// 关闭模态框
function closeModal() {
    modal.style.display = 'none';
}

// 确认注销账户操作
function confirmLogout() {
    // 在这里添加注销账户的操作
    console.log('用户点击了确认注销账户按钮');

    // 关闭模态框
    closeModal();
}
// document.getElementById('confirmBtn').addEventListener('click', function() {
//     // 在这里添加点击确认时的操作，比如执行注销账号的操作
//     $.post("log_off");
// });
//
// document.getElementById('cancelBtn').addEventListener('click', function() {
//     document.getElementById('myModal').style.display = 'none'; // 点击取消时关闭弹窗
// });

//     document.querySelector('.btn.btn-warning').addEventListener('click', function() {
//     document.getElementById('myModal').style.display = 'block'; // 点击"注销账号"按钮时显示弹窗
// });
// document.querySelector('.btn-warning').addEventListener('click', function() {
//     if (confirm("确定要注销账号吗？")) {
//         window.location.href = "${pageContext.request.contextPath}/log_off";
//     }
// });
document.getElementById('confirmBtn').addEventListener('click', function() {
    //在这里添加点击确认时的操作，比如执行注销账号的操作
    $.post("log_off");
});

document.getElementById('cancelBtn').addEventListener('click', function() {
    document.getElementById('myModal').style.display = 'none';
    //点击取消时关闭弹窗
});
