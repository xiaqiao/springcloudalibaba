package cn.x.springcloudalibaba.order.feign;

import cn.x.springcloudalibaba.order.bean.ResponseResult;
import cn.x.springcloudalibaba.order.feign.fallback.UserFeignFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author xqa
 * @since 2021/2/2
 */
@FeignClient(name = "springcloudalibaba-user",
        fallbackFactory = UserFeignFallbackFactory.class)
public interface UserFeignClient {

    @GetMapping(value = "/user/{id}")
    ResponseResult getUserInfo(@PathVariable Integer id);
}
