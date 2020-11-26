package dao;

import vo.StudentVo;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName StudentDao
 * @Description TODO
 * @Author UnKnW
 * @Date 2020/11/23
 **/
public interface StudentDao {
    /**
     * 查询所有学生（试图对象）
     *
     * @return 学生视图列表数据
     * @throws SQLException 异常
     */
    List<StudentVo> selectAll() throws SQLException;
}
