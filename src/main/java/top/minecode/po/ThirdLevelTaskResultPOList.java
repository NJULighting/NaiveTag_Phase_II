package top.minecode.po;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 2018/4/1.
 * Description:
 *
 * @author iznauy
 */
public class ThirdLevelTaskResultPOList {

    private List<ThirdLevelTaskResultPO> thirdLevelTaskResultPOS;

    public List<ThirdLevelTaskResultPO> getThirdLevelTaskResultPOS() {
        return thirdLevelTaskResultPOS;
    }

    public void setThirdLevelTaskResultPOS(List<ThirdLevelTaskResultPO> thirdLevelTaskResultPOS) {
        this.thirdLevelTaskResultPOS = thirdLevelTaskResultPOS;
    }

    public @Nullable ThirdLevelTaskResultPO getThirdLevelTaskResultById(Integer id) {
        return thirdLevelTaskResultPOS.stream().filter(e -> e.getId().equals(id))
                .findFirst().orElse(null);
    }

    public Integer getNextThirdLevelTaskResultId() {
        return thirdLevelTaskResultPOS.size() + 1;
    }

    public @NotNull List<ThirdLevelTaskResultPO> getThirdLevelTaskResultByDoerId(Integer id) {
        return thirdLevelTaskResultPOS.stream().filter(e -> e.getDoerId().equals(id))
                .collect(Collectors.toList());
    }

}
