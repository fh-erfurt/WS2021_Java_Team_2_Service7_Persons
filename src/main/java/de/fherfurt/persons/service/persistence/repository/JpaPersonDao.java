package de.fherfurt.persons.service.persistence.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import de.fherfurt.persons.service.model.Person;
import java.util.Collection;


/**
 * The class JpaPersonDao is the implememtation class of the interface PersonDao.
 * @author  Tran Anh Hoang
 * @version  2.0.0.0
 */

public class JpaPersonDao extends JpaGenericsDao<Person> implements PersonDao {

    public JpaPersonDao( EntityManager em ){
        super( Person.class, em );
    }


    /**
     * find a certain Person by the specific personId
     * @param personId unique key
     * @return searched person and all their datas
     */
    @Override
    public Person findPersonById(long personId) {
        return getEntityManager().find(Person.class, personId);
    }


}
