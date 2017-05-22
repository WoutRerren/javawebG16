/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Coursemember;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rerre
 */
@Repository("coursememberDao")
public class JpaCoursememberDao extends GenericDaoJpa<Coursemember> implements CoursememberDao {

    public JpaCoursememberDao() {
        super(Coursemember.class);
    }

    @Transactional(readOnly = true)
    @Override
    public Coursemember getByUsername(String username) {
        TypedQuery<Coursemember> query
                = em.createNamedQuery(
                        "Cursist.getByUsername", Coursemember.class);
        query.setParameter(
                "username", username);
        return query.getResultList().get(0);
    }
    
}
