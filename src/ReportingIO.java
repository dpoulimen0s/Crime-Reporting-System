import java.util.Scanner;

public class ReportingIO {

    public static void main(String[] args) {

        new ReportingIO().menu();
    }

    private void menu() {
        Reporting newrep = new Reporting();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            System.out.println("--------------------------");
            System.out.println("| 1. Enter District data |");
            System.out.println("| 2. Enter Incident data |");
            System.out.println("| 3. Report              |");
            System.out.println("| 4. Exit                |");
            System.out.println("--------------------------");
            System.out.println("Please select an option: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    // here is the code to add data to a district.
                    District district1 = inputDistrict();
                    newrep.districts.put(district1.getName(), district1 );
                    System.out.println(newrep.districts.values());
                    break;

                case "2":
                    // here is the code to add data to incident.
                    String distname = sc.nextLine();
                    //newrep.getDistricts().put(district.getName(),district);
                    //System.out.println(newrep.getDistricts().values());
                    if(newrep.getDistricts().containsKey(distname)) {
                        newrep.addIncident(distname, inputIncident());
                    }else   {
                        District district = new District(distname);
                        district.getIncidents().add(inputIncident());
                        newrep.distToMap(distname, district);
                    }
                    break;

                case "3":

                    /* here is the code to take reports about:

                    • The district with the largest average value incident for a given year.
                    • The largest value incident ever recorded.
                    • A list of all incidents recorded with value greater than a given amount of money.
                    */
                    System.out.println(newrep.districts.values());
                    break;

                case "4":
                    System.out.println("The program is terminated.");
                    System.out.println("Thank You!");
                    flag = false;
                    break;

                default:
                    System.out.println("This is not a valid option!");

            }
        }
    }

    public Incident inputIncident() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the value of the incident: ");
        double value = sc.nextDouble();

        System.out.println("Enter the postal code of the incident: ");
        sc.nextLine();
        String postcode = sc.nextLine().toUpperCase();

        System.out.println("Enter the month that incident happened: ");
        String month = sc.nextLine().toUpperCase();

        System.out.println("Enter the year that incident happened: ");
        int year = sc.nextInt();

        return new Incident(value,postcode,month,year);

    }

    public District inputDistrict(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the name of the district: ");
        String name = sc.nextLine();
        return new District(name);
    }

}
