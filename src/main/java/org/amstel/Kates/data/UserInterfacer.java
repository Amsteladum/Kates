package org.amstel.Kates.data;

import org.amstel.Kates.data.User;
import org.amstel.Kates.data.UserInterface;

import org.springframework.util.StringUtils;

interface UserInterface {
    User getUser();
    User setUser(User user);
    User findById(User id);
}

public class UserInterfacer implements UserInterface {
    User user;
    UserInterface uirs;

    public User getUser() {
        return this.user;
    }

    public User setUser(User user) {
        uirs.getUser();

        findById(user);

        return setUser(user);
    } /*TODO Lambda operation (expression) of getting the User ID and then Setting the User ID.*/

    public User findById(User id) {

        id = (User) (!StringUtils.isEmpty(findById(id))
                ? !findById(id).equals(findById(id))
                : 0); // TODO Write a Lambda Function.
        return id;
    }
}