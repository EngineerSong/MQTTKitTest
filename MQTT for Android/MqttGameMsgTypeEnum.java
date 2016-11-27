package com.zhangkong.letsgo.im.core.domain.Enum;

/**
 * Created by w on 2016/3/9.
 */
public enum MqttGameMsgTypeEnum {
    //          a) 发起游戏
    INITIATOR("0" , "发起游戏"),
    //          b) 加入游戏
    JOIN("1" , "加入游戏"),
    //          c) 游戏消息
    MSG("2" , "游戏消息"),
    //          d) 退出游戏
    EXIT("3" , "退出游戏");

    private String code;
    private String name;

    private MqttGameMsgTypeEnum(String code , String name){
        this.code = code;
        this.name = name;
    }

    public static MqttGameMsgTypeEnum getItemByCode(String code){
        for(MqttGameMsgTypeEnum mqttGameMsgTypeEnum : MqttGameMsgTypeEnum.values()){
            if(mqttGameMsgTypeEnum.getCode().equals(code)){
                return mqttGameMsgTypeEnum;
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
