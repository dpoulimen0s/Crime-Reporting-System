/**
 *This is a class for representing an Incident object. This has methods
 * to set and get the values of it.
 *
 * @author Dimitris Poulimenos
 *
 */
public class Incident {
    private double value;
    private String postcode;
    private String month;
    private int year;

    /**
     *This is the constructor that wires up the parameter values with the field variables.
     *
     * @param value This represents the amount of money of the the stolen goods.
     * @param postcode This represents the postal code of the Area where the incident took place.
     * @param month This represents the month the incident took place.
     * @param year This represents the year the incident took place.
     */
    public Incident(double value, String postcode, String month, int year) {
        this.value = value;
        this.postcode = postcode;
        this.month = month;
        this.year = year;
    }

    public double getValue() {

        return value;
    }

    public void setValue(int value) {

        this.value = value;
    }

    public String getPostcode() {

        return postcode;
    }

    public void setPostcode(String postcode) {

        this.postcode = postcode;
    }

    public String getMonth() {

        return month;
    }

    public void setMonth(String month) {

        this.month = month;
    }

    public int getYear() {

        return year;
    }

    public void setYear(int year) {

        this.year = year;
    }


    /**
     *This returns a human readable version of our object (Incident)
     * @return string representation of an Incident.
     */
    @Override
    public String toString() {
        return "    Incident: Monetary Value=" + value + ", Postal Code='" + postcode + '\'' + ", Month='" + month + '\'' + ", Year=" + year + '\n';
    }
}
