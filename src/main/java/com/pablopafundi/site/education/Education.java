package com.pablopafundi.site.education;

import com.pablopafundi.site.common.domain.BaseExperience;
import com.pablopafundi.site.common.domain.BaseWithLang;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@AttributeOverride(name = "id", column = @Column(name = "id_education"))
@Table(name = "education")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
public class Education extends BaseExperience {


    public Education(String name, String description, LocalDate dateStart, LocalDate dateEnd, String siteURL){
        super(name, description, dateStart, dateEnd, siteURL);
    }



}
