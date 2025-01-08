package com.pablopafundi.site.knowledge;

import com.pablopafundi.site.common.domain.BaseWithLang;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "knowledge", indexes = {@Index(name = "idx_lang", columnList = "lang")})
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "id_knowledge"))
public class Knowledge extends BaseWithLang {


    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SkillType skillType;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SkillLevel skillLevel;


}
