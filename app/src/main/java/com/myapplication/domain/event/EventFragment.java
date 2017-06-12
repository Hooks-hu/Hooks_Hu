package com.myapplication.domain.event;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.myapplication.BaseFragment;
import com.myapplication.R;

/**
 * Created by Administrator on 2017/6/9.
 */

public class EventFragment extends BaseFragment {

    public static EventFragment newInstance(String content) {
        EventFragment fragment = new EventFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_NAME, content);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_base_layout,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView tv_content = (TextView) getView().findViewById(R.id.tv_content);
        tv_content.setText("活动");
    }
}
