package com.pablopafundi.site.common.domain;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BaseExperience extends BaseWithLang {

    @Column(
            unique = true
    )
    private String name;

    @Column(
           length = 400
    )
    private String description;

    private LocalDate dateStart;

    private LocalDate dateEnd;

    private String siteURL;



}
