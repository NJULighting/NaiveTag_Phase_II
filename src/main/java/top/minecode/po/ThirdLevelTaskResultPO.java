package top.minecode.po;

import top.minecode.domain.tag.TagResult;
import top.minecode.domain.task.ThirdLevelTaskResultType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2018/4/1.
 * Description:
 * @author iznauy
 */
public class ThirdLevelTaskResultPO implements Serializable {

    private Integer id; // 可以放空

    private Integer thirdLevelTaskId;

    private Map<String, TagResult> tagResults = new HashMap<>();

    private Integer doerId;

    private Double actualScore;

    private LocalDate acceptTime;

    private LocalDate expireTime;

    private LocalDate endTime; //做完的时间

    private ThirdLevelTaskResultType state = ThirdLevelTaskResultType.doing;

    public LocalDate getAcceptTime() {
        return acceptTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public ThirdLevelTaskResultPO() {
    }

    public ThirdLevelTaskResultPO(Integer thirdLevelTaskId,
                                  Integer doerId,
                                  LocalDate acceptTime, LocalDate expireTime) {
        this.thirdLevelTaskId = thirdLevelTaskId;
        this.doerId = doerId;
        this.acceptTime = acceptTime;
        this.expireTime = expireTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public void setAcceptTime(LocalDate acceptTime) {
        this.acceptTime = acceptTime;
    }

    public LocalDate getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDate expireTime) {
        this.expireTime = expireTime;
    }

    public ThirdLevelTaskResultType getState() {
        return state;
    }

    public void setState(ThirdLevelTaskResultType state) {
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getThirdLevelTaskId() {
        return thirdLevelTaskId;
    }

    public void setThirdLevelTaskId(Integer thirdLevelTaskId) {
        this.thirdLevelTaskId = thirdLevelTaskId;
    }

    public Map<String, TagResult> getTagResults() {
        return tagResults;
    }

    public void setTagResults(Map<String, TagResult> tagResults) {
        this.tagResults = tagResults;
    }

    public Integer getDoerId() {
        return doerId;
    }

    public void setDoerId(Integer doerId) {
        this.doerId = doerId;
    }

    public Double getActualScore() {
        return actualScore;
    }

    public void setActualScore(Double actualScore) {
        this.actualScore = actualScore;
    }
}