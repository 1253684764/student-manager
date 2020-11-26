package service.impl;

import dao.AdminDao;
import dao.ClazzDao;
import entity.Clazz;
import factory.DaoFactory;
import service.ClazzService;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName ClassServiceImpl
 * @Description TODO
 * @Author ghr
 * @Date 2020/11/26 14:23
 **/
public class ClassServiceImpl implements ClazzService {
    private final ClazzDao clazzDao = DaoFactory.getClazzDaoInstance();
    @Override
    public List<Clazz> getClassByDepId(int id) {
        List<Clazz> clazzList = null;
        try {
            clazzList=clazzDao.selectByDepartmentId(id);
        } catch (SQLException e) {
            System.err.println("根据id查询班级信息出现异常");
        }
        return clazzList;
    }

    @Override
    public List<Clazz> selectAll() {
        List<Clazz> clazzList = null;
        try {
            clazzList=clazzDao.selectAll();
        } catch (SQLException e) {
            System.err.println("查询班级信息出现异常");
        }
        return clazzList;
    }
}
