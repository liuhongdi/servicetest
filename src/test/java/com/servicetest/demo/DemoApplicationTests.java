package com.servicetest.demo;

import com.servicetest.demo.service.HelloService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@SpringBootTest
class DemoApplicationTests {



    @Test
    void contextLoads() {
    }

}
