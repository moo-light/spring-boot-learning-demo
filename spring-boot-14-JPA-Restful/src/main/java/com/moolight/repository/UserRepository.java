package com.moolight.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.moolight.model.User;

@Repository
public interface UserRepository extends
        JpaRepository<User, Long> {
            List<User> findAllByAtk(int atk);

            List<User> findAllByAgiBetween(int start, int end);
        
            @Query("SELECT u FROM User u WHERE u.def between :start and :end")
            List<User> findUserByDefQuery(@Param("start") Integer start,@Param("end") Integer end);
        
            List<User> findAllByAgiGreaterThan(int agiThreshold);

}