import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Course pl = new Course("PL", "Ms Azhan", 6);
        Course discrete = new Course("Discrete Math", "Mr Matanov", 5);
        Course korean = new Course("Korean", "Ms Tattyby", 3);

        ArrayList<PlanItem> plan = new ArrayList<>();

        plan.add(new Assignment("Lab 3", pl, 3, 1));
        plan.add(new Assignment("Homework 4", discrete, 4, 3));
        plan.add(new ExamPreparation("Midterm Review", discrete, 6, 4));
        plan.add(new ClubEvent("Programming Club", 2, 0));

        System.out.println("=== ALL ITEMS ===");
        for (PlanItem item : plan) {
            if (item.isUrgent()) {
                System.out.println(item + "  <-- URGENT");
            } else {
                System.out.println(item);
            }
        }

        int totalHours = 0;
        for (PlanItem item : plan) {
            if (!item.isCompleted()) {
                totalHours += item.getEstimatedHours();
            }
        }

        System.out.println("\nTotal remaining hours: " + totalHours);

        // отмечаем одно выполненным
        plan.get(0).markCompleted();

        System.out.println("\nAfter completion:");
        System.out.println(plan.get(0));
    }
}
