/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Assessment;
import java.util.List;

/**
 *
 * @author rerre
 */
public interface AssessmentDao extends GenericDao<Assessment> {
    
    List<Assessment> getByCoursememberId(long id);
}
