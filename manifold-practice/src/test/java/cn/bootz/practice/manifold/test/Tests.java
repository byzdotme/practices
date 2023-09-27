package cn.bootz.practice.manifold.test;

import cn.bootz.practice.manifold.FooServiceImpl;
import cn.bootz.practice.manifold.FooServiceWrapper;
import manifold.ext.rt.api.Jailbreak;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tony.zhuby
 * @date 2023/9/23
 */
public class Tests {
    static Logger log = LoggerFactory.getLogger(Tests.class);

    @Test
    public void testFoo() {
        @Jailbreak FooServiceWrapper service = new FooServiceWrapper(new FooServiceImpl());
        log.info("{}", service.foo());
        log.info("{}", service.showDelegate());
    }
}
