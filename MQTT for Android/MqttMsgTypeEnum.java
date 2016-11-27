package com.zhangkong.letsgo.im.core.domain.Enum;

/**
 * MQTT 消息类型枚举
 * Created by w on 2016/3/9.
 */
public enum MqttMsgTypeEnum {
    // 普通消息（文本消息、表情、文本表情混合）
    STANDARD("0" , "普通消息"),
    // 图片
    //      普通图片
    //      阅后即焚
    PHOTO("1" , "图片"),
    // 语音
    VOICE("2" , "语音"),
    // 好友相关
    FRIEND("3" , "好友"),
    // 游戏
    GAME_NOTIFI("4" , "游戏"),
    // 红包
    RED_PACKETS("5" , "红包"),
    // 聊天动作
    ACTION_CHAT("6" , "聊天动作") ,
    // 在线状态
    ONLINE_STATE_CHAT("7" , "状态"),
    // 系统通知
    SYS_NOTIFI("8" , "系统通知"),
    // 动态评论
    COMMENT_DYNAMIC("9" , "动态评论");

    // 编号
    private String code;
    // 名称
    private String name;

    private MqttMsgTypeEnum(String code , String name){
        this.code = code;
        this.name = name;
    }

    public static MqttMsgTypeEnum getItemByCode(String code){
        for(MqttMsgTypeEnum mqttMsgTypeEnum : MqttMsgTypeEnum.values()){
            if(mqttMsgTypeEnum.getCode().equals(code)){
                return mqttMsgTypeEnum;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
