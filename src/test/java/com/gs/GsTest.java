package com.gs;

import com.gs.service.intf.DemoUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GsTest {

    private DemoUserService demoUserService;

    @Test
    public void test() {
        System.out.println("test start");
    }
}
