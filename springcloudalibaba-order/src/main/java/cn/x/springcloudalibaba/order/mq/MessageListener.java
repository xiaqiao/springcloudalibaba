package cn.x.springcloudalibaba.order.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

/**
 * @author xqa
 * @since 2021/3/2
 */
@EnableBinding(Sink.class)
@Slf4j
public class MessageListener {

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        log.info("receive:{}", message.getPayload());
    }

}
