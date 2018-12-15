package bagaskara.satria.codepolitanreader;

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

import java.util.ArrayList;

public class ArtikelListAdapter extends RecyclerView.Adapter<ArtikelListAdapter.ArtikelViewHolder> {
        ArrayList<Artikel>data;
        Context context;

        public ArtikelListAdapter(ArrayList<Artikel>data,Context context){
            this.data=data;
            this.context=context;
        }
    @NonNull
    @Override
    public ArtikelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.artikel,parent,false);
        return  new ArtikelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtikelViewHolder holder, int position) {
    final Artikel artikel=data.get(position);

    holder.tvPenulis.setText(artikel.getPenulis());
    holder.tvJudul.setText(artikel.getJudul());

    Picasso.get().load(artikel.getThumbnail()).into(holder.ivThumbnail);

    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent pinIntent=new Intent(context,DetailActivity.class);
            pinIntent.putExtra("ARTIKEL",artikel);
            context.startActivity(pinIntent);

        }
    });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ArtikelViewHolder extends RecyclerView.ViewHolder{
        TextView tvJudul,tvPenulis;
        ImageView ivThumbnail;
        public ArtikelViewHolder(View itemView) {
            super(itemView);
            tvJudul=itemView.findViewById(R.id.tvJudul);
            tvPenulis=itemView.findViewById(R.id.tvpenulis);
            ivThumbnail=itemView.findViewById(R.id.ivSampul);
        }
    }
}
