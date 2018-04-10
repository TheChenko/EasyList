package uk.ac.vt71brighton.easylist.data;

/**
 * Created by volodymyrtkachenko.
 */

import android.net.Uri;
import android.content.ContentResolver;
import android.provider.BaseColumns;

/**
 * API Contract for the EasyList app.
 */
public final class EasyContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private EasyContract() {}

    /**
     * The "Content authority" is a name for the entire content provider, similar to the
     * relationship between a domain name and its website.  A convenient string to use for the
     * content authority is the package name for the app, which is guaranteed to be unique on the
     * device.
     */
    public static final String CONTENT_AUTHORITY = "uk.ac.vt71brighton.easylist";

    /**
     * Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
     * the content provider.
     */
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    /**
     * Possible path (appended to base content URI for possible URI's)
     * For instance, content://uk.ac.vt71brighton.easylist/elist/ is a valid path for
     * looking at list data. content://uk.ac.vt71brighton.easylist/lorem/ will fail,
     * as the ContentProvider hasn't been given any information on what to do with "lorem".
     */
    public static final String PATH_EList = "elist";

    /**
     * Inner class that defines constant values for the item database table.
     * Each entry in the table represents a single itemlist.
     */
    public static final class EListEntry implements BaseColumns {

        /** The content URI to access the item data in the provider */
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_EList);

        /**
         * The MIME type of the {@link #CONTENT_URI} for a list of items.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_EList;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single item.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_EList;

        /** Name of database table for items */
        public final static String TABLE_NAME = "elist";

        /**
         * Unique ID number for the item (only for use in the database table).
         *
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Name of the item.
         *
         * Type: TEXT
         */
        public final static String COLUMN_EL_NAME ="name";

        /**
         * Description of the item.
         *
         * Type: TEXT
         */
        public final static String COLUMN_EL_DESC = "desc";

        /**
         * Gender of the item.
         *
         * The only possible values are {@link #GENDER_UNKNOWN}, {@link #GENDER_MALE},
         * or {@link #GENDER_FEMALE}.
         *
         * Type: INTEGER
         */
        public final static String COLUMN_EL_GENDER = "gender";

        /**
         * Age of the item.
         *
         * Type: INTEGER
         */
        public final static String COLUMN_EL_AGE = "age";

        /**
         * Allergies.
         *
         * Type: TEXT
         */
        public final static String COLUMN_EL_ALLERGIES ="allergies";

        /**
         * Nationality.
         *
         * Type: TEXT
         */
        public final static String COLUMN_EL_NATIONALITY ="nationality";

        /**
         * Languages spoken.
         *
         * Type: TEXT
         */
        public final static String COLUMN_EL_LANG ="lang";

        /**
         * Contact number.
         *
         * Type: TEXT
         */
        public final static String COLUMN_EL_CONTACT = "contact";

        /**
         * Possible values for the gender of the item.
         */
        public static final int GENDER_UNKNOWN = 0;
        public static final int GENDER_MALE = 1;
        public static final int GENDER_FEMALE = 2;

        /**
         * Returns whether or not the given gender is {@link #GENDER_UNKNOWN}, {@link #GENDER_MALE},
         * or {@link #GENDER_FEMALE}.
         */
        public static boolean isValidGender(int gender) {
            if (gender == GENDER_UNKNOWN || gender == GENDER_MALE || gender == GENDER_FEMALE) {
                return true;
            }
            return false;
        }
    }

}
