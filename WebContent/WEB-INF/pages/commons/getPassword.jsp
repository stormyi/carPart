<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>修配连汽配市场</title>
<link href="${ctx}/css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"  src="${ctx}/js/jquery.min.js"></script>      
<script src="${ctx}/js/layer/layer.min.js" type="text/javascript"></script>
<script language="javascript"> 
function getPwd(){
var index = parent.layer.getFrameIndex(window.name);
var email=$("#email").val();
var username=$("#username").val();
if(email!=""&&username!=""){
$.ajax({
    url:"${ctx}/login/getPassword.shtml",    //请求的url地址
    data:{"email":email,"loginName":username,},    //参数值
    type:"post",   //请求方式
    dataType:"text",
    success:function(data){
       if(data==1){
       		alert("对不起，身份校验失败！");
       }else if(data==2){
           alert("密码修改已经成功，请查收邮件");
           parent.layer.close(index);
       }else if(data==3){
    	   alert("服务器错误，稍后重试") ;
       }
    }
});
}else{

alert("用户名和邮箱不能为空");
}
}
</script>
</head>
<body>
    <div class="password_d"><!--main颜色-->
            <div class="dang">当前位置：找回密码</div>
            <div class="password_f"> 
            <dl><dt><span style="color:red">*</span>用户名：</dt><dd><input type="text" name="user" id="username" class="in"/></dd><dd>输入您的用户名</dd></dl>
                <dl><dt><span style="color:red">*</span>邮箱：</dt><dd><input type="text" name="email" id="email" class="in"/></dd><dd>输入您注册信息中的email地址</dd></dl>
                <dl style="border:0;"><dt>&nbsp;</dt><dd><input type="button" value="找回密码" class="pa" onclick="getPwd()" /></dd></dl>
           </div>
        </div>
    </div><!--main颜色-->
</body>
</html>
