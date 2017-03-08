package com.bella.fm.framwork.image;

import android.net.Uri;

import com.bella.fm.App;
import com.bella.fm.framwork.utils.DisplayUtil;
import com.bella.fm.framwork.utils.StringUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;


/**
 * Description: facebook 显示图片封装
 *
 *
 *
 * 规则
 * 远程图片	http://,  https://	HttpURLConnection
 * 本地文件	          file://	 FileInputStream
 * Content provider	 content://	ContentResolver
 * asset目录下的资源 asset://	AssetManager
 * res目录下的资源	 res://	Resources.openRawResource
 *
 */
public class ImageLoader {

    private static ImageLoader imageLoader;

    private ImageLoader() {
    }

    public static ImageLoader getInstance(){

        if (imageLoader == null)
            imageLoader = new ImageLoader();
        return imageLoader;

    }

    /**
     * 显示Image
     * @param mSimpleDraweeView
     * @param url
     */
    public void disPlayImage(SimpleDraweeView mSimpleDraweeView, String url){

        if (StringUtils.isEmpty(url))
            return;

        int width = 0;
        int heigth = 0;

        //如果layout里面没有设置宽高就给个默认高度
        width = mSimpleDraweeView.getWidth();
        heigth = mSimpleDraweeView.getHeight();

        if (width <= 0) {
            width = DisplayUtil.dip2px(App.getAppContext(), 40);
        }
        if (heigth <= 0) {
            heigth = DisplayUtil.dip2px(App.getAppContext(), 40);
        }

        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(url))
                .setProgressiveRenderingEnabled(true)
                .setLocalThumbnailPreviewsEnabled(true)
                .setResizeOptions(new ResizeOptions(width, heigth))
                .build();



        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)

                .setOldController(mSimpleDraweeView.getController())
                .build();
        mSimpleDraweeView.setController(controller);
    }

    /**
     * 加载本地图片（相机相册获取的图片）
     * @param mSimpleDraweeView
     * @param url
     */
    public void disThisLocalityImage(SimpleDraweeView mSimpleDraweeView, String url){

        if (StringUtils.isEmpty(url))
            return;

        int width = 0;
        int heigth = 0;

        //如果layout里面没有设置宽高就给个默认高度
        width = mSimpleDraweeView.getWidth();
        heigth = mSimpleDraweeView.getHeight();

        if (width <= 0) {
            width = DisplayUtil.dip2px(App.getAppContext(), 40);
        }
        if (heigth <= 0) {
            heigth = DisplayUtil.dip2px(App.getAppContext(), 40);
        }

//        LogUtils.e("file://"+url);
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(Uri.parse("file://"+url))
                .setProgressiveRenderingEnabled(true)
                .setLocalThumbnailPreviewsEnabled(true)
                .setResizeOptions(new ResizeOptions(width, heigth))
                .build();

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setOldController(mSimpleDraweeView.getController())
                .build();
        mSimpleDraweeView.setController(controller);
    }

    /**
     * 内容提供者中的图片
     * @param mSimpleDraweeView
     * @param url
     */
    public void disContentProviderImage(SimpleDraweeView mSimpleDraweeView, String url){

        if (StringUtils.isEmpty(url))
            return;

        int width = 0;
        int heigth = 0;

        //如果layout里面没有设置宽高就给个默认高度
        width = mSimpleDraweeView.getWidth();
        heigth = mSimpleDraweeView.getHeight();

        if (width <= 0) {
            width = DisplayUtil.dip2px(App.getAppContext(), 40);
        }
        if (heigth <= 0) {
            heigth = DisplayUtil.dip2px(App.getAppContext(), 40);
        }

//        LogUtils.e("file://"+url);
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(Uri.parse("content://"+url))
                .setProgressiveRenderingEnabled(true)
                .setLocalThumbnailPreviewsEnabled(true)
                .setResizeOptions(new ResizeOptions(width, heigth))
                .build();

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setOldController(mSimpleDraweeView.getController())
                .build();
        mSimpleDraweeView.setController(controller);
    }

    /**
     * 本地资源（res下的图片）
     * @param mSimpleDraweeView
     * @param url
     */
    public void disResourceImage(SimpleDraweeView mSimpleDraweeView, String url){

        if (StringUtils.isEmpty(url))
            return;

        int width = 0;
        int heigth = 0;

        //如果layout里面没有设置宽高就给个默认高度
        width = mSimpleDraweeView.getWidth();
        heigth = mSimpleDraweeView.getHeight();

        if (width <= 0) {
            width = DisplayUtil.dip2px(App.getAppContext(), 40);
        }
        if (heigth <= 0) {
            heigth = DisplayUtil.dip2px(App.getAppContext(), 40);
        }

//        LogUtils.e("file://"+url);
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(Uri.parse("res://"+url))
                .setProgressiveRenderingEnabled(true)
                .setLocalThumbnailPreviewsEnabled(true)
                .setResizeOptions(new ResizeOptions(width, heigth))
                .build();

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setOldController(mSimpleDraweeView.getController())
                .build();
        mSimpleDraweeView.setController(controller);
    }


    /**
     *  asset文件下的
     * @param mSimpleDraweeView
     * @param url
     */
    public void disAssetImage(SimpleDraweeView mSimpleDraweeView, String url){

        if (StringUtils.isEmpty(url))
            return;

        int width = 0;
        int heigth = 0;

        //如果layout里面没有设置宽高就给个默认高度
        width = mSimpleDraweeView.getWidth();
        heigth = mSimpleDraweeView.getHeight();

        if (width <= 0) {
            width = DisplayUtil.dip2px(App.getAppContext(), 40);
        }
        if (heigth <= 0) {
            heigth = DisplayUtil.dip2px(App.getAppContext(), 40);
        }

//        LogUtils.e("file://"+url);
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(Uri.parse("asset://"+url))
                .setProgressiveRenderingEnabled(true)
                .setLocalThumbnailPreviewsEnabled(true)
                .setResizeOptions(new ResizeOptions(width, heigth))
                .build();

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setOldController(mSimpleDraweeView.getController())
                .build();
        mSimpleDraweeView.setController(controller);
    }
//    /**
//     * 显示Image
//     * @param mSimpleDraweeView
//     * @param url
//     */
//    public void disPlayImage2(SimpleDraweeView mSimpleDraweeView, String url, ControllerListener controllerListener){
//
//        if (StringUtils.isEmpty(url))
//            return;
//
//        int width = 0;
//        int heigth = 0;
//
//        //如果layout里面没有设置宽高就给个默认高度
//        width = mSimpleDraweeView.getWidth();
//        heigth = mSimpleDraweeView.getHeight();
//
//        if (width <= 0) {
//            width = DisplayUtil.dip2px(App.getAppContext(), 40);
//        }
//        if (heigth <= 0) {
//            heigth = DisplayUtil.dip2px(App.getAppContext(), 40);
//        }
//
//        LogUtils.e("file://"+url);
//        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(Uri.parse("file://"+url))
//                .setProgressiveRenderingEnabled(true)
//                .setLocalThumbnailPreviewsEnabled(true)
//                .setResizeOptions(new ResizeOptions(width, heigth))
//                .build();
//
//        DraweeController controller = Fresco.newDraweeControllerBuilder()
//                .setImageRequest(request)
//                .setControllerListener(controllerListener )
//                .setOldController(mSimpleDraweeView.getController())
//                .build();
//        mSimpleDraweeView.setController(controller);
//    }

}
