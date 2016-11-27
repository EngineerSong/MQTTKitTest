package com.zhangkong.letsgo.im.core.config;

import com.zhangkong.letsgo.im.core.domain.Enum.MqttGameMsgTypeEnum;
import com.zhangkong.letsgo.im.core.domain.Enum.MqttMsgTypeEnum;
import com.zhangkong.letsgo.im.core.domain.entity.MqttMessageContent;

/**
 * 主题配置
 *  单聊
 *     1. 以当前登录用户的唯一标识作为第一级主题
 *     2. 当前登录用户的的好友或非好友唯一标识作为第二级主题
 *     3. 关注当前用户的主题即可接收此用户所有好友或非好友的的消息
 *
 * 群聊
 *     1. 以当前进入店铺的唯一标识作为第一级主题
 *     2. 关注当前进入店铺的主题可接收此店铺群组的消息
 *     3. 群内其他消息在此主题下一级继续扩展
 *
 * Created by w on 2016/3/6.
 */
public class TopicConfig {
    // 接收所有消息主题格式
    public final static String RECEIVE_ALL_MSG_TOPIC_FORMAT = "%s/#";
    // 发送消息主题格式
    //      1. 普通消息（文本消息、表情、文本表情混合）
    public final static String STANDARD_MSG_TOPIC_FORMAT = "%s/chat/standard";
    //      2. 图片
    //          a) 普通图片(无查看限制)
    //          b) 阅后即焚(仅可查看一次)
    public final static String PHOTO_MSG_TOPIC_FORMAT = "%s/chat/photo";
    //      3. 语音
    public final static String VOICE_MSG_TOPIC_FORMAT = "%s/chat/voice";
    //      3. 游戏
    //          a) 某个聊天的所有游戏通知
    public final static String ALL_GAME_NOTIFI_MSG_TOPPIC_FORMAT = "%s/chat/game/#/notifi";
    //          b) 某个聊天的某个游戏聊天消息
    public final static String GAME_CHAT_MSG_TOPIC_FORMAT = "%s/chat/game/%s/chat";
    //          b) 某个聊天的某个游戏通知
    public final static String GAME_NOTIFI_MSG_TOPIC_FORMAT = "%s/chat/game/%s/notifi";
    //      4. 红包
    //          a) 发(包)红包
    //          b) 领取红包
    public final static String RED_PACKETS_MSG_TOPIC_FORMAT = "%s/chat/red_packets";
    //      5. 聊天动作
    //          a) 进出群
    //          b) 正在输入、正在发送
    public final static String ACTION_CHAT_MSG_TOPIC_FORMAT = "%s/chat/action";
    //      6. 状态
    //          a) 在线、隐身、忙碌
    public final static String STATE_CHAT_NOTIFI_TOPIC_FORMAT = "%s/chat/state";
    //      7. 好友管理
    //          a) 好友申请
    //          b) 好友申请的同意、拒绝、忽略等操作
    //          c) 好友删除
    public final static String FRIEND_MANAGER_CHAT_MSG_TOPIC_FORMAT = "%s/chat/friend";
    // 系统通知
    public final static String SYS_NOTIFI_TOPIC_FORMAT = "sys/notifi";
    // 动态评论
    public final static String COMMENT_DYNAMIC_TOPIC_FORMAT = "%s/dynamic/comment";

    /**
     * 获取发送任何消息主题
     * @param topicFormat 主题格式
     * @param identity 身份
     * @return 主题字符串
     */
    public static String getTopic(String topicFormat , String identity){
        return String.format(topicFormat , identity);
    }

    /**
     * 获取发送任何消息主题
     * @param topicFormat 主题格式
     * @param identity 身份
     * @param identityTwo 第二个唯一标识
     * @return 主题字符串
     */
    public static String getTopic(String topicFormat , String identity , String identityTwo){
        return String.format(topicFormat , identity , identityTwo);
    }

    /**
     * 根据消息类型获取主题
     *
     * @param mqttMessageContent 消息对象
     * @param identity 唯一标识
     * @return 主题字符串
     */
    public static String getTopicByMsgType(MqttMessageContent mqttMessageContent, String identity){
        switch (MqttMsgTypeEnum.getItemByCode(mqttMessageContent.getMsgType())){
            case STANDARD:
                return getTopic(TopicConfig.STANDARD_MSG_TOPIC_FORMAT, identity);
            case PHOTO:
                return getTopic(TopicConfig.PHOTO_MSG_TOPIC_FORMAT , identity);
            case VOICE:
                return getTopic(TopicConfig.VOICE_MSG_TOPIC_FORMAT , identity);
            case FRIEND:
                return getTopic(TopicConfig.FRIEND_MANAGER_CHAT_MSG_TOPIC_FORMAT , identity);
            case GAME_NOTIFI:
                return getGameTopicByMsgType(MqttGameMsgTypeEnum.getItemByCode(mqttMessageContent.getMsg()[1]) , mqttMessageContent , identity);
            case RED_PACKETS:
                return getTopic(TopicConfig.RED_PACKETS_MSG_TOPIC_FORMAT , identity);
            case ACTION_CHAT:
                return getTopic(TopicConfig.ACTION_CHAT_MSG_TOPIC_FORMAT , identity);
            case ONLINE_STATE_CHAT:
                return getTopic(TopicConfig.STATE_CHAT_NOTIFI_TOPIC_FORMAT , identity);
            case SYS_NOTIFI:
                return TopicConfig.SYS_NOTIFI_TOPIC_FORMAT;
            case COMMENT_DYNAMIC:
                return getTopic(TopicConfig.COMMENT_DYNAMIC_TOPIC_FORMAT , identity);
        }

        return null;
    }

    /**
     * 根据消息类型获取游戏主题
     *
     * @param mqttGameMsgTypeEnum 消息类型
     * @param mqttMessageContent 消息内容
     * @return 主题
     */
    private static String getGameTopicByMsgType(MqttGameMsgTypeEnum mqttGameMsgTypeEnum , MqttMessageContent mqttMessageContent , String identity){
        switch (mqttGameMsgTypeEnum){
            case INITIATOR:
                return getTopic(TopicConfig.GAME_NOTIFI_MSG_TOPIC_FORMAT , identity , mqttMessageContent.getMsg()[2]);
            case JOIN:
                return getTopic(TopicConfig.GAME_NOTIFI_MSG_TOPIC_FORMAT , identity , mqttMessageContent.getMsg()[2]);
            case MSG:
                return getTopic(TopicConfig.GAME_CHAT_MSG_TOPIC_FORMAT , identity , mqttMessageContent.getMsg()[2]);
            case EXIT:
                return getTopic(TopicConfig.GAME_NOTIFI_MSG_TOPIC_FORMAT , identity , mqttMessageContent.getMsg()[2]);
        }
        return null;
    }


}
