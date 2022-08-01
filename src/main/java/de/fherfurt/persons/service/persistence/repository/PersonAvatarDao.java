package de.fherfurt.persons.service.persistence.repository;

public interface PersonAvatarDao {
    byte [] findPersonAvatarByPersonId(long personId);
    byte [] findPersonAvatarById(long avatarId);
}
