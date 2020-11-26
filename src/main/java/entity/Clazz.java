package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Clazz
 * @Description TODO
 * @Author ghr
 * @Date 2020/11/26 19:56
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Clazz {
    private Integer id;
    private Integer departmentId;
    private String className;

    @Override
    public String toString() {
        return className;
    }
}
