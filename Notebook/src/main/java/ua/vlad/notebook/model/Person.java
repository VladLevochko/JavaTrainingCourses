package ua.vlad.notebook.model;

/**
 * Created by vlad on 07.11.16.
 */
public class Person {

    private String lastName;
    private String firstName;
    private String patronymic;
    private String fullName;
    private String nickName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName() {
        this.fullName = lastName + " " + firstName.charAt(0);
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", fullName='" + fullName + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
