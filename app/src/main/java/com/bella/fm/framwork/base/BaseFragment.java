package com.bella.fm.framwork.base;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.bella.fm.R;
import com.bella.fm.framwork.tools.SystemStatusManager;
import com.bella.fm.framwork.utils.ViewUtils;
import com.jph.takephoto.app.TakePhotoFragment;

import butterknife.ButterKnife;

/**
 *  * author：yangzhidan on 2016/10/12 15:05
 *  * function: 基类Fragment
 *  
 */
public abstract class BaseFragment extends TakePhotoFragment implements View.OnClickListener{

    protected View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(getResource(), null);
            beforeInitView();
            initView(rootView);
            initData();
        }
        ButterKnife.bind(this,rootView);
        //缓存的rootView需要判断是否已经被加过parent， 如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        return rootView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {

        super.setUserVisibleHint(isVisibleToUser);
    }

    protected <T extends View> T findViewByIdNoCast(int id) {
        return rootView == null ? null : (T) rootView.findViewById(id);
    }

    protected abstract int getResource();

    protected abstract void beforeInitView();

    protected abstract void initView(View rootView);

    protected abstract void initData();

    /**
     * 根据id设置点击事件
     * @param objects
     */

    public void setOnClick(Object... objects) {

        for (Object object : objects) {
            if (object instanceof View) {
                ((View) object).setOnClickListener(this);
            }

            if (object instanceof Integer){
                findViewByIdNoCast((Integer) object).setOnClickListener(this);
            }

        }
    }

    /**
     * 根据id设置点击事件
     * @param objects
     */

//    public void setClickBackground(Object... objects) {
//
//        for (Object object : objects) {
//            if (object instanceof View) {
////                ((View) object).setOnClickListener(this);
//                ViewUtils.setSelectorColor(getContext(),(View) object, R.color.c_ffffff,R.color.c_f2f1f1);
//            }
////            if (object instanceof Integer){
////                findViewByIdNoCast((Integer) object).setOnClickListener(this);
////            }
//        }
//    }


//    private Dialog dialog = null;
//    public void loadingAnim(){
//        dialog = new Dialog(getContext(),android.R.style.Theme_DeviceDefault_Dialog_NoActionBar);
//        View view = View.inflate(getContext(), R.layout.dialog_loading,null);
//        Animation operatingAnim = AnimationUtils.loadAnimation(getContext(), R.anim.rotation);
//        LinearInterpolator lin = new LinearInterpolator();
//        operatingAnim.setInterpolator(lin);
//        ImageView img = (ImageView) view.findViewById(R.id.img_loading);
//        img.startAnimation(operatingAnim);
//        dialog.setContentView(view);
//        dialog.setCancelable(true);
//        dialog.setCanceledOnTouchOutside(false);
//        dialog.setContentView(view);
//        dialog.show();
//
//    }
//    public void cancelAnim(){
//        if (dialog!= null&&dialog.isShowing())
//            dialog.dismiss();
//        dialog = null;
//    }
    /**
     * 设置状态栏背景颜色
     */
    public void setTitleBarColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window win = getActivity().getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            winParams.flags |= bits;
            win.setAttributes(winParams);
        }
        SystemStatusManager tintManager = new SystemStatusManager(getActivity());
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setStatusBarTintResource(color);
    }


}
