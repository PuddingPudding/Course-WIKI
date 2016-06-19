/**
 * Created by arial on 2016/6/19.
 */
public class courseClass {
    private String courseName = "";
    private String courseID = "";
    private double courseScore = 0;
    private String teacher = "";
    private int score = 0;

    private courseClass(String courseName, String courseID, double courseScore, String teacher, int score)
    {
        this.courseName = courseName;
        this.courseID = courseID;
        this.courseScore = courseScore;
        this.teacher = teacher;
        this.score = score;
    }
}
