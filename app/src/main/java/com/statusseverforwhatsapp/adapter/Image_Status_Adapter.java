package com.statusseverforwhatsapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.statusseverforwhatsapp.R;
import com.statusseverforwhatsapp.Util;
import com.statusseverforwhatsapp.model.WhatsappStatusModel;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Image_Status_Adapter extends RecyclerView.Adapter<Image_Status_Adapter.ViewHolder> {

    private ArrayList<WhatsappStatusModel> list=null;
    private Context context;
    private LayoutInflater inflater;
    private String savefilePath = Util.RootDirectoryWhatsapp+"/";

    public Image_Status_Adapter(ArrayList<WhatsappStatusModel> list, FragmentActivity activity) {
    }


    @NonNull
    @Override
    public Image_Status_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (inflater==null){
            inflater = LayoutInflater.from(parent.getContext());
        }
        View view = LayoutInflater.from(context).inflate(R.layout.image_layout, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Image_Status_Adapter.ViewHolder holder, int position) {

        WhatsappStatusModel item=list.get(position);
       /* if (item.getUri().toString().endsWith(".mp4")){

        }*/
        Glide.with(context).load(item.getPath()).into(holder.img_status);

        holder.img_status.setOnClickListener(v -> {
            Util.createFileFolder();
            final String path=item.getPath();
            final File file=new File(path);
            File destFile=new File(savefilePath);

            try {
                FileUtils.copyFileToDirectory(file,destFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Toast.makeText(context, "Saved to : "+savefilePath, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_status;
        CheckBox imgCheck;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_status=itemView.findViewById(R.id.image_status);
            imgCheck=itemView.findViewById(R.id.checkbox_image);

        }
    }
}
