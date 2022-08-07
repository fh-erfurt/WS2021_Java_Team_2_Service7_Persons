package de.fherfurt.persons.service.persistence.repository;

import de.fherfurt.persons.service.model.Address;
import de.fherfurt.persons.service.model.Faculty;
import de.fherfurt.persons.service.model.PersonAvatar;
import de.fherfurt.persons.service.util.DataProvider;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.logging.Logger;


/**
 * The Singleton-Class RepositoryFactory has the main goal to create entityManagerFactory, initialize RepositoryImp and create Testdata from Class Data Provider.
 * @author  Tran Anh Hoang
 * @version  2.0.0.0
 */
public class RepositoryFactory
{
    private static final Logger LOGGER = Logger.getLogger( RepositoryFactory.class.getSimpleName() );

    private static final String DEVELOP_PERSISTENCE_UNIT_NAME = "develop-person-unit";
    private static final String TEST_PERSISTENCE_UNIT_NAME = "test-person-unit";

    private final EntityManagerFactory entityManagerFactory;
    private final RepositoryImp repository;

    private static RepositoryFactory INSTANCE;

    public static RepositoryFactory getInstance() throws IOException {
        if( INSTANCE == null )
            INSTANCE = new RepositoryFactory();

        return INSTANCE;
    }

    /**
     * private Constructor, because of the SingletonPattern
     * create entityManagerFactory, initialize RepositoryImp and create Testdata from Class Data Provider
     * @throws IOException when imagebyte is null
     */
    private RepositoryFactory() throws IOException {
        LOGGER.info( "Init Repo Factory" );

        // Prepare Entity Manager Factory
        this.entityManagerFactory = prepareEntityManagerFactory();

        // Create Repo
        LOGGER.info( "Create RepositoryImpl" );
        this.repository = new RepositoryImp( this.getPersonDao(), this.getAddressDao(),this.getFacultyDao() , this.getPersonAvataDao());

        // Create Test Data with Persons-Objects
        LOGGER.info( "Create Test Data" );
        DataProvider.createTestData().forEach( this.repository::createPerson );
    }

    /**
     * prepareEntityManagerFactory will initialize the EntityManagerFactory and choose the Database for the project
     * @return EntityManagerFactory
     */
    private EntityManagerFactory prepareEntityManagerFactory() {
        LOGGER.info( "Prepare Entity Manager Factory");

        String runMode = System.getenv("RUN_MODE");
        LOGGER.info( "RUN_MODE: " +  runMode );

        if( runMode == null || runMode.equalsIgnoreCase( "develop" ) )
            return Persistence.createEntityManagerFactory( DEVELOP_PERSISTENCE_UNIT_NAME );
        else
            return Persistence.createEntityManagerFactory( TEST_PERSISTENCE_UNIT_NAME );
    }

    private PersonDao getPersonDao() {
        return new JpaPersonDao( this.entityManagerFactory.createEntityManager() );
    }


    private GenericDao<Address> getAddressDao() {
        return new JpaGenericsDao<>( Address.class, this.entityManagerFactory.createEntityManager() );
    }

    private GenericDao<Faculty> getFacultyDao() {
        return new JpaGenericsDao<>( Faculty.class, this.entityManagerFactory.createEntityManager() );
    }

    private PersonAvatarDao getPersonAvataDao(){
        return new JpaPersonAvatarDao(PersonAvatar.class, this.entityManagerFactory.createEntityManager());
    }

    public PersonRepository getPersonRepository() {
        return this.repository;
    }

    public PersonAvatarRepository getPersonAvatarRepository(){ return this.repository;}

    public RepositoryImp getAddressRepository() {
        return this.repository;
    }

}