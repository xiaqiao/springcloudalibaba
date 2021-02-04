package cn.x.springcloudalibaba.order.feign.fallback;

import cn.x.springcloudalibaba.order.bean.ResponseResult;
import cn.x.springcloudalibaba.order.feign.UserFeignClient;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xqa
 * @since 2021/2/2
 */
@Component
@Slf4j
public class UserFeignFallbackFactory implements FallbackFactory<UserFeignClient> {

    @Override
    public UserFeignClient create(Throwable throwable) {
        log.error("fallback: {}", throwable.getMessage());
        return new UserFeignClient() {
            @Override
            public ResponseResult getUserInfo(Integer id) {
                Map<String, Object> map = new HashMap<>();
                map.put("id", -1);
                map.put("name", "error");
                return ResponseResult.success(map);
            }
        };
    }
}
