function check() {
    if(form.sid.value==""){
        alert("你输入的用户编号为空，请重新输入！");
        form.sid.form();
        return false;
    }

    var regm = /^s[0-9][0-9]$/
    if(form.sid.value!=""&&!form.sid.value.match(regm)) {
        alert("用户编号输入错误，请以s00的格式输入！");
    }

    if(form.sname.value==""){
        alert("你输入的用户名称为空，请重新输入！");
        form.sid.form();
        return false;
    }
    if(form.password.value==""){
        alert("你输入的用户密码为空，请重新输入！");
        form.sid.form();
        return false;
    }

    if(form.password1.value=""){
        alert("你输入的用户确认密码为空，请重新输入！\"");
        form.sid.form();
        return false;
    }
    if(form.password1.value!=form.password.value){
        alert("确认密码输入不一致，请重新输入！");
        form.sid.form();
        return false;
    }


    var regm = /^[0-9]$/
    if(form.sid.value!=""&&!form.sid.value.match(regm)) {
        alert("你输入的用户权限为空，请重新输入！");
    }
    if(form.superuser.value==""){
        alert("你输入的用户权限格式错误，请以0-9的格式输入！");
        form.superuser.form();
        return false;
    }
}
