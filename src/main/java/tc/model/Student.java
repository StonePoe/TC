package tc.model;

/**
 * Created by stonezhang on 2017/2/20.
 */
public class Student {
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", bankid=" + bankid +
                ", memeberid=" + memeberid +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    private long id;
    private Long bankid;
    private Long memeberid;
    private String password;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getBankid() {
        return bankid;
    }

    public void setBankid(Long bankid) {
        this.bankid = bankid;
    }

    public Long getMemeberid() {
        return memeberid;
    }

    public void setMemeberid(Long memeberid) {
        this.memeberid = memeberid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student that = (Student) o;

        if (id != that.id) return false;
        if (bankid != null ? !bankid.equals(that.bankid) : that.bankid != null) return false;
        if (memeberid != null ? !memeberid.equals(that.memeberid) : that.memeberid != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (bankid != null ? bankid.hashCode() : 0);
        result = 31 * result + (memeberid != null ? memeberid.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
