package com.worlds.myteaching;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.worlds.myteaching.custmlistview.CustomListViewActivity;
import com.worlds.myteaching.json.JsonActivity;
import com.worlds.myteaching.sharepreference_demo.SharedPrefLoginActivity;

public class MainActivity extends AppCompatActivity {
    private static Button btnSharePref, btnCustomList;
    AlertDialog.Builder dialogBuilder;
    AlertDialog alertDialog;
    ImageView imageView;
    private static final int IMAGE_PICK = 1000;
    private static final int PERMISSION_CODE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCustomList = findViewById(R.id.cListview);
        imageView = findViewById(R.id.image);
        Log.d("hello","hello");
        Log.d("hello","hello");


        Log.d("hello","hello pavan");
        Log.d("hello","hello pavan");
        Log.d("hello","hello pavan");


        btnSharePref = findViewById(R.id.btnSharedPref);
        btnSharePref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBuilder = new AlertDialog.Builder(MainActivity.this);
                View layoutView = getLayoutInflater().inflate(R.layout.custom_dialog_new, null);
                Button dialogButton = layoutView.findViewById(R.id.btndismiss);
                dialogBuilder.setView(layoutView);
                alertDialog = dialogBuilder.create();
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                alertDialog.show();
                dialogButton.setOnClickListener(new
                                                        View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                alertDialog.dismiss();
                                                            }
                                                        });

                startActivity(new Intent(getApplicationContext(), JsonActivity.class));


            }
        });

        btnCustomList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getApplicationContext(), btnCustomList);
                popupMenu.getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        return true;
                    }
                });
                //popupMenu.show();

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                        //permission not granted

                        String[] permission = {
                                Manifest.permission.READ_EXTERNAL_STORAGE};
                        requestPermissions(permission, PERMISSION_CODE);
                    } else {
                        pickFromGallery();
// permission denied
                    }
                } else {
                    pickFromGallery();

                }

                // startActivity(new Intent(getApplicationContext(), CustomListViewActivity.class));
            }
        });


    }

    private void pickFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_PICK);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK && requestCode == IMAGE_PICK) {
            imageView.setImageURI(data.getData());
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    pickFromGallery();
                } else {
                    Toast.makeText(getApplicationContext(), "Not granted", Toast.LENGTH_LONG).show();
                }

        }
    }

}
