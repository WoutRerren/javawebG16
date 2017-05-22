/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Coursemember;

/**
 *
 * @author rerre
 */
public interface CoursememberDao extends GenericDao<Coursemember> {
    public Coursemember getByUsername(String username);
}
