package com.example.jwtrole.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
//Java Persistence API is a collection of classes and methods to persistently store the vast amounts of data into a database
// which is provided by the Oracle Corporation.
//Java classes whose objects or instances will be stored in database tables are called persistent classes in Hibernate.
// Hibernate works best if these classes follow some simple rules, also known as the Plain Old Java Object (POJO) programming model.
//The @Entity annotation specifies that the class is an entity and is mapped to a database table
//Entity: The entities are the persistence objects stores as a record in the database. Persistence Unit: It defines a set of all entity
// classes. In an application, EntityManager instances manage it.
@Entity
public class Role {
    //not autogenerating here
    @Id
    private String roleName; //column1
    private String roleDescription; //column2

    //getters and setters
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
