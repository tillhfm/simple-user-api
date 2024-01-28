package de.trxsson.userapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


/**
 * Represents a user.
 * <p>
 * The User class encapsulates information about a user, including their ID, name,
 * and date of birth. The class provides getter and setter methods for each property.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    /**
     * The ID of a user.
     * <p>
     * This private field represents the ID of a user. It is used to store the unique identifier
     * for a user object. The ID is generated using UUID (Universally Unique Identifier) which
     * ensures uniqueness across different systems and time. The ID can be used to uniquely
     * identify a user in a system.
     * <p>
     * Example usage:
     * <pre>
     *     User user = new User();
     *     UUID id = UUID.randomUUID();
     *     user.setId(id);
     *     UUID userId = user.getId();
     *     System.out.println(userId); // prints the generated UUID
     * </pre>
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
     * This is a private field that represents the date of birth of a user. It is used to store
     * the user's date of birth as a string. The format of the date should be specified in a
     * consistent manner, such as using the ISO-8601 standard format (YYYY-MM-DD).
     * <p>
     * Example usage:
     * <pre>
     *     User user = new User();
     *     user.setDateOfBirth("1990-01-01");
     *     String dob = user.getDateOfBirth();
     *     System.out.println(dob); // prints "1990-01-01"
     * </pre>
     *
     * @see User
     * @see User#getDateOfBirth()
     * @see User#setDateOfBirth(String)
     * @since 1.0
     */
    private String dateOfBirth;

}
