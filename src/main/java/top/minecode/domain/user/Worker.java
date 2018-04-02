package top.minecode.domain.user;

import top.minecode.po.WorkerPO;

/**
 * Created on 2018/4/2.
 * Description:
 *
 * @author iznauy
 */
public class Worker extends GeneralUser {

    private Double averageScoreRatio = 1.0;

    public Double getAverageScoreRatio() {
        return averageScoreRatio;
    }

    public void setAverageScoreRatio(Double averageScoreRatio) {
        this.averageScoreRatio = averageScoreRatio;
    }

    public Worker() {

    }

    public Worker(Integer id, UserType userType, String userName,
                  String name, String password, String email,
                  Double score, Double averageScoreRatio) {
        super(id, userType, userName, name, password, email, score);
        this.averageScoreRatio = averageScoreRatio;
    }

    public WorkerPO toWorkerPO() {
        WorkerPO worker = new WorkerPO();
        worker.setScores(score);
        worker.setEmail(email);
        worker.setUsername(username);
        worker.setId(id);
        worker.setName(name);
        worker.setPassword(password);
        worker.setAverageScoreRatio(averageScoreRatio);
        return worker;
    }

}
