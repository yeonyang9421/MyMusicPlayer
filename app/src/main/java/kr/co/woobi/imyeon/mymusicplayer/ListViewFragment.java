package kr.co.woobi.imyeon.mymusicplayer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;
import java.util.List;

public class ListViewFragment extends Fragment {

    private List<String> mData;
    public static ListViewFragment newInstance(List<String> data){
        ListViewFragment fragment=new ListViewFragment();
        Bundle bundle=new Bundle();
        bundle.putSerializable("data", (Serializable) data);
        fragment.setArguments(bundle);
        return  fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
