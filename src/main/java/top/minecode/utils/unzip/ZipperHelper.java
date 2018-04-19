package top.minecode.utils.unzip;

/**
 * Created on 2018/3/19.
 * Description:
 *
 * @author iznauy
 */
public interface ZipperHelper {

    boolean unZip(String sourcePath, String outPath);

    int ZIPPER_BUFF_SIZE = 1024;
}
