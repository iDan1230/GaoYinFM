package com.bella.fm.framwork.image;

import android.net.Uri;
import android.os.Environment;

import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.compress.CompressConfig;
import com.jph.takephoto.model.CropOptions;
import com.jph.takephoto.model.LubanOptions;
import com.jph.takephoto.model.TakePhotoOptions;

import java.io.File;

import me.shaohui.advancedluban.Luban;

/**
 *  * author：yangzhidan on 2017/1/5 09:30
 *  * function: takePhoto相机调用
 *  
 */

public class AlbumTools {
    private static boolean isCrop;//是否剪切
    private static boolean rgPickTool = true;//使用TakePhoto自带相册
    private static boolean rgCorrectTool = false;//纠正拍照的照片旋转角度
    private static boolean rgCompress = true;//是否压缩
    /**
     *
     * @param type 相机/相册
     * @param limit 多图选择的图片个数
     * @param isCrop1 是否裁剪
     * @param rbFile  是否从文件中选取
     * @param takePhoto
     */
    public static void onClick(int type,int limit ,boolean isCrop1,boolean rbFile,TakePhoto takePhoto) {
        isCrop = isCrop1;

        File file=new File(Environment.getExternalStorageDirectory(), "/temp/"+ System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists())file.getParentFile().mkdirs();

        Uri imageUri = Uri.fromFile(file);
        configCompress(takePhoto);
        configTakePhotoOption(takePhoto);
        switch (type){
            case 1://相册
                if(limit>1){
                    if(isCrop){//裁剪
                        takePhoto.onPickMultipleWithCrop(limit,getCropOptions());
                    }else {
                        takePhoto.onPickMultiple(limit);
                    }
                    return;
                }
                if(rbFile){//从文件中选图
                    if(isCrop){//裁剪
                        takePhoto.onPickFromDocumentsWithCrop(imageUri,getCropOptions());
                    }else {
                        takePhoto.onPickFromDocuments();
                    }
                    return;
                }else {
                    if(isCrop){//裁剪
                        takePhoto.onPickFromGalleryWithCrop(imageUri,getCropOptions());
                    }else {
                        takePhoto.onPickFromGallery();
                    }
                }
                break;
            case 2://相机
                if(isCrop){//裁剪
                    takePhoto.onPickFromCaptureWithCrop(imageUri,getCropOptions());
                }else {
                    takePhoto.onPickFromCapture(imageUri);
                }
                break;
            default:
                break;
        }
    }


    private static void configTakePhotoOption(TakePhoto takePhoto){
        TakePhotoOptions.Builder builder=new TakePhotoOptions.Builder();
        if(rgPickTool){
            builder.setWithOwnGallery(true);
        }
        if(rgCorrectTool){
            builder.setCorrectImage(true);
        }
        takePhoto.setTakePhotoOptions(builder.create());
    }
    /**
     * 压缩
     * @param takePhoto
     */
    private static void configCompress(TakePhoto takePhoto){
        if(!rgCompress){
            takePhoto.onEnableCompress(null,false);
            return ;
        }
        int maxSize= 102400;//图片最大大小
        int width= 800;
        int height= 800;
        boolean showProgressBar=true;//显示压缩进度条
        boolean enableRawFile = true;//拍照压缩后是否保存原图
        boolean rgCompressTool = true;//使用自带压缩工具
        CompressConfig config;
        if(rgCompressTool){
            config=new CompressConfig.Builder()
                    .setMaxSize(maxSize)
                    .setMaxPixel(width>=height? width:height)
                    .enableReserveRaw(enableRawFile)
                    .create();
        }else {
            LubanOptions option=new LubanOptions.Builder()
                    .setGear(Luban.CUSTOM_GEAR)
                    .setMaxHeight(height)
                    .setMaxWidth(width)
                    .setMaxSize(maxSize)
                    .create();
            config= CompressConfig.ofLuban(option);
            config.enableReserveRaw(enableRawFile);
        }
        takePhoto.onEnableCompress(config,showProgressBar);
    }
    /*
     裁剪配置
     */
    private static CropOptions getCropOptions(){
        if(!isCrop)return null;
        int height= 800;//裁剪高度
        int width= 800;//裁剪宽度
        boolean withWonCrop=true;//裁剪工具 true 第三方， false takephoto 自带
        CropOptions.Builder builder=new CropOptions.Builder();
        boolean rgCropSize = false;//尺寸/比例  true 宽*高  flase 宽/高
        if(!rgCropSize){
            builder.setAspectX(width).setAspectY(height);
        }else {
            builder.setOutputX(width).setOutputY(height);
        }
        builder.setWithOwnCrop(withWonCrop);
        return builder.create();
    }

}
