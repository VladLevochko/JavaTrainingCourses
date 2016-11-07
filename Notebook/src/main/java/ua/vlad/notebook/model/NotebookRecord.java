package ua.vlad.notebook.model;

import ua.vlad.notebook.UserGroups;

import java.util.Date;
import java.util.List;

/**
 * Created by vlad on 06.11.16.
 */
public class NotebookRecord {

    private Person person;
    private String comment;
    private List<UserGroups> groups;
    private ContactInformation contactInformation;
    private Address address;
    private Date creationDate;
    private Date lastUpdate;

    public NotebookRecord() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public ContactInformation getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<UserGroups> getGroups() {
        return groups;
    }

    public void setGroups(List<UserGroups> groups) {
        this.groups = groups;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "NotebookRecord{" +
                "person=" + person +
                ", comment='" + comment + '\'' +
                ", groups=" + groups +
                ", contactInformation=" + contactInformation +
                ", address=" + address +
                ", creationDate=" + creationDate +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
