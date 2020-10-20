package com.qf.j2003;

import com.qf.j2003.utils.EncryptUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoginEurekaClientApplicationTests {

    @Test
    void contextLoads() {
    }
//加密解密测试
    public static void main(String[] args) {
        String sencode = EncryptUtil.AESencode("0000", "admin");
        System.out.println(sencode);
        String aesDecode = EncryptUtil.AESDecode("13456", "44480f8a1a50e33e1d14455e699cc9bf");
        System.out.println(aesDecode);
    }
}
