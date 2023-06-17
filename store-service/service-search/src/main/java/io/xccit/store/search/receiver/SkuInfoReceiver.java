package io.xccit.store.search.receiver;

import com.rabbitmq.client.Channel;
import io.xccit.store.mq.constant.MQConst;
import io.xccit.store.search.service.ISkuInfoApiService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author CH_ywx
 * @date 2023-06-17
 * @description SkuInfo消息接收端
 */
@Component
public class SkuInfoReceiver {

    @Autowired
    private ISkuInfoApiService skuInfoApiService;

    /**
     * 商品上架消息接收
     * @param skuID skuID
     * @param message 消息
     * @param channel 通道
     * @throws IOException 异常信息
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = MQConst.QUEUE_GOODS_UPPER,durable = "true"),
            exchange = @Exchange(value = MQConst.EXCHANGE_GOODS_DIRECT),
            key = {MQConst.ROUTING_GOODS_UPPER}
    ))
    public void upperSku(Long skuID, Message message, Channel channel) throws IOException {
        if (skuID != null){
            skuInfoApiService.upperSku(skuID);
        }
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }

    /**
     * 商品下架消息接收
     * @param skuID skuID
     * @param message 消息
     * @param channel 通道
     * @throws IOException 异常信息
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = MQConst.QUEUE_GOODS_LOWER,durable = "true"),
            exchange = @Exchange(value = MQConst.EXCHANGE_GOODS_DIRECT),
            key = {MQConst.ROUTING_GOODS_LOWER}
    ))
    public void lowerSku(Long skuID, Message message, Channel channel) throws IOException {
        if (skuID != null){
            skuInfoApiService.lower(skuID);
        }
        /*
         * 第一个参数：表示收到的消息的标号
         * 第二个参数：如果为true表示可以签收多个消息
         */
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }
}
