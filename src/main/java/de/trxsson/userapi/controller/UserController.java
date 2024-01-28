package de.trxsson.userapi.controller;

import de.trxsson.userapi.entity.User;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

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

    /**
     * Creates a new user with the given name and date of birth.
     *
     * @param name The name of the user.
     * @param dateOfBirth The date of birth of the user.
     * @return The created User object.
     */
    @NonNull
    @PostMapping("users")
    public User createUser(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "dateOfBirth") LocalDate dateOfBirth
    ) {
        //TODO: Create and return new user from database
        return new User();
    }

    /**
     * Retrieves a user based on the provided ID.
     *
     * @param id The ID of the user to retrieve.
     * @return The User object representing the retrieved user.
     */
    @NonNull
    @GetMapping("users/{id}")
    public User retrieveUser(@PathVariable(value = "id") UUID id) {
        //TODO: Retrieve and return user from database
        return new User();
    }

    /**
     * Updates a user in the database based on the provided ID.
     *
     * @param id The ID of the user to update.
     * @return The updated User object.
     */
    @NonNull
    @PutMapping("users/{id}")
    public User updateUser(
            @PathVariable(value = "id") UUID id,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "dateOfBirth") LocalDate dateOfBirth
    ) {
        //TODO: Update and return user from database
        return new User();
    }

    /**
     * Deletes a user from the database based on the provided ID.
     *
     * @param id The UUID representing the ID of the user to be deleted.
     */
    @DeleteMapping("users/{id}")
    public void deleteUser(@PathVariable(value = "id") UUID id) {
        //TODO: Delete user from database
    }

}
