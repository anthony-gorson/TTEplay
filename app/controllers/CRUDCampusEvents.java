/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.event.CampusEvent;
import play.mvc.*;
import play.*;
import controllers.CRUD;
import models.*;

/**
 *
 * @author waxzce
 */
@CRUD.For(CampusEvent.class)
@Check("staff")
@With(Secure.class)
public class CRUDCampusEvents extends CRUD {
}
