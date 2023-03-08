# EAD

## 项目设计

- 用户管理
  
  - post请求
    
  - 用户注册
  
  - 昵称
  
  - 头像
  
  - 密码
  
  - 邮箱、oppenid
  
  - 用户登录
  
     - post请求
  
     - username/openid
  
     - password
  
     - 返回数据
  
       - 数据库中传递的数据
  
       ~~~js
       wx.request({
         url: 'http://127.0.0.1:8080/api/name', //仅为示例，并非真实的接口地址
         data: {
           username: '123456',
           password: '1234567'
         },
         header: {
           'content-type': 'application/json' // 默认值
         },
         success (res) {
          	res.data.code==0
             res.data.data
             res.data.message=""
             if(res.data.code!=0){
                 showToast({
                     meg:res.data.msg
                 })
             }else{
                 this.setdata({
                     
                 })
             }
         },
           fail:res=>{
               
           }
       })
       ~~~
  
       
  
  - 用户退出登录
  
     - 用户id
  
  - 用户修改信息
  
     - post
     - id（必须传）
     - 待修改项
  
  - 用户注销账户
  
     - delete请求
        - id
  
  - 用户积分管理
  
- 支付TODO

- 知识闯关
  - 题目的管理
  - 请求方式post
  - 请求参数

  ~~~java
    /**
       * 类型
       */
      private Integer type;
  
      /**
       * 答案
       */
      private String answer;
  
      /**
       * 解析
       */
      private String analysis;
  
      /**
       * 所属关卡
       */
      private Integer belonglevel;
  ~~~

  - 用户闯关进度管理
    - 答题情况增删改查
    - 答题加积分

- 濒危动物信息管理
  - 增删改查
  	
   - 不同类别
  
  	- 有关濒危动物的新闻管理

- 关键词资料查询

- 商品兑换的

## 数据库表

- 用户表
  - id
  - 昵称
  - 头像
  - 邮箱
  - 密码
  - 积分
  - 创建时间
  - 更新时间
  - 是否删除
- 题库表
  - id
  - 类型
    - 1- 单选 2- 填空 - 2- 多选
  - 答案
  - 解析
  - 所属关卡 int
  - 创建时间
  - 更新时间
  - 是否删除
- 用户-题库表
  - 用户id 
  - 题目id
  - 状态 0 - 错误 1- 正确
  - 创建时间
  - 更新时间
  - 是否删除
- 动物
  - id
  - 名称
  - 分类id
  - 简介
  - 图片
  - 濒危等级
  - 形态描述
  - 生活习性
  - 生活地理环境
  - 分布范围
  - 各界报道
  - 创建时间
  - 更新时间
  - 是否删除
- 新闻
  - id
  - 名称
  - 内容
  - 发布时间
  - 封面图片
  - 新闻内容
  - 创建时间
  - 更新时间
  - 是否删除
- 文献
  - id
  - 标题
  - 动物id
  - url
  - 发布时间
  - 作者
  - 期刊
  - 创建时间
  - 更新时间
  - 是否删除
- 支付记录表
  - id
  - 用户id
  - 支付编号
  - 支付金额
  - 时间
  - 创建时间
  - 更新时间
  - 是否删除
- 兑换表
  - id
  - 名称
  - 所需积分
  - 图片
- 兑换-用户表
  - id
  - 用户id
  - 商品id
  - 地址
  - 邮寄状态 status 0——未邮寄 1——邮寄4

### 数据库字段设计

~~~sql
用户表
user
(
    id         bigint primary key auto_increment comment '用户ID',
    nickName   varchar(255) comment '昵称',
    avatar     varchar(1024) comment '头像',
    email      varchar(255) comment '邮箱',
    password   varchar(255) comment '密码',
    integral   int comment '积分',
    createTime timestamp default CURRENT_TIMESTAMP comment '创建时间',
    updateTime timestamp default CURRENT_TIMESTAMP comment '更新时间',
    isDelete   int       default 0 comment '是否删除'
);
题库

`topicbank`
(
    `id`          bigint       NOT NULL AUTO_INCREMENT COMMENT 'id',
    `type`        int(1)       NOT NULL COMMENT '类型',
    `answer`      varchar(255) NOT NULL COMMENT '答案',
    `analysis`    text COMMENT '解析',
    `belongLevel` int(10)      NOT NULL COMMENT '所属关卡',
    createTime    timestamp default CURRENT_TIMESTAMP comment '创建时间',
    updateTime    timestamp default CURRENT_TIMESTAMP comment '更新时间',
    isDelete      int       default 0 comment '是否删除',
    PRIMARY KEY (`id`)
)


