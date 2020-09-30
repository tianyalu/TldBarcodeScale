package com.sty.dld.barcodescale.util;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Author: tian
 * @UpdateDate: 2020/9/25 3:59 PM
 */
public class FileUtil {

    /**
     *
     * @param context
     * @param assetName
     * @param targetPath
     * @param forceUpdate
     */
    public static void copyAssetsFile(Context context, String assetName, String targetPath, boolean forceUpdate) {
        File targetFile = null;
        InputStream in = null;
        OutputStream out = null;

        try {
            AssetManager assetManager = context.getAssets();
            targetFile = new File(targetPath);
            if(!targetFile.getParentFile().exists()) {
                targetFile.getParentFile().mkdirs();
            }
            if(targetFile.exists()) {
                if(forceUpdate) {
                    targetFile.deleteOnExit();
                }else {
                    return;
                }
            }

            targetFile.createNewFile();
            in = assetManager.open(assetName);
            out = new FileOutputStream(targetFile, false);
            copy(in, out);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void copyAssetsFile(Context context, String assetName, String targetPath) {
        copyAssetsFile(context, assetName, targetPath, false);
    }

    public static void copy(InputStream from, OutputStream to) throws IOException {
        byte[] buf = new byte[2048];
        while (true) {
            int r = from.read(buf);
            if(r == -1) {
                break;
            }
            to.write(buf, 0, r);
        }
    }
}
