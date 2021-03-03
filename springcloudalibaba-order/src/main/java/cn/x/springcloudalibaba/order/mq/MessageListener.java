package cn.x.springcloudalibaba.order.mq;

import cn.x.springcloudalibaba.order.dto.OrderVO;
import cn.x.springcloudalibaba.order.mq.sink.IOrderSink;
import cn.x.springcloudalibaba.order.mq.sink.ITestSink;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

/**
 * @author xqa
 * @since 2021/3/2
 */
@EnableBinding(value = {ITestSink.class, IOrderSink.class})
@Slf4j
public class MessageListener {

    @StreamListener(ITestSink.INPUT)
    public void testInput(Message<String> message) {
        log.info("receive_test:{}", message.getPayload());
    }

    @StreamListener(IOrderSink.INPUT)
    public void orderInput(Message<OrderVO> message) {
        log.info("receive_order:{}", JSONObject.toJSONString(message.getPayload()));
    }

}
