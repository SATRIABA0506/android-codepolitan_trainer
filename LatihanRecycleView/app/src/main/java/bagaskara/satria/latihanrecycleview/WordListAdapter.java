package bagaskara.satria.latihanrecycleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.sql.Struct;
import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    LinkedList<String>mWordList;
    Context context;

    public WordListAdapter(LinkedList<String> mWordList, Context context) {
            this.mWordList = mWordList;
            this.context = context;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view=LayoutInflater.from(context).inflate(R.layout.wordlist_item, parent,false);
        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        String title=mWordList.get(position);
        holder.titleTextView.setText(title);

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //
//            }
//        });//////penggunaan onclick selain dengan (class  WordViewHolder) dimulai dari holder di baris 37 cara selain dengan worldview holder onclick di samain dengan onclick di class  WordViewHolder


    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }

    class  WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView titleTextView;

        public WordViewHolder(View itemView) {
            super(itemView);
            titleTextView=itemView.findViewById(R.id.word_title);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position=getLayoutPosition();
            String title = mWordList.get(position);
            mWordList.set(position,"Clicked" +title);
            notifyDataSetChanged();
        }
    }
}
