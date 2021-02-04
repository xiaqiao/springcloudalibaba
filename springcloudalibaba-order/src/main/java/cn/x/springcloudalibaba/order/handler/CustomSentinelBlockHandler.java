package cn.x.springcloudalibaba.order.handler;

import cn.x.springcloudalibaba.order.bean.ResponseResult;
import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author xqa
 * @since 2021/2/4
 */
public class CustomSentinelBlockHandler {

    public static ResponseResult defaultHandler(Long id, BlockException e) {
        return ResponseResult.flowLimit();
    }

}
