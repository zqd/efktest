###这是一个为efk演示的例子
####efk
- 采用docker-compose file完成。
- fluentd使用http方式接收log
- 目标项目使用log4j2将日志吐给fluentd

####efkTest
- 测试的目标项目
- log4j2采用yml配置，因此增加了jackson的pom依赖

####问题回顾
- 由于目标机器不是docker，当然更主要的还是莫名原因导致安装td-agent十分困难。所以最终测试了该种方案。
- 如果使用td-agent抓取异常时是否只抓去了异常本身的堆栈信息。（我们通常希望看到谁出错了，错误是什么？）
- 目标地址的ip即add_remote_addr属性我认为所有的应用都会设置为true，但是其默认值为false
- 该方式抓取的异常日志在kibana上展示的不符合程序员的阅读习惯，估计需要写kbl查询语句来解决