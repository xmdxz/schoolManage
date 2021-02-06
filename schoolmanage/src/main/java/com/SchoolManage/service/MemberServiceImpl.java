package com.SchoolManage.service;

import com.SchoolManage.dao.MemberDao;
import com.SchoolManage.pojo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author RainGoal
 * @Date 2021/2/5 21:55
 * @Description TODO
 * @Version 1.0
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public List<Member> findAll(int Page, int num) {
        int startPage = (Page-1)*num;
        return memberDao.findAll(startPage, num);
    }

    @Override
    public int findAllNum() {
        return memberDao.findAllNum();
    }

    @Override
    public List<Member> findByDepartment(String department, int Page, int num) {
        int startPage = (Page-1)*num;
        return memberDao.findByDepartment(department,startPage,num);
    }

    @Override
    public int findByDepartmentNum(String department) {
        return memberDao.findByDepartmentNum(department);
    }

    @Override
    public Member findById(String id) {
        return memberDao.findById(id);
    }

    @Override
    public List<Member> findByName(String name, int Page, int num) {
        int startPage = (Page-1)*num;
        return memberDao.findByName(name, startPage, num);
    }

    @Override
    public int findByNameNum(String name) {
        return memberDao.findByNameNum(name);
    }

    @Override
    public List<Member> findByPosition(String position, int Page, int num) {
        int startPage = (Page-1)*num ;
        return memberDao.findByPosition(position, startPage, num);
    }

    @Override
    public int findByPositionNum(String position) {
        return memberDao.findByPositionNum(position);
    }

    @Override
    public List<Member> findByConditions(Map<String, String> map) {
        return memberDao.findByConditions(map);
    }

    @Override
    public int findByConditionsNum(Map<String, String> map) {
        return memberDao.findByConditionsNum(map);
    }

    @Override
    public int insertData(Member member) {
        return memberDao.insertData(member);
    }

    @Override
    public int insertDatas(List<Member> members) {
        return memberDao.insertDatas(members);
    }

    @Override
    public int updateData(Member member) {
        return memberDao.updateData(member);
    }

    @Override
    public int deleteData(String id) {
        return memberDao.deleteData(id);
    }

    @Override
    public Member findByDepartmentAndId(String department, String id) {
        return memberDao.findByDepartmentAndId(department,id);
    }

    @Override
    public List<Member> findByDepartmentAndName(String department, String name, int startPage, int num) {
        return memberDao.findByDepartmentAndName(department,name,startPage,num);
    }

    @Override
    public int findByDepartmentAndNameNum(String department, String name) {
        return memberDao.findByDepartmentAndNameNum(department,name);
    }
}
