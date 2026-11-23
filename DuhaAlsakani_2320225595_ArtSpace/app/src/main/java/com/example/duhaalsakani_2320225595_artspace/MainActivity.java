package com.example.duhaalsakani_2320225595_artspace;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.duhaalsakani_2320225595_artspace.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
 public static ActivityMainBinding mainBinding;
    private int artworkNumber = 0;

    private int[] images = {
            R.drawable.first,
            R.drawable.second,
            R.drawable.third,
            R.drawable.four,
            R.drawable.five,
            R.drawable.six
    };

    private String[] titles = {
            "Sunset Dreams",
            " The Mona Lisa ",
            "Ocean Memories",
            "Golden Horizon",
            "Colors of Life",
            "The Last Light"
    };

    private String[] artists = {
            "Olivia Bennett",
            "Leonardo da Vinci",
            "Sophia Williams",
            "Ethan Brooks",
            "Isabella Morgan",
            "Lucas Anderson"
    };

    private String[] years = {
            "2018",
            "1503–1519",
            "2019",
            "2021",
            "2022",
            "2023"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            artworkNumber = savedInstanceState.getInt("artworkNumber", 0);
        }
        EdgeToEdge.enable(this);
        mainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mainBinding.btnNext.setOnClickListener(view -> {
            if (artworkNumber < 5) {
                artworkNumber++;
                displayArtwork();
            }
        });

        mainBinding.btnPrevious.setOnClickListener(view -> {
            if (artworkNumber > 0) {
                artworkNumber--;
                displayArtwork();
            }
        });

        displayArtwork();

        mainBinding.imageArtwork.setOnClickListener(view -> {

            Intent intent = new Intent(MainActivity.this, ArtworkDetailsActivity.class);

            intent.putExtra("title", titles[artworkNumber]);
            intent.putExtra("artist", artists[artworkNumber]);
            intent.putExtra("year", years[artworkNumber]);

            startActivity(intent);
        });



    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("artworkNumber", artworkNumber);
    }

    private void displayArtwork() {

        mainBinding.imageArtwork.setImageResource(images[artworkNumber]);

        mainBinding.textTitle.setText(titles[artworkNumber]);

        mainBinding.textArtist.setText(artists[artworkNumber] + " - " + years[artworkNumber]);

        mainBinding.textCounter.setText((artworkNumber + 1) + "/6");

        mainBinding.btnPrevious.setEnabled(artworkNumber != 0);

        mainBinding.btnNext.setEnabled(artworkNumber != 5);
    }
}