package de.fherfurt.persons.service.resources;

import de.fherfurt.persons.service.model.Person;
import de.fherfurt.persons.service.persistence.repository.JpaGenericsDao;
import de.fherfurt.persons.service.persistence.repository.PersonAvatarRepository;
import de.fherfurt.persons.service.persistence.repository.PersonDao;
import de.fherfurt.persons.service.persistence.repository.PersonRepository;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * @author Tran Anh Hoang
 * The class SearchingSystem includes iterator search methode for a person (by personId or personinformation)
 * and a search methode for the Avatar of a certain Person
 */
public class SearchingSystem {

}