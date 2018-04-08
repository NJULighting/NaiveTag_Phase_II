package top.minecode.dao.task;

import org.springframework.stereotype.Repository;
import top.minecode.po.FirstLevelTaskPO;
import top.minecode.po.TableFactory;

import java.util.List;

/**
 * Created on 2018/4/7.
 * Description:
 * @author Liao
 */
@Repository
public class RequesterTaskDao {

    public List<FirstLevelTaskPO> getTasks() {
        return TableFactory.firstLevelTaskTable().getAll();
    }

}
