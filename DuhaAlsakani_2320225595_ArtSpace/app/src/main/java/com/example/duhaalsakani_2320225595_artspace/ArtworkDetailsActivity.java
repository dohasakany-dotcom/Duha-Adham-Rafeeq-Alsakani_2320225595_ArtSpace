package com.example.duhaalsakani_2320225595_artspace;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.duhaalsakani_2320225595_artspace.databinding.ActivityArtworkDetailsBinding;
import com.example.duhaalsakani_2320225595_artspace.databinding.ActivityMainBinding;

public class ArtworkDetailsActivity extends AppCompatActivity {
 public static ActivityArtworkDetailsBinding detailsBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        detailsBinding=ActivityArtworkDetailsBinding.inflate(getLayoutInflater());
        setContentView(detailsBinding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        String title = getIntent().getStringExtra("title");
        String artist = getIntent().getStringExtra("artist");
        String year = getIntent().getStringExtra("year");

        detailsBinding.textArtworkInfo.setText(
                "Title: " + title + "\n" +
                "Artist: " + artist + "\n" +
                "Year: " + year
        );

        detailsBinding.btnBack.setOnClickListener(view -> {
            finish();
        });

        detailsBinding.btnVisitWebsite.setOnClickListener(view -> {

            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.google.com"));

           // هنا نفس مشكلة المحاضرة الاخيرة غالبا التحديث ما بخليه يفتح ف راح اشيلها زي معملنا وخلص
                    // if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
    //}
                );






    }


}