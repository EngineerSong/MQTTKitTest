//
//  ViewController.m
//  MQTTTest
//
//  Created by barara on 16/3/23.
//  Copyright © 2016年 Jay. All rights reserved.
//

#import "ViewController.h"
#import "JayClientManager.h"

@interface ViewController () <UITextViewDelegate>

{
    NSString *_topStr;
    NSMutableDictionary *_dic;
    UITextField *_tf;
    UITextView *_textView;
}

@end

@implementation ViewController

- (NSMutableString *)getStr:(NSMutableString *)Str
{
    [Str appendFormat:@"qqqqqqqqqq"];
    NSMutableString *muStr = Str;
    return muStr;
}

- (void)viewDidLoad {
    [super viewDidLoad];
    
    _tf = [[UITextField alloc] initWithFrame:CGRectMake(20, 40, 200, 40)];
    _tf.placeholder = @"消息内容";
    [self.view addSubview:_tf];
    
    UIButton *btn = [UIButton buttonWithType:UIButtonTypeSystem];
    btn.frame = CGRectMake(80, 80, 60, 40);
    [btn setTitle:@"发送" forState:UIControlStateNormal];
    [btn addTarget:self action:@selector(btnClick) forControlEvents:UIControlEventTouchUpInside];
    [self.view addSubview:btn];
    
    _textView = [[UITextView alloc] initWithFrame:CGRectMake(0, 120, self.view.frame.size.width, 200)];
    _textView.font = [UIFont fontWithName:@"Arial" size:18.0];
    _textView.backgroundColor = [UIColor blackColor];
    _textView.textColor = [UIColor whiteColor];
    _textView.contentInset = UIEdgeInsetsMake(0, 0, 0, 0);
    _textView.scrollEnabled = YES;
    //_textView.selectable = YES;//选择复制功能
    _textView.autoresizingMask = UIViewAutoresizingFlexibleHeight;//自适应高度
    _textView.delegate = self;
    _textView.editable = NO;//禁止编辑
    [self.view addSubview:_textView];
    
    UInt64 recordTime = [[NSDate date] timeIntervalSince1970]*1000;
    NSString *timeString = [NSString stringWithFormat:@"%llu",recordTime];
    NSLog(@"timeR = %@",timeString);
    
    NSArray *arr = @[@"wuli黄黄啊哈哈"];
    
    _dic = [[NSMutableDictionary alloc] init];
    [_dic setObject:@"666" forKey:Mqtt_sender];
    [_dic setObject:@"5" forKey:Mqtt_receiver];
    [_dic setObject:MqttMsgTypeEnum_STANDARD forKey:Mqtt_msgType];
    [_dic setObject:MqttChatTypeEnum_MULTI_CHAT forKey:Mqtt_chatType];
    [_dic setObject:arr forKey:Mqtt_msg];
    [_dic setObject:timeString forKey:Mqtt_sendTime];
    
    [JayClientManager sharedClient].oneBlock = ^(NSString* oneChatString){
        NSLog(@"单聊页收到消息 = %@",oneChatString);
    };
    
    [JayClientManager sharedClient].groupBlock = ^(NSString* groupChatString){
        NSLog(@"群聊页收到消息 = %@",groupChatString);
        
        dispatch_sync(dispatch_get_main_queue(), ^(){
            // 这里的代码会在主线程执行
            _textView.text = [NSString stringWithFormat:@"%@",groupChatString];
        });
    };
    
    [[JayClientManager sharedClient].client connectToHost:MQTT_HOST completionHandler:^(MQTTConnectionReturnCode code) {
        if (code == ConnectionAccepted) {
            NSLog(@"连接Host成功,ID = %@",[JayClientManager sharedClient].client.clientID);
            
            [[JayClientManager sharedClient] mgrReceiveMessage];
            
            [[JayClientManager sharedClient].client subscribe:@"shop-5/#"
             withCompletionHandler:nil];
            
            [self mqtt_sendGroupMessageWith:_dic andShopID:@"5"];
            
            
        } else {
            
        }
    }];
    
    
    
}

- (void)btnClick
{
    NSArray *arr = @[_tf.text];
    [_dic setObject:arr forKey:Mqtt_msg];
    [self mqtt_sendGroupMessageWith:_dic andShopID:@"5"];
}

