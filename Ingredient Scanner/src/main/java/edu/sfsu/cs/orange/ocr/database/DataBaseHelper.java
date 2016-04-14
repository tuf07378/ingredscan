package edu.sfsu.cs.orange.ocr.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import edu.sfsu.cs.orange.ocr.model.Food;

/**
 * Created by Rob on 4/12/2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper{

    //The Android's default system path of your application database.
    private static String DB_PATH = "/data/data/edu.sfsu.cs.orange.ocr/databases/";

    private static String DB_NAME = "sample.sqlite";

    private SQLiteDatabase myDataBase;

    private final Context myContext;

    /**
     * Constructor
     * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
     * @param context
     */
    public DataBaseHelper(Context context) {

        super(context, DB_NAME, null, 1);
        this.myContext = context;
    }

    /**
     * Creates a empty database on the system and rewrites it with your own database.
     * */
    public void createDataBase() throws IOException {

        boolean dbExist = checkDataBase();

        if(dbExist){
            //do nothing - database already exist
        }else{

            //By calling this method and empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.
            this.getReadableDatabase();

            try {

                copyDataBase();

            } catch (IOException e) {

                throw new Error("Error copying database");

            }
        }

    }

    /**
     * Check if the database already exist to avoid re-copying the file each time you open the application.
     * @return true if it exists, false if it doesn't
     */
    private boolean checkDataBase(){

        SQLiteDatabase checkDB = null;

        try{
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        }catch(SQLiteException e){

            //database does't exist yet.

        }

        if(checkDB != null){

            checkDB.close();

        }

        return checkDB != null ? true : false;
    }

    /**
     * Copies your database from your local assets-folder to the just created empty database in the
     * system folder, from where it can be accessed and handled.
     * This is done by transfering bytestream.
     * */
    private void copyDataBase() throws IOException{

        //Open your local db as the input stream
        InputStream myInput = myContext.getAssets().open(DB_NAME);

        // Path to the just created empty db
        String outFileName = DB_PATH + DB_NAME;

        //Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        //transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }

        //Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public void openDataBase() throws SQLException {

        //Open the database
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

    }

    @Override
    public synchronized void close() {

        if(myDataBase != null)
            myDataBase.close();

        super.close();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // Add your public helper methods to access and get content from the database.
    // You could return cursors by doing "return myDataBase.query(....)" so it'd be easy
    // to you to create adapters for your views.



    public List<Food> getListFood() {

        System.out.println("HERE 1");

        Food food = null;
        List<Food> foodList = new ArrayList<>();
        openDataBase();
        Cursor cursor = myDataBase.rawQuery("SELECT * FROM FOOD", null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            food = new Food(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
            foodList.add(food);
            cursor.moveToNext();
        }
        cursor.close();
        close();  //close database
        return foodList;
    }

    public String makefoodListString() {

        List<Food> foodList;
        foodList = getListFood();
        String foodString = "";
        for(int i = 0; i < foodList.size(); i++)
            foodString += foodList.get(i).getName() + " ";

        foodString += "sex";
        return foodString;
    }

    public String[] getFoodTags(String [] ingredient) {

        List<Food> foodList = new ArrayList<>();
        foodList = getListFood();
        String [] tagList = new String[100];

        int k = 0;

        for(int i = 0; i < ingredient.length; i++)
        {
            for(int j = 0; j < foodList.size(); j++) {
                if (foodList.get(j).getName() == ingredient[i]) {
                        tagList[k] = foodList.get(j).getTags();
                        k++;
                }
            }
        }


        return tagList;
    }

    public String makeTagListString(String [] tagList) {
        String tags = "";
        for(int i = 0; i < tagList.length; i++)
            tags += tagList[i];

        tags += "sex";
    return tags;
    }

}
