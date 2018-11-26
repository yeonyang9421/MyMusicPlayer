package kr.co.woobi.imyeon.mymusicplayer;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private PlayerFragment mPlayerFragment;
    private  ListViewFragment mListViewFragment;
    private SongFragment mSongFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout=findViewById(R.id.tab);
        ViewPager viewPager=findViewById(R.id.view_pager);

        //플레이어
        mPlayerFragment=new PlayerFragment();

        //아티스트
        List<String> artistList= new ArrayList<>();
        for (int i=0; i<50; i++){
            artistList.add("가수" + i);
        }
        mListViewFragment = ListViewFragment.newInstance(artistList);

        //노래
        mSongFragment = new SongFragment();

        MusicPlayerPagerAdapter adapter=new MusicPlayerPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
    }

    private  class  MusicPlayerPagerAdapter extends FragmentPagerAdapter{

        public MusicPlayerPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch ( position){
                case 0:
                    return mPlayerFragment;
                case 1:
                    return mListViewFragment;
                case 2:
                    return mSongFragment;
            }
            return  null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch ( position){
                case 0:
                    return "플레이어";
                case 1:
                    return "아티스트";
                case 2:
                    return "노래";
            }
            return  null;

        }
    }

}
