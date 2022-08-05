package de.fherfurt.persons.service.persistence.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import de.fherfurt.persons.service.model.Person;
import java.util.Collection;

public class JpaPersonDao extends JpaGenericsDao<Person> implements PersonDao {

    //TODO: wird hier Person konstant übergeben?
    public JpaPersonDao( EntityManager em ){
        super( Person.class, em );
    }

    /*
    @Override
    public Person findPersonById(long personId) {
        return getEntityManager().find(Person.class, personId);
    }
    */


    @Override
    public Person findPersonById(long personId) {
        Person person = (Person) getEntityManager().createNativeQuery("SELECT p.firstname, p.lastname, p.email from person p where p.id = ?").setParameter("id", personId).getSingleResult();
        return person;
    }



    //TODO: Mehrere Paramater kann das so machen?
    @Override
    public Collection<Person> findPersonBy(String firstname, String lastname, String major, String faculty) {
        Query query = getEntityManager().createQuery("SELECT c FROM " + getEntityClass().getCanonicalName() +
                "c where c." + firstname + "c." + lastname + "and c." + major + "and c." + faculty );

        return (Collection<Person>) query.getResultList();
    }

    //TODO: Warum sind manche "c" als syntaktisch falsch deklierert
    // C ist das Object
    @Override
    public Collection<Person> findAllPersonWithDeletedFlag() {
        Query query = getEntityManager().createQuery("SELECT c FROM " + getEntityClass().getCanonicalName() +
                "c where c.deletedFlag = 1");


        //TODO: Mögliche Variante, jedoch schwierig, da man nicht weiß, wie JPA im Hintergrund die Tabellen mappt
        //Query query = getEntityManager().createNativeQuery()
        return (Collection<Person>) query.getResultList();
    }


    //TODO: Warum sind manche "c" als syntaktisch falsch deklierert
    @Override
    public Collection<Person> findAllPersonsWithoutDeletedFlag() {
        Query query = getEntityManager().createQuery("SELECT c FROM " + getEntityClass().getCanonicalName() +
                "c where c.deletedFlag = 0");

        return (Collection<Person>) query.getResultList();
    }
}
