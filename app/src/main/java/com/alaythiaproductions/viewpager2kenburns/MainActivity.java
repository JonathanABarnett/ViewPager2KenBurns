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

    private ViewPager2 locationsViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationsViewPager = findViewById(R.id.locations_viewpager);

        List<TravelLocation> travelLocations = new ArrayList<>();

        TravelLocation travelLocation1  = new TravelLocation("Eiffel Tower", "Paris, France", "https://cdn.lifestyleasia.com/wp-content/uploads/2019/10/21224220/Winer-Parisienne.jpg", 4.5);
        TravelLocation travelLocation2  = new TravelLocation("Rocky Nat. Park", "Estes Park, CO", "https://www.outtherecolorado.com/wp-content/uploads/2019/06/iStock-996409334-1024x683.jpg", 3.8);
        TravelLocation travelLocation3  = new TravelLocation("Mt. Fuji", "Honshu, Japan", "https://d36tnp772eyphs.cloudfront.net/blogs/1/2011/05/japan-1200x729.jpg", 2.3);
        TravelLocation travelLocation4  = new TravelLocation("Denali Nat. Park", "Denali, AK", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Bear_Digging_and_Denali_%2811330360484%29.jpg/800px-Bear_Digging_and_Denali_%2811330360484%29.jpg", 4.6);
        TravelLocation travelLocation5  = new TravelLocation("Caribbean Beach", "Caribbean Islands", "https://www.sailingeurope.com/blog/wp-content/uploads/2019/01/Barbados.jpg", 3.3);
        TravelLocation travelLocation6  = new TravelLocation("St. Louis Arch", "St. Louis, MO", "https://thumbs-prod.si-cdn.com/qyknExPUw3jj0hDfGODpC60gOys=/800x600/filters:no_upscale()/https://public-media.si-cdn.com/filer/ee/29/ee29f55b-813b-4043-a25e-cf7eb8d158fb/gateway-arch.jpg", 3.6);
        TravelLocation travelLocation7  = new TravelLocation("Grand Canyon Nat. Park", "Grand Canyon, AZ", "https://cdn.getyourguide.com/img/location_img-489-2998343155-88.jpg", 3.7);


        travelLocations.add(travelLocation1);
        travelLocations.add(travelLocation2);
        travelLocations.add(travelLocation3);
        travelLocations.add(travelLocation4);
        travelLocations.add(travelLocation5);
        travelLocations.add(travelLocation6);
        travelLocations.add(travelLocation7);

        locationsViewPager.setAdapter(new TravelLocationAdapter(travelLocations, locationsViewPager));

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
                page.setScaleY(0.85f + r * 0.2f);
            }
        });

        locationsViewPager.setPageTransformer(compositePageTransformer);
    }

}
