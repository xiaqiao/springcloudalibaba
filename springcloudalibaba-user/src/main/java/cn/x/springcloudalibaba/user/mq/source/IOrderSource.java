package cn.x.springcloudalibaba.user.mq.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author xqa
 * @since 2021/3/3
 */
public interface IOrderSource {

    /**
     * Name of the output channel.
     */
    String OUTPUT = "order-output";

    /**
     * @return output channel
     */
    @Output(IOrderSource.OUTPUT)
    MessageChannel testOutput();

}
