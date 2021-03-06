package top.minecode.utils;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileFilter;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created on 2018/4/19.
 * Description:
 * @author Liao
 */
public class ImagesSet implements Iterable<ImagesSet.SubImageSet> {
    private static final String HAVE_NO_FORMAT = "noFormat";

    private List<String> images;
    private double scoreOfEachImage;

    public ImagesSet(String filePath, double totalScore) {
        File imageFile = new File(filePath);
        File[] files = imageFile.listFiles(pathname -> pathname.getName().equals("data"));
        assert files != null && files[0] != null;
        imageFile = files[0];

        List<String> supportedFormats = Config.INSTANCE.getSupportFormats();
        File[] imageFiles = imageFile.listFiles(pathname -> supportedFormats.contains(getFormat(pathname)));
        assert imageFiles != null;
        images = Stream.of(imageFiles).map(f -> Config.INSTANCE.getLogicPath(f.getPath())).collect(Collectors.toList());
        this.scoreOfEachImage = totalScore / images.size();
    }

    private String getFormat(File file) {
        String fileName = file.getName();
        int index = fileName.lastIndexOf(".");
        // If the file don't have a suffix, just return "noExists"
        return index == -1 ? HAVE_NO_FORMAT : fileName.substring(index);
    }

    @Override
    public @NotNull Iterator<SubImageSet> iterator() {
        return new Iterator<SubImageSet>() {
            private int delta = Config.INSTANCE.getThirdLevelTaskImagesNum();
            private int i = 0;
            private int j = delta;

            @Override
            public boolean hasNext() {
                return i < images.size();
            }

            @Override
            public SubImageSet next() {
                SubImageSet next;
                if (j < images.size()) {
                    next = new SubImageSet(i, j);
                } else
                    next = new SubImageSet(i, images.size());
                i += delta;
                j += delta;
                return next;
            }
        };
    }

    public class SubImageSet {
        private List<String> subImages;

        private SubImageSet(int i, int j) {
            this.subImages = images.subList(i, j);
        }

        public double getScores() {
            return subImages.size() * scoreOfEachImage;
        }

        public List<String> getImages() {
            return subImages;
        }
    }
}
