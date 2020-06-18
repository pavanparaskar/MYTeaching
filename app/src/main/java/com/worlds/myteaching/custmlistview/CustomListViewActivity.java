package com.worlds.myteaching.custmlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.worlds.myteaching.MainActivity;
import com.worlds.myteaching.R;

public class CustomListViewActivity extends AppCompatActivity {

    ListView list;
    String[] web = {
            "One",
            "Two",
            "Three",
            "Fur",
            "Five",
            "Six",
            "Seven"
    };
    Integer[] imageId = {
            R.drawable.ic_android_black_24dp,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.three,
            R.drawable.abc,
            R.drawable.four

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        CustomList adapter = new
                CustomList(CustomListViewActivity.this, web, imageId);
        list = (ListView) findViewById(R.id.listview);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                PopupMenu popupMenu = new PopupMenu(getApplicationContext(), list);
                popupMenu.getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        return true;
                    }
                });
                popupMenu.show();

                Toast.makeText(CustomListViewActivity.this, "You Clicked at " + web[+position], Toast.LENGTH_SHORT).show();

            }
        });

    }
}
