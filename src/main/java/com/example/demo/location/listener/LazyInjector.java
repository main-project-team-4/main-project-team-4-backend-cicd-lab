package com.example.demo.location.listener;

import com.example.demo.config.ListenerConfig;
import org.springframework.context.ApplicationContext;

import java.util.function.Supplier;

public class LazyInjector<T> {
    private final Supplier<ApplicationContext> contextSupplier = ListenerConfig::getContext;
    private final Class<T> classBean;
    private T bean;

    public LazyInjector(Class<T> classBean) {
        this.classBean = classBean;
    }

    public T getBean() {
        if(bean == null)
            bean = contextSupplier.get().getBean(classBean);
        return bean;
    }
}