用户题库表
`userTopicbank`
(
    `id`         bigint     NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `userId`     bigint     NOT NULL COMMENT '用户ID',
    `questionId` bigint     NOT NULL COMMENT '题目ID',
    `status`     tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态：0-错误 1-正确',
    createTime   timestamp           default CURRENT_TIMESTAMP comment '创建时间',
    updateTime   timestamp           default CURRENT_TIMESTAMP comment '更新时间',
    isDelete     int                 default 0 comment '是否删除',
    PRIMARY KEY (`id`)
) 


动物
`animal`
(
    `id`                      bigint        NOT NULL COMMENT '动物编号',
    `name`                    varchar(50)   NOT NULL COMMENT '动物名称',
    `categoryId`              bigint        NOT NULL COMMENT '分类编号',
    `introduction`            varchar(1024) NOT NULL COMMENT '动物简介',
    `picture`                 varchar(1024) NOT NULL COMMENT '图片',
    `endangeredLevel`         varchar(255)  NOT NULL COMMENT '濒危等级',
    `morphologyDescription`   varchar(1024) NOT NULL COMMENT '形态描述',
    `habit`                   varchar(1024) NOT NULL COMMENT '生活习性',
    `geographicalEnvironment` varchar(255)  NOT NULL COMMENT '生活地理环境',
    `distributionRange`       varchar(1024) NOT NULL COMMENT '分布范围',
    `report`                  varchar(1024) NOT NULL COMMENT '各界报道',
    createTime                timestamp default CURRENT_TIMESTAMP comment '创建时间',
    updateTime                timestamp default CURRENT_TIMESTAMP comment '更新时间',
    isDelete                  int       default 0 comment '是否删除'
) 

新闻
`news`
(
    `id`          bigint not null comment '新闻编号',
    `name`        varchar(255) comment '新闻名称',
    `content`     text comment '新闻url',
    `releaseTime` datetime comment '发布时间',
    `coverImg`    varchar(1024) comment '封面图片',
    `newsContent` text comment '所属单位',
    primary key (`id`),
    createTime    timestamp default CURRENT_TIMESTAMP comment '创建时间',
    updateTime    timestamp default CURRENT_TIMESTAMP comment '更新时间',
    isDelete      int       default 0 comment '是否删除'
) 


文献
`document`
(
    `id`          bigint NOT NULL AUTO_INCREMENT COMMENT '文献id',
    `title`       varchar(255)  DEFAULT NULL COMMENT '标题',
    `animalId`    bigint        DEFAULT NULL COMMENT '动物id',
    `url`         varchar(1024) DEFAULT NULL COMMENT '文献url',
    `publishTime` datetime      DEFAULT NULL COMMENT '发布时间',
    `author`      varchar(255)  DEFAULT NULL COMMENT '作者',
    `periodical`  varchar(255)  DEFAULT NULL COMMENT '期刊',
    createTime    timestamp     default CURRENT_TIMESTAMP comment '创建时间',
    updateTime    timestamp     default CURRENT_TIMESTAMP comment '更新时间',
    isDelete      int           default 0 comment '是否删除',
    PRIMARY KEY (`id`)
) 

支付记录
`payRecord`
(
    `id`        bigint      NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `userId`    bigint      NOT NULL COMMENT '用户id',
    `payNum`    varchar(50) NOT NULL COMMENT '支付编号',
    `payAmount` numeric     NOT NULL COMMENT '支付金额',
    createTime  timestamp default CURRENT_TIMESTAMP comment '创建时间',
    updateTime  timestamp default CURRENT_TIMESTAMP comment '更新时间',
    isDelete    int       default 0 comment '是否删除',
    PRIMARY KEY (`id`)
)



兑换商品
`exchange`
(
    `id`            bigint        NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name`          varchar(255)  NOT NULL COMMENT '名称',
    `requiredScore` int(11)       NOT NULL COMMENT '所需积分',
    `picture`       varchar(1024) NOT NULL COMMENT '图片',
    createTime      timestamp default CURRENT_TIMESTAMP comment '创建时间',
    updateTime      timestamp default CURRENT_TIMESTAMP comment '更新时间',
    isDelete        int       default 0 comment '是否删除',
    PRIMARY KEY (`id`)
) 


用户-兑换表
`userExchange`
(
    `id`       bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `userId`   bigint unsigned NOT NULL COMMENT '用户id',
    `goodsId`  bigint unsigned NOT NULL COMMENT '商品id',
    `address`  varchar(255)    NOT NULL COMMENT '地址',
    phone      varchar(20)     not null comment '电话',
    `status`   tinyint(4)      NOT NULL DEFAULT '0' COMMENT '邮寄状态 0——未邮寄 1——邮寄',
    createTime timestamp                default CURRENT_TIMESTAMP comment '创建时间',
    updateTime timestamp                default CURRENT_TIMESTAMP comment '更新时间',
    isDelete   int                      default 0 comment '是否删除',
    PRIMARY KEY (`id`)
) 
~~~



## 测试

- 用户功能测试完成
- 动物功能测试完成
- 后续将服务器的ip地址添加到yml文件中

