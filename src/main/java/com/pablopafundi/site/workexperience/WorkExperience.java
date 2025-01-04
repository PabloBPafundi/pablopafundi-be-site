package com.pablopafundi.site.workexperience;

import com.pablopafundi.site.common.domain.BaseExperience;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;



@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@AttributeOverride(name = "id", column = @Column(name = "id_work_experience"))
@Table(name = "work_experience")
@Inheritance(strategy = InheritanceType.JOINED)
public class WorkExperience extends BaseExperience {


    public WorkExperience(String name, String description, LocalDate dateStart, LocalDate dateEnd, String siteURL){
        super(name, description, dateStart, dateEnd, siteURL);
    }
}
