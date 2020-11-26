package factory;

import dao.AdminDao;
import dao.ClazzDao;
import dao.DepartmentDao;
import dao.StudentDao;
import dao.impi.AdminDaoImpl;
import dao.impi.ClazzDaoImpl;
import dao.impi.DepartmentDaolmpl;
import dao.impi.StudentDaoImpl;

/**
 * @ClassName DaoFactory
 * @Description TODO
 * @Author ALIENWARE
 * @Date 2020/11/26
 **/
public class DaoFactory {


    public static AdminDao getAdminDaoInstance(){
        return new AdminDaoImpl();
    }
    public static DepartmentDao getDepartmentDaoInstance(){
        return new DepartmentDaolmpl();
    }
    public static ClazzDao getClazzDaoInstance(){
        return new ClazzDaoImpl();
    }
    public static StudentDao getStudentDaoInstance(){
        return new StudentDaoImpl();
    }
}
