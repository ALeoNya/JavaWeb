package cn.edu.lingnan.dao;


import cn.edu.lingnan.pojo.Course;

public interface CourseDao {

    //按课程编号查询课程记录
    public Course selectCourseByCid(String cid);

    //插入一条课程记录
    public boolean insertCourse(Course course);

    //删除课程表 (外键约束 要在Service层先删除Score表的记录 再删除Course表记录)
    public boolean deleteCourseByCid(String cid);


}
