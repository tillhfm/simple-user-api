package de.trxsson.userapi.entity;

import lombok.Getter;

import java.time.LocalDate;
import java.time.Period;

/**
 * Represents a response user.
 * <p>
 * The ResponseUser class extends the User class and calculates their age and whether they are an adult.
 * It is used for API responses.
 *
 * @see User
 * @since 1.0
 */
@Getter
public class ResponseUser extends User {

    /**
     * The package-private constructor to create a new ResponseUser.
     * <p>
     * Calculates the age and determines if the user is an adult.
     *
     * @param user the user object for which to calculate the age and determine if they are an adult
     */
    protected ResponseUser(User user) {
        super(user.getId(), user.getName(), user.getDateOfBirth());
        age = getDateOfBirth().until(LocalDate.now()).getYears();
        isAdult = age >= 18;
    }

    /**
     * The age of a user.
     * <p>
     * This private final variable represents the age of a user. It is used to store the calculated age
     * of the user based on their date of birth and the current date.
     *
     * @see ResponseUser
     * @see ResponseUser#getAge()
     * @since 1.0
     */
    private final int age;

    /**
     * Represents whether a user is an adult.
     * <p>
     * This private final variable represents whether a user is considered an adult. It is used to store
     * the boolean value indicating if the user is 18 years or older.
     *
     * @see ResponseUser
     * @see ResponseUser#isAdult()
     * @since 1.0
     */
    private final boolean isAdult;

}
