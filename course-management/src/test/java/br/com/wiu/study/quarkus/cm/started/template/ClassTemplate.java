package br.com.wiu.study.quarkus.cm.started.template;

import br.com.wiu.study.quarkus.cm.started.enums.StatusClass;
import br.com.wiu.study.quarkus.cm.started.vo.ClassVO;

public class ClassTemplate {

    public static ClassVO successTemplate() {
        return ClassVO
                .builder()
                .id(1)
                .description("class test")
                .status(StatusClass.CREATED)
                .year((short)2021)
                .build();
    }

    public static ClassVO failureTemplate() {
        return ClassVO
                .builder()
                .id(-1)
                .description("this is a invalid description because the size is bigger than the max value")
                .status(null)
                .year((short)-2)
                .build();
    }


}
