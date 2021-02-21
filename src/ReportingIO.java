import java.util.Scanner;

public class ReportingIO {

    public static void main(String[] args) {

        new ReportingIO().menu();
    }

    private void menu() {
        Reporting newrep = new Reporting();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        //Sample Data for Testing.
        //District Newcastle with incidents.
        District dist1 = new District("Newcastle");
        Incident inc1 = new Incident(585.5,"ne12ja","June",2018);
        Incident inc2 = new Incident(5065.3,"ne12km","July",2019);
        Incident inc3 = new Incident(10127.24,"ne1fj2","August",2020);
        dist1.getIncidents().add(inc1);
        dist1.getIncidents().add(inc2);
        dist1.getIncidents().add(inc3);
        newrep.distToMap(dist1.getName(), dist1);

        //District Durham with incidents.
        District dist2 = new District("Durham");
        Incident inc4 = new Incident(1050,"dh1t2m","june",2010);
        Incident inc5 = new Incident(5050.5,"dh125s","january",2015);
        Incident inc6 = new Incident(15056.5,"dh11aq","october",2020);
        dist2.getIncidents().add(inc4);
        dist2.getIncidents().add(inc5);
        dist2.getIncidents().add(inc6);
        newrep.distToMap(dist2.getName(), dist2);

        //District London with incidents.
        District dist3 = new District("London");
        Incident inc7 = new Incident(20000,"w1127f","september",2013);
        Incident inc8 = new Incident(3560.5,"w11f32","sctober",2017);
        Incident inc9 = new Incident(585.5,"w11n4j","november",2019);
        dist3.getIncidents().add(inc7);
        dist3.getIncidents().add(inc8);
        dist3.getIncidents().add(inc9);
        newrep.distToMap(dist3.getName(), dist3);


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
                    System.out.println("The list of Districts have " + newrep.districts.values().size() + " inside.");
                    System.out.println("-----------------------------------------------------------------------------");
                    for (String name : newrep.districts.keySet()) {
                        System.out.println(name);
                    }
                    System.out.println("--------------");
                    District district1 = inputDistrict();
                    newrep.districts.put(district1.getName(), district1 );
                    System.out.println(newrep.districts.values());
                    break;

                case "2":
                    // here is the code to add data to incident.
                    System.out.println("--------------------------------------------------------------------");
                    System.out.println("| In order to add an Incident you have to assign it to a District  |");
                    System.out.println("| from the list below.                                             |");
                    System.out.println("| If the District does not exist it will be created automatically. |");
                    System.out.println("--------------------------------------------------------------------");
                    System.out.println("District List: ");
                    System.out.println("---------------");
                    for (String name : newrep.districts.keySet()) {
                        System.out.println(name);
                    }
                    System.out.println("-------------------------------------");
                    System.out.println("Please enter the name of the District: ");
                    String distname = sc.nextLine();

                    if(newrep.getDistricts().containsKey(distname)) {
                        newrep.addIncident(distname, inputIncident());
                        System.out.println("You have successfully added an Incident to " + distname );
                    }else   {
                        District district = new District(distname);
                        district.getIncidents().add(inputIncident());
                        newrep.distToMap(distname, district);
                        System.out.println("You have successfully created the District " + distname + " with Incident");
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
        System.out.println("Please enter the name of the new District: ");
        System.out.println();
        String name = sc.nextLine();
        return new District(name);
    }

}
