function check() {
    if(form.sid.value==""){
        alert("The number you entered is empty....");
        form.sid.form();
        return false;
    }

    var regm = /^s[0-9][0-9]$/
    if(form.sid.value!=""&&!form.sid.value.match(regm)) {
        alert("The number of format you entered is empty....");
    }

    if(form.sname.value==""){
        alert("The sname you entered is empty....");
        form.sid.form();
        return false;
    }
    if(form.password.value==""){
        alert("The password you entered is empty....");
        form.sid.form();
        return false;
    }

    if(form.password1.value=""){
        alert("The passwor you entered against is empty....");
        form.sid.form();
        return false;
    }
    if(form.password1.value!=form.password.value){
        alert("The passwor you entered be not same as the before");
        form.sid.form();
        return false;
    }


    var regm = /^[0-9]$/
    if(form.sid.value!=""&&!form.sid.value.match(regm)) {
        alert("The number of format you entered is empty....");
    }
    if(form.superuser.value==""){
        alert("The user right you entered is empty....");
        form.superuser.form();
        return false;
    }
}