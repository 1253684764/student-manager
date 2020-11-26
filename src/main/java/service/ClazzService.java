package service;

import entity.Clazz;

import java.util.List;

/**
 * @ClassName ClazzService
 * @Description TODO
 * @Author UnKnW
 * @Date 2020/11/20
 **/
public interface ClazzService {
    List<Clazz> getClassByDepId(int id);
    List<Clazz> selectAll();
}
