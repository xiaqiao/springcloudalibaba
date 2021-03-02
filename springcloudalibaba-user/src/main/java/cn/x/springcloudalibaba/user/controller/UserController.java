package cn.x.springcloudalibaba.user.controller;

import cn.x.springcloudalibaba.user.bean.ResponseResult;
import cn.x.springcloudalibaba.user.dto.UserVO;
import cn.x.springcloudalibaba.user.mq.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
@RefreshScope
public class UserController {

    @Value("${user.name}")
    private String userName;

    @Autowired
    private IMessageProvider messageProvider;

    @GetMapping("/{id}")
    public ResponseResult user(@PathVariable Integer id) {
        UserVO userVO = new UserVO();
        userVO.setId(id);
        userVO.setName(userName);
        return ResponseResult.success(userVO);
    }

    @GetMapping("/sendMessage")
    public ResponseResult sendMessage() {
        return ResponseResult.success(messageProvider.send());
    }

}
