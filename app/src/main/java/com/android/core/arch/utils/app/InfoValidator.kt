package com.android.core.arch.utils.app

import java.util.regex.Pattern

/**
 * InfoValidator Class
 * @author  Rohit Anvekar
 * @since   2019-02-14
 */
object InfoValidator {

    val MIN_ZIP_CODE_LENGTH = 4
    val MAX_ZIP_CODE_LENGTH = MIN_ZIP_CODE_LENGTH + 1

    /**
     * Method to check if the passed string in empty or not
     *
     * @param valueToCheck the string value
     * @return true if the string is not null or blank, false otherwise
     */
    fun isNotNullOrBlank(valueToCheck: String?): Boolean {
        return null != valueToCheck && valueToCheck.trim { it <= ' ' } != ""
    }

    /**
     * Method to check if [Collection] is null or empty
     *
     * @param collection the Collection instance to be checked for non-empty
     * @return true if collection has at-least one item
     */
    fun isValidCollection(collection: Collection<*>?): Boolean {
        return null != collection && !collection.isEmpty()
    }

    /**
     * Method to check the supplied string is a valid email
     *
     * @param val string to be checked for email-validation
     * @return true if valid email, false otherwise
     */
    fun isValidEmail(`val`: String): Boolean {
        val emailPattern = Pattern.compile(AppConstants.Patterns.EMAIL_PATTERN)

        return isNotNullOrBlank(`val`) && emailPattern.matcher(`val`).matches()
    }


    /**
     * Method to check whether password is valid as per regex mention on AppConstants
     *
     * @param password
     * @return
     */
    fun isValidPassword(password: String): Boolean {
        val passwordPattern = Pattern.compile(AppConstants.Patterns.PASSWORD_PATTERN)
        if (!isNotNullOrBlank(password)) {
            return false
        } else if (password.length < 6 || password.length > 20) {
            return false
        } else if (!passwordPattern.matcher(password).matches()) {
            return false
        }
        return true
    }


    fun isValidZipCode(zipCode: String): Boolean {
        return isNotNullOrBlank(zipCode) &&
                zipCode.length >= MIN_ZIP_CODE_LENGTH &&
                zipCode.length <= MAX_ZIP_CODE_LENGTH
    }

    fun isValidMobileNumber(mobileNumber: String): Boolean {
        val REGEX_PATTERN_CONTACT_NUMBER = "\\+?(\\d{10,15}|\\(?\\d{3}\\)?[-.\\s]\\d{3}[-.\\s]\\d{4})"

        return isNotNullOrBlank(mobileNumber) && Pattern.compile(REGEX_PATTERN_CONTACT_NUMBER)
                .matcher(mobileNumber).matches()
    }


    /**
     * Method to check whether login credentials are valid as per rule define for the application.
     *
     * @param email
     * @param password
     * @return
     */
    fun isValidLogin(email: String, password: String): Boolean {
        return isValidEmail(email) && isValidPassword(password)
    }
}
