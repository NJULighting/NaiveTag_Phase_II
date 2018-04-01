package top.minecode.po;


import java.util.List;

/**
 * Created on 2018/4/1.
 * Description:
 *
 * @author iznauy
 */
public class AdministratorPOList {

    private List<AdministratorPO> administratorPOS;

    public List<AdministratorPO> getAdministratorPOS() {
        return administratorPOS;
    }

    public void setAdministratorPOS(List<AdministratorPO> administratorPOS) {
        this.administratorPOS = administratorPOS;
    }

    public AdministratorPO getAdministratorById(Integer administratorId) {
        return administratorPOS.stream().filter(e -> e.getId().equals(administratorId))
                .findFirst().orElse(null);
    }

    public boolean addAdministratorPO(AdministratorPO po) {
        if (getAdministratorById(po.getId()) != null)
            return false;
        else
            administratorPOS.add(po);
        return true;
    }

    public Integer getNextAdministratorId() {
        return administratorPOS.size() + 1;
    }



}
