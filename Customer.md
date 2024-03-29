## Tips 提示

### 创建程序

* 使用 Spring Boot Starter 创建项目
    * https://start.spring.io 
    * Starter：Web、JPA、JDBC、H2）
* 在pom.xml中增加设置
    * Junit4 或 Junit5 (exclude Junit4 from spring boot test first)
    * assertJ（Optional)
    * swagger2/swagger-ui
* 编辑 application.properties(见程序)
* Enable Swagger UI
	     
		```
		@EnableSwagger2
		@SpringBootApplication
		public class CustomerApplication {
			public static void main(String[] args) {
				SpringApplication.run(CustomerApplication.class, args);
			}	
		}
		```
* 编写程序
* 运行
    * 方法1:
	  ```
        mvn spring-boot:run
      ```
   
    * 方法2：
        ```
        mvn clean package
        java -jar target/gs-rest-service-0.1.0.jar
        ```

    * 方法3： run CustomerApplication in IDE
    * h2 console: http://localhost:8080/h2 
    * JDBC URL : jdbc:h2:./h2-dev
    * api doc: http://localhost:8080/swagger-ui.html

### 使用什么DB？
* 如使用H2 
```
spring.datasource.url: jdbc:h2:mem:IntegrationTest;DB_CLOSE_DELAY=-1;MODE=MYSQL
```

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
		
	

