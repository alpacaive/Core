package alpacaive.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( // @Component 가 붙은 클래스를 다 찾아서 자동으로 스프링 빈으로 등록을 해준다
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // 뺄거 선택해주는 것 -> @Configuration 붙은거는 뺌
)
public class AutoAppConfig {



}
