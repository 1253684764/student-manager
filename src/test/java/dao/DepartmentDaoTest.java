package dao;

import entity.Department;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import entity.Department;
import factory.DaoFactory;
import org.junit.Test;
import java.sql.SQLException;
import static org.junit.Assert.*;

public class DepartmentDaoTest {
    private final DepartmentDao departmentDao = DaoFactory.getDepartmentDaoInstance();
    @Test
    public void getAll() {
        List<Department> departmentList = null;
        try{
            departmentList = departmentDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assert  departmentList !=null;
        departmentList.forEach(System.out::println);
    }

}