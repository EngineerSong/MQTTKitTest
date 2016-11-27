package com.zhangkong.letsgo.im.core.domain.Enum;

/**
 * Created by w on 2016/3/9.
 */
public enum  MqttPhotoMsgTypeEnum {
    //          a) 普通图片(无查看限制)
    STANDARD("0" , "普通图片") ,
    //          b) 阅后即焚(仅可查看一次)
    ONCE("1" , "阅后即焚");

    private String code;
    private String name;

    private MqttPhotoMsgTypeEnum(String code , String name){
        this.code = code;
        this.name = name;
    }

    public static MqttPhotoMsgTypeEnum getItemByCode(String code){
        for(MqttPhotoMsgTypeEnum mqttPhotoMsgTypeEnum : MqttPhotoMsgTypeEnum.values()){
            if(mqttPhotoMsgTypeEnum.getCode().equals(code)){
                return mqttPhotoMsgTypeEnum;
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
