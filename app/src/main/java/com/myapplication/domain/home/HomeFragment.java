package com.myapplication.domain.home;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.myapplication.BaseFragment;
import com.myapplication.R;
import com.myapplication.base.BaseConst;
import com.myapplication.base.BaseResult;
import com.myapplication.base.HttprequestListener;
import com.myapplication.domain.http.GsonParseUtil;
import com.myapplication.utils.NavigateUtils;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by Administrator on 2017/6/9.
 */

public class HomeFragment extends BaseFragment implements HttprequestListener, ListViewAdapter.OnFocusBtnClickListener {

    private ListView lv_list;
    //头部就数据
    private List<HomeHeadResponse> headList = new ArrayList<>();
    private List<HomeListDataResponse> mList = new ArrayList<>();
    private List<StarsTodayResponse> xiaomoStartListData = new ArrayList<>();
    private Button bt_get;
    private View header;
    private HeaderAdapter headerAdapter;
    private ViewPager vp_viepager;
    private ListViewAdapter mAdapter;
    //小摩星探父布局
    private  RelativeLayout stars_rank_Panel;
    // xiaomolistData
    private List<StarBoardResponse> starsRankResponseList = new ArrayList<StarBoardResponse>();
    private ImageView iv_pic;
    private TextView tv_stars_name, stars_info, know_more,tv_today_big_title;
    //星级推荐父布局
    private LinearLayout so_mall_dynamic_Panel;
    private String mPagename = "RecommendFragment";

