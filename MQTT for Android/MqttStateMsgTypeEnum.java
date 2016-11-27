package com.zhangkong.letsgo.im.core.domain.Enum;

/**
 * Created by w on 2016/3/9.
 */
public enum  MqttStateMsgTypeEnum {
    //          0) 在线
    ONLINE("0" , "在线"),
    //          1) 隐身
    STEALTH("1" , "隐身"),
    //          2) 忙碌
    BUSY("2" , "忙碌");

    private String code;
    private String name;

    private MqttStateMsgTypeEnum(String code ,String name){
        this.code = code;
        this.name = name;
    }

    public static MqttStateMsgTypeEnum getItemByCode(String code){
        for(MqttStateMsgTypeEnum mqttStateMsgTypeEnum : MqttStateMsgTypeEnum.values()){
            if(mqttStateMsgTypeEnum.getCode().equals(code)){
                return mqttStateMsgTypeEnum;
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
