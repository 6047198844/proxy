package hello.proxy.common.cglib;

import hello.proxy.common.cglib.code.TimeMethodInterceptor;
import hello.proxy.common.service.ConcreteService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

@Slf4j
public class CglibTest {
    @Test
    void cglib() {
        final ConcreteService target = new ConcreteService();

        final Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ConcreteService.class);
        enhancer.setCallback(new TimeMethodInterceptor(target));
        final ConcreteService proxy = (ConcreteService) enhancer.create();
        System.out.println("target.getClass() = " + target.getClass());
        System.out.println("proxy.getClass() = " + proxy.getClass());

        proxy.call();
    }
}
