package dao;

import entity.Admin;
import java.sql.SQLException;

/**
 * @ClassName AdminDao
 * @Description TODO
 * @Author ghr
 * @Date 2020/11/26
 **/
public interface AdminDao {
    /**
     * 根据账号查找管理员
     *
     * @param account 账号入参
     * @return Admin 管理员信息
     * @throws SQLException 该方法会抛出SQL异常
     */
    Admin findAdminByAccount(String account) throws SQLException;
}

