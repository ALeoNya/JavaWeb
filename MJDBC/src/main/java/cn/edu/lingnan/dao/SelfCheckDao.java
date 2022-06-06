package cn.edu.lingnan.dao;

import cn.edu.lingnan.pojo.Self;

import java.util.Vector;

public interface SelfCheckDao {
    public Vector<Self> findSelfDataByName(String sname);
}
