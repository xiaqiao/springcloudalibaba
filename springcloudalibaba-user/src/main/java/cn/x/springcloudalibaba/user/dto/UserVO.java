package cn.x.springcloudalibaba.user.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author xqa
 * @since 2021/2/2
 */
@Data
public class UserVO {

    private Integer id;
    private String name;
    private List<Map> orderList;

}
