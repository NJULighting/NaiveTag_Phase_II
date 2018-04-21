package top.minecode.domain.tag;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.xml.dom.Tag;
import top.minecode.domain.tag.*;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created on 2018/4/13.
 * Description:
 *
 * @author iznauy
 */
public class TagResultTest {

    private Gson gson;

    private List<Frame> frames;

    private List<Point> points;

//    @BeforeClass
    public void init() throws Exception {

        // init GSON
        gson = new GsonBuilder()
                .serializeNulls()
                .registerTypeAdapter(TagResult.class, new TagDeserializer())
                .registerTypeAdapter(TagResult.class, new TagSerializer())
                .create();

        // init Frames
        Frame frame1 = new Frame();
        frame1.setLeftTop(new Point(23, 19));
        frame1.setRightDown(new Point(100, 200));
        frame1.setLabel("iznauy1");

        Frame frame2 = new Frame();
        frame2.setLeftTop(new Point(2213, 192));
        frame2.setRightDown(new Point(1002, 2200));
        frame2.setLabel("iznauy2");

        Frame frame3 = new Frame();
        frame3.setLeftTop(new Point(213, 191));
        frame3.setRightDown(new Point(1200, 2010));
        frame3.setLabel("iznauy3");

        frames = new ArrayList<>();
        frames.add(frame1);
        frames.add(frame2);
        frames.add(frame3);

        // init points
        Point point1 = new Point(10, 11);
        Point point2 = new Point(11, 12);
        Point point3 = new Point(22, 77);

        points = new ArrayList<>();
        points.add(point1);
        points.add(point2);
        points.add(point3);
    }

    private void test(TagResult tagResult) throws Exception {
        String rawJson = gson.toJson(tagResult, TagResult.class);
        TagResult tag = gson.fromJson(rawJson, TagResult.class);
        String json = gson.toJson(tag, TagResult.class);
        assertEquals(json, rawJson);
    }

 //   @Test
    public void test100() throws Exception {
        TagResult tagResult = new GlobalLabelTagResult("iznauy");
        test(tagResult);
    }

//    @Test
    public void test101() throws Exception {
        TagResult tagResult = new GlobalLabelTagResult("中国");
        test(tagResult);
    }

 //   @Test
    public void test200() throws Exception {
        TagResult tagResult = new SingleSquareLabelTagResult(frames.get(0));
        test(tagResult);
    }

 //   @Test
    public void test201() throws Exception {
        TagResult tagResult = new SingleSquareLabelTagResult(frames.get(1));
        test(tagResult);
    }

 //   @Test
    public void test300() throws Exception {
        TagResult tagResult = new MultiSquareLabelTagResult(frames);
        test(tagResult);
    }

 //   @Test
    public void test301() throws Exception {
        TagResult tagResult = new MultiSquareAnnotationTagResult(frames.subList(0, 1));
        test(tagResult);
    }

 //   @Test
    public void test400() throws Exception {
        TagResult tagResult = new SimpleAreaTagResult(points);
        test(tagResult);
    }

  //  @Test
    public void test401() throws Exception {
        TagResult tagResult = new AreaLabelTagResult(points, "iznauy");
        test(tagResult);
    }

}