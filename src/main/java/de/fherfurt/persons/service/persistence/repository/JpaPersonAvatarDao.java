package de.fherfurt.persons.service.persistence.repository;


import de.fherfurt.persons.service.model.Person;
import de.fherfurt.persons.service.model.PersonAvatar;


import javax.persistence.EntityManager;
/**
 * The class JpaPersonAvatarDao is the implementation class of the interface PersonAvatarDao.
 * @author  Tran Anh Hoang
 * @version  2.0.0.0
 */
public class JpaPersonAvatarDao extends JpaGenericsDao<PersonAvatar> implements PersonAvatarDao{

    public JpaPersonAvatarDao(Class<PersonAvatar> type, EntityManager em) {
        super(type, em);
    }
    @Override
    public byte[] findPersonAvatarById(long personAvatarId) {
        //return SerializationUtils.serialize(getEntityManager().find(persistentClass, avatarId));
        return getEntityManager().find(PersonAvatar.class, personAvatarId).getAvatarByteArray();
    }
}
