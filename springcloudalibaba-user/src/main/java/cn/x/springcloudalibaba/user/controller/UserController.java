package cn.x.springcloudalibaba.user.controller;

import cn.x.springcloudalibaba.user.bean.ResponseResult;
import cn.x.springcloudalibaba.user.dto.UserVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xqa
 * @since 2021/2/2
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{id}")
    public ResponseResult user(@PathVariable Integer id) {
        UserVO userVO = new UserVO();
        userVO.setId(id);
        userVO.setName("x" + id);
        return ResponseResult.success(userVO);
    }

}
