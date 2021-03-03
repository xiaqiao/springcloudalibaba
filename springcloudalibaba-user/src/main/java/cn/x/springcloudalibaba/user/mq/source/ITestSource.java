package cn.x.springcloudalibaba.user.mq.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author xqa
 * @since 2021/3/3
 */
public interface ITestSource {

    /**
     * Name of the output channel.
     */
    String OUTPUT = "test-output";

    /**
     * @return output channel
     */
    @Output(ITestSource.OUTPUT)
    MessageChannel testOutput();

}
