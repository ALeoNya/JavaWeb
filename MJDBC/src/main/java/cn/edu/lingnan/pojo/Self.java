package cn.edu.lingnan.pojo;

public class Self {

    private String sid;
    private String sname;
    private String tname;
    private String cid;
    private String cname;
    private int score;

    @Override
    public String toString() {
        return "Self{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", tname='" + tname + '\'' +
                ", cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", score=" + score +
                '}';
    }

    public Self() {
    }

    public Self(String sid, String sname, String tname, String cid, String cname, int score) {
        this.sid = sid;
        this.sname = sname;
        this.tname = tname;
        this.cid = cid;
        this.cname = cname;
        this.score = score;
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

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
