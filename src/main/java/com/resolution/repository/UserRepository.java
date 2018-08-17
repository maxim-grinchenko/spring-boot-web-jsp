package com.resolution.repository;

import com.resolution.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    @Override
    List<User> findAll();

    Optional<User> findOneByActivationKey(String activationKey);

    List<User> findAllByActivatedIsFalseAndCreatedDateBefore(ZonedDateTime dateTime);

    Optional<User> findOneByResetKey(String resetKey);

    Optional<User> findOneByEmail(String email);

    Optional<User> findOneByLogin(String login);

    Optional<User> findOneById(Long userId);

    @Query(value = "select distinct user from User user join fetch user.authorities",
            countQuery = "select count(user) from User user")
    Page<User> findAllWithAuthorities(Pageable pageable);

    List<User> findByLoginOrEmail(String login, String email);

    List<User> findByIdIn(List<Long> ids);

    @Override
    void delete(User t);

    @Query(value = "select distinct user from User user join fetch user.authorities where user.id in (:ids)")
    List<User> findByIdWithAuthorities(@Param("ids") List<Long> ids);

    List<User> findByKskIdAndAuthoritiesName(Long kskId, String role);

    List<User> findByRegionAndAuthoritiesName(String region, String role);

    List<User> findByAuthoritiesName(String role);
}