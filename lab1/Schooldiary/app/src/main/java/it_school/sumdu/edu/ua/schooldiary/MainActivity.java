package it_school.sumdu.edu.ua.schooldiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static final String TABLE_DIARY = "mydiarytable";
    Button btnAdd, btnGetData;
    EditText txtSubject, txtDate, txtTask, txtDateQuery;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd   = (Button) findViewById(R.id.button);
        btnAdd.setOnClickListener(this);
        btnGetData = (Button) findViewById(R.id.button2);
        btnGetData.setOnClickListener(this);

        txtSubject = (EditText) findViewById(R.id.editText);
        txtDate = (EditText) findViewById(R.id.editText2);
        txtTask = (EditText) findViewById(R.id.editText3);
        txtDateQuery   = (EditText) findViewById(R.id.editText4);

        dbHelper = new DBHelper(this);
    }

    @Override
    public void onClick(View v) {

        ContentValues cv = new ContentValues();
        String subject = txtSubject.getText().toString();
        String date = txtDate.getText().toString();
        String task = txtTask.getText().toString();
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        switch (v.getId()) {
            case R.id.button:
                cv.put("subject", subject);
                cv.put("date", date);
                cv.put("task", task);
                db.insert("mydiarytable", null, cv);
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Нове домашнє завдання додано в щоденник " ,
                        Toast.LENGTH_SHORT);
                toast.show();
                txtSubject.getText().clear();
                txtDate.getText().clear();
                txtTask.getText().clear();
                break;
            case R.id.button2:
                List<String> subjectlist = new ArrayList<String>();
                List<String> tasklist= new ArrayList<String>();
                String dateQuery = txtDateQuery.getText().toString();
                String sqlQuery = "select * "
                        + "from " + TABLE_DIARY
                        +  " where date = ?" ;
                Cursor c = db.rawQuery(sqlQuery, new String[]{dateQuery});
                String cursorSubject, cursorTask;
                if (c.moveToFirst()) {
                    do {
                        cursorSubject = c.getString(c.getColumnIndex("subject"));
                        subjectlist.add(cursorSubject);
                        cursorTask = c.getString(c.getColumnIndex("task"));
                        tasklist.add(cursorTask);
                    } while (c.moveToNext());
                }
                c.close();
                if ((subjectlist.isEmpty())&&(tasklist.isEmpty())) {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "На цю дату домашнє завдання відсутнє ", Toast.LENGTH_LONG);
                    t.show();
                } else {
                    Intent intent = new Intent(this, DiaryDetail.class);
                    intent.putStringArrayListExtra("subjectlist", (ArrayList<String>) subjectlist);
                    intent.putStringArrayListExtra("tasklist", (ArrayList<String>) tasklist);
                    startActivity(intent);
                }
                break;
        }
        dbHelper.close();
    }

    class DBHelper extends SQLiteOpenHelper {

        public   DBHelper(Context context) {
            super(context, "myDiary", null, 1);
        }

        @Override
        public   void   onCreate(SQLiteDatabase db) {

            db.execSQL("create   table   mydiarytable    ("
                    + "id    integer   primary    key    autoincrement,"
                    + "subject   text,"
                    + "date   text,"
                    + "task   text"
                    + ");");
        }

        @Override
        public   void   onUpgrade(SQLiteDatabase db,  int    oldVersion,  int    newVersion) {


        }
    }
}
