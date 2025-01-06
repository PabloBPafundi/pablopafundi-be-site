package com.pablopafundi.site.common.domain;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public abstract class BaseWithLang extends BaseEntity{

    //@NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "lang", nullable = false)
    private LanguageEnum lang;


}
