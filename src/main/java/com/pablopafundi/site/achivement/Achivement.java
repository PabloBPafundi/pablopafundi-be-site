package com.pablopafundi.site.achivement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pablopafundi.site.common.domain.BaseEntity;
import com.pablopafundi.site.common.domain.BaseWithLang;
import com.pablopafundi.site.workexperience.WorkExperience;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@AttributeOverride(name = "id", column = @Column(name = "id_achivement"))
@Table(name = "achivement")
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED)
public class Achivement extends BaseWithLang {

    @NotEmpty
    @Column(unique = true, nullable = false)
    private String name;


    @NotEmpty
    @Column(unique = true, nullable = false, length = 750)
    private String description;


}
