package de.fherfurt.persons.service.persistence.repository;


/**
 * The interface PersonAvatarDao represent the abstract layer between PersonAvatarDao, GenericDao and Repository-Layer.
 * @author  Tran Anh Hoang
 * @version  2.0.0.0
 */
public interface PersonAvatarDao {
    byte [] findPersonAvatarByPersonId(long personId);
    byte [] findPersonAvatarById(long avatarId);
}
