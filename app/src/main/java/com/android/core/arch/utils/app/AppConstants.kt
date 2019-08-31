package com.android.core.arch.utils.app

/**
 * App constants
 * @author  Rohit Anvekar
 * @since   2019-02-14
 */
class AppConstants private constructor()// This utility class is not publicly instantiable
{


    object Patterns {
        val EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
        val USERNAME_PATTERN = "^[a-zA-Z0-9]{3,20}$"
        val NAME_PATTERN = "^(?!(\\S+[\\-']$))(?!(\\S*[\\-']{2}\\S*$))(?=\\S{1,35}$)([a-zA-Z]['\\-a-zA-Z]*)$"
        val PASSWORD_PATTERN = "^(?=.*\\d)(?=.*[A-Za-z])(?!^[~!@#\\$%^&*()_+\\-=]*$)([a-zA-Z0-9~!@#\\$%^&*()_+\\-=]{6,20})$"
    }

    companion object {

        val STATUS_CODE_SUCCESS = "success"
        val STATUS_CODE_FAILED = "failed"

        val API_STATUS_CODE_LOCAL_ERROR = 0

        val DB_NAME = "testing.db"
        val PREF_NAME = "testing_pref"

        val NULL_INDEX = -1L

        val SEED_DATABASE_OPTIONS = "seed/options.json"
        val SEED_DATABASE_QUESTIONS = "seed/questions.json"

        val TIMESTAMP_FORMAT = "yyyyMMdd_HHmmss"
    }

}
