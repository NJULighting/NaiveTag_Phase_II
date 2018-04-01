package top.minecode.po;

import java.util.List;

/**
 * Created on 2018/4/1.
 * Description:
 *
 * @author iznauy
 */
public class FirstLevelTaskPOList {

    private List<FirstLevelTaskPO> firstLevelTaskPOS;

    public List<FirstLevelTaskPO> getFirstLevelTaskPOS() {
        return firstLevelTaskPOS;
    }

    public void setFirstLevelTaskPOS(List<FirstLevelTaskPO> firstLevelTaskPOS) {
        this.firstLevelTaskPOS = firstLevelTaskPOS;
    }

    public FirstLevelTaskPO findFirstLevelTaskPOById(Integer id) {
        return firstLevelTaskPOS.stream().filter(e -> e.getId().equals(id)).findFirst()
                .orElse(null);
    }

    public Integer getNextFirstLevelTaskId() {
        return firstLevelTaskPOS.size() + 1;
    }

}
