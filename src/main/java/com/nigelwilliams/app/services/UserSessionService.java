package com.nigelwilliams.app.services;

import com.nigelwilliams.app.models.User;
import com.nigelwilliams.app.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserSessionService {
    private final UserService userService;

    private User currentUser;

    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * Attempts to find the User with the given "name" in the database. If successful,
     * the User is stored as the "currentUser" for this session.
     * @param name The name of the user logging in
     * @return True if the login was successful
     */
    public boolean login(String name) {
        User foundUser = userService.getUserByName(name);
        if (foundUser != null) {
            currentUser = foundUser;

            return true;
        }

        return false;
    }
}
