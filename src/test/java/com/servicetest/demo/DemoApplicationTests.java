package com.servicetest.demo;

import com.servicetest.demo.service.HelloService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
@SpringBootTest
class DemoApplicationTests {

    @Resource
    HelloService helloService;

    @Test
    @DisplayName("测试sayhello方法")
    void contextLoads() {

        String hellostr = helloService.sayHello("老刘");

        assertThat(hellostr, equalTo("您好,老刘!"));
        assertThat(hellostr, hasLength(6));
        assertThat(hellostr, containsString("您好,"));

        /*
        int rest = helloService.addTwo(13,14);
        //Assert.assertEquals(27,rest);
        //Assert.assertEquals(17,rest);
        assertThat(rest, equalTo(27));
        //assertThat(17, equalTo(rest));
        //assertThat(rest,greaterThanOrEqualTo(28));

         */
    }

    @ParameterizedTest
    //@ValueSource(ints = {1, 2, 3})
    @CsvSource({"1,2,3", "11,12,23", "33,100,233"})
    @DisplayName("参数化测试")
    void paramTest(int first,int second,int sum) {
        //System.out.println("first参数:"+first+";second参数:"+second+";sum参数:"+sum);
        int rest = helloService.addTwo(first,second);
        assertThat(rest, equalTo(sum));
    }

}
