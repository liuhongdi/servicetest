package com.servicetest.demo;

import com.servicetest.demo.service.HelloService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@DisplayName("测试HelloService")
@SpringBootTest
class DemoApplicationTests {

    @Resource
    HelloService helloService;



    @BeforeAll
    static void initAll() {
        System.out.println("this is BeforeAll");
    }

    @AfterAll
    static void endAll() {
        System.out.println("this is AfterAll");
    }


    @BeforeEach
    public void initOne() {
        System.out.println("this is BeforeEach");
    }

    @AfterEach
    public void endOne() {
        System.out.println("this is AfterEach");
    }


    @Test
    @DisplayName("测试sayhello方法")
    void contextLoads() {
        String hellostr = helloService.sayHello("老刘");
        assertThat(hellostr, equalTo("您好,老刘!"));
        assertThat(hellostr, hasLength(6));
        assertThat(hellostr, containsString("您好,"));
    }

    @ParameterizedTest
    @CsvSource({"1,2,3", "11,12,23", "33,100,133"})
    @DisplayName("参数化测试")
    void paramTest(int first,int second,int sum) {
        int rest = helloService.addTwo(first,second);
        assertThat(rest, equalTo(sum));
    }

}
