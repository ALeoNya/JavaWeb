function allcheck(checkbox) {
    alert("[Debug] A select all operation will be performed");
    var  oCheck = document.getElementsByName("check");
    if(checkbox.checked==true) {
        for(var i=0;i<oCheck.length;i++) {
            oCheck[i].checked = true;
        }
    }else {
        for(var i=0;i<oCheck.length;i++) {
            oCheck[i].checked = false;
        }
    }

}

function delall() {
    var allsid = new Array();
    var flag = false;
    var oCheck = document.getElementsByName("check");
    for(var i=0;i<oCheck.length;i++) {
        if(oCheck[i].checked) {
            allsid.push(oCheck[i].value);
            flag = true;
        }
    }
    alert("[Debug] in delall method,allsid is value = "+allsid);
    if(flag ==true){
        if(confirm("Are you sure to delete it?")) {
                location.href = "deleteStu?flag=all&sid="+allsid;
        }
    }else {
        alert("Choose at least one option")
    }
}