package com.myapplication.domain.user;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.myapplication.BaseFragment;
import com.myapplication.R;

/**
 * Created by Administrator on 2017/6/9.
 */

public class UserFragment extends BaseFragment {

    public static UserFragment newInstance(String content) {
        UserFragment fragment = new UserFragment();
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
    protected void initView(View view) {
        super.initView(view);
        TextView tv_content = (TextView) view.findViewById(R.id.tv_content);
        tv_content.setText("个人");
    }
}
