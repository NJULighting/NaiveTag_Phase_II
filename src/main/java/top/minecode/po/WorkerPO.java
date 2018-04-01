package top.minecode.po;

import java.util.List;

/**
 * Created on 2018/4/1.
 * Description:
 * @author iznauy
 */
public class WorkerPO {

    private Integer id;
    private String username;
    private String password;
    private String name;
    private String email;
    private Double scores;
    private Double averageScoreRatio;
    private List<Integer> thirdLevelTasks;
    private List<Integer> thirdLevelTasksResults;

    public WorkerPO(Integer id, String username, String password, String name, String email,
                    Double scores, Double averageScoreRatio, List<Integer> thirdLevelTasks,
                    List<Integer> thirdLevelTasksResults) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.scores = scores;
        this.averageScoreRatio = averageScoreRatio;
        this.thirdLevelTasks = thirdLevelTasks;
        this.thirdLevelTasksResults = thirdLevelTasksResults;
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

    public List<Integer> getThirdLevelTasks() {
        return thirdLevelTasks;
    }

    public void setThirdLevelTasks(List<Integer> thirdLevelTasks) {
        this.thirdLevelTasks = thirdLevelTasks;
    }

    public List<Integer> getThirdLevelTasksResults() {
        return thirdLevelTasksResults;
    }

    public void setThirdLevelTasksResults(List<Integer> thirdLevelTasksResults) {
        this.thirdLevelTasksResults = thirdLevelTasksResults;
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
}
