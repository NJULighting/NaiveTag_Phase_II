package top.minecode.dao.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created on 2018/4/3.
 * Description:
 *
 * @author iznauy
 */
public class Unzipper {

    public boolean unZip(String sourcePath, String outPath) {

        try {
            FileInputStream fin = new FileInputStream(sourcePath);
            CheckedInputStream checkedInputStream = new CheckedInputStream(fin, new Adler32());
            ZipInputStream zin = new ZipInputStream(fin);
            ZipEntry zipEntry;

            while((zipEntry = zin.getNextEntry()) != null){

                File targetFile = new File(outPath + File.separator + zipEntry.getName());

                if(!targetFile.getParentFile().exists())
                    targetFile.getParentFile().mkdirs();

                if(zipEntry.isDirectory())
                    targetFile.mkdirs();
                else {
                    FileOutputStream out = new FileOutputStream(targetFile);
                    byte[] buff = new byte[CommonConstant.UNZIPPER_BUFFER_SIZE];
                    int length;
                    while((length = zin.read(buff)) != -1){
                        out.write(buff, 0, length);
                    }
                    out.close();
                }
            }

            zin.close();
            checkedInputStream.close();
            fin.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
