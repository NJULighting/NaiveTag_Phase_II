package top.minecode.utils.unzip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created on 2018/3/19.
 * Description:
 * @author iznauy
 */
public class ZipHelper {

    private static final int ZIPPER_BUFF_SIZE = 1024;

    public String unZip(String sourcePath, String outPath) throws IOException {

        File source = new File(sourcePath);
        FileInputStream fin = new FileInputStream(source);
        CheckedInputStream checkedInputStream = new CheckedInputStream(fin, new Adler32());
        ZipInputStream zin = new ZipInputStream(fin);
        ZipEntry zipEntry;

        String folderName = source.getName();
        if (folderName.lastIndexOf('.') != -1)
            folderName = folderName.substring(0, folderName.lastIndexOf("."));

        File outPathFile = new File(outPath + File.separator + folderName + File.separator);
        if (!outPathFile.mkdirs())
            throw new IOException("File duplicated");

        while ((zipEntry = zin.getNextEntry()) != null) {
            File targetFile = new File(outPathFile.getPath() + File.separator + zipEntry.getName());
            if (!targetFile.getParentFile().exists()) targetFile.getParentFile().mkdirs();

            if (zipEntry.isDirectory()) targetFile.mkdirs();
            else {
                FileOutputStream out = new FileOutputStream(targetFile);
                byte[] buff = new byte[ZIPPER_BUFF_SIZE];
                int length;
                while ((length = zin.read(buff)) != -1) {
                    out.write(buff, 0, length);
                }
                out.close();
            }
        }

        zin.close();
        checkedInputStream.close();
        fin.close();
        return outPathFile.getPath();
    }

}
