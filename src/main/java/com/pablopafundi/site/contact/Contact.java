package com.pablopafundi.site.contact;

import com.pablopafundi.site.common.domain.BaseWithLang;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@AttributeOverride(name = "id", column = @Column(name = "id_contact"))
@Table(name = "contact", indexes = {@Index(name = "idx_lang", columnList = "lang")})
@Inheritance(strategy = InheritanceType.JOINED)
public class Contact extends BaseWithLang {


    @NotNull(message = "Channel must have a value")
    @Column(nullable = false)
    private ContactChannel channel;

    @NotBlank(message = "Contact must have a value")
    @Column(nullable = false)
    private String contact;


    private String url;

}
