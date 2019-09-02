# 客户管理程序

## 问题

* 给定一个基于 Spring Boot 的客户管理程序(Customer)，包含生成客户和查询所有客户的功能
* 任务
	* 增加集成测试
	    * 对Mapper->DB进行集成测试
	    * 对Service->Mapper->DB进行集成测试
	    * 对Controller->Service->Mapper->DB进行集成测试
	
* 思考：
    * 使用什么DB进行测试？
    * 怎样准备测试数据？
        * 使用Repository准备
        * 使用SQL准备
        * 使用DBUnit/DB-Rider准备
    * 怎样触发请求到Controller?

* 要求： 
    * 集成测试和单元测试可分别运行
    
		
		
## 作业 

* 在集成测试驱动下完成客户修改和查询所有客户的功能


## 学习目的：
* 掌握集成测试的概念和原理
* 掌握集成测试的方法


