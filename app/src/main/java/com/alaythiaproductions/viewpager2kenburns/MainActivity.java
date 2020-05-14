package com.alaythiaproductions.viewpager2kenburns;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 locationsViewPager = findViewById(R.id.locations_viewpager);

        List<TravelLocation> travelLocations = new ArrayList<>();

        TravelLocation travelLocation1  = new TravelLocation("Eiffel Tower", "Paris, France", "https://cdn.lifestyleasia.com/wp-content/uploads/2019/10/21224220/Winer-Parisienne.jpg", 4.5);
        TravelLocation travelLocation2  = new TravelLocation("Rocky Nat. Park", "Estes Park, CO", "https://www.outtherecolorado.com/wp-content/uploads/2019/06/iStock-996409334-1024x683.jpg", 3.8);
        TravelLocation travelLocation3  = new TravelLocation("Mt. Fuji", "Honshu, Japan", "https://d36tnp772eyphs.cloudfront.net/blogs/1/2011/05/japan-1200x729.jpg", 2.3);
        TravelLocation travelLocation4  = new TravelLocation("Denali Nat. Park", "Denali, AK", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Bear_Digging_and_Denali_%2811330360484%29.jpg/800px-Bear_Digging_and_Denali_%2811330360484%29.jpg", 4.6);
        TravelLocation travelLocation5  = new TravelLocation("Caribbean Beach", "Caribbean Islands", "https://www.sailingeurope.com/blog/wp-content/uploads/2019/01/Barbados.jpg", 3.3);

        travelLocations.add(travelLocation1);
        travelLocations.add(travelLocation2);
        travelLocations.add(travelLocation3);
        travelLocations.add(travelLocation4);
        travelLocations.add(travelLocation5);

        locationsViewPager.setAdapter(new TravelLocationAdapter(travelLocations));

        locationsViewPager.setClipToPadding(false);
        locationsViewPager.setClipChildren(false);
        locationsViewPager.setOffscreenPageLimit(3);
        locationsViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.95f + r * 0.05f);
            }
        });

        locationsViewPager.setPageTransformer(compositePageTransformer);
    }
}
