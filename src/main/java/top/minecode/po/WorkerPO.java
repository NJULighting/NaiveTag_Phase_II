package top.minecode.po;


import top.minecode.domain.user.UserType;
import top.minecode.domain.user.Worker;

import java.io.Serializable;

/**
 * Created on 2018/4/1.
 * Description:
 * @author iznauy
 */
public class WorkerPO implements Serializable {

    private Integer id;
    private String username;
    private String password;
    private String name;
    private String email;
    private Double scores;
    private Double averageScoreRatio;

    public WorkerPO() {
    }

    public WorkerPO(Integer id, String username, String password, String name, String email,
                    Double scores, Double averageScoreRatio) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.scores = scores;
        this.averageScoreRatio = averageScoreRatio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getScores() {
        return scores;
    }

    public void setScores(Double scores) {
        this.scores = scores;
    }

    public Double getAverageScoreRatio() {
        return averageScoreRatio;
    }

    public void setAverageScoreRatio(Double averageScoreRatio) {
        this.averageScoreRatio = averageScoreRatio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Worker toWorker() {
        Worker worker = new Worker();
        worker.setScore(scores);
        worker.setUserType(UserType.worker);
        worker.setEmail(email);
        worker.setUsername(username);
        worker.setId(id);
        worker.setName(name);
        worker.setPassword(password);
        worker.setAverageScoreRatio(averageScoreRatio);
        return worker;
    }

}
