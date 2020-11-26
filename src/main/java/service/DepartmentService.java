package service;

import entity.Department;

import java.util.List;

/**
 * @ClassName DepartmentService
 * @Description TODO
 * @Author ghr
 * @Date 2020/11/26
 **/
public interface DepartmentService {
    /**
     * 查询所有院系
     *
     * @return List<Department>
     */
    List<Department> selectAll();
    void deleteId(int id);
    int addDepartment(Department department);
}
