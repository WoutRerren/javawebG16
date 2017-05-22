/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;



/**
 *
 * @author rerre
 */
@Transactional
public class GenericDaoJpa<T> implements GenericDao<T>{

    private Class<T> type;
    protected EntityManager em;

    public GenericDaoJpa(Class<T> type) {
        super();
        this.type = type;
    }

    @PersistenceContext
    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    @Transactional(readOnly = true)
    @Override
    public List<T> findAll() {
return this.em.createQuery(
                "select entity from " + this.type.getName() + " entity").getResultList();
    }

    @Override
    public T update(T object) {
        return em.merge(object);
    }

    @Transactional(readOnly=true)
    @Override
    public T get(Long id) {
         T entity = this.em.find(this.type, id);
        return entity;
    }

    @Override
    public void delete(T object) {
        em.remove(em.merge(object));

    }

    @Override
    public void insert(T object) {
        em.persist(object);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean exists(Long id) {
        T entity = this.em.find(this.type, id);
        return entity != null;
    }
    
}
