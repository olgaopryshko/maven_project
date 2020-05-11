package sportgames.participants;

public final class Person implements IParticipant {

    private String firstName;
    private String lastName;


    public Person(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getName() {
        if (firstName == null) {
            return lastName;
        }
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return getName();
    }
}
