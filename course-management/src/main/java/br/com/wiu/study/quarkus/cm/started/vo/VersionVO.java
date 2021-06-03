package br.com.wiu.study.quarkus.cm.started.vo;

import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;

//javax.inject.Singleton - When used on your bean, you have to implement writeResolve() and readReplace to avoid any serialization issues. Use it judiciously based on what your bean actually has in it.
//javax.enterprise.context.ApplicationScoped - Allows the container to proxy the bean and take care of serialization process automatically. This is recommended to avoid unprecedented issues.
//For More information refer this page number 45. http://docs.jboss.org/weld/reference/1.1.0.Final/en-US/pdf/weld-reference.pdf
@ApplicationScoped
@Getter
public class VersionVO {

    private int versionId;

    @PostConstruct
    public void init() {
        versionId = 1;
    }
}
