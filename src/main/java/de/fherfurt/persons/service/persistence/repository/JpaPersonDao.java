package de.fherfurt.persons.service.persistence.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import de.fherfurt.persons.service.model.Person;
import java.util.Collection;

public class JpaPersonDao extends JpaGenericsDao<Person> implements PersonDao {

    public JpaPersonDao( EntityManager em ){
        super( Person.class, em );
    }

    @Override
    public Person findPersonById(long personId) {
        return getEntityManager().find(Person.class, personId);
    }



    @Override
    public Collection<Person> findPersonBy(String firstname, String lastname, String major, String faculty) {
        Query query = getEntityManager().createNativeQuery("SELECT * from person p inner join faculty f on p.id = f.id where p.firstname= ? " +
                "and p.lastname = ? and p.major = ? and f.facultyname = ?" ).setParameter("firstname", firstname).setParameter("lastname", lastname)
                .setParameter("major", major).setParameter("facultyname", faculty);

        return (Collection<Person>) query.getResultList();
    }

}
