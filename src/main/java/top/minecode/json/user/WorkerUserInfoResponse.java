package top.minecode.json.user;

/**
 * Created on 2018/4/12.
 * Description:
 *
 * @author iznauy
 */
public class WorkerUserInfoResponse extends UserInfoResponse {

    private int rank;

    private double averageScoreRatio;

    public WorkerUserInfoResponse() {
    }

    public WorkerUserInfoResponse(String username, String name, String email,
                                  Double score, int rank, double averageScoreRatio) {
        super(username, name, email, score);
        this.rank = rank;
        this.averageScoreRatio = averageScoreRatio;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public double getAverageScoreRatio() {
        return averageScoreRatio;
    }

    public void setAverageScoreRatio(double averageScoreRatio) {
        this.averageScoreRatio = averageScoreRatio;
    }
}
