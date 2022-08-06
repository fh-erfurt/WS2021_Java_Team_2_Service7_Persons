package de.fherfurt.persons.service.persistence.repository;


/**
 * The interface PersonAvatarRepository represent the abstract layer between PersonAvatarRepository and Resource-Layer.
 * @author  Tran Anh Hoang
 * @version  2.0.0.0
 */
public interface PersonAvatarRepository {
    byte [] findPersonAvatarByPersonId(long personId);
    byte [] findPersonAvatarById(long avatarId);
}
