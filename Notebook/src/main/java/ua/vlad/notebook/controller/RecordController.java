package ua.vlad.notebook.controller;

import ua.vlad.notebook.View;
import ua.vlad.notebook.globalvariables.RegularExpressions;
import ua.vlad.notebook.model.Address;
import ua.vlad.notebook.model.ContactInformation;
import ua.vlad.notebook.model.NotebookRecord;
import ua.vlad.notebook.model.Person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by vlad on 07.11.16.
 */
public class RecordController {

    private Scanner in;
    private View view;

    /**
     * Constructor
     * @param in Scanner object
     * @param view View object
     */
    public RecordController(Scanner in, View view) {
        this.in = in;
        this.view = view;
    }

    /**
     * creates new record object and fill it
     * @return filled record object
     */
    public NotebookRecord processRecord() {
        NotebookRecord record = new NotebookRecord();

        record.setPerson(readPersonInformation());
        record.setComment(readComment());
        record.setContactInformation(readContactInformation());
        record.setAddress(readAddress());
        record.setCreationDate(readDate(
                RegularExpressions.DATE_REGEX,
                View.CREATION_DATE_RECOMMENDATION
        ));
        record.setLastUpdate(readDate(
                RegularExpressions.DATE_REGEX,
                View.LAST_UPDATE_RECOMMENDATION
        ));

        return record;
    }

    /**
     * read string and parse it to data object
     * @param regex regular expression for string to be read
     * @param recommendation message for user about expected format of input
     * @return date object
     */
    private Date readDate(String regex, String recommendation) {
        String stringDate = readInformation(regex, recommendation);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
        Date date = null;
        try {
            date = formatter.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    /**
     * create and fill address object
     * @return address object
     */
    private Address readAddress() {
        Address address = new Address();

        address.setCity(readInformation(
                RegularExpressions.CITY_REGEX,
                View.CITY_RECOMMENDATION
        ));
        address.setStreet(readInformation(
                RegularExpressions.STREET_REGEX,
                View.STREET_RECOMMENDATION
        ));
        address.setBuildingNumber(readInformation(
                RegularExpressions.BUILDING_REGEX,
                View.BUILDING_RECOMMENDATION
        ));
        address.setApartmentNumber(Integer.parseInt(readInformation(
                RegularExpressions.APARTMENT_REGEX,
                View.APARTMENT_RECOMMENDATION
        )));
        address.setIndex(readInformation(
                RegularExpressions.INDEX_REGEX,
                View.INDEX_RECOMMENDATION
        ));
        address.setFullAddress();

        return address;
    }

    /**
     * create and fill ContactInformation object
     * @return filled ContactInformation object
     */
    private ContactInformation readContactInformation() {
        ContactInformation contactInformation = new ContactInformation();

        contactInformation.setHomePhone(readInformation(
                RegularExpressions.HOME_PHONE_REGEX,
                View.HOME_PHONE_RECOMMENDATION
        ));
        contactInformation.setMobilePhone(readInformation(
                RegularExpressions.MOBILE_PHONE_REGEX,
                View.MOBILE_PHONE_RECOMMENDATION
        ));
        contactInformation.setMobilePhone2(readInformation(
                RegularExpressions.MOBILE_PHONE2_REGEX,
                View.OPTIONAL_MOBILE_PHONE_RECOMMENDATION
        ));
        contactInformation.setEmail(readInformation(
                RegularExpressions.EMAIL_REGEX,
                View.EMAIL_RECOMMENDATION
        ));
        contactInformation.setSkype(readInformation(
                RegularExpressions.SKYPE_REGEX,
                View.SKYPE_RECOMMENDATION
        ));

        return contactInformation;
    }

    /**
     * read comment to record
     * @return string with comment
     */
    private String readComment() {
        return readInformation(RegularExpressions.COMMENT_REGEX, View.COMMENT_RECOMMENDATION);
    }

    /**
     * create and fill Person object
     * @return filled Person object
     */
    public Person readPersonInformation() {
        Person person = new Person();

        person.setFirstName(readInformation(
                RegularExpressions.NAME_REGEX,
                View.FIRST_NAME_RECOMMENDATION
        ));
        person.setLastName(readInformation(
                RegularExpressions.LAST_NAME_REGEX,
                View.LAST_NAME_RECOMMENDATION
        ));
        person.setPatronymic(readInformation(
                RegularExpressions.NAME_REGEX,
                View.PATRONYMIC_RECOMMENDATION
        ));
        person.setFullName();
        person.setNickName(readInformation(
                RegularExpressions.NICK_NAME_REGEX,
                View.NICKNAME_RECOMMENDATION
        ));

        return person;
    }

    /**
     * read user's input and check it with regular expression
     * @param regex regular expression
     * @param recommendation message about expected format of input
     * @return string that match regular expression
     */
    public String readInformation(String regex, String recommendation) {
        view.printMessage(recommendation);

        String s;
        while(!(s = in.nextLine()).matches(regex)) {
            view.printMessage(View.INCORRECT_INPUT);
            view.printMessage(recommendation);
        }

        return s;
    }
}
