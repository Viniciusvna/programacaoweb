package dev.fujioka.java.avancado.web.repository;

import dev.fujioka.java.avancado.web.domain.User;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
        extends JpaRepository<User, Long> {

	public List<User> findProductByLogin(@Param("login") String login);
	public List<User> findProductById(@Param("id") Long id);
	public List<User> findProductByDtCreation(@Param("dtCreation") Date dtCreation);
	public List<User> findProductByDtUpdate(@Param("dtUpdate") Date dtUpdate);
	public List<User> findProductByFirstName(@Param("firstName") String firstName);
	public List<User> findProductByLastName(@Param("lastName") String lastName);
}