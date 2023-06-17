package io.xccit.store.mq.constant;

/**
 * @author CH_ywx
 * @date 2023-06-17
 * @description MQ常量类
 */
public class MQConst {
    /**
     * 消息补偿
     */
    public static final String MQ_KEY_PREFIX = "store.mq:list";
    public static final int RETRY_COUNT = 3;

    /**
     * 商品上下架
     */
    public static final String EXCHANGE_GOODS_DIRECT = "store.goods.direct";
    public static final String ROUTING_GOODS_UPPER = "store.goods.upper";
    public static final String ROUTING_GOODS_LOWER = "store.goods.lower";
    //队列
    public static final String QUEUE_GOODS_UPPER  = "store.goods.upper";
    public static final String QUEUE_GOODS_LOWER  = "store.goods.lower";

    /**
     * 团长上下线
     */
    public static final String EXCHANGE_LEADER_DIRECT = "store.leader.direct";
    public static final String ROUTING_LEADER_UPPER = "store.leader.upper";
    public static final String ROUTING_LEADER_LOWER = "store.leader.lower";
    //队列
    public static final String QUEUE_LEADER_UPPER  = "store.leader.upper";
    public static final String QUEUE_LEADER_LOWER  = "store.leader.lower";

    //订单
    public static final String EXCHANGE_ORDER_DIRECT = "store.order.direct";
    public static final String ROUTING_ROLLBACK_STOCK = "store.rollback.stock";
    public static final String ROUTING_MINUS_STOCK = "store.minus.stock";

    public static final String ROUTING_DELETE_CART = "store.delete.cart";
    //解锁普通商品库存
    public static final String QUEUE_ROLLBACK_STOCK = "store.rollback.stock";
    public static final String QUEUE_SECKILL_ROLLBACK_STOCK = "store.seckill.rollback.stock";
    public static final String QUEUE_MINUS_STOCK = "store.minus.stock";
    public static final String QUEUE_DELETE_CART = "store.delete.cart";

    //支付
    public static final String EXCHANGE_PAY_DIRECT = "store.pay.direct";
    public static final String ROUTING_PAY_SUCCESS = "store.pay.success";
    public static final String QUEUE_ORDER_PAY  = "store.order.pay";
    public static final String QUEUE_LEADER_BILL  = "store.leader.bill";

    //取消订单
    public static final String EXCHANGE_CANCEL_ORDER_DIRECT = "store.cancel.order.direct";
    public static final String ROUTING_CANCEL_ORDER = "store.cancel.order";
    //延迟取消订单队列
    public static final String QUEUE_CANCEL_ORDER  = "store.cancel.order";

    /**
     * 定时任务
     */
    public static final String EXCHANGE_DIRECT_TASK = "store.exchange.direct.task";
    public static final String ROUTING_TASK_23 = "store.task.23";
    //队列
    public static final String QUEUE_TASK_23  = "store.queue.task.23";
}
