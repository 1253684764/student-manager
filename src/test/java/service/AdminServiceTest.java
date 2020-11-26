package service;

import factory.ServiceFactory;
import utils.ResultEntity;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdminServiceTest {
    private final AdminService adminService = ServiceFactory.getAdminServiceInstance();
    @Test
    public void adminLogin() {
        ResultEntity resultEntity = adminService.adminLogin("1253684764@qq.com","20000206ghr");
        assertEquals(0,resultEntity.getCode());
        System.out.println(resultEntity);
    }
}