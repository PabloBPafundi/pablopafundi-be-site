package com.pablopafundi.site.profiletags;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileTagRepository extends JpaRepository<ProfileTag, Integer> {


    boolean existsByTagNameAndIsActive(String n, Boolean isActive);
}
