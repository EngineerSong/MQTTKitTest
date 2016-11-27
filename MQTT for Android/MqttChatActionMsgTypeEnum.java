package com.zhangkong.letsgo.im.core.domain.Enum;

/**
 * Created by w on 2016/3/9.
 */
public enum MqttChatActionMsgTypeEnum {
    //          0) 连接
    JOIN("0" , "连接"),
    //          1) 断开
    DISCONNECTION("1" , "断开"),
    //          2) 正在输入
    WRITING("2" , "正在输入"),
    //          3) 正在发送
    SENDING("3" , "正在发送"),
    //          4) 已送达
    DELIVERED("4" ,"已送达"),
    //          5) 对方已读
    READ("5" , "已读");

    private String code;
    private String name;

    private MqttChatActionMsgTypeEnum(String code , String name){
        this.code = code;
        this.name = name;
    }

    public static MqttChatActionMsgTypeEnum getItemByCode(String code){
        for(MqttChatActionMsgTypeEnum mqttChatActionMsgTypeEnum : MqttChatActionMsgTypeEnum.values()){
            if(mqttChatActionMsgTypeEnum.getCode().equals(code)){
                return mqttChatActionMsgTypeEnum;
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
