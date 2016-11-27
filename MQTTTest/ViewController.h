//
//  ViewController.h
//  MQTTTest
//
//  Created by barara on 16/3/23.
//  Copyright © 2016年 Jay. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <MQTTKit.h>
#import "FoodGlobal.h"
#import <Foundation/Foundation.h>

@interface ViewController : UIViewController

@property (nonatomic, copy) NSString *clientID;
@property (nonatomic, strong) MQTTClient *client;

@end

