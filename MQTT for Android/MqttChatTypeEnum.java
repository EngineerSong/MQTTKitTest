package com.zhangkong.letsgo.im.core.domain.Enum;

/**
 * Created by w on 2016/3/17.
 */
public enum MqttChatTypeEnum {
    // 单聊
    CHAT("0" , "单聊"),
    // 群聊
    MULTI_CHAT("1" , "群聊"),
    // 在线状态
    STATE("2" , "状态"),
    // 系统通知
    PUSH("3" , "推送");

    private String code;
    private String name;

    private MqttChatTypeEnum(String code , String name){
        this.code = code;
        this.name = name;
    }

    public static MqttChatTypeEnum  getItemByCode(String code){
        for(MqttChatTypeEnum mqttChatTypeEnum : MqttChatTypeEnum.values()){
            if(mqttChatTypeEnum.getCode().equals(code)){
                return mqttChatTypeEnum;
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
