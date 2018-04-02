package top.minecode.json.user;

/**
 * Created on 2018/4/3.
 * Description:
 *
 * @author iznauy
 */
public class WorkerInfoResponse {

    private String username;

    private String name;

    private String email;

    private Integer rank;

    private String averageScoreRatio;

    private Double totalScore;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getAverageScoreRatio() {
        return averageScoreRatio;
    }

    public void setAverageScoreRatio(String averageScoreRatio) {
        this.averageScoreRatio = averageScoreRatio;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }
}
