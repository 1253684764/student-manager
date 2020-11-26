package dao;

import entity.Clazz;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName ClazzDao
 * @Description TODO
 * @Author UnKnW
 * @Date 2020/11/20
 **/
public interface ClazzDao {
    /**
     * 按照院系id查询班级
     *
     * @param departmentId 院系ID
     * @return List<CClass> 院系班级集合
     * @throws SQLException 异常
     */
    List<Clazz> selectByDepartmentId(int departmentId) throws SQLException;

    /**
     * 查询所有班级
     *
     * @return List<Clazz></>
     * @throws SQLException 异常
     */
    List<Clazz> selectAll() throws SQLException;
}
