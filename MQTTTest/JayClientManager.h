//
//  JayClientManager.h
//  MQTTTest
//
//  Created by barara on 16/3/24.
//  Copyright © 2016年 Jay. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import <MQTTKit.h>
#import "FoodGlobal.h"

typedef void(^OneBlock)(NSString* oneChatString);
typedef void(^GroupBlock)(NSString* groupChatString);

@interface JayClientManager : NSObject

@property (nonatomic, copy) OneBlock oneBlock;
@property (nonatomic, copy) GroupBlock groupBlock;

@property (nonatomic, strong) MQTTClient *client;


+ (instancetype)sharedClient;
- (void)mgrConnectMqttHost;
- (void)mgrReceiveMessage;


@end
