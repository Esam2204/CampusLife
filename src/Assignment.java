public class Assignment extends PlanItem {

    private Course course;

    public Assignment(String title, Course course, int estimatedHours, int daysUntil) {
        super(title, estimatedHours, daysUntil);
        this.course = course;
    }

    @Override
    public String getCategory() {
        return "Assignment (" + course.getName() + ")";
    }
}
