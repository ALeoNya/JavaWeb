package cn.edu.lingnan.pojo;

public class Student {

    private String sid;
    private String sname;
    private String password;
    private int superuser;
    private int flag;

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", password='" + password + '\'' +
                ", superuser=" + superuser +
                ", flag=" + flag +
                '}';
    }

    public Student() {
    }

    public Student(String sid, String sname, String password, int superuser, int flag) {
        this.sid = sid;
        this.sname = sname;
        this.password = password;
        this.superuser = superuser;
        this.flag = flag;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSuperuser() {
        return superuser;
    }

    public void setSuperuser(int superuser) {
        this.superuser = superuser;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }



}
