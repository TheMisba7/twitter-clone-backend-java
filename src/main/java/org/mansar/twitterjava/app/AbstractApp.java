package org.mansar.twitterjava.app;

import org.mansar.twitterjava.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class AbstractApp <E, R extends JpaRepository<E, Long>> {
    protected final R dao;

    public AbstractApp(R dao) {
        this.dao = dao;
    }

    protected E save(E entity) {
        return dao.save(entity);
    }

    protected E getById(Long id) {
        return dao.findById(id).orElseThrow(() -> new RuntimeException("not found"));
    }

    protected void delete(Long id) {
        dao.deleteById(id);
    }

    protected E update(E entity) {
        return save(entity);
    }

    public User getCurrentUser() {
        return (User) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
    }
}
