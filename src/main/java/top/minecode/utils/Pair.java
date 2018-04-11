package top.minecode.utils;

import java.io.Serializable;

/**
 * Created on 2018/4/1.
 * Description:
 *
 * @author iznauy
 */
public class Pair<L, R> implements Serializable {

    private L left;

    private R right;

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public L getLeft() {
        return left;
    }

    public void setLeft(L left) {
        this.left = left;
    }

    public R getRight() {
        return right;
    }

    public void setRight(R right) {
        this.right = right;
    }
}
