package com.weaverprojects.opentinder.View.Windows;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;
import com.weaverprojects.opentinder.Model.BasicProfile;
import com.weaverprojects.opentinder.R;
import com.weaverprojects.opentinder.View.Adapters.ListAdapters.CardAdapter;


import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Keith on 2015-10-03.
 */
public class HomeActivity extends Activity {

    String markerZuckyImg = "http://i2.kym-cdn.com/entries/icons/facebook/000/013/564/aP2dv.jpg";
    public static final String TAG = "";

    //Tabs

    private ActionBar actionBar;


    //Home Activity
    private ArrayList<BasicProfile> cardsList;
    private CardAdapter mArrayAdapter;
    private int i;
    SwipeFlingAdapterView flingContainer;

    ImageView left;
    ImageView right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.activity_home);

        getActionBar().setDisplayHomeAsUpEnabled(false);

        flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);
        left = (ImageView) findViewById(R.id.left);
        right = (ImageView) findViewById(R.id.right);

        cardsList = new ArrayList<>();

        for(int i = 0;i < 15;i++) {
            String temp = String.valueOf(i);
            cardsList.add(new BasicProfile("randomcode" + temp, "XHR", "Palermo, CABA", "Senior Java developer",  markerZuckyImg));
        }

        mArrayAdapter = new CardAdapter(this, R.layout.cards_item, cardsList);

        flingContainer.setAdapter(mArrayAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                cardsList.remove(0);
                mArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object o) {
                Toast.makeText(HomeActivity.this, "Left", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightCardExit(Object o) {
                Toast.makeText(HomeActivity.this, "Right", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdapterAboutToEmpty(int i) {
                //cardsList.add("XML ".concat(String.valueOf(i)));
                mArrayAdapter.notifyDataSetChanged();
                Log.d("LIST", "notified");
                i++;
            }

            @Override
            public void onScroll(float v) {
                View view = flingContainer.getSelectedView();
                view.findViewById(R.id.item_swipe_left_indicator).setAlpha(v < 0 ? -v : 0);
                view.findViewById(R.id.item_swipe_right_indicator).setAlpha(v > 0 ? v : 0);
            }
        });

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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
        }else if(id == R.id.action_chats){
            Intent openChatWindow = new Intent(this, ChatsActivity.class);
            startActivity(openChatWindow);
            return true;
        }else if(id == R.id.action_profile){
            Intent openProfileWindow = new Intent(this, ProfileActivity.class);
            startActivity(openProfileWindow);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
