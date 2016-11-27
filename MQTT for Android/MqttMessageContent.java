package com.zhangkong.letsgo.im.core.domain.entity;

/**
 * Created by w on 2016/3/9.
 */
public class MqttMessageContent {
    // 发送者
    private String sender;
    // 接收者=
    private String receiver;
    /**
     * 消息类型 {@link com.zhangkong.letsgo.im.core.domain.Enum.MqttMsgTypeEnum}
     **/
    private String msgType;

    /**
     * 聊天类型(单聊、群聊等) {@link com.zhangkong.letsgo.im.core.domain.Enum.MqttChatTypeEnum}
     */
    private String chatType;
     /**
      * 消息内容
      *   1. 普通消息["消息内容"]
      *    2. 图片
      *        0) 普通图片
      *        1) 阅后
      *        ["类型{@link com.zhangkong.letsgo.im.core.domain.Enum.MqttPhotoMsgTypeEnum}","图片地址"]
      *    3. 语音
      *        ["时长","语音文件地址"]
      *    4. 好友相关
      *         0) 添加好友
      *         1) 同意好友申请
      *         2) 拒绝好友申请
      *         3) 忽略好友申请
      *         4) 删除好友
      *        ["类型{@link com.zhangkong.letsgo.im.core.domain.Enum.MqttFriendRelationTypeEnum}"]
      *    5. 游戏通知
      *        0) 发起游戏
      *        1) 加入游戏
      *        2) 游戏消息
      *        3) 退出游戏
      *        ["类型{@link com.zhangkong.letsgo.im.core.domain.Enum.MqttGameMsgTypeEnum}","游戏名称ID","游戏唯一标识, 即谁创建的哪个游戏"]
      *    6. 红包
      *        0) 发(包)红包
      *        1) 领取红包
      *        ["类型{@link com.zhangkong.letsgo.im.core.domain.Enum.MqttRedPacketsMsgTypeEnum}" , "红包唯一标识，即谁发的哪个红包"]
      *    7. 聊天动作
      *        0) 连接
      *        1) 断开
      *        2) 正在输入
      *        3) 正在发送
      *        4) 消息已收
      *        5) 对方已读
      *        ["类型{@link com.zhangkong.letsgo.im.core.domain.Enum.MqttChatActionMsgTypeEnum}"]
      *    8. 状态
      *        0) 在线
      *        1) 隐身
      *        2) 忙碌
      *        ["类型{@link com.zhangkong.letsgo.im.core.domain.Enum.MqttStateMsgTypeEnum}"]
      *    9. 系统通知
      *        ["系统通知内容"]
      *    10. 动态评论
      *        ["评论内容"]
      **/
    private String[] msg;
    // 消息发送时间
    private String sendTime;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getChatType() {
        return chatType;
    }

    public void setChatType(String chatType) {
        this.chatType = chatType;
    }

    public String[] getMsg() {
        return msg;
    }

    public void setMsg(String[] msg) {
        this.msg = msg;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }
}
