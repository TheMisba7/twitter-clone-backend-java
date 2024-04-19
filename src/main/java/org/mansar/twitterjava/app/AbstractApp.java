package org.mansar.twitterjava.app;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractApp <E, R extends JpaRepository<E, Long>> {
    private final R dao;

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
}
