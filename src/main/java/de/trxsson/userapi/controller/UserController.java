package de.trxsson.userapi.controller;

import de.trxsson.userapi.entity.User;
import lombok.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The UserController class is a REST controller that handles HTTP requests related to user management.
 * It provides methods to retrieve and edit users.
 *
 * @see User
 * @since 1.0
 */
@RestController
public class UserController {

    /**
     * Retrieves an array of users based on the provided limit and offset values.
     *
     * @param limit  The maximum number of users to retrieve.
     * @param offset The starting index of the users to retrieve.
     * @return An array of User objects representing the retrieved users.
     *
     * @see User
     * @since 1.0
     */
    @NonNull
    @GetMapping("users")
    public User[] retrieveUsers(
            @RequestParam(value = "limit") int limit,
            @RequestParam(value = "offset", required = false, defaultValue = "0") int offset
    ) {
        //TODO: Retrieve and return users from database
        return new User[0];
    }

}
