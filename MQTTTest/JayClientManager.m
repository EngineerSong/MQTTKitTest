//
//  JayClientManager.m
//  MQTTTest
//
//  Created by barara on 16/3/24.
//  Copyright © 2016年 Jay. All rights reserved.
//

#import "JayClientManager.h"

static JayClientManager *instance = nil;

@implementation JayClientManager

+ (instancetype)sharedClient
{
    //单例
    static dispatch_once_t onceToken;
    dispatch_once(&onceToken, ^{
        
        instance = [[self alloc] init];
        
    });
    return instance;
}

- (instancetype)init
{
    if (self = [super init]) {
        
        //把deviceId作为mqtt的clientId   port为端口号  username是用户名 password是密码
        NSString *deviceId = [[[UIDevice currentDevice]identifierForVendor]UUIDString];
        NSString *clientId = [NSString stringWithFormat:@"user-%@", deviceId];
        self.client = [[MQTTClient alloc] initWithClientId:clientId];
        self.client.port = 1883;
        //self.client.username = @"kidcares";
        //self.client.password = @"12345";
    }
    return self;
}

- (void)mgrConnectMqttHost
{
    [self.client connectToHost:MQTT_HOST completionHandler:^(NSUInteger code) {
        if (code == ConnectionAccepted) {
            NSLog(@"连接Host成功");
            
            
            
            
            
        } else {
            
        }
    }];
}

- (void)mgrReceiveMessage
{
    //接收消息
    [self.client setMessageHandler:^(MQTTMessage *message) {
        NSString *text = message.payloadString;
        NSString *topic = message.topic;
        NSLog(@"received message is %@,\ntopic = %@", text,topic);
        
        id json = [NSJSONSerialization JSONObjectWithData:message.payload options:NSJSONReadingMutableContainers error:nil];
        NSDictionary *dict = (NSDictionary *)json;
        NSLog(@"received dic = %@",dict);
        
        if ([dict[Mqtt_chatType] isEqual:MqttChatTypeEnum_CHAT]) {
            //收到的是单聊的消息
            if ([JayClientManager sharedClient].oneBlock) {
                [JayClientManager sharedClient].oneBlock(message.payloadString);
            }
        }
        
        if ([dict[Mqtt_chatType] isEqual:MqttChatTypeEnum_MULTI_CHAT]) {
            //收到的是群聊的消息
            if ([JayClientManager sharedClient].groupBlock) {
                [JayClientManager sharedClient].groupBlock(message.payloadString);
            }
        }
    }];
}

@end
