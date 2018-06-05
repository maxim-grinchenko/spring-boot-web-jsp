package com.resolution.repository.impl;

import com.resolution.domain.entity.User;
import com.resolution.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

/*
@Repository
@Slf4j
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public void delete(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
    }

    @Transactional
    @Override
    public void deleteAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from User");

        int result = query.executeUpdate();
        LOGGER.debug("Deleted result: {}", result);
    }

    @Override
    public boolean existsById(long id) {
        return findById(id) != null;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @SuppressWarnings("unchecked")
    @Override
    public List<User> findAll() {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from User");
        return (List<User>) query.getResultList();
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public User findById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Transactional
    @Override
    public User save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        return user;
    }

    @Transactional
    @Override
    public void saveAll(List<User> users) {
        LOGGER.debug("Start batch save users: {}", users);
        Session session = sessionFactory.getCurrentSession();

        for (int i = 0; i < users.size(); i++) {
            session.save(users.get(i));
            int batchSize = 5;
            if (i % batchSize == 0) {
                session.flush();
                session.clear();
            }
        }
        LOGGER.debug("Stop batch save index");
    }
}*/
