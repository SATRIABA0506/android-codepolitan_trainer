package bagaskara.satria.restclient;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {
    ArrayList<Photo>photo=new ArrayList<>();   //buat dulu class Photo
    RecyclerView recyclerView; //tipe data RecyclerView mempunyai variabel recyclerView
    AdapterPhoto adapterPhoto; //tipe data AdapterPhoto mempunyai adapterPhoto

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView); //inisialisasi objek ngambil dari id android:id="@+id/recyclerView" pada content_main.xml
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//Sebuah RecyclerView dapat menampilkan datanya dalam bentuk Linear, Grid, atau StaggeredGrid. Kita akan menampilkan datanya dalam bentuk Linear (menyusun ke bawah).
                                                                            //disini menggunakan linear

        final RecyclerView recyclerView=findViewById(R.id.recyclerView);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);//menset toolbar pada bagian atas  kanan bergambar titik 3
        setSupportActionBar(toolbar);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);//mengabil dari interface.java



        Call<List<Photo>> photosCall=apiInterface.getPhotos();
        photosCall.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                List<Photo>photos=response.body();
                Log.d("MainActivity",String.valueOf(photos.size()));

                adapterPhoto=new AdapterPhoto(photos,MainActivity.this);
                recyclerView.setAdapter(adapterPhoto);
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                Log.e("MainActivity",t.toString());
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);

    }
}
