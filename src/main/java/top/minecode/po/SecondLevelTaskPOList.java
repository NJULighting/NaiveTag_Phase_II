package top.minecode.po;

import java.util.List;

/**
 * Created on 2018/4/1.
 * Description:
 *
 * @author iznauy
 */
@Deprecated
public class SecondLevelTaskPOList {

    private List<SecondLevelTaskPO> secondLevelTaskPOS;

    public List<SecondLevelTaskPO> getSecondLevelTaskPOS() {
        return secondLevelTaskPOS;
    }

    public void setSecondLevelTaskPOS(List<SecondLevelTaskPO> secondLevelTaskPOS) {
        this.secondLevelTaskPOS = secondLevelTaskPOS;
    }

    public SecondLevelTaskPO findSecondLevelTaskPOById(Integer id) {
        return secondLevelTaskPOS.stream().filter(e -> e.getId().equals(id)).findFirst()
                .orElse(null);
    }

    public Integer getNextSecondLevelTaskId() {
        return secondLevelTaskPOS.size() + 1;
    }
}
