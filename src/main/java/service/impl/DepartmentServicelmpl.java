package service.impl;

import dao.DepartmentDao;
import entity.Department;
import factory.DaoFactory;
import service.DepartmentService;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName DepartmentServicelmpl
 * @Description TODO
 * @Author ghr
 * @Date 2020/11/26 15:28
 **/
public class DepartmentServicelmpl implements DepartmentService {
    private final DepartmentDao departmentDao = DaoFactory.getDepartmentDaoInstance();

    @Override
    public List<Department> selectAll() {
        List<Department> departmentList = null;

        try {
            departmentList = departmentDao.getAll();
        } catch (SQLException e) {
            System.err.println("查询院系信息出现异常");
        }
        return departmentList;
    }

    @Override
    public void deleteId(int id) {
        try {
            departmentDao.delete(id);
        } catch (SQLException ee) {
            System.err.println("删除信息出现异常");
        }
    }

    @Override
    public int addDepartment(Department department) {
        int n=0;
        try {
            n = departmentDao.insertDepartment(department);
        } catch (SQLException e) {
            System.err.println("新增院系信息出现异常");
        }
        return n;
    }
}
