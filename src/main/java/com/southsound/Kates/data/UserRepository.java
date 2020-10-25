package com.southsound.Kates.data;

import com.southsound.Kates.data.User;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

public interface UserRepository extends JpaRepository {

	@PutMapping("/{userDataId}")
	UserRepository putUser(@RequestBody UserRepository put);
	UserRepository save(User user);

	User getUser();
	User setUser(User user); /*TODO Lambda operation (expression) of getting the User ID and then Setting the User ID.*/

	String findByUsername(String username);

	User findById(User id);

	PageRequest findAll(PageRequest pageRequest);
}
/* TODO Create the RESTful functionalities of `UserRepository`.
 *
 */
