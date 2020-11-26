package dao.impi;

import dao.DepartmentDao;
import entity.Department;
import utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DepatmentDaolmpl
 * @Description TODO
 * @Author ghr
 * @Date 2020/11/17 22:18
 **/
public class DepartmentDaolmpl implements DepartmentDao {
    @Override
    public List<Department> getAll() throws SQLException{
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT * FROM t_department";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Department> departmentList = new ArrayList<>();
        while(rs.next()){
            Department department = new Department();
            department.setId(rs.getInt("id"));
            department.setDepartmentName(rs.getString("department_name"));
            department.setLogo(rs.getString("logo"));
            departmentList.add(department);
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return departmentList;
    }

    @Override
    public void delete(int id) throws SQLException {

            JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
            Connection connection = jdbcUtil.getConnection();
            String de = "delete FROM t_department WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(de);
            pstmt.setInt(1,id);
            pstmt.execute();
            pstmt.close();
            connection.close();
    }

    @Override
    public int insertDepartment(Department department) throws SQLException {
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = jdbcUtil.getConnection();
        String ist = "INSERT INTO t_department (department_name,logo) VALUES (?,?)";
        PreparedStatement pstmt = connection.prepareStatement(ist);
        pstmt.setString(1,department.getDepartmentName());
        pstmt.setString(2,department.getLogo());
        int n = pstmt.executeUpdate();
        pstmt.close();
        connection.close();
        return n;
    }
}