package bagaskara.satria.restclient;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.security.AccessControlContext;
import java.util.ArrayList;
import java.util.List;

public class AdapterPhoto extends RecyclerView.Adapter<AdapterPhoto.PhotoViewHolder> {
    List<Photo> photo;
    Context context;

    public AdapterPhoto(List<Photo> photo,Context context) {
        this.photo = photo;
        this.context = context;
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.photo,parent,false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        Photo viewphoto=photo.get(position);

        holder.judul.setText(viewphoto.getTitle());

        Picasso.get().load(viewphoto.getThumbnailUrl()).into(holder.image);



    }

    @Override
    public int getItemCount() {
        return photo.size();
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder{
        TextView judul;
        ImageView image;



        public PhotoViewHolder(View itemView) {
            super(itemView);
            judul=itemView.findViewById(R.id.judulPhoto);
            image=itemView.findViewById(R.id.viewphoto);
        }
    }
}
