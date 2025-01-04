package com.pablopafundi.site.common.domain;


import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
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
    @Column(nullable = false)
    private LanguageEnum lang;


}
