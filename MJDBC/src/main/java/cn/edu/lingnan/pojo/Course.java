package cn.edu.lingnan.pojo;

public class Course {
    private String cid;
    private String cname;
    private String tname;
    private int flag;

    public Course() {
    }

    public Course(String cid, String cname, String tname, int flag) {
        this.cid = cid;
        this.cname = cname;
        this.tname = tname;
        this.flag = flag;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", tname='" + tname + '\'' +
                ", flag=" + flag +
                '}';
    }
}

