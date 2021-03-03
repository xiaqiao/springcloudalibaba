package cn.x.springcloudalibaba.user.mq;

/**
 * @author xqa
 * @since 2021/3/2
 */
public interface IMessageProvider {

    String sendTest();

    String sendOrder(String userName);

}
