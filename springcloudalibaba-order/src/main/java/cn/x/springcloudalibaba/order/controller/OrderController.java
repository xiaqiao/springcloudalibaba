package cn.x.springcloudalibaba.order.controller;

import cn.x.springcloudalibaba.order.bean.ResponseResult;
import cn.x.springcloudalibaba.order.dto.OrderVO;
import cn.x.springcloudalibaba.order.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author xqa
 * @since 2021/2/2
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/{id}")
    public ResponseResult order(@PathVariable Long id) {
        OrderVO orderVO = new OrderVO();
        orderVO.setId(id);
        orderVO.setOderName("orderName" + id);
        Map data = (Map) userFeignClient.getUserInfo(id.intValue()).getData();
        orderVO.setUserName(data.get("name").toString());
        return ResponseResult.success(orderVO);
    }

}