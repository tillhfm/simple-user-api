package de.tillhfm.userapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;


/**
 * Represents a user.
 * <p>
 * The User class encapsulates information about a user, including their ID, name,
 * and date of birth. The class provides getter and setter methods for each property.
 *
 * @since 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {


    /**
     * Represents the unique identifier of an object.
     *
     * <p>
     * The id field is a private {@link UUID} variable used to store the unique identifier of an object.
     * This identifier can be used to distinguish one object from another.
     * </p>
     *
     * <p>
     * Example usage:
     *
     * <pre>
     *     // Create a new User object
     *     User user = new User();
     *
     *     // Set the id of the user
     *     UUID id = UUID.randomUUID();
     *     user.setId(id);
     *
     *     // Get the id of the user
     *     UUID userId = user.getId();
     *     System.out.println(userId); // Prints the unique identifier
     * </pre>
     *
     * </p>
     *
     * @see User
     * @see User#getId()
     * @see User#setId(UUID)
     * @since 1.0
     */
    private UUID id;

    /**
     * The name of a user.
     * <p>
     * This private field represents the name of a user. It is used to store the
     * name of a user object.
     * <p>
     * Example usage:
     * <pre>
     *     User user = new User();
     *     user.setName("John Doe");
     *     String name = user.getName();
     *     System.out.println(name); // prints "John Doe"
     * </pre>
     *
     * @see User
     * @see User#getName()
     * @see User#setName(String)
     * @since 1.0
     */
    private String name;

    /**
     * The date of birth of a user.
     * <p>
     * This private variable represents the date of birth of a user. It is used to store the user's
     * date of birth in the form of a LocalDate object.
     * <p>
     * Example usage:
     * <pre>
     *     User user = new User();
     *     LocalDate dob = LocalDate.of(1990, 5, 15);
     *     user.setDateOfBirth(dob);
     *     LocalDate userDob = user.getDateOfBirth();
     *     System.out.println(userDob); // prints "1990-05-15"
     * </pre>
     *
     * @see User
     * @see User#getDateOfBirth()
     * @see User#setDateOfBirth(LocalDate)
     * @since 1.0
     */
    private LocalDate dateOfBirth;

    /**
     * Converts this User object to a ResponseUser object for API responses.
     *
     * @return a ResponseUser object representing the extended User object
     *
     * @since 1.0
     */
    public ResponseUser toAPIResponse() {
        return new ResponseUser(this);
    }

}
