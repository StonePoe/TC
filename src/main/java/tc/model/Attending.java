package tc.model;

import java.util.Date;

public class Attending {
    private int id;
    private int sid;
    private int cid;
    private int state;
    private int isMember;
    private String enrollingTime;
    private double Score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getIsMember() {
        return isMember;
    }

    public void setIsMember(int isMember) {
        this.isMember = isMember;
    }

    public String getEnrollingTime() {
        return enrollingTime;
    }

    public void setEnrollingTime(String enrollingTime) {
        this.enrollingTime = enrollingTime;
    }

    public double getScore() {
        return Score;
    }

    public void setScore(double score) {
        Score = score;
    }

    @Override
    public String toString() {
        return "Attending{" +
                "id=" + id +
                ", sid=" + sid +
                ", cid=" + cid +
                ", state=" + state +
                ", isMember=" + isMember +
                ", enrollingTime='" + enrollingTime + '\'' +
                ", Score=" + Score +
                '}';
    }
}