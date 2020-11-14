package org.amstel.Kates.services;

import org.amstel.Kates.data.User;
import org.amstel.Kates.data.UserInterfacer;
import org.amstel.Kates.data.UserRepository;

import org.springframework.util.StringUtils;

public class UserService {
    private final UserRepository repository;
    UserInterfacer uirs;

    public UserService(UserRepository userRepository) { this.repository = userRepository; }

    public boolean hasGotUserById(User id, User user) {
		return StringUtils.isEmpty(uirs.getUser()) ? !uirs.findById(id).equals(uirs.getUser()) : !user.equals(id);
	}
	
	public String getUsername(String userString) {
		return userString;
	}

    public UserRepository saveUser(User user) {
        /* TODO update User by updating all the User constructor's parameters.
        *  */
        // Long id /*TODO get ID from database, in order to initialize variable.*/ ; // NOTE Convert into a initialized lambda operation.

        repository.findById(uirs.getUser());

        User id = getUser(user);
        if (!StringUtils.isEmpty(uirs.getUser()) && !hasGotUserById(id, user)) {
            uirs.setUser(uirs.getUser());
        }

        return repository.save(user);
    }

    public User getUser(User user) {
        if (!StringUtils.isEmpty(uirs.getUser()) && !uirs.getUser().equals(uirs.getUser()))
            saveUser(user);

        return user;
    }
}

/* Get User information (use of User constructor)
* Post User information everytime the page is accessed with a renewed session.
* Update User information and User Repository and database.
* */
