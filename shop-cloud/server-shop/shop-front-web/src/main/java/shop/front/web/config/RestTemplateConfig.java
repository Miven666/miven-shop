package shop.front.web.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 引用自https://www.jianshu.com/p/95bf08696cd7
 *
 * @author mingzhi.xie
 * @date 2019/4/15.
 */

@Configuration
public class RestTemplateConfig {

    @Resource
    private RestTemplateBuilder builder;

    /**
     * Fix 'Could not extract response: no suitable HttpMessageConverter found for response type [class ] and content type [text/javascript;charset=UTF-8]'
     */
    @Bean
    public RestTemplate restTemplate() {
        //先获取到converter列表
        List<HttpMessageConverter<?>> converters = builder.build().getMessageConverters();
        for(HttpMessageConverter<?> converter : converters){
            if(converter instanceof MappingJackson2HttpMessageConverter){
                try{
                    //先将原先支持的MediaType列表拷出
                    List<MediaType> mediaTypeList = new ArrayList<>(converter.getSupportedMediaTypes());
                    //加入对text/javascript的支持
                    mediaTypeList.add(MediaType.parseMediaType("text/javascript"));
                    ((MappingJackson2HttpMessageConverter) converter).setSupportedMediaTypes(mediaTypeList);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        return builder.build();
    }

}
