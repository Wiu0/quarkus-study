package br.com.wiu.study.quarkus.cm.started.vo;

import br.com.wiu.study.quarkus.cm.started.enums.StatusClass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassVO {

    @Min(1)
    @Max(Integer.MAX_VALUE)
    private int id;
    @Size(min = 5, max = 30)
    private String description;
    @NotNull
    private StatusClass status;
    @Min(1)
    @Max(Short.MAX_VALUE)
    private short year;
}
