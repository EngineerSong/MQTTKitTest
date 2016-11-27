package com.zhangkong.letsgo.im.core.domain.Enum;

/**
 * Created by w on 2016/3/17.
 */
public enum MqttFriendRelationTypeEnum {

//             0) 添加好友
    ADD("0" , "添加好友"),
//              1) 同意好友申请
    AGREE("1" , "同意添加好友"),
//              2) 拒绝好友申请
    REJECT("2" , "拒绝好友申请"),
//              3) 忽略好友申请
    IGNORE("3" , "忽略好友申请"),
//              4) 删除好友
    DELETE("4" , "删除好友");

    private String code;
    private String name;

    private MqttFriendRelationTypeEnum(String code ,String name){
        this.code = code;
        this.name = name;
    }

    public static MqttFriendRelationTypeEnum getItemByCode(String code){
        for(MqttFriendRelationTypeEnum mqttFriendRelationTypeEnum : MqttFriendRelationTypeEnum.values()){
            if(mqttFriendRelationTypeEnum.getCode().equals(code)){
                return mqttFriendRelationTypeEnum;
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
