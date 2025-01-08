package com.pablopafundi.site.profiletags;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pablopafundi.site.common.domain.BaseEntity;
import com.pablopafundi.site.myprofile.MyProfile;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@AttributeOverride(name = "id", column = @Column(name = "id_profile_title"))
@Table(name = "profile_tag", indexes = {@Index(name = "idx_lang", columnList = "lang")})
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class ProfileTag extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String tagName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_my_profile", nullable = false)
    @JsonBackReference
    private MyProfile profile;

}
