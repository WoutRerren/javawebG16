/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Assessment;
import domain.AssessmentWrapper;
import domain.Coursemember;
import domain.GbGroup;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.AssessmentDao;
import service.CoursememberDao;

/**
 *
 * @author dylan
 */
@Controller
public class AssessmentController
{

    @Autowired
    private CoursememberDao coursememberDao;

    @Autowired
    private AssessmentDao assessmentDao;

    @RequestMapping(value = "/peerassessment", method = RequestMethod.GET)
    public String AssessmentPage(Model model, Principal principal)
    {

        Coursemember current = coursememberDao.getByUsername(principal.getName());
        GbGroup gbGroup = current.getGbGroep();
        List<Coursemember> coursemembers = new ArrayList<>();

        coursemembers = gbGroup.getCoursemembers();
        List<Integer> answers = new ArrayList<>();
        answers.addAll(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        model.addAttribute("answers", answers);
        List<Assessment> assesments = new ArrayList<>();

        for (int i = 0; i < coursemembers.size(); i++)
        {

            Assessment assessment = new Assessment(coursemembers.get(i));
            assesments.add(assessment);
            assesments.get(i).setForCoursemember(coursemembers.get(i));
        }
        AssessmentWrapper wrapper = new AssessmentWrapper();
        wrapper.setAssessments(assesments);
        model.addAttribute("wrapper", wrapper);
        return "peerassessment";
    }
    
    @RequestMapping(value = "/overzichtassesments", method = RequestMethod.GET)
    public String overzichtAssesment(Model model, Principal principal) {
        Coursemember current = coursememberDao.getByUsername(principal.getName());
 
        return "overzichtassesments";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String SaveAssessment(@ModelAttribute(value = "wrapper") AssessmentWrapper wrapper, Model model, BindingResult result, Principal principal)
    {

        if (result.hasErrors())
        {
            return "peerassessment";
        }

        for (Assessment p : wrapper.getAssessments())
        {
            assessmentDao.insert(p);
        }
        Coursemember current = coursememberDao.getByUsername(principal.getName());
        for (int i = 0; i < wrapper.getAssessments().size(); i++)
        {
            wrapper.getAssessments().get(i).setForCoursemember(current.getGbGroep().getCoursemembers().get(i));
        }
        current.setAssessments(wrapper.getAssessments());
        coursememberDao.update(current);

        return "overzichtassessments";
    }

}
