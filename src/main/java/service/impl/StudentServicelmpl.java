package service.impl;

import dao.DepartmentDao;
import dao.StudentDao;
import entity.Student;
import factory.DaoFactory;
import service.StudentService;
import vo.StudentVo;
import factory.DaoFactory;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName StudentServicelmpl
 * @Description TODO
 * @Author ghr
 * @Date 2020/11/26 19:26
 **/
public class StudentServicelmpl implements StudentService {
    private final StudentDao studentDao = DaoFactory.getStudentDaoInstance();

    @Override
    public List<StudentVo> selectAll() {
        List<StudentVo> studentList = null;
        try {
            studentList = studentDao.selectAll();
        } catch (SQLException e) {
            System.err.println("查询学生信息发生错误");
        }
        return studentList;
    }
}
