import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        District dist1 = new District("NEWCASTLE");
        Incident inc1 = new Incident(585.5,"NE12JA","JUNE",2018);
        Incident inc2 = new Incident(5065.3,"NE12KM","JULY",2020);
        Incident inc3 = new Incident(10127.24,"NE1FJ2","MARCH",2020);
        dist1.getIncidents().add(inc1);
        dist1.getIncidents().add(inc2);
        dist1.getIncidents().add(inc3);
        newrep.distToMap(dist1.getName(), dist1);

        //District Durham with incidents.
        District dist2 = new District("DURHAM");
        Incident inc4 = new Incident(1050,"DH1T2M","JUNE",2010);
        Incident inc5 = new Incident(5050.5,"DH125S","JANUARY",2015);
        Incident inc6 = new Incident(15056.5,"DH11AQ","OCTOBER",2020);
        dist2.getIncidents().add(inc4);
        dist2.getIncidents().add(inc5);
        dist2.getIncidents().add(inc6);
        newrep.distToMap(dist2.getName(), dist2);

        //District London with incidents.
        District dist3 = new District("LONDON");
        Incident inc7 = new Incident(20000,"W1127F","SEPTEMBER",2013);
        Incident inc8 = new Incident(3560.5,"W11F32","OCTOBER",2017);
        Incident inc9 = new Incident(585.5,"W11N4J","NOVEMBER",2019);
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

                    System.out.println("The list of Districts have " + newrep.districts.values().size() + " inside.");
                    System.out.println("-----------------------------------------------------------------------------");
                    for (String name : newrep.districts.keySet()) {
                        System.out.println("- " + name);
                    }
                    System.out.println("--------------");
                    District district1 = inputDistrict();
                    if (newrep.districts.containsKey(district1.getName())) {
                        System.out.println("The District " + district1.getName() + " is already in the District list.");
                        System.out.println("Select option 2 from the main menu to add an Incident to " +
                                ""+ district1.getName());
                        break;
                    }
                    newrep.districts.put(district1.getName(), district1 );
                    System.out.println("You have successfully created a new District!");
                    System.out.println(newrep.districts.values());
                    break;

                case "2":

                    System.out.println("--------------------------------------------------------------------");
                    System.out.println("| In order to add an Incident you have to assign it to a District  |");
                    System.out.println("| from the list below.                                             |");
                    System.out.println("| If the District does not exist it will be created automatically. |");
                    System.out.println("--------------------------------------------------------------------");
                    System.out.println("District List: ");
                    System.out.println("---------------");
                    for (String name : newrep.districts.keySet()) {

                        System.out.println( "- " + name);
                    }
                    System.out.println("-------------------------------------");
                    System.out.println("Please enter the name of the District: ");
                    String distname = sc.nextLine().toUpperCase();

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


                    Scanner sc1 = new Scanner(System.in);

                    System.out.println("----------------------------------------------------------------------------");
                    System.out.println("| 1. The district with the largest average value incident for a given year |");
                    System.out.println("| 2. The largest value incident ever recorded                              |");
                    System.out.println("| 3. A list of all incidents recorded with value greater than a given      |");
                    System.out.println("|    amount of money                                                       |");
                    System.out.println("| 4. Back to menu                                                          |");
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.println("Please select one of the options: ");
                    String choice1 = sc1.nextLine();

                    switch (choice1) {

                        case "1":

                            break ;
                        case "2":


                            break ;

                        case "3":

                            break;

                        case "4":

                            break;

                        default:
                            System.out.println("Please enter a valid number!");
                            break ;
                    }


                    break;

                case "4":
                    //Here I'm displaying a message when the user decides to terminate the program.
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

        System.out.println("Enter the month that incident happened: (e.g January)");
        String month = sc.nextLine().toUpperCase();

        System.out.println("Enter the year that incident happened: (e.g 2020)");
        int year = sc.nextInt();

        return new Incident(value,postcode,month,year);

    }

    public District inputDistrict(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the name of the new District: ");
        System.out.println();
        String name = sc.nextLine().toUpperCase();
        return new District(name);
    }

}
