/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author rerre
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Assesment.getById", query = "SELECT p FROM Assessment p WHERE p.forCoursemember.id = :id")})
public class Assessment implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Answer> answers;
    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    private Coursemember forCoursemember;

    public Assessment() {
    }
    
    public Assessment(Coursemember coursemember){
        this.forCoursemember=coursemember;
        this.answers=new ArrayList<>();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Coursemember getForCoursemember() {
        return forCoursemember;
    }

    public void setForCoursemember(Coursemember forCoursemember) {
        this.forCoursemember = forCoursemember;
    }
       @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Assessment)) {
            return false;
        }
        Assessment other = (Assessment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Assessment[ id=" + id + " ]";
    }
    
}
