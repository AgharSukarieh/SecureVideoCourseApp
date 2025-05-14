package com.example.myproject.pojo;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class VideoStorage {

    public static String saveVideoToInternalStorage(Context context, String sourcePath, String fileName) {
        try {
            File directory = new File(context.getFilesDir(), "kkkkk");
            if (!directory.exists() && !directory.mkdirs()) {
                return "Error: Failed to create directory.";
            }

            File sourceFile = new File(sourcePath);

            if (!sourceFile.exists() || !sourceFile.canRead()) {
                return "Error: Source file not found or cannot be read: " + sourcePath;
            }

            File file = new File(directory, fileName);
            try (FileInputStream inputStream = new FileInputStream(sourceFile);
                 FileOutputStream outputStream = new FileOutputStream(file)) {

                byte[] buffer = new byte[4096]; 
                int length;
                while ((length = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }
                return "Video copied successfully to: " + file.getAbsolutePath();
            } catch (IOException e) {
                e.printStackTrace();
                return "Error copying video: " + e.getMessage();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    public static String saveMultipleVideosToInternalStorage(Context context, String[] sourcePaths, String[] fileNames) {
        if (sourcePaths == null || fileNames == null || sourcePaths.length != fileNames.length) {
            return "Error: Invalid input. Source paths and file names must not be null and must have the same length.";
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sourcePaths.length; i++) {
            String saveResult = saveVideoToInternalStorage(context, sourcePaths[i], fileNames[i]);
            result.append(saveResult).append("\n");
        }
        return result.toString();
    }

}
