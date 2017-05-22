/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Assessment;
import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rerre
 */
@Repository("assessmentDao")
public class JpaAssessmentDao extends GenericDaoJpa<Assessment> implements AssessmentDao{

    public JpaAssessmentDao() {
        super(Assessment.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Assessment> getByCoursememberId(long id) {
       
        TypedQuery<Assessment> query
                = em.createNamedQuery(
                        "Assessment.getById", Assessment.class);
        query.setParameter(
                "id", id);
        return query.getResultList();
       }
    
}
