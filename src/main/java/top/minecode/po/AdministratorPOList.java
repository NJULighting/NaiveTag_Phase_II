package top.minecode.po;


import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2018/4/1.
 * Description:
 *
 * @author iznauy
 */
public class AdministratorPOList extends Table {

    private List<AdministratorPO> administratorPOS;

    public AdministratorPOList() {
        super();
    }

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

    @Override
    protected String getFileName() {
        return "admin.json";
    }

    @Override
    protected void save() {
        String json = POConfig.gson.toJson(this);
        writeToFile(json);
    }

    @Override
    protected void load() {
        String json = loadFromFile();
        if (json == null)
            administratorPOS = new ArrayList<>();
        else {
            AdministratorPOList temp = POConfig.gson.fromJson(json, AdministratorPOList.class);
            this.administratorPOS = temp.administratorPOS;
        }
    }
}
