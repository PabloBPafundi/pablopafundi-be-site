package com.pablopafundi.site.portfolio;

import com.pablopafundi.site.common.domain.BaseWithLang;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@AttributeOverride(name = "id", column = @Column(name = "id_portfolio"))
@Table(
        name = "portfolio",
        indexes = {
                @Index(name = "idx_lang", columnList = "lang")
        })
@Inheritance(strategy = InheritanceType.JOINED)
public class Portfolio extends BaseWithLang {

    @NotBlank
    @Column(nullable = false, length = 300, unique = true)
    private String name;

    @NotBlank
    @Column(nullable = false, length = 750)
    private String description;

    @NotNull
    @Column(nullable = false)
    private LocalDate dateCompleted;

    @NotBlank
    @Column(nullable = false)
    private String urlRepository;


}
