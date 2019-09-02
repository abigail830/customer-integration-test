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

-------------------------------

## Tips 提示

### 集成测试与单元测试分离

* 创建IntegrationTestBase, 标注Category,并可以集中放置集成测试所需Annotation
* 所有集成测试以*IT结尾命名，继承于创建IntegrationTestBase
* pom.xml配置：
    * 通过 build-helper-maven-plugin 将 integrationtest 中的测试源码和资源加入Maven
    * 通过 maven-surefire-plugin 配置是否可忽略单元测试（默认不忽略）
    * 通过 maven-failsafe-plugin 配置集成测试
* 运行集成测试
    * 运行单元测试和集成测试：``` mvn verify ```
    * 只运行集成测试：```mvn verify -DskipUnitTest=true ```
		
		
```
            <properties>
                    <java.version>1.8</java.version>
                    <skipUnitTest>false</skipUnitTest>
            </properties>
            
            <!-- other dependencies-->    
            
            <plugin>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.20.1</version>
                <configuration>
                    <skipTests>${skipUnitTest}</skipTests>
                </configuration>
            </plugin>

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-failsafe-plugin</artifactId>
                <version>3.0.0-M3</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>integration-test</goal>
                            <goal>verify</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
```
