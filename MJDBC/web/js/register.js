function check() {
    if(form.sid.value==""){
        alert("��������û����Ϊ�գ����������룡");
        form.sid.form();
        return false;
    }

    var regm = /^s[0-9][0-9]$/
    if(form.sid.value!=""&&!form.sid.value.match(regm)) {
        alert("�û���������������s00�ĸ�ʽ���룡");
    }

    if(form.sname.value==""){
        alert("��������û�����Ϊ�գ����������룡");
        form.sid.form();
        return false;
    }
    if(form.password.value==""){
        alert("��������û�����Ϊ�գ����������룡");
        form.sid.form();
        return false;
    }

    if(form.password1.value=""){
        alert("��������û�ȷ������Ϊ�գ����������룡\"");
        form.sid.form();
        return false;
    }
    if(form.password1.value!=form.password.value){
        alert("ȷ���������벻һ�£����������룡");
        form.sid.form();
        return false;
    }


    var regm = /^[0-9]$/
    if(form.sid.value!=""&&!form.sid.value.match(regm)) {
        alert("��������û�Ȩ��Ϊ�գ����������룡");
    }
    if(form.superuser.value==""){
        alert("��������û�Ȩ�޸�ʽ��������0-9�ĸ�ʽ���룡");
        form.superuser.form();
        return false;
    }
}
