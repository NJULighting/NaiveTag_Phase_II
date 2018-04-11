package top.minecode.po;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 2018/4/1.
 * Description:
 *
 * @author iznauy
 */
@Deprecated
public class ThirdLevelTaskResultPOList {

    private List<ThirdLevelTaskResultPO> thirdLevelTaskResultPOS;

    public List<ThirdLevelTaskResultPO> getThirdLevelTaskResultPOS() {
        return thirdLevelTaskResultPOS;
    }

    public void setThirdLevelTaskResultPOS(List<ThirdLevelTaskResultPO> thirdLevelTaskResultPOS) {
        this.thirdLevelTaskResultPOS = thirdLevelTaskResultPOS;
    }

    public ThirdLevelTaskResultPO getThirdLevelTaskResultById(Integer id) {
        return thirdLevelTaskResultPOS.stream().filter(e -> e.getId().equals(id))
                .findFirst().orElse(null);
    }

    public Integer getNextThirdLevelTaskResultId() {
        return thirdLevelTaskResultPOS.size() + 1;
    }

    public List<ThirdLevelTaskResultPO> getThirdLevelTaskResultByDoerId(Integer id) {
        return thirdLevelTaskResultPOS.stream().filter(e -> e.getDoerId().equals(id))
                .collect(Collectors.toList());
    }

}
