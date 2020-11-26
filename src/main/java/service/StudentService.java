package service;

import vo.StudentVo;

import java.util.List;

/**
 * @ClassName StudentService
 * @Description TODO
 * @Author UnKnW
 * @Date 2020/11/23
 **/
public interface StudentService {
    List<StudentVo> selectAll();
}
