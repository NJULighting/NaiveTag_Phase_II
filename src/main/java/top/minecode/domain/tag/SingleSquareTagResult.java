package top.minecode.domain.tag;

import top.minecode.utils.Pair;

/**
 * Created on 2018/4/2.
 * Description:
 * @author Liao
 */
public abstract class SingleSquareTagResult extends TagResult {

    private Frame frame;

    public SingleSquareTagResult() {
    }

    public SingleSquareTagResult(TagType tagType, Frame frame) {
        super(tagType);
        this.frame = frame;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }
}
