package cn.x.springcloudalibaba.user.mq.impl;

import cn.x.springcloudalibaba.user.dto.OrderVO;
import cn.x.springcloudalibaba.user.mq.IMessageProvider;
import cn.x.springcloudalibaba.user.mq.source.IOrderSource;
import cn.x.springcloudalibaba.user.mq.source.ITestSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Random;
import java.util.UUID;

/**
 * @author xqa
 * @since 2021/3/2
 */
@EnableBinding(value = {ITestSource.class, IOrderSource.class})
@Slf4j
public class IMessageProviderImpl implements IMessageProvider {

    @Autowired
    private ITestSource testSource;
    @Autowired
    private IOrderSource orderSource;

    @Override
    public String sendTest() {
        String string = UUID.randomUUID().toString();
        testSource.testOutput().send(MessageBuilder.withPayload(string).build());
        log.info("send:{}", string);
        return "ok";
    }

    @Override
    public String sendOrder(String userName) {
        OrderVO orderVO = new OrderVO();
        long orderId = new Random().nextLong();
        orderVO.setId(orderId);
        orderVO.setOderName("orderName" + orderId);
        orderVO.setUserName(userName);
        orderSource.testOutput().send(MessageBuilder.withPayload(orderVO).build());
        log.info("send:{}", orderId);
        return "ok";
    }
}
