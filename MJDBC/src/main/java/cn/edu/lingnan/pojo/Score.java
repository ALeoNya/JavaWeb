package cn.edu.lingnan.pojo;

public class Score {
    private String sid;
    private String cname;
    private int score;

    public Score() {
    }

    public Score(String sid, String cname, int score) {
        this.sid = sid;
        this.cname = cname;
        this.score = score;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
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



    @Override
    public String toString() {
        return "score{" +
                "sid='" + sid + '\'' +
                ", cname='" + cname + '\'' +
                ", score=" + score +
                '}';
    }
}
