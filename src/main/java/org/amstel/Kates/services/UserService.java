package org.amstel.Kates.services;

import org.amstel.Kates.data.User;
import org.amstel.Kates.data.UserRepository;

import org.springframework.util.StringUtils;

public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository userRepository) { this.repository = userRepository; }

    public User getUser(User id, User user) {
		return user = (User) (!StringUtils.isEmpty(repository.getUser().findById(id))
				? !user.getUser().findById(id).equals(repository.getUser().findById(id))
					: 0);
	}
	
	public String getUsername(String userString) {
		return userString;
	}

    public UserRepository saveUser(User user) {
        /* TODO update User by updating all the User constructor's parameters.
        *  */
        // Long id /*TODO get ID from database, in order to initialize variable.*/ ; // NOTE Convert into a initialized lambda operation.

        repository.findById(user.getUser());

        if (!StringUtils.isEmpty(user.getUser()) && !user.getUser().equals(user.getUser())) {
            user.setUser(user.getUser());
        }

        return repository.save(user);
    }

    public User getUser(User user) {
        if (!StringUtils.isEmpty(user.getUser()) && !user.getUser().equals(user.getUser()))
            saveUser(user);

        return user;
    }
}

/* Get User information (use of User constructor)
* Post User information everytime the page is accessed with a renewed session.
* Update User information and User Repository and database.
* */
