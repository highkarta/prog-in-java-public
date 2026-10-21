package practice.assn3;

/**
 * ProjectAllocation
 */
public class ProjectAllocation {

    private int[][] hours;

    ProjectAllocation(int[][] hours) {
        this.hours = hours;
    }

    void displayEmployeeReport() {
        for (int i = 0; i < hours.length; i++) {
            for (int j = 0; j < hours[0].length; j++) {
                System.out.print(hours[i][j] + " ");
            }
            System.out.println();
        }
    }

    int calculateEmployeeTotal() {
        int total = 0;
        for (int i = 0; i < hours.length; i++) {
            for (int j = 0; j < hours[0].length; j++) {
                total += hours[i][j];
            }
            System.out.println(i + 1 + " " + total);
            total = 0;
        }
        return total; // what exactly can you return?
    }

    int[][] generateProjectReport() {
        int[][] transpose = new int[hours[0].length][hours.length]; // in transpose mxn becomes nxm
        // don't make this a global class variable, it does not impact states
        for (int i = 0; i < hours.length; i++) {
            for (int j = 0; j < hours[0].length; j++) {
                // don't forget the 0
                transpose[j][i] = hours[i][j]; // it is mandatory to have j,i = i,j condition, not the other way around, why?
            }
        }
        return transpose;
    }

    int[] calculateProjectTotal() {
        int[][] localTranspose = generateProjectReport(); // this must be called before you calculateProjectTotal()
        int[] totals = new int[localTranspose.length];
        int total = 0;
        for (int i = 0; i < localTranspose.length; i++) {
            for (int j = 0; j < localTranspose[0].length; j++) {
                total += localTranspose[i][j];
            }
            totals[i] = total;
            total = 0;
        }
        return totals;
    }

    int findMostWorkedProject() {
        int[] totals = calculateProjectTotal(); // Ensures totals are computed

        if (totals == null || totals.length == 0) {
            return -1; // Guard against empty data
        }

        int max = totals[0];
        int mostWorked = 1; // defaults to the first project
        for (int i = 0; i < totals.length; i++) {
            if (totals[i] > max) {
                max = totals[i];
                mostWorked = i + 1;
            }
        }
        return mostWorked;
    }

    public static void main(String[] args) {
        int[][] hours = {
            { 20, 15, 10 },
            { 12, 18, 14 },
            { 25, 10, 20 },
            { 15, 22, 12 },
        };
        ProjectAllocation p = new ProjectAllocation(hours);
        int val = p.findMostWorkedProject();
        System.out.println(val);
        /*
        int[][] bc = p.generateProjectReport();
        for (int i = 0; i < bc.length; i++) {
            for (int j = 0; j < bc[0].length; j++) {
                System.out.print(bc[i][j] + " ");
            }
            System.out.println();
        }
        */
    }
}
