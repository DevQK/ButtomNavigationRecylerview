package khanh.buttomnavigationrecylerview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import khanh.buttomnavigationrecylerview.Fragment.CartFragment;
import khanh.buttomnavigationrecylerview.Fragment.GiftsFragment;
import khanh.buttomnavigationrecylerview.Fragment.ProfileFragment;
import khanh.buttomnavigationrecylerview.Fragment.StoreFragment;
import khanh.buttomnavigationrecylerview.helper.BottomNavigationBehavior;

public class MainActivity extends AppCompatActivity {

    private ActionBar actionBar;
    private BottomNavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getSupportActionBar();
        BottomNavigationClick();
        KhoiTaoHieuUng();
    }
    private void BottomNavigationClick() {
        navigationView = (BottomNavigationView) findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fm;
                switch (item.getItemId()){
                    case R.id.navigation_shop:
                        actionBar.setTitle("Shop");
                        fm = new StoreFragment(); //Load fm store
                        loadFragMent(fm);
                        return true;
                    case R.id.navigation_gifts:
                        actionBar.setTitle("Gifs");
                        fm = new GiftsFragment(); //Load fm gifs
                        loadFragMent(fm);
                        return true;
                    case R.id.navigation_cart:
                        actionBar.setTitle("Cart");
                        fm = new CartFragment(); //Load fm Cart
                        loadFragMent(fm);
                        return true;
                    case R.id.navigation_profile:
                        actionBar.setTitle("Profile");
                        fm = new ProfileFragment(); //Load fm Profile
                        loadFragMent(fm);
                        return true;
                }
                return false;
            }
        });
        actionBar.setTitle("Shop");
        loadFragMent(new StoreFragment());
    }

    // khởi tạo function fragment layout
    private void loadFragMent(Fragment fragment){
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        trans.replace(R.id.frame_container, fragment);
        trans.addToBackStack(null);
        trans.commit();
    }

    private void KhoiTaoHieuUng() {
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigationView.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());
    }
}
