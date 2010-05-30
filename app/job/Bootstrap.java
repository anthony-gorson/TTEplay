/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package job;

/**
 *
 * @author waxzce
 */
import models.person.Person;
import models.person.GlobalStaff;
import models.person.Staff;
import models.person.Student;
import java.util.Date;
import play.*;
import play.jobs.*;
import play.test.*;

import models.*;
import models.event.CampusEvent;
import models.event.ExamEvent;
import models.event.GlobalEvent;
import models.event.LessonEvent;
import models.event.PersoEvent;
import org.joda.time.DateTime;
import org.joda.time.Interval;

@OnApplicationStart
public class Bootstrap extends Job {

    public void doJob() {
        // Check if the database is empty
        Fixtures.deleteAllEntities();
        // if (Person.count() == 0) {
        /// nantes campus
        Campus c = new Campus();
        c.name = "Nantes";
        c.save();
        // promo M1
        Promo po = new Promo();
        po.campus = c;
        po.name = "M1";
        po.save();
        /// user waxzce
        Student p = new Student();
        p.dateOfBirth = new Date(88, 4, 5);
        p.firstName = "Quentin";
        p.lastName = "ADAM";
        p.login = "waxzce";
        p.password = "azerty";
        p.mail = "waxzce@gmail.com";
        p.promo = po;
        p.save();
        /// user farof
        Student p2 = new Student();
        p2.dateOfBirth = new Date(70, 0, 1);
        p2.firstName = "Mathieu";
        p2.lastName = "MERDY";
        p2.login = "farof";
        p2.password = "azerty";
        p2.mail = "gfarof@gmail.com";
        p2.promo = po;
        p2.save();
        /// user pherve
        Staff s = new Staff();
        s.dateOfBirth = new Date(70, 0, 1);
        s.firstName = "Philippe";
        s.lastName = "HERVE";
        s.login = "pherve";
        s.password = "azerty";
        s.mail = "pherve@gmail.com";
        s.campus = c;
        s.save();
        /// user gpougne
        GlobalStaff gs = new GlobalStaff();
        gs.dateOfBirth = new Date(70, 0, 1);
        gs.firstName = "Gaetan";
        gs.lastName = "POUGNE";
        gs.login = "gpougne";
        gs.password = "azerty";
        gs.mail = "gpougne@gmail.com";
        gs.save();

        //global event;
        GlobalEvent ge = new GlobalEvent();
        ge.name = "a GlobalEvent";
        ge.description = "big test";
        //    ge.interval = new Interval(new DateTime(), new DateTime((new DateTime()).getMillis() + (3600 * 1000)));
        ge.start = (new DateTime()).getMillis();
        ge.end = new DateTime((new DateTime()).getMillis() + (3600 * 1000)).getMillis();

        ge.save();
        //campus event;
        CampusEvent ce = new CampusEvent();
        ce.campus = c;
        ce.name = "a CampusEvent";
        ce.description = "big test";
        ce.start = (new DateTime()).getMillis();
        ce.end = new DateTime((new DateTime()).getMillis() + (3600 * 1000)).getMillis();
        ce.save();
        //exam event;
        ExamEvent ee = new ExamEvent();
        ee.promo = po;
        ee.name = "a ExamEvent";
        ee.description = "big test";
        ee.start = (new DateTime()).getMillis();
        ee.end = new DateTime((new DateTime()).getMillis() + (3600 * 1000)).getMillis();
        ee.save();
        //lesson event;
        LessonEvent le = new LessonEvent();
        le.promo = po;
        le.name = "a LessonEvent";
        le.description = "big test";
        le.start = (new DateTime()).getMillis();
        le.end = new DateTime((new DateTime()).getMillis() + (3600 * 1000)).getMillis();
        le.save();
        //perso event;
        PersoEvent per = new PersoEvent();
        per.person = p;
        per.name = "a PersoEvent";
        per.description = "big test";
        per.start = (new DateTime()).getMillis();
        per.end = new DateTime((new DateTime()).getMillis() + (3600 * 1000)).getMillis();
        per.save();

        //     }
    }
}
