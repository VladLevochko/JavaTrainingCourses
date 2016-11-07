package ua.vlad.notebook;

import ua.vlad.notebook.model.NotebookRecord;

import java.util.List;

/**
 * Created by vlad on 06.11.16.
 */
public class View {

    public static final String GREETING = "Hello! You are in notebook";
    /**
     * person information recommendations
     */
    public static final String FIRST_NAME_RECOMMENDATION = "input first name in format 'Abcdfe'";
    public static final String LAST_NAME_RECOMMENDATION = "input last name in format 'Abcdfe";
    public static final String PATRONYMIC_RECOMMENDATION = "input patronymic 'Abcdfe'";
    public static final String NICKNAME_RECOMMENDATION = "input nickname";
    /**
     * comment recommendation
     */
    public static final String COMMENT_RECOMMENDATION = "input comment";
    /**
     * groups recommendation
     */
    public static final String GROUPS_RECOMMENDATION = "input groups";
    /**
     * contact information recommendations
     */
    public static final String HOME_PHONE_RECOMMENDATION = "input home number in format 0-123-456-789";
    public static final String MOBILE_PHONE_RECOMMENDATION = "input mobile number in format 012-345-67-89";
    public static final String OPTIONAL_MOBILE_PHONE_RECOMMENDATION = MOBILE_PHONE_RECOMMENDATION
            + "\nmay be empty";
    public static final String EMAIL_RECOMMENDATION = "input email";
    public static final String SKYPE_RECOMMENDATION = "input skype name";
    /**
     * address information recommendations
     */
    public static final String CITY_RECOMMENDATION = "input city";
    public static final String STREET_RECOMMENDATION = "input street";
    public static final String BUILDING_RECOMMENDATION = "input building number";
    public static final String APARTMENT_RECOMMENDATION = "input apartment number";
    public static final String INDEX_RECOMMENDATION = "input index (5 digits)";
    /**
     * data recommendations
     */
    public static final String CREATION_DATE_RECOMMENDATION = "input creation date in format dd/MM/yyyy";
    public static final String LAST_UPDATE_RECOMMENDATION = "input last update date in format dd/MM/yyyy";
    /**
     * warnings
     */
    public static final String NOTEBOOK_IS_EMPTY = "Notebook is empty";
    public static final String INCORRECT_COMMAND = "Incorrect command! Try again";
    public static final String INCORRECT_INPUT = "Incorrect input! Try again";

    public View() {

    }

    /**
     * print message to console
     * @param message string to print
     */
    public void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * print list of records
     * @param records list of records
     */
    public void printRecords(List<NotebookRecord> records) {
        if (records.size() == 0) {
            System.out.println(NOTEBOOK_IS_EMPTY);
        }
        for (NotebookRecord record: records) {
            System.out.println(record);
            System.out.println("--------------------------------");
        }
    }
}
