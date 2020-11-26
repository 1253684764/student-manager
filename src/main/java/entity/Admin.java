package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Admin
 * @Description TODO
 * @Author ALIENWARE
 * @Date 2020/11/26
 **/
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Admin {
    private Integer id;
    private String account;
    private String password;
    private String adminName;
}
