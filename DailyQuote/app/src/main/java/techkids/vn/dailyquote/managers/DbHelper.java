package techkids.vn.dailyquote.managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

import techkids.vn.dailyquote.models.Quote;

/**
 * Created by apple on 10/13/16.
 */

public class DbHelper extends SQLiteAssetHelper {

    public static final String DATABASE_NAME = "quote.db";
    public static final int DATABASE_VERSION = 1;

    private static final String TAG = DbHelper.class.toString();

    /* ------------------------ QUOTE ------------------------ */
    public static final String QUOTE_TABLE_NAME = "tbl_quote";
    public static final String QUOTE_COLUMN_TITLE = "title";

    public static final String QUOTE_COLUMN_CONTENT = "content";
    public static final String[] QUOTE_COLUMNS = new String[] {
            QUOTE_COLUMN_TITLE,
            QUOTE_COLUMN_CONTENT
    };

    private DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public List<Quote> getAllQuotes() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Quote> quoteArrayList = new ArrayList<>();
        Cursor cursor = db.query(QUOTE_TABLE_NAME, QUOTE_COLUMNS, null, null, null, null, null);
        while(cursor.moveToNext()) {
            quoteArrayList.add(createQuote(cursor));
        }
        db.close();

        return quoteArrayList;
    }

    public Quote selectRandomQuote() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(QUOTE_TABLE_NAME,
               QUOTE_COLUMNS, null,null,null,null,"RANDOM()", "1");
        Quote quote = null;
        if (cursor.moveToNext()) {
            quote = createQuote(cursor);
        }
        db.close();
        return quote;
    }

    public void insertQuote(Quote quote) {
        Log.d(TAG, String.format("Inserting a quote %s", quote.toString()));

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(QUOTE_COLUMN_TITLE, quote.getTitle());
        contentValues.put(QUOTE_COLUMN_CONTENT, quote.getContent());
        db.insert(QUOTE_TABLE_NAME, null, contentValues);
        db.close();
    }

    private Quote createQuote(Cursor cursor) {
        int titleIndex = cursor.getColumnIndex("title");
        int contentIndex = cursor.getColumnIndex("content");
        String title = cursor.getString(titleIndex);
        String content = cursor.getString(contentIndex);
        Quote quote = new Quote(content, title);
        return quote;
    }

    private static DbHelper instance;

    public static DbHelper getInstance() {
        return instance;
    }

    public static void init(Context context) {
        instance = new DbHelper(context);
    }
}