    public static HomeFragment newInstance(String content) {
        HomeFragment fragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_NAME, content);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        lv_list = (ListView) view.findViewById(R.id.lv_list);
        header = getActivity().getLayoutInflater().inflate(R.layout.item_header_layout,null);
        stars_rank_Panel = (RelativeLayout) header.findViewById(R.id.stars_rank_Panel);
        so_mall_dynamic_Panel = (LinearLayout) header.findViewById(R.id.so_mall_dynamic_Panel);
        lv_list.addHeaderView(header);
        initHeader(header);
        mAdapter = new ListViewAdapter(getActivity(),mList,R.layout.layout_newest_dymic_item);
        lv_list.setAdapter(mAdapter);
        mAdapter.setOnFocusBtnClickListener(this);
        GsonParseUtil.requestData(getActivity(),BaseConst.BANNER_URL,"headData",HomeHeadResponse.class,this);
        GsonParseUtil.requestData(getActivity(),BaseConst.XIAOMOSTARTLIST_URL,"xiaomoStartList",StarBoardResponse.class,this);
        GsonParseUtil.requestData(getActivity(),BaseConst.STARTRECOMAD_URL,"homeListData",HomeListDataResponse.class,this);


    }

    @Override
    public void requestSuccess(BaseResult jsonResult, String type) {
        if ("headData".endsWith(type)) {
            headList.addAll(jsonResult.getData());
            headerAdapter.notifyDataSetChanged();
        }else if ("homeListData".endsWith(type)) {
            mList.addAll(jsonResult.getData());
            mAdapter.notifyDataSetChanged();
        }else if ("xiaomoStartList".endsWith(type)) {
            starsRankResponseList.addAll(jsonResult.getData());
            setStarsRankLayout();
        }else if ("xiaomoStart".endsWith(type)) {
            upDateTodayStars(jsonResult.getData());
        }
    }

    /**
     * 小摩List添加数据
     */
    private void setStarsRankLayout(){
        stars_rank_Panel.removeAllViews();
        int size = starsRankResponseList.size();
        if (size > 0) {//表示明星排行榜有数据，stars_rank_Panel可以添加东西
            LinearLayout relativeLayout = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.recommend_stars_rank_layout, null);
            LinearLayout starslayout = (LinearLayout) relativeLayout.findViewById(R.id.starsPanle);
            setStars(starslayout);
            tv_today_big_title = (TextView)relativeLayout.findViewById(R.id.tv_today_big_title);
            iv_pic = (ImageView) relativeLayout.findViewById(R.id.iv_pic);
            tv_stars_name = (TextView) relativeLayout.findViewById(R.id.tv_stars_name);
            stars_info = (TextView) relativeLayout.findViewById(R.id.stars_info);
            know_more = (TextView) relativeLayout.findViewById(R.id.know_more);
            LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            stars_rank_Panel.addView(relativeLayout, lp2);
            GsonParseUtil.requestData(getActivity(),BaseConst.XIAOMOSTART_URL,"xiaomoStart",StartListDataResponse.class,this);
        }
    }
    private void setStars(LinearLayout starslayout) {
        for (int i = 0; i < starsRankResponseList.size(); i++) {
            LinearLayout childLayout = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.recommend_stars_layout, null);
            LinearLayout star_layout = (LinearLayout) childLayout.findViewById(R.id.star_layout);
            CircleImageView iv_face = (CircleImageView) childLayout.findViewById(R.id.user_face_view);// 明星头像
            TextView stars_position = (TextView) childLayout.findViewById(R.id.stars_position);//明星排名
            TextView stars_name = (TextView) childLayout.findViewById(R.id.stars_name);// 明星名字
            star_layout.setTag(i);
//            star_layout.setOnClickListener(RecommendFragment.this);
            stars_position.setText("TOP " + (i + 1));
            stars_name.setText(starsRankResponseList.get(i).getNickname());
            Glide.with(getActivity()).load(starsRankResponseList.get(i).getFace()).error(R.drawable.default_face).into(iv_face);
            LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            starslayout.addView(childLayout, lp2);
        }
    }

    public void upDateTodayStars(List<StartListDataResponse> result) {
        if (result != null && result.size() > 0) {
            final StartListDataResponse bean = result.get(0);
            if(iv_pic == null || tv_today_big_title == null
                    || stars_info == null || tv_stars_name == null
                    || know_more == null){
                return;
            }
            if(!TextUtils.isEmpty(bean.getTodaystar_image())){
                Glide.with(getActivity().getApplicationContext()).load(bean.getTodaystar_image()).centerCrop().into(iv_pic);
            }else{
                Glide.with(getActivity().getApplicationContext()).load(bean.getTodaystar_image()).centerCrop().into(iv_pic);
            }
            if(!TextUtils.isEmpty(bean.getBig_title())){
                tv_today_big_title.setText(bean.getBig_title());
            }else{
                tv_today_big_title.setText("");
            }
//          know_more.setText();
            if (!TextUtils.isEmpty(bean.getContent())){
                stars_info.setText(bean.getContent());
            } else {
                stars_info.setText("");
            }
            if (!TextUtils.isEmpty(bean.getSmall_title())){
                tv_stars_name.setText(bean.getSmall_title());
            } else {
                tv_stars_name.setText("");
            }
//            know_more.setOnClickListener(new View.OnClickListener(){
//                @Override
//                public void onClick(View view){
//                    if(TextUtils.isEmpty(bean.getJumptonative())){
//                        String url = bean.getUrl();
//                        if(!TextUtils.isEmpty(url)){
//                            if (url.contains("?")){
//                                url = url + "&tn=" + BaseConst.MY_TOKEN;
//                            } else {
//                                url = url + "?tn=" + BaseConst.MY_TOKEN;
//                            }
//                            Intent intent = new Intent(getActivity(), ShowThemeWebActivity.class);
//                            intent.putExtra("title", "活动");
//                            intent.putExtra("url", url);
//                            startActivity(intent);
//                        }
//                    }else{
//                        Gson gson = new Gson();
//                        StarsTodayResponse.Jumptonative jumptonative =  gson.fromJson(bean.getJumptonative(),StarsTodayResponse.Jumptonative.class);
//                        if("starhome".equals(jumptonative.getTarget())){
//                            if(!TextUtils.isEmpty(jumptonative.getUid())){
//                                StarBoardResponse vo = new StarBoardResponse();
//                                vo.setUid(Integer.parseInt(jumptonative.getUid()));
//                                vo.setNickname(bean.getNickname());
//                                NavigateUtils.navigateToStarDetail(getActivity(), vo);
//                            }
//                        }
//                        if("game".equals(jumptonative.getTarget())){
//                            if(!TextUtils.isEmpty(jumptonative.getGid())){
//                                if("0".equals(jumptonative.getGid())){// 去游戏列表页
//                                    Intent intent = new Intent(getActivity(), MallGameActivity.class);
//                                    startActivity(intent);
//                                }else if("1".equals(jumptonative.getGid())){// 去刮刮乐
//                                    Intent intent = new Intent(getActivity(), LotteryGGLtwoActivity.class);//前往刮刮乐
//                                    startActivity(intent);
//                                }else if("2".equals(jumptonative.getGid())){// 去大转盘
//                                    Intent intent = new Intent(getActivity(), LotteryWheelActivity.class);////前往大转盘
//                                    startActivity(intent);
//                                }
//                            }
//                        }
//                    }
//                }
//            });
        }
    }

    private void initHeader(View header) {
        vp_viepager = (ViewPager) header.findViewById(R.id.vp_viepager);
        headerAdapter = new HeaderAdapter(getActivity(),headList);
        vp_viepager.setAdapter(headerAdapter);
    }
    @Override
    public void onItemClick(HomeListDataResponse response2, int position) {
        HomeListDataResponse response = mList.get(position);
        if (response.getTechtype() == 5 ||response.getTechtype() == 10 || response.getTechtype() == 20){
            NavigateUtils.navigateToFeedINSDatail(getActivity(),response);
        } else {
            if (response.getTechtype() == 30){
                NavigateUtils.navigateToActivityDetail(getActivity(), response.getTid(),response.getUid(),response);
            }
        }
    }


    @Override
    public void focusClick(HomeListDataResponse response, int position) {

    }

    @Override
    public void faceClick(HomeListDataResponse response, int position) {

    }



    static class HeaderAdapter extends PagerAdapter {
        private List<HomeHeadResponse> dataList;
        private Context mContext;
        private OnBannerItemClickListener mListener;

        public HeaderAdapter(Context context, List<HomeHeadResponse> _dataList) {
            dataList = _dataList;
            mContext = context;
        }
        @Override
        public int getCount() {
            return dataList.size();
        }
        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View v = initView(position);
            container.addView(v);
            return v;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        private View initView(final int position) {
//            MainActivity ba = (MainActivity) mContext;
            View v;
            v = View.inflate(mContext,R.layout.layout_banner, null);
            ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
            TextView textView = (TextView) v.findViewById(R.id.textView);
            if(dataList != null && dataList.size() > 0){
                HomeHeadResponse vo = dataList.get(position);
                if (vo != null) {
                    Glide.with(mContext.getApplicationContext()).load(vo.getCoverimgurl()).centerCrop().into(imageView);
                    textView.setText(vo.getTitle());
                }
                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mListener != null) {
                            mListener.onBannerItemClickListener(position);
                        }
                    }
                });
            }
            return v;
        }

        public void setOnBannerItemClickListener(OnBannerItemClickListener l) {
            mListener = l;
        }

        public interface OnBannerItemClickListener {
            public void onBannerItemClickListener(int position);
        }
    }

}
