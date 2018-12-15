package bagaskara.satria.mydatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "todo_db";
    private static final String TABLE_NAME = "todo_table";


    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE todo_table('_id' INTEGER PRIMARY KEY,'name' TEXT,'priority' INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS todo_table");
        onCreate(db);


    }
    public long updateItem(ItemTodo todo) {
//        getWritableDatabase().execSQL("INSERT INTO todo_table"+todo.getName()+);

        ContentValues values = new ContentValues();
        values.put("name", todo.getName());
        values.put("priority", todo.getPriority());
        long id = getWritableDatabase().update("todo_table",values,"_id=?",new String[]{String.valueOf(todo.getId())});
        Log.d("MyDatabase","addItem : "+id);
        return id;
    }

    public long addItem(ItemTodo todo) {
//        getWritableDatabase().execSQL("INSERT INTO todo_table"+todo.getName()+);

        ContentValues values = new ContentValues();
        values.put("name", todo.getName());
        values.put("priority", todo.getPriority());
        long id = getWritableDatabase().insert("todo_table", null, values);
        Log.d("MyDatabase","addItem : "+id);
        return id;
    }

    public List<ItemTodo> getAll() {
        String sql = "SELECT*FROM todo_table";
        List<ItemTodo> items = new ArrayList<>();
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);
        if(cursor.moveToFirst()){
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                int priority = cursor.getInt(2);
                ItemTodo item = new ItemTodo(id, priority, name);
                items.add(item);
            }while(cursor.moveToNext());
            cursor.close();

        }
        return items;
    }
    public  void delete(int id){
        getWritableDatabase().delete("todo_table","_id=?",new String[]{String.valueOf(id)});

    }

}