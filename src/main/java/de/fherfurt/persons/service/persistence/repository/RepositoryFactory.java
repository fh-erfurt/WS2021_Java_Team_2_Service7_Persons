package de.fherfurt.persons.service.persistence.repository;

import de.fherfurt.persons.service.model.Address;
import de.fherfurt.persons.service.model.PersonAvatar;
import de.fherfurt.persons.service.util.DataProvider;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.logging.Logger;

public class RepositoryFactory
{
    private static final Logger LOGGER = Logger.getLogger( RepositoryFactory.class.getSimpleName() );

    private static final String DEVELOP_PERSISTENCE_UNIT_NAME = "dev-person-unit";
    private static final String TEST_PERSISTENCE_UNIT_NAME = "test-person-unit";

    private final EntityManagerFactory entityManagerFactory;
    private final RepositoryImp repository;

    private static RepositoryFactory INSTANCE;

    public static RepositoryFactory getInstance() {
        if( INSTANCE == null )
            INSTANCE = new RepositoryFactory();

        return INSTANCE;
    }

    private RepositoryFactory() {
        LOGGER.info( "Init Repo Factory" );

        // Prepare Entity Manager Factory
        this.entityManagerFactory = prepareEntityManagerFactory();

        // Create Repo
        LOGGER.info( "Create RepositoryImpl" );
        this.repository = new RepositoryImp( this.getPersonDao(), this.getAddressDao() , this.getPersonAvataDao());

        // Create Test Data and Test InputField
        // Data is a list with Persons-Objects
        // TODO: Wie kann man die Datenbank schon davor füllen?
        LOGGER.info( "Create Test Data" );
        DataProvider.createTestData().forEach( this.repository::createPerson );
    }

    private EntityManagerFactory prepareEntityManagerFactory() {
        LOGGER.info( "Prepare Entity Manager Factory");

        String runMode = System.getenv("RUN_MODE");
        LOGGER.info( "RUN_MODE: " +  runMode );

        if( runMode == null || runMode.equalsIgnoreCase( "develop" ) )
            return Persistence.createEntityManagerFactory( DEVELOP_PERSISTENCE_UNIT_NAME );
        else
            return Persistence.createEntityManagerFactory( TEST_PERSISTENCE_UNIT_NAME );

    }



    //Setzen der Person-EntityManager
    private PersonDao getPersonDao() {
        return new JpaPersonDao( this.entityManagerFactory.createEntityManager() );
    }

    //Setzen der Adress-EntityManager
    private GenericDao<Address> getAddressDao() {
        return new JpaGenericsDao<>( Address.class, this.entityManagerFactory.createEntityManager() );
    }

    //Setzen der PersonAvatar-EntityManager
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