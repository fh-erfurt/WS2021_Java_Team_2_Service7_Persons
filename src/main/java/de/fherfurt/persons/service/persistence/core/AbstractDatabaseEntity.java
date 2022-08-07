package de.fherfurt.persons.service.persistence.core;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


/**
 * The class AbstractDatabaseEntity is an entity-class. This class has the main goal as a parent class and entity and inheritance specific attribute to the other child entity-classes
 *
 * @author Tran Anh Hoang
 * @version 2.0.0.
 */
@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AbstractDatabaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Version
    private Long version;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;


    public AbstractDatabaseEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    @PrePersist
    void onCreate() {
        this.setCreated(new Date());
    }

}
