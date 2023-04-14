package com.statusseverforwhatsapp.fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Environment;
import android.provider.DocumentsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.statusseverforwhatsapp.R;
import com.statusseverforwhatsapp.adapter.Image_Status_Adapter;
import com.statusseverforwhatsapp.model.WhatsappStatusModel;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;


public class ImageFragment extends Fragment {
    RecyclerView recyclerView_Image;
    SwipeRefreshLayout refreshLayout;
    private ArrayList<WhatsappStatusModel> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_image, container, false);
        super.onCreate(savedInstanceState);
        recyclerView_Image = root.findViewById(R.id.recycler_image);
        refreshLayout = root.findViewById(R.id.swipe_image);
        list = new ArrayList<>();
        // getData();
        refreshLayout.setOnRefreshListener(() -> {
            refreshLayout.setRefreshing(false);
        });
        WhatsappStatusModel model;

        String targetPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/media/com.whatsapp/WhatsApp/Media/.Statuses";

        Log.d("Files", "Path: " + targetPath);
        File f = new File(targetPath);
        File file[] = f.listFiles();
        Log.d("Files", "Size: " + file.length);
        for (int i = 0; i < file.length; i++) {
            File files = file[i];
            if (Uri.fromFile(files).toString().endsWith(".png") ||
                    Uri.fromFile(files).toString().endsWith(".jpg")) {
                model = new WhatsappStatusModel("whatsapp" + i, Uri.fromFile(files), file[i].getAbsolutePath(),
                        files.getPath());

                list.add(model);
                //here populate your listview
                Log.d("Files", "FileName:" + file[i].getName());
            }


        }
        Image_Status_Adapter adapter = new Image_Status_Adapter(list, getActivity());
        recyclerView_Image.setAdapter(adapter);
        Toast.makeText(getActivity(), "" + targetPath, Toast.LENGTH_SHORT).show();


        return root;
    }
}

   /* private void getData() {


        *//*File tragetDirector = new File(targetPath);


        File[] allfiles = tragetDirector.listFiles();

        Arrays.sort(allfiles, ((o1, o2) ->
                Long.compare(o2.lastModified(), o1.lastModified())));


        for (int i = 0; i < allfiles.length; i++) {
            File file = allfiles[i];
            if (Uri.fromFile(file).toString().endsWith(".png") ||
                    Uri.fromFile(file).toString().endsWith(".jpg")) {
                model = new WhatsappStatusModel("whatsapp" + i, Uri.fromFile(file), allfiles[i].getAbsolutePath(),
                        file.getName());

                list.add(model);*//*

    }*/

    /*@RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onActivityResult(int requestCode, int resultCode,
                                 Intent resultData) {
        Uri wa_status_uri = null;
        if (requestCode == 10001
                && resultCode == Activity.RESULT_OK) {
            // The result data contains a URI for the document or directory that
            // the user selected.

            if (resultData != null) {
                wa_status_uri = resultData.getData();
                // Perform operations on the document using its URI.
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE);
                // Optionally, specify a URI for the directory that should be opened in
                // the system file picker when it loads.

                 wa_status_uri = Uri.parse(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/media/com.whatsapp/WhatsApp/Media/.Statuses");
                intent.putExtra(DocumentsContract.EXTRA_INITIAL_URI, wa_status_uri);
                startActivityForResult(intent, 10001);
            }
            }
        }
    }*/


