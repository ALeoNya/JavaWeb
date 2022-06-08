package cn.edu.lingnan.dao;

import cn.edu.lingnan.pojo.Score;

import java.util.List;
import java.util.Vector;

public interface   ScoreDao {

    //ͨ��ѧ��ɾ��ѧ���ɼ� û�����Լ�� ֱ��ɾ��
    public boolean deleteScoreBySid(String sid);

    //ͨ��ѧ�źͿγ̺�ɾ��ѧ���ɼ� û�����Լ�� ֱ��ɾ��
    public boolean deleteScoreBySidAndCid(String sid , String cid);

    //ͨ��ѧ�źͿγ̺�ɾ��ѧ���ɼ� û�����Լ�� ֱ��ɾ��
    public boolean deleteScoreByCid(String cid);

    //ͨ��ѧ�Ų�ѯѧ��ѡ������Щ�γ�
    public List<Score> selectScoreBySid(String sid);

    //ͨ��ѧ�źͿγ̺Ų�ѯѧ��ѡ������Щ�γ�
    public Score selectScoreBySidAndCid(String sid , String cid);

    //���� �ɼ� �����Լ�� ��Service �������
    public boolean insertScore(Score score);



    //���¹���
    boolean updateScore(Score score);

    public Vector<Score> findAllScore();
}
