package com.qf.j2003.config;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.region.Region;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description 文件上传配置
 *
 * @author sunQuanxi
 * @date 2020/10/16 20:08
 */
@Configuration
public class UploadConfig {
    @Bean
    public COSClient cosClient() {
        // 1 初始化用户身份信息（secretId, secretKey）。
        String secretId = "AKIDDGo68leWVDesXvuMfSyRmqLq4ANQaUCh";
        String secretKey = "MNDVcGPO7bopCKMFtIPG6rMZfYBWaSIt";
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
// 2 设置 bucket 的区域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
// clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region("ap-chengdu");
        ClientConfig clientConfig = new ClientConfig(region);
// 3 生成 cos 客户端。
        return new COSClient(cred, clientConfig);
    }
}
