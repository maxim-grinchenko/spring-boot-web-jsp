package com.resolution.repository;

import com.resolution.domain.entity.User;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

@RepositoryDefinition(domainClass = User.class, idClass = Long.class)
public interface UserRepositoryDef {
    List<User> findByNameLikeIgnoreCase(String s);
}
