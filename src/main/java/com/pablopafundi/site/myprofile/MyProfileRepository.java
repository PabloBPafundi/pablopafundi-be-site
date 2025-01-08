package com.pablopafundi.site.myprofile;


import com.pablopafundi.site.common.domain.LanguageEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MyProfileRepository extends JpaRepository<MyProfile, Integer> {


    Optional<MyProfile> findTop1ByIsActiveTrueAndLangEquals(LanguageEnum lang);

    List<MyProfile> findTop2ByIsActiveTrue();

    MyProfile findTop1ByIsActiveTrue();

}
