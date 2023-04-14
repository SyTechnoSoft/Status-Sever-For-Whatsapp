package com.statusseverforwhatsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.util.Log;
import android.view.View;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.statusseverforwhatsapp.model.WhatsappStatusModel;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<WhatsappStatusModel> list = null;
    private RecyclerView recyclerView;
    CardView btn_webWhatsapp, btn_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermission();
        SwipeRefreshLayout refreshLayout = findViewById(R.id.refreshLayout);
        btn_webWhatsapp = findViewById(R.id.card_web);
        btn_status = findViewById(R.id.card_sever);
        //checkWhatsAppPermission();


        refreshLayout.setOnRefreshListener(() -> {
            refreshLayout.setRefreshing(false);
        });

        btn_webWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, WhatsappWeb.class));
            }
        });

   btn_status.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           startActivity(new Intent(MainActivity.this,StatusActivity.class));
       }
   });
    }

    private void checkWhatsAppPermission() {
       /* // Choose a directory using the system's file picker.
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE);
        // Optionally, specify a URI for the directory that should be opened in
        // the system file picker when it loads.

        Uri wa_status_uri = Uri.parse(Environment.getExternalStorageDirectory().getAbsolutePath() + "/WhatsApp/Media/.Statuses/");  //"content://com.android.externalstorage.documents/tree/primary%3AAndroid%2Fmedia/document/primary%3AAndroid%2Fmedia%2Fcom.whatsapp%2FWhatsApp%2FMedia%2F.Statuses");
        intent.putExtra(DocumentsContract.EXTRA_INITIAL_URI, wa_status_uri);
        startActivityForResult(intent, 10001);
        Toast.makeText(this, ""+wa_status_uri, Toast.LENGTH_SHORT).show();*/
        // Choose a directory using the system's file picker.
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE);
        // Optionally, specify a URI for the directory that should be opened in
        // the system file picker when it loads.

        Uri wa_status_uri = Uri.parse("content://com.android.externalstorage.documents/tree/primary%3AAndroid%2Fmedia/document/primary%3AAndroid%2Fmedia%2Fcom.whatsapp%2FWhatsApp%2FMedia%2F.Statuses");
        intent.putExtra(DocumentsContract.EXTRA_INITIAL_URI, wa_status_uri);
        startActivityForResult(intent, 10001);
    }


    private void checkPermission() {
        Dexter.withContext(this)
                .withPermissions(
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                ).withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {

                        if (!report.areAllPermissionsGranted()) {
                            checkPermission();

                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {/* ... */}
                }).check();
    }
}