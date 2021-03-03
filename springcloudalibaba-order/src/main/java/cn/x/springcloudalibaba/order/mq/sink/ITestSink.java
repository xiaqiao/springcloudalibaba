package cn.x.springcloudalibaba.order.mq.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author xqa
 * @since 2021/3/3
 */
public interface ITestSink {

    /**
     * Input channel name.
     */
    String INPUT = "test-input";

    /**
     * @return input channel.
     */
    @Input(ITestSink.INPUT)
    SubscribableChannel input();

}
