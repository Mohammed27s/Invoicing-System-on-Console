package SoloProject;

import java.util.HashMap;
import java.util.Map;

//This is Program Statistics Class
public class ProgramStatistics {
    // Field to store the counts of each menu option
    private final Map<Integer, Integer> menuOptionCounts;

    // Constructor
    public ProgramStatistics() {
        menuOptionCounts = new HashMap<>();
    }

    // Increment the count of the selected menu option
    public void updateMenuOptionCount(Integer optionNum) {
        menuOptionCounts.put(optionNum, menuOptionCounts.getOrDefault(optionNum, 0) + 1);
    }

    // Display Program Statistics
    public void displayProgramStatistics() {
        System.out.println("Program Statistics:");
        for (Map.Entry<Integer, Integer> entry : menuOptionCounts.entrySet()) {
            System.out.println("Menu Option " + entry.getKey() + " selected " + entry.getValue() + " times.");
        }
    }
}
