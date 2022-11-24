package com.example.jwtrole.dao;
import com.example.jwtrole.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//The Data Access Object (or DAO) pattern: separates a data resource's client interface from its data access mechanisms.
//This way, the service remains completely in dark about how the low-level operations to access the database is done.
// This is known as the principle of Separation of Logic.
//https://www.digitalocean.com/community/tutorials/dao-design-pattern

//Role - on which we are going to use this crud repository, String - id type
@Repository
public interface RoleDao extends CrudRepository<Role, String> {

}
