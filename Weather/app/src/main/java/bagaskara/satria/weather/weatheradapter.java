package bagaskara.satria.weather;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;

import bagaskara.satria.weather.model.List;

public class weatheradapter extends RecyclerView.Adapter<weatheradapter.WeatherViewHolder>{
    Context context;
    java.util.List<List> list;

    public weatheradapter(Context context, java.util.List<List> list) {
        this.context = context;
        this.list = list;


    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.layoutcuaca,viewGroup,false);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder weatherViewHolder, int i) {
        Date date=new java.util.Date(list.get(i).getDt()*1000L);
        SimpleDateFormat sdf=new SimpleDateFormat("dd MM YYYY");
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT+7"));
        String formatteedDate=sdf.format(date);

    weatherViewHolder.date.setText(formatteedDate);
    weatherViewHolder.desc.setText(list.get(i).getWeather().get(0).getMain());  //penjelasan ????

    String urlIcon="https://api.openweathermap.org/img/w/"+list.get(i).getWeather().get(0).getIcon()+".png";
    Picasso.get().load(urlIcon).into(weatherViewHolder.wheaterIcon);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder{
        ImageView wheaterIcon;
        TextView date,desc;

        public WeatherViewHolder(@NonNull View itemView) {
            super(itemView);
            wheaterIcon=itemView.findViewById(R.id.fotocuaca);
            date=itemView.findViewById(R.id.date);
            desc=itemView.findViewById(R.id.cuaca);
        }
    }
    }
