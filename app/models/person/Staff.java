/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.person;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import models.Campus;

/**
 *
 * @author waxzce
 */
@Entity
public class Staff extends Person {

    @ManyToOne
    public Campus campus;


}