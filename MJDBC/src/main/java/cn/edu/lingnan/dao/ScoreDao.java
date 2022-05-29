package cn.edu.lingnan.dao;

import cn.edu.lingnan.pojo.Score;

import java.util.List;

public interface   ScoreDao {

    //通过学号删除学生成绩 没有外键约束 直接删除
    public boolean deleteScoreBySid(String sid);

    //通过学号和课程号删除学生成绩 没有外键约束 直接删除
    public boolean deleteScoreBySidAndCid(String sid , String cid);

    //通过学号和课程号删除学生成绩 没有外键约束 直接删除
    public boolean deleteScoreByCid(String cid);

    //通过学号查询学生选修了哪些课程
    public List<Score> selectScoreBySid(String sid);

    //通过学号和课程号查询学生选修了哪些课程
    public Score selectScoreBySidAndCid(String sid , String cid);

    //插入 成绩 （外键约束 在Service 层操作）
    public boolean insertScore(Score score);
}
