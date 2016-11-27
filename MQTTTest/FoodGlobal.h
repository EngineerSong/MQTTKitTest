
#define GETWIDTH self.view.frame.size.width//self.view宽度
#define GETHEIGHT self.view.frame.size.height//self.view高度

#define IndexPage @"http://192.168.10.186:8081"//请求的服务器地址

#define kUIColorFromRGB(rgbValue) [UIColor \
colorWithRed:((float)((rgbValue & 0xFF0000) >> 16))/255.0 \
green:((float)((rgbValue & 0xFF00) >> 8))/255.0 \
blue:((float)(rgbValue & 0xFF))/255.0 alpha:1.0]


//=====================MqttMessageContent==========================

#define Mqtt_sender @"sender"//发送者
#define Mqtt_receiver @"receiver"//接收者
#define Mqtt_msgType @"msgType"//消息类型 {@link MqttMsgTypeEnum}
#define Mqtt_chatType @"chatType"//聊天类型(单聊、群聊等) {@link MqttChatTypeEnum}
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
#define Mqtt_msg @"msg"
// 消息发送时间
#define Mqtt_sendTime @"sendTime"

//===================MqttChatActionMsgTypeEnum======================

//          0) 连接
#define MqttChatActionMsgTypeEnum_JOIN @"0"
//          1) 断开
#define MqttChatActionMsgTypeEnum_DISCONNECTION @"1"
//          2) 正在输入
#define MqttChatActionMsgTypeEnum_WRITING @"2"
//          3) 正在发送
#define MqttChatActionMsgTypeEnum_SENDING @"3"
//          4) 已送达
#define MqttChatActionMsgTypeEnum_DELIVERED @"4"
//          5) 对方已读
#define MqttChatActionMsgTypeEnum_READ @"5"

//===================MqttChatTypeEnum==========================

// 单聊
#define MqttChatTypeEnum_CHAT @"0"
// 群聊
#define MqttChatTypeEnum_MULTI_CHAT @"1"
// 在线状态
#define MqttChatTypeEnum_STATE @"2"
// 系统通知
#define MqttChatTypeEnum_PUSH @"3"

//====================MqttFriendRelationTypeEnum==============

//             0) 添加好友
#define MqttFriendRelationTypeEnum_ADD @"0"
//              1) 同意好友申请
#define MqttFriendRelationTypeEnum_AGREE @"1"
//              2) 拒绝好友申请
#define MqttFriendRelationTypeEnum_REJECT @"2"
//              3) 忽略好友申请
#define MqttFriendRelationTypeEnum_IGNORE @"3"
//              4) 删除好友
#define MqttFriendRelationTypeEnum_DELETE @"4"

//=====================MqttGameMsgTypeEnum====================

//          a) 发起游戏
#define MqttGameMsgTypeEnum_INITIATOR @"0"
//          b) 加入游戏
#define MqttGameMsgTypeEnum_JOIN @"1"
//          c) 游戏消息
#define MqttGameMsgTypeEnum_MSG @"2"
//          d) 退出游戏
#define MqttGameMsgTypeEnum_EXIT @"3"

//=====================MqttMsgTypeEnum========================

// 普通消息（文本消息、表情、文本表情混合）
#define MqttMsgTypeEnum_STANDARD @"0"
// 图片
//      普通图片
//      阅后即焚
#define MqttMsgTypeEnum_PHOTO @"1"
// 语音
#define MqttMsgTypeEnum_VOICE @"2"
// 好友相关
#define MqttMsgTypeEnum_FRIEND @"3"
// 游戏
#define MqttMsgTypeEnum_GAME_NOTIFI @"4"
// 红包
#define MqttMsgTypeEnum_RED_PACKETS @"5"
// 聊天动作
#define MqttMsgTypeEnum_ACTION_CHAT @"6"
// 在线状态
#define MqttMsgTypeEnum_ONLINE_STATE_CHAT @"7"
// 系统通知
#define MqttMsgTypeEnum_SYS_NOTIFI @"8"
// 动态评论
#define MqttMsgTypeEnum_COMMENT_DYNAMIC @"9"

//=====================MqttPhotoMsgTypeEnum===================

//          a) 普通图片(无查看限制)
#define MqttPhotoMsgTypeEnum_STANDARD @"0"
//          b) 阅后即焚(仅可查看一次)
#define MqttPhotoMsgTypeEnum_ONCE @"1"

//=====================MqttRedPacketsMsgTypeEnum==============

//          0) 发(包)红包
#define MqttRedPacketsMsgTypeEnum_PACK @"0"
//          1) 领取红包
#define MqttRedPacketsMsgTypeEnum_GET @"1"

//=====================MqttStateMsgTypeEnum===================

//          0) 在线
#define MqttStateMsgTypeEnum_ONLINE @"0"
//          1) 隐身
#define MqttStateMsgTypeEnum_STEALTH @"1"
//          2) 忙碌
#define MqttStateMsgTypeEnum_BUSY @"2"

//=====================TopicConfig=============================

// 接收所有消息主题格式
#define RECEIVE_ALL_MSG_TOPIC_FORMAT @"%@/#"
// 发送消息主题格式
//      1. 普通消息（文本消息、表情、文本表情混合）
#define STANDARD_MSG_TOPIC_FORMAT @"%@/chat/standard"
//      2. 图片
//          a) 普通图片(无查看限制)
//          b) 阅后即焚(仅可查看一次)
#define PHOTO_MSG_TOPIC_FORMAT @"%@/chat/photo"
//      3. 语音
#define VOICE_MSG_TOPIC_FORMAT @"%@/chat/voice"
//      3. 游戏
//          a) 某个聊天的所有游戏通知
#define ALL_GAME_NOTIFI_MSG_TOPPIC_FORMAT @"%@/chat/game/#/notifi"
//          b) 某个聊天的某个游戏聊天消息
#define GAME_CHAT_MSG_TOPIC_FORMAT @"%@/chat/game/%@/chat"
//          b) 某个聊天的某个游戏通知
#define GAME_NOTIFI_MSG_TOPIC_FORMAT @"%@/chat/game/%@/notifi"
//      4. 红包
//          a) 发(包)红包
//          b) 领取红包
#define RED_PACKETS_MSG_TOPIC_FORMAT @"%@/chat/red_packets"
//      5. 聊天动作
//          a) 进出群
//          b) 正在输入、正在发送
#define ACTION_CHAT_MSG_TOPIC_FORMAT @"%@/chat/action"
//      6. 状态
//          a) 在线、隐身、忙碌
#define STATE_CHAT_NOTIFI_TOPIC_FORMAT @"%@/chat/state"
//      7. 好友管理
//          a) 好友申请
//          b) 好友申请的同意、拒绝、忽略等操作
//          c) 好友删除
#define FRIEND_MANAGER_CHAT_MSG_TOPIC_FORMAT @"%@/chat/friend"
// 系统通知
#define SYS_NOTIFI_TOPIC_FORMAT @"sys/notifi"
// 动态评论
#define COMMENT_DYNAMIC_TOPIC_FORMAT @"%@/dynamic/comment"



#define MQTT_HOST @"192.168.10.92"//MQTT服务器网址



/**
 *  首页店铺列表接口
 */
#define HomeUrl_ShopList @"http://192.168.10.186:8081/wxclouds/shopInfoManager/getShopForIndex.shtml"
/**
 *  首页轮播图接口
 */
#define HomeUrl_ShufflingFigure @"http://192.168.10.186:8081/wxclouds/advManager/getAdvInUse.shtml"






