package com.example.baitung;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    ListView listView;
    Adapter adapter;
    database Database;
    ArrayList<Restaurant> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Database = new database(this,"NameDataBase",null,1);
        listView = findViewById(R.id.list);
//        database.Them(new Restaurant("1","Hung","NamDung",9.2));
//        database.Them(new Restaurant("2","Hung","NamDung",9.2));
//        database.Them(new Restaurant("3","Hung","NamDung",9.2));
//        database.Them(new Restaurant("4","Hung","NamDung",9.2));
        Cursor cursor = Database.Sqlgetdata("select * from Restaurant");
        while (cursor.moveToNext()){
            arrayList.add(new Restaurant(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getDouble(3)
            ));
        }
        adapter = new Adapter(this,R.layout.line_layout,arrayList);
        listView.setAdapter(adapter);
    }

}
