package cn.x.springcloudalibaba.order.fallback;

import cn.x.springcloudalibaba.order.bean.ResponseResult;

/**
 * @author xqa
 * @since 2021/2/4
 */
public class CustomSentinelFallback {

    public static ResponseResult defaultFallback(Long id) {
        return ResponseResult.sysError();
    }

}
