package com.weaverprojects.opentinder.View.Windows;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.weaverprojects.opentinder.Controller.Image.BlurTransform;
import com.weaverprojects.opentinder.Controller.Image.CircleTransform;
import com.weaverprojects.opentinder.R;
import com.weaverprojects.opentinder.View.Adapters.ListAdapters.ImageAdapter;

import java.util.ArrayList;

/**
 * Created by Keith on 2015-10-03.
 */
public class ProfileActivity extends Activity {
    public static final String TAG = "OpenTinder_PA_";

    String markerZuckyImg = "http://mhalabs.org/wp-content/uploads/upme/1451456913_brodie.jpg";
    String coverImg = "https://lh3.googleusercontent.com/IQoInMEsZsucHLfyq5OVthg4E1LXER8xjoyxrEBfZYh20y1rcdLyV5K7qPxoWg0eqPG6=s926-fcrop64=1,1fff1fc4df94e03a";

    //UI
    ImageView profileImageView;
    ImageView coverImageView;
    TextView nameTextView;
    TextView ageTextView;
    TextView distanceTextView;
    TextView activeTextView;
    TextView aboutTextView;
    ListView photosListView;
    LinearLayout getTopWrapper;

    MyViewPagerAdapter myViewPagerAdapter;
    ViewPager viewPager;
    int[] layouts;

    ImageAdapter mImageAdapter;
    ArrayList<com.weaverprojects.opentinder.Model.Image> profileImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        layouts = new int[]{
                R.layout.slide1,
                R.layout.slide2,
                R.layout.slide3,
                R.layout.slide4,
                R.layout.slide5};

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);

        profileImages = new ArrayList<>();

        profileImages.add(new com.weaverprojects.opentinder.Model.Image(markerZuckyImg));
        profileImages.add(new com.weaverprojects.opentinder.Model.Image(markerZuckyImg));
        profileImages.add(new com.weaverprojects.opentinder.Model.Image(markerZuckyImg));
        profileImages.add(new com.weaverprojects.opentinder.Model.Image(markerZuckyImg));
        profileImages.add(new com.weaverprojects.opentinder.Model.Image(markerZuckyImg));
        profileImages.add(new com.weaverprojects.opentinder.Model.Image(markerZuckyImg));

        declareUIObjects();

        mImageAdapter = new ImageAdapter(this, R.layout.single_image, profileImages);
        //photosListView.setAdapter(mImageAdapter);

        Picasso.with(this).load(markerZuckyImg).transform(new CircleTransform()).into(profileImageView);
        Picasso.with(this).load(coverImg).transform(new BlurTransform(this)).into(coverImageView);

        nameTextView.setText("Andres Lopez");
        ageTextView.setText(", 36");
        distanceTextView.setText("Parque Patricios, CABA");
        activeTextView.setText("Active 13 minutes ago");
        aboutTextView.setText("Project manager");

        int topWrapperHeight = getTopWrapper.getHeight();
//        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) getTopWrapper.getLayoutParams();
//        lp.height = topWrapperHeight;
//        getTopWrapper.setLayoutParams(lp);
        //setListViewHeightBasedOnChildren(photosListView);

        Log.v(TAG, "[" + String.valueOf(topWrapperHeight) + "]");

        //LinearLayout.LayoutParams lp2 = (LinearLayout.LayoutParams) photosListView.getLayoutParams();
        //photosListView.setPadding(0, topWrapperHeight, 0,0);
    }
    @Override
    protected void onPause(){
        super.onPause();
    }
    @Override
    protected void onResume(){
        super.onResume();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    protected void declareUIObjects(){
        profileImageView = (ImageView) findViewById(R.id.profileImageView);
        coverImageView = (ImageView) findViewById(R.id.coverImageView);
        nameTextView = (TextView) findViewById(R.id.nameTextView);
        ageTextView = (TextView) findViewById(R.id.ageTextView);
        distanceTextView = (TextView) findViewById(R.id.distanceTextView);
        activeTextView = (TextView) findViewById(R.id.activeTextView);
        aboutTextView = (TextView) findViewById(R.id.aboutTextView);
        //photosListView = (ListView) findViewById(R.id.photosListView);
        getTopWrapper = (LinearLayout) findViewById(R.id.getTopWrapper);
    }

    public void setListViewHeightBasedOnChildren(ListView listView) {

        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();

    }

    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}