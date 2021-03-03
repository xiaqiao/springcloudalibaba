package cn.x.springcloudalibaba.order.mq.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author xqa
 * @since 2021/3/3
 */
public interface IOrderSink {

    /**
     * Input channel name.
     */
    String INPUT = "order-input";

    /**
     * @return input channel.
     */
    @Input(IOrderSink.INPUT)
    SubscribableChannel input();

}
