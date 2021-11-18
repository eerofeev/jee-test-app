package com.gepardec.jeetestapp.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

@ApplicationScoped
public class LoggerProducer {

    @Produces
    public Logger produceLogger(InjectionPoint ip) {
        if (ip.getMember() != null) {
            return LoggerFactory.getLogger(ip.getMember().getDeclaringClass());
        } else if (ip.getBean() != null) {
            return LoggerFactory.getLogger(ip.getBean().getBeanClass());
        } else {
            return LoggerFactory.getLogger("DEFAUL");
        }
    }

}
