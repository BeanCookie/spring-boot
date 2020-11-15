#### 自定义配置

这里模拟调用有道翻译的api过程，需要用到三个配置项appKey、appSecret和api地址，首先在properties文件中进行配置

```shell
cat > src/main/resources/application.properties <<EOF
appKey=xxxxxxa777xxxxxx
appSecret=xxxxxx0gFDWLyDublBeTGIVVjcxxxxxx
youdaoUrl=https://openapi.youdao.com/api
EOF
```

可以通过`@Value`注解在Bean中直接获取到配置中定义的属性值

```shell
mkdir src/main/java/com/zeaho/spring/springbootdemo/service/impl

cat > src/main/java/com/zeaho/spring/springbootdemo/service/TranslateService.java <<EOF
package com.zeaho.spring.springbootdemo.service;

/**
 * @author LuZhong
 */
public interface TranslateService {
    /**
     * 讲给定的汉字翻译成英文
     * @param text
     * @return
     */
    String translate(String text);
}
EOF

cat > src/main/java/com/zeaho/spring/springbootdemo/service/impl/TranslateServiceImpl.java <<EOF
package com.zeaho.spring.springbootdemo.service.impl;

import com.zeaho.spring.springbootdemo.service.TranslateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author LuZhong
 */
@Service
public class TranslateServiceImpl implements TranslateService {
    private final Logger logger = LoggerFactory.getLogger(TranslateServiceImpl.class);
    @Value("${appKey}")
    private String appKey;

    @Value("${appSecret}")
    private String appSecret;

    @Value("${youdaoUrl}")
    private String youdaoUrl;
    @Override
    public String translate(String text) {
        logger.info("{} {} {}", appKey, appSecret, youdaoUrl);
        return String.format("translate: %s", text);
    }
}
EOF
```

`@Value`目前用起来很方便但是实际的大型项目往往会有成百上千的配置需要被定义，如果没有进行有效的分类会对后续维护带来极大的负担，这时就需要使用ConfigurationProperties对配置进行封装。

```shell
cat > src/main/resources/application.properties <<EOF
youdao.appKey=xxxxxxa777xxxxxx
youdao.appSecret=xxxxxx0gFDWLyDublBeTGIVVjcxxxxxx
youdao.youdaoUrl=https://openapi.youdao.com/api
EOF
```



```shell
mkdir src/main/java/com/zeaho/spring/springbootdemo/properties

cat > src/main/java/com/zeaho/spring/springbootdemo/properties/YouDaoTranslateProperties.java <<EOF
package com.zeaho.spring.springbootdemo.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author lzzz
 */
@Configuration
@ConfigurationProperties("youdao")
public class YouDaoTranslateProperties {
    private String appKey;
    private String appSecret;
    private String youdaoUrl;

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getYoudaoUrl() {
        return youdaoUrl;
    }

    public void setYoudaoUrl(String youdaoUrl) {
        this.youdaoUrl = youdaoUrl;
    }
}
EOF
```

上面我们一直使用properties文件编写配置文件，但是随着配置分类不断增加弊端也愈发明显，我们需要重复配置相同的前缀，这时使用yaml配置就可以解决重复定义的问题。

```shell
mv src/main/resources/application.properties src/main/resources/application.yml
cat > src/main/resources/application.properties <<EOF
youdao:
  appKey: xxxxxxa777xxxxxx
  appSecret: xxxxxx0gFDWLyDublBeTGIVVjcxxxxxx
  youdaoUrl: https://openapi.youdao.com/api
EOF
```

