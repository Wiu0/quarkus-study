package br.com.wiu.study.quarkus.sample.service;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SampleService {

    public String getHello(String name) {
        return String.format("Hello %s", name);
    }
}
