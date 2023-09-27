package cn.bootz.practice.manifold;

import manifold.ext.delegation.rt.api.link;

/**
 * @author tony.zhuby
 * @date 2023/9/23
 */
public class FooServiceWrapper implements FooService{

    @link
    FooService fooService;

    public FooServiceWrapper(FooService fooService) {
        this.fooService = fooService;
    }

    private String showDelegate() {
        return "delegate ${fooService.getClass().getName()}";
    }
}
