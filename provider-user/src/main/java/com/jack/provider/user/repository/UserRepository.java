package com.jack.provider.user.repository;

import com.jack.common.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author yangyueming
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findOneById(Long id);
}
