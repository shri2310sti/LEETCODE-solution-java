import java.util.*;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<Robot> robots = new ArrayList<>(n);

        // Step 1: Combine all information into a list of robots
        for (int i = 0; i < n; i++) {
            robots.add(new Robot(positions[i], healths[i], directions.charAt(i), i));
        }

        // Step 2: Sort robots by their positions
        robots.sort(Comparator.comparingInt(robot -> robot.position));

        // Step 3: Use a stack to handle the collisions
        Deque<Robot> stack = new ArrayDeque<>();
        for (Robot robot : robots) {
            if (robot.direction == 'R') {
                stack.push(robot);
            } else {
                while (!stack.isEmpty() && stack.peek().direction == 'R') {
                    Robot rightRobot = stack.peek();
                    if (rightRobot.health > robot.health) {
                        rightRobot.health -= 1;
                        robot = null;
                        break;
                    } else if (rightRobot.health < robot.health) {
                        robot.health -= 1;
                        stack.pop();
                    } else {
                        stack.pop();
                        robot = null;
                        break;
                    }
                }
                if (robot != null) {
                    stack.push(robot);
                }
            }
        }

        // Step 4: Collect the healths of the surviving robots in the initial order
        List<Integer> survivingHealths = new ArrayList<>();
        robots.sort(Comparator.comparingInt(robot -> robot.index)); // Sort back by initial index
        Set<Integer> survivingIndices = new HashSet<>();
        for (Robot robot : stack) {
            survivingIndices.add(robot.index);
        }

        for (Robot robot : robots) {
            if (survivingIndices.contains(robot.index)) {
                survivingHealths.add(robot.health);
            }
        }

        return survivingHealths;
    }

    // Helper class to store robot information
    static class Robot {
        int position;
        int health;
        char direction;
        int index;

        Robot(int position, int health, char direction, int index) {
            this.position = position;
            this.health = health;
            this.direction = direction;
            this.index = index;
        }
    }
}
