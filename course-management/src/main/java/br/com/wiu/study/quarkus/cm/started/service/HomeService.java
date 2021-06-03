package br.com.wiu.study.quarkus.cm.started.service;

import br.com.wiu.study.quarkus.cm.started.vo.VersionVO;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class HomeService {

    @Inject
    private VersionVO version;

    public Uni<VersionVO> getVersion() {
        return Uni.createFrom().item(version);
    }
}
