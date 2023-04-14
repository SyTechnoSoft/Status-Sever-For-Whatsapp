package com.statusseverforwhatsapp.fragments;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.statusseverforwhatsapp.MainActivity;
import com.statusseverforwhatsapp.R;
import com.statusseverforwhatsapp.StatusActivity;
import com.statusseverforwhatsapp.VideoPlayActivity;
import com.statusseverforwhatsapp.adapter.VideoAdapter;
import com.statusseverforwhatsapp.model.Video;

import java.io.File;
import java.util.ArrayList;


public class VideoFragment extends Fragment {
    /*private final ActivityResultLauncher<String> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), result -> {
        if (result) {
            getVideos();
        }
    });
    ArrayList<Video> arrayList = new ArrayList<>();
    RecyclerView recyclerView;
*/
    public VideoFragment() {
        // Required empty public constructor
    }


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_image, container, false);
        super.onCreate(savedInstanceState);
        return root;
       /* recyclerView =  root.findViewById(R.id.video);
        recyclerView.setHasFixedSize(true);
       recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            activityResultLauncher.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        } else if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            activityResultLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE);
        } else {
            getVideos();
        }
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        getVideos();
    }

    private void getVideos() {
        arrayList.clear();
       // String path = "/storage/emulated/0/Movies";
        String path="content://com.android.externalstorage.documents/tree/primary%3AAndroid%2Fmedia/document/primary%3AAndroid%2Fmedia%2Fcom.whatsapp%2FWhatsApp%2FMedia%2F.Statuses";
        File file = new File(path);
        File[] files = file.listFiles();
        if (files != null) {
            for (File file1 : files) {
                if (file1.getPath().endsWith(".mp4")) {
                    arrayList.add(new Video(file1.getPath()));
                }
            }
        }
        VideoAdapter adapter = new VideoAdapter(getActivity(), arrayList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener((view, path1) -> startActivity(new Intent(getActivity(), VideoPlayActivity.class).putExtra("video", path1)));
    }*/
    }
}