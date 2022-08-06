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

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;


    public AbstractDatabaseEntity() {}

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Date getCreated()
    {
        return created;
    }

    @PrePersist
    void onCreate()
    {
        this.setCreated( new Date() );
    }

}
