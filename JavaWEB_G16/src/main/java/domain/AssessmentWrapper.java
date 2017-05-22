/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rerre
 */
public class AssessmentWrapper {
    private List<Assessment> assessments;

    public AssessmentWrapper() {
        this.assessments = new ArrayList<>();
    }

    
    public List<Assessment> getAssessments() {
        return assessments;
    }

    public void setAssessments(List<Assessment> assessments) {
        this.assessments = assessments;
    }
    
    public void add(Assessment assessment){
        assessments.add(assessment);
    }
    
}
