package de.fherfurt.persons.service.persistence.core;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
public class AbstractDatabaseEntity {


    /**
     * @Id Jede Tabelle braucht ID, somit wird das vererbt
     * @GeneratedValue markiert den Primärschlüssel als automatisch vergeben
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;


    /**
     * @Id markiert eine Instanz-variable, welche von JPA automatisch zur Versionierung verwendet wird
     */
    @Version
    private Long version;

    /**
     * @Temporal Für den Datentyp Date muss bei de Abbildung ein SQL Datentyp via festgelegt werden
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;

    public AbstractDatabaseEntity() {}


    @PrePersist
    void onCreate()
    {
        this.setCreated( new Date() );
    }

    @PreUpdate
    void onUpdate()
    {
        this.setModified( new Date() );
    }

    @Override
    public String toString() {
        return "AbstractDatabaseEntity{" +
                "id=" + id +
                ", created=" + created +
                ", version=" + version +
                ", modified=" + modified +
                '}';
    }
}