//发送单人消息
- (void)mqtt_sendOneMessageWith:(NSMutableDictionary *)sendDictionary
{
    NSString *shopStr = [NSString stringWithFormat:@"user-1"];
    switch ([sendDictionary[Mqtt_msgType] intValue]) {
        case 0:// 普通消息（文本消息、表情、文本表情混合）
            _topStr = [NSString stringWithFormat:STANDARD_MSG_TOPIC_FORMAT,shopStr];
            break;
        case 1:// 图片
            _topStr = [NSString stringWithFormat:PHOTO_MSG_TOPIC_FORMAT,shopStr];
            break;
        case 2:// 语音
            _topStr = [NSString stringWithFormat:VOICE_MSG_TOPIC_FORMAT,shopStr];
            break;
        case 3:// 好友相关
            _topStr = [NSString stringWithFormat:FRIEND_MANAGER_CHAT_MSG_TOPIC_FORMAT,shopStr];
            break;
        case 4:// 游戏
            _topStr = [NSString stringWithFormat:STANDARD_MSG_TOPIC_FORMAT,shopStr];
            break;
        case 5:// 红包
            _topStr = [NSString stringWithFormat:RED_PACKETS_MSG_TOPIC_FORMAT,shopStr];
            break;
        case 6:// 聊天动作
            _topStr = [NSString stringWithFormat:ACTION_CHAT_MSG_TOPIC_FORMAT,shopStr];
            break;
        case 7:// 在线状态
            _topStr = [NSString stringWithFormat:STATE_CHAT_NOTIFI_TOPIC_FORMAT,shopStr];
            break;
        case 8:// 系统通知
            _topStr = [NSString stringWithFormat:SYS_NOTIFI_TOPIC_FORMAT];
            break;
        case 9:// 动态评论
            _topStr = [NSString stringWithFormat:COMMENT_DYNAMIC_TOPIC_FORMAT,shopStr];
            break;

        default:
            break;
    }
    
    
    
    NSString *sendAllString = [NSString stringWithFormat:@"%@",sendDictionary];
    [[JayClientManager sharedClient].client publishString:sendAllString
                                                  toTopic:_topStr
                                                  withQos:AtLeastOnce
                                                   retain:NO
                                        completionHandler:^(int mid) {
        
        NSLog(@"单人消息发送成功,dic = %@",sendDictionary);
        
        
    }];
}

//发送群聊消息
- (void)mqtt_sendGroupMessageWith:(NSMutableDictionary *)sendDictionary andShopID:(NSString *)shopID
{
    NSString *shopStr = [NSString stringWithFormat:@"shop-%@",shopID];
    switch ([sendDictionary[Mqtt_msgType] intValue]) {
        case 0:// 普通消息（文本消息、表情、文本表情混合）
            _topStr = [NSString stringWithFormat:STANDARD_MSG_TOPIC_FORMAT,shopStr];
            break;
        case 1:// 图片
            _topStr = [NSString stringWithFormat:PHOTO_MSG_TOPIC_FORMAT,shopStr];
            break;
        case 2:// 语音
            _topStr = [NSString stringWithFormat:VOICE_MSG_TOPIC_FORMAT,shopStr];
            break;
        case 3:// 好友相关
            _topStr = [NSString stringWithFormat:FRIEND_MANAGER_CHAT_MSG_TOPIC_FORMAT,shopStr];
            break;
        case 4:// 游戏
            _topStr = [NSString stringWithFormat:STANDARD_MSG_TOPIC_FORMAT,shopStr];
            break;
        case 5:// 红包
            _topStr = [NSString stringWithFormat:RED_PACKETS_MSG_TOPIC_FORMAT,shopStr];
            break;
        case 6:// 聊天动作
            _topStr = [NSString stringWithFormat:ACTION_CHAT_MSG_TOPIC_FORMAT,shopStr];
            break;
        case 7:// 在线状态
            _topStr = [NSString stringWithFormat:STATE_CHAT_NOTIFI_TOPIC_FORMAT,shopStr];
            break;
        case 8:// 系统通知
            _topStr = [NSString stringWithFormat:SYS_NOTIFI_TOPIC_FORMAT];
            break;
        case 9:// 动态评论
            _topStr = [NSString stringWithFormat:COMMENT_DYNAMIC_TOPIC_FORMAT,shopStr];
            break;
            
        default:
            break;
    }
    //NSLog(@"topic = %@",_topStr);
    
    NSData *jsonData = [NSJSONSerialization dataWithJSONObject:sendDictionary options:0 error:nil];
    //NSLog(@"json = %@",[[NSString alloc] initWithData:jsonData encoding:NSUTF8StringEncoding]);
    [[JayClientManager sharedClient].client publishString:[[NSString alloc] initWithData:jsonData encoding:NSUTF8StringEncoding]
                                                  toTopic:_topStr
                                                  withQos:AtMostOnce
                                                   retain:NO
                                        completionHandler:^(int mid) {
        NSLog(@"群聊消息发送成功,dic = %@",sendDictionary);
        
        
        
    }];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
}

@end
