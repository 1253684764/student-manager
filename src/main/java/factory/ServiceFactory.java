package factory;

import service.AdminService;
import service.ClazzService;
import service.DepartmentService;
import service.StudentService;
import service.impl.AdminServiceImpl;
import service.impl.ClassServiceImpl;
import service.impl.DepartmentServicelmpl;
import service.impl.StudentServicelmpl;

/**
 * @ClassName ServiceFacotry
 * @Description TODO
 * @Author ALIENWARE
 * @Date 2020/11/26
 **/
public class ServiceFactory {

    public static AdminService getAdminServiceInstance(){
            return new AdminServiceImpl();
        }
    public static DepartmentService getDepartmentServiceInstance(){
        return new DepartmentServicelmpl();
    }
    public static ClazzService getClazzServiceInstance(){
        return new ClassServiceImpl();
    }
    public static StudentService getStudentServiceInstance(){
        return new StudentServicelmpl();
    }
        }



