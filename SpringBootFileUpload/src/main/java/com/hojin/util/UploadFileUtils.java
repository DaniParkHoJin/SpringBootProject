package com.hojin.util;

import lombok.extern.slf4j.Slf4j;
import org.imgscalr.Scalr;
import org.springframework.util.FileCopyUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

@Slf4j
public class UploadFileUtils {

    public static String UploadFile(String uploadPath, String originalName, byte[] fileData) throws Exception {
        UUID uid = UUID.randomUUID();

        String savedName = uid.toString() + "_" + originalName;
        String savePath = calPath(uploadPath);
        File target = new File(uploadPath + savePath, savedName);

        FileCopyUtils.copy(fileData, target);

        String formatName = originalName.substring(originalName.lastIndexOf(".") + 1);

        String uploadFileName = savePath.replace(File.separatorChar, '/') + '/' + savedName;

        if (MediaUtils.getMediaType(formatName) != null) {
            makeThumbnail(uploadPath, savePath, savedName);
        }
        return uploadFileName;
    }

    private static void makeThumbnail(String uploadPath, String path, String fileName) throws Exception {
        BufferedImage sourceImg = ImageIO.read(new File(uploadPath + path, fileName));
        BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100);
        String thoubnailName = uploadPath + path + File.separator + "s_" + fileName;

        File newFile = new File(thoubnailName);
        String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

        ImageIO.write(destImg, formatName.toUpperCase(), newFile);
    }

    private static String calPath(String uploadPath) {
        Calendar cal = Calendar.getInstance();

        String yearPath = File.separator + cal.get(Calendar.YEAR);
        String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
        String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));

        makeDir(uploadPath, yearPath, monthPath, datePath);

        log.info(datePath);
        return datePath;

    }

    private static void makeDir(String uploadPath, String... paths) {
        if (new File(paths[paths.length - 1]).exists()) {
            return;
        }
        for (String path : paths) {
            File dirPath = new File(uploadPath + path);
            if (!dirPath.exists()) {
                dirPath.mkdir();
            }
        }
    }
}
