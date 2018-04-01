package top.minecode.po;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.util.List;

/**
 * Created on 2018/4/1.
 * Description:
 *
 * @author iznauy
 */
public class RequesterPOList {

    private List<RequesterPO> requesterPOS;

    public List<RequesterPO> getRequesterPOS() {
        return requesterPOS;
    }

    public void setRequesterPOS(List<RequesterPO> requesterPOS) {
        this.requesterPOS = requesterPOS;
    }

    public @Nullable RequesterPO getRequesterById(Integer requesterId) {
        return requesterPOS.stream().filter(e -> e.getId().equals(requesterId))
                .findFirst().orElse(null);
    }

    public boolean addRequesterPO(@NotNull RequesterPO po) {
        if (getRequesterById(po.getId()) != null)
            return false;
        else
            requesterPOS.add(po);
        return true;
    }

    public Integer getNextRequesterId() {
        return requesterPOS.size() + 1;
    }

}
