package de.fherfurt.persons.service.persistence.repository;


import de.fherfurt.persons.service.model.PersonAvatar;
import org.apache.commons.lang3.SerializationUtils;

import javax.persistence.EntityManager;

public class JpaPersonAvatarDao extends JpaGenericsDao<PersonAvatar> implements PersonAvatarDao{

    public JpaPersonAvatarDao(Class<PersonAvatar> type, EntityManager em) {
        super(type, em);
    }

    //TODO: SQL-Querry bauen
    @Override
    public byte[] findPersonAvatarByPersonId(long personId) {
        return new byte[0];
    }

    //TODO: Fix-ByteArray
    @Override
    public byte[] findPersonAvatarById(long avatarId) {
        //return SerializationUtils.serialize(getEntityManager().find(persistentClass, avatarId));
        return new byte[0];
    }
}
