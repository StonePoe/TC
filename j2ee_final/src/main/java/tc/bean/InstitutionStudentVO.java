package tc.bean;

import tc.model.Student;

/**
 * Created by stonezhang on 2017/3/18.
 */
public class InstitutionStudentVO {
    private int id;
    private String name;
    private double score;
    private String enrollTime;
    private int learningState;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getEnrollTime() {
        return enrollTime;
    }

    public void setEnrollTime(String enrollTime) {
        this.enrollTime = enrollTime;
    }

    public int getLearningState() {
        return learningState;
    }

    public void setLearningState(int learningState) {
        this.learningState = learningState;
    }
}
