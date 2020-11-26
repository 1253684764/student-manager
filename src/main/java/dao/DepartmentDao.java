package dao;

import entity.Department;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName DepatmentDao
 * @Description TODO
 * @Author ghr
 * @Date 2020/11/26
 **/


public interface DepartmentDao {
    /**
     * 查询所有院系
     *
     * @return List<department>
     * @throws SQLException 异常
     */
    List<entity.Department> getAll() throws SQLException;
    void delete(int id)throws SQLException;
    int insertDepartment(entity.Department department) throws SQLException;
}
