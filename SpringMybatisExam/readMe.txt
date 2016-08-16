运行步骤：
1.进入文件目录Exam1下
2.mvn clean package
3.运行指令：mvn exec:java -Dexec.mainClass="com.hand.App" -Dexec.args="arg0 arg1 arg2"



4.数据库配置文件  src/main/java/jdbc.properties
5.spring配置文件  src/main/java/applicationContext.xml 
6.mybatis配置文件 src/main/java/mybatisConfig.xml 
7.项目结构：src/main/java
						 /com.hand      主类，
						 /com.dao       service接口以及mapper.xml
						 /com.service   调用dao里面的service接口类
						 /com.entitys   实体类
						 /com.event     自定义事件相关类

8:debug日志输出有点多，会影响查看结果。。。。。。。