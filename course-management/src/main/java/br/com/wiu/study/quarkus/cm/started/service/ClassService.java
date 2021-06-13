package br.com.wiu.study.quarkus.cm.started.service;


import br.com.wiu.study.quarkus.cm.started.config.database.DBInit;
import br.com.wiu.study.quarkus.cm.started.entity.ClassEntity;
import br.com.wiu.study.quarkus.cm.started.repository.basic.ClassRepository;
import io.smallrye.mutiny.Multi;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ClassService {

     @Inject
    ClassRepository repository;

    public Multi<ClassEntity> findAll() {
        return repository.findAll();
    }
}
