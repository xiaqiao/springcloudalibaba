package cn.x.springcloudalibaba.order.controller;

import cn.x.springcloudalibaba.order.bean.ResponseResult;
import cn.x.springcloudalibaba.order.dto.OrderVO;
import cn.x.springcloudalibaba.order.fallback.CustomSentinelFallback;
import cn.x.springcloudalibaba.order.feign.UserFeignClient;
import cn.x.springcloudalibaba.order.handler.CustomSentinelBlockHandler;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
@RefreshScope
@Slf4j
public class OrderController {

    @Autowired
    private UserFeignClient userFeignClient;

    @Value("${order.name}")
    private String orderName;

    @GetMapping("/{id}")
    @SentinelResource(value = "id",
            blockHandlerClass = CustomSentinelBlockHandler.class,
            blockHandler = "defaultHandler",
            fallbackClass = CustomSentinelFallback.class,
            fallback = "defaultFallback")
    public ResponseResult order(@PathVariable Long id) {
        log.info("-------------------------{}----------------------", id);
        OrderVO orderVO = new OrderVO();
        orderVO.setId(id);
        orderVO.setOderName(orderName);
        Map data = (Map) userFeignClient.getUserInfo(id.intValue()).getData();
        orderVO.setUserName(data.get("name").toString());
        return ResponseResult.success(orderVO);
    }
}
