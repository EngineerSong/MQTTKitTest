package com.zhangkong.letsgo.im.core.domain.Enum;

/**
 * Created by w on 2016/3/9.
 */
public enum MqttRedPacketsMsgTypeEnum {
    //          0) 发(包)红包
    PACK("0" , "包红包"),
    //          1) 领取红包
    GET("1" , "获取红包");

    private String code;
    private String name;

    private MqttRedPacketsMsgTypeEnum(String code , String name){
        this.code = code;
        this.name = name;
    }

    public static MqttRedPacketsMsgTypeEnum getItemByCode(String code){
        for(MqttRedPacketsMsgTypeEnum mqttRedPacketsMsgTypeEnum : MqttRedPacketsMsgTypeEnum.values()){
            if(mqttRedPacketsMsgTypeEnum.getCode().equals(code)){
                return mqttRedPacketsMsgTypeEnum;
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
