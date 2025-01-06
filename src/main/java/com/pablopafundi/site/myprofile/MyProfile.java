package com.pablopafundi.site.myprofile;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pablopafundi.site.common.domain.BaseWithLang;
import com.pablopafundi.site.common.domain.LanguageEnum;
import com.pablopafundi.site.profiletags.ProfileTag;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@AttributeOverride(name = "id", column = @Column(name = "id_my_Profile"))
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Table(
        name = "my_profile",
        indexes = {
                @Index(name = "idx_lang", columnList = "lang")
        })
public class MyProfile extends BaseWithLang {

    private String residency;

    @Column(length = 1000)
    private String aboutMe;

    private String profileImageUrl = null;

    @OneToMany(mappedBy = "profile")
    @JsonManagedReference
    private List<ProfileTag> title;


    public MyProfile(String residency, String aboutMe, LanguageEnum lang) {
        super(lang);
        this.residency = residency;
        this.aboutMe = aboutMe;
    }
}
