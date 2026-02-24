import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // --- Create Courses ---
        Course pl = new Course("PL", "Ms Azhan", 6);
        Course discrete = new Course("Discrete Math", "Mr Matanov", 5);
        Course korean = new Course("Korean", "Ms Tattyby", 3);

        ArrayList<Course> courses = new ArrayList<>();
        courses.add(pl);
        courses.add(discrete);
        courses.add(korean);

        // --- Create Assignment Tasks ---
        ArrayList<AssignmentTask> tasks = new ArrayList<>();
        tasks.add(new AssignmentTask("Lab 2", pl, 3, 1));
        tasks.add(new AssignmentTask("Project Part 1", pl, 8, 5));
        tasks.add(new AssignmentTask("Homework 3", discrete, 4, 2));
        tasks.add(new AssignmentTask("Essay Draft", korean, 5, 7));
        tasks.add(new AssignmentTask("Quiz Prep", discrete, 2, 0));

        // --- Create Study Sessions ---
        ArrayList<StudySession> sessions = new ArrayList<>();
        sessions.add(new StudySession(pl, 90));
        sessions.add(new StudySession(discrete, 120));
        sessions.add(new StudySession(pl, 60));
        sessions.add(new StudySession(korean, 45));

        // --- Print Courses ---
        System.out.println("=== COURSES ===");
        for (Course c : courses) {
            System.out.println(c);
        }

        // --- Print Assignments + Highlight Urgent ---
        System.out.println("=== ASSIGNMENTS ===");
        for (AssignmentTask t : tasks) {
            if (t.isUrgent()) {
                System.out.println(t + "  <-- URGENT");
            } else {
                System.out.println(t);
            }
        }

        // --- Total Estimated Hours Remaining ---
        int totalRemainingHours = 0;
        for (AssignmentTask t : tasks) {
            if (!t.isCompleted()) {
                totalRemainingHours += t.getEstimatedHours();
            }
        }
        System.out.println("Total remaining estimated hours: " + totalRemainingHours);

        // --- Total Study Time Per Course ---
        System.out.println("=== STUDY TIME PER COURSE (in hours) ===");
        for (Course c : courses) {
            double totalHours = 0;
            for (StudySession s : sessions) {
                if (s.getCourse().equals(c)) {
                    totalHours += s.hours();
                }
            }
            System.out.println(c.getName() + ": " + totalHours + " hours");
        }

        // --- Mark one assignment as completed ---
        AssignmentTask completedTask = tasks.get(0); // Lab 2
        completedTask.markCompleted();

        System.out.println("=== AFTER COMPLETING ONE TASK ===");
        System.out.println("Updated Task:");
        System.out.println(completedTask);

        // Recalculate remaining hours
        totalRemainingHours = 0;
        for (AssignmentTask t : tasks) {
            if (!t.isCompleted()) {
                totalRemainingHours += t.getEstimatedHours();
            }
        }
        System.out.println("New remaining estimated hours: " + totalRemainingHours);
    }
}
