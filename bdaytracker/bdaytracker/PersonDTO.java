package bdaytracker;

public class PersonDTO {

    private String name;
    private String likes;
    private String dislikes;
    private int birthDay_Day;
    private int birthDay_Month;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getDislikes() {
        return dislikes;
    }

    public void setDislikes(String dislikes) {
        this.dislikes = dislikes;
    }

    public int getBirthDay_Day() {
        return birthDay_Day;
    }

    public void setBirthDay_Day(int birthDay_Day) {
        this.birthDay_Day = birthDay_Day;
    }

    public int getBirthDay_Month() {
        return birthDay_Month;
    }

    public void setBirthDay_Month(int birthDay_Month) {
        this.birthDay_Month = birthDay_Month;
    }

}
