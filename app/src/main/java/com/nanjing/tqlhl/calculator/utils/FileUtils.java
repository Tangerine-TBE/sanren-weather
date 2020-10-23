package com.nanjing.tqlhl.calculator.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <pre>
 *      @author hurley
 *      date : 2018/11/04
 *      github : https://github.com/HurleyJames
 *      desc : 文件工具类
 * </pre>
 */
public class FileUtils {
    private static final String TAG = "FileUtils";

    /**
     * 读取位于assets文件夹中的文件并转换成字符串
     *
     * @param fileName
     * @param context
     * @return
     */
    public static String readFileFromAssets(String fileName, Context context) {
        StringBuilder builder = new StringBuilder();
        try {
            //获取assets资源管理器
            AssetManager manager = context.getAssets();
            //通过管理器打开文件并读取
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    manager.open(fileName)
            ));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
    /**
     * Checks if external storage is available to at least read.
     */
    public static boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        return (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state));
    }

    public static boolean isFileInExternalStorage(String path) {
        if (path != null) {
            String external = Environment.getExternalStorageDirectory().getAbsolutePath();
            return path.contains(external);
        } else {
            return false;
        }
    }

    public static File getAppDir() {
        return getStorageDir(Constants.APPLICATION_NAME);
    }

    /**
     * Checks if external storage is available for read and write.
     */
    public static boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }




    /**
     * Get public external storage directory
     * @param dirName Directory name.
     */
    public static File getStorageDir(String dirName) {
        if (dirName != null && !dirName.isEmpty()) {
            File file = new File(Environment.getExternalStorageDirectory(), dirName);
            if (isExternalStorageReadable() && isExternalStorageWritable()) {
//				if (!file.exists() && !file.mkdirs()) {
//					Log.e(LOG_TAG, "Directory " + file.getAbsolutePath() + " was not created");
//				}
                createDir(file);
            } else {

            }
            return file;
        } else {
            return null;
        }
    }

    public static File createDir(File dir) {
        if (dir != null) {
            if (!dir.exists()) {
                try {
                    if (dir.mkdirs()) {

                        return dir;
                    } else {

                    }
                } catch (Exception e) {

                }
            } else {

                return dir;
            }
        }

        return null;
    }
}
