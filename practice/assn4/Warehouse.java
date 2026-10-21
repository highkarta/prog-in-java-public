package practice.assn4;

import java.util.*;

/**
 * Warehouse
 */
public class Warehouse {

    private int[][] inventory;

    Warehouse(int[][] inventory) {
        this.inventory = inventory;
    }

    void displayInventory() {
        for (int i = 0; i < inventory.length; i++) {
            for (int j = 0; j < inventory.length; j++) {
                System.out.print(inventory[i][j] + " ");
            }
            System.out.println();
        }
    }

    void getRobotVisitOrder() {
        int top, left, bottom, right;
        top = left = 0;
        bottom = inventory.length - 1;
        right = inventory[0].length - 1; // 1
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                System.out.print(inventory[top][i] + " ");
            }
            top++;
            // System.out.println();

            for (int i = top; i <= bottom; i++) {
                System.out.print(inventory[i][right] + " ");
            }
            // System.out.println();
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.print(inventory[bottom][i] + " ");
                }
                bottom--;
            }
            // System.out.println();

            if (left < right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(inventory[i][left] + " ");
                }
                left++;
            }
            // System.out.println();
        }
    }

    int[] calculateBoundaryStock() {
        // fix this
        // List<Integer> cnt = new ArrayList<>();
        int top, bottom, left, right;
        top = left = 0;
        bottom = right = inventory.length - 1;
        int r = inventory.length / 2;
        // right = inventory[0].length - 1;
        int[] sectionA = new int[r];

        for (int i = 0; i < r; i++) {
            int section = 0;
            for (int j = left; j <= right; j++) {
                section += inventory[top][i];
                if (top != bottom) {
                    section += inventory[bottom][i];
                }
            }

            for (int j = top + 1; j <= bottom; j++) {
                section += inventory[j][left];
                if (left != right) {
                    section += inventory[j][right];
                }
            }

            sectionA[i] = section;
            System.out.println("Section " + (i + 1) + " = " + section);
            
            top++;
            left++;
            bottom--;
            right--;
        }

        return sectionA;

        /*
        while (top < bottom && left < right) {
            int total = 0;
            for (int i = 0; i < inventory.length; i++) {
                for (int j = 0; j < inventory.length; j++) {
                    if (i == top || i == bottom || j == left || j == right) {
                        total += inventory[i][j]; // no need to account for border elements
                    }
                }
                cnt.add(total);
            }
        }
        */

        /*
        for (int i = 0; i < inventory.length; i++) {
            for (int j = 0; j < inventory.length; j++) {
                if (
                    i == 0 ||
                    i == inventory.length - 1 ||
                    j == 0 ||
                    j == inventory.length - 1
                ) {
                    total += inventory[i][j]; // no need to account for border elements
                }
            }
        }
        */
    }

    int findMaximumSection() {
        // fix this
        int max = inventory[0][0]; // can't take 0
        for (int i = 0; i < inventory.length; i++) {
            for (int j = 0; j < inventory.length; j++) {
                if (inventory[i][j] > max) {
                    max = inventory[i][j];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] inventory = {
            { 10, 20, 30, 40 },
            { 50, 60, 70, 80 },
            { 90, 100, 110, 120 },
            { 130, 140, 150, 160 },
        };

        Warehouse w = new Warehouse(inventory);
        w.displayInventory();
        System.out.println();
        w.getRobotVisitOrder();
        System.out.println();
        int[] val1 = w.calculateBoundaryStock();
        for (int el : val1) {
            System.out.println(el);
        }
        // int val2 = w.findMaximumSection();
        // System.out.println(val2);
    }
}
