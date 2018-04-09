package uk.ac.vt71brighton.easylist.data;

/**
 * Created by volodymyrtkachenko on 12/03/2018.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import uk.ac.vt71brighton.easylist.data.EasyContract.EListEntry;

/**
 * Created by volodymyrtkachenko on 09/03/2018.
 */

/**
 * Database helper for the app. Manages database creation and version management.
 */
public class EasyDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = EasyDbHelper.class.getSimpleName();

    /** Name of the database file */
    private static final String DATABASE_NAME = "easylist.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * Constructs a new instance of {@link EasyDbHelper}.
     *
     * @param context of the app
     */
    public EasyDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the items table
        String SQL_CREATE_PETS_TABLE =  "CREATE TABLE " + EListEntry.TABLE_NAME + " ("
                + EListEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + EListEntry.COLUMN_EL_NAME + " TEXT NOT NULL, "
                + EListEntry.COLUMN_EL_DESC + " TEXT, "
                + EListEntry.COLUMN_EL_GENDER + " INTEGER NOT NULL, "
                + EListEntry.COLUMN_EL_AGE + " INTEGER NOT NULL DEFAULT 0);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_PETS_TABLE);
    }

    /**
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
    }
}