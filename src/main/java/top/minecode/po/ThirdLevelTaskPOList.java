package top.minecode.po;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created on 2018/4/1.
 * Description:
 *
 * @author iznauy
 */
public class ThirdLevelTaskPOList {

    private List<ThirdLevelTaskPO> thirdLevelTaskPOS;

    public List<ThirdLevelTaskPO> getThirdLevelTaskPOS() {
        return thirdLevelTaskPOS;
    }

    public void setThirdLevelTaskPOS(List<ThirdLevelTaskPO> thirdLevelTaskPOS) {
        this.thirdLevelTaskPOS = thirdLevelTaskPOS;
    }

    public ThirdLevelTaskPO getThirdLevelTaskById(Integer id) {
        return thirdLevelTaskPOS.stream().filter(e -> e.getId().equals(id))
                .findFirst().orElse(null);
    }

    public Integer getNextThirdLevelTaskId() {
        return thirdLevelTaskPOS.size() + 1;
    }

    public List<ThirdLevelTaskPO> getThirdLevelTasksBySecondLevelTaskId(Integer id) {
        return thirdLevelTaskPOS.stream().filter(e -> e.getSecondLevelTaskId().equals(id))
                .collect(Collectors.toList());
    }

}
