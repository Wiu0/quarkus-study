package br.com.wiu.study.quarkus.cm.started.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassEntity {

    private long id;
    private String description;
}
