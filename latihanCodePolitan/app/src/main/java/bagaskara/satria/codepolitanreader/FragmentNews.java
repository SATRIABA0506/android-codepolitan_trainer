package bagaskara.satria.codepolitanreader;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class FragmentNews extends AppCompatActivity {
    ArrayList<Artikel> kumpulanArtikel = new ArrayList<>();
    RecyclerView recyclerView;
    ArtikelListAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_news);

        kumpulanArtikel.add(new Artikel("100 Fungsi Paling Populer di PHP",
                "Muhammad Budhiluhoer",
                "http://www.codepolitan.com/100-fungsi-paling-populer-di-php5b4c1cea92f36",
                "https://static.cdncdpl.com/270x135/2dd7d3ba70bcbe34f8b0d7242c773a78/php_100_function.png"));

        kumpulanArtikel.add(new Artikel("Library JavaScript Menarik Tahun 2018",
                "Muhammad Budhiluhoer",
                "http://www.codepolitan.com/library-javascript-menarik-tahun2018-5b45b6a00c549",
                "https://static.cdncdpl.com/270x135/2dd7d3ba70bcbe34f8b0d7242c773a78/js.png"));

        kumpulanArtikel.add(new Artikel("7 Prinsip Dasar dalam Mendesain Button",
                "Geeraldo Jose",
                "http://www.codepolitan.com/7-prinsip-dasar-dalam-mendesain-button5b4471e91b53b",
                "https://static.cdncdpl.com/270x135/d3cf87e0e00038b907551b1638c4a94a/Cover(7_Prinsip_Dasar_dalam_Mendesain _Button)-01.jpg"));

        kumpulanArtikel.add(new Artikel("20 Situs dengan Efek Parallax Untuk Inspirasi",
                "Takagi Fujimaru",
                "http://www.codepolitan.com/23-situs-dengan-efekparallax-untuk-inspirasi-5b14d6f83521a",
                "https://static.cdncdpl.com/270x135/998b78e349061b4971c0a2b0e8d6be41/melanie.png"));

        kumpulanArtikel.add(new Artikel("PHP 7.3: A Look at JSON Error Handling",
                "Muhamad Jalaludin",
                "http://www.codepolitan.com/php-73-a-look-at-json-error-handling5b4c3ac24bcb9",
                "https://static.cdncdpl.com/270x135/6f69c54dd7b1279b3420a3d7d7d7b237/cover-01.jpg"));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter=new ArtikelListAdapter(kumpulanArtikel,getApplicationContext());//////////////
        recyclerView.setAdapter(adapter);
    }
}