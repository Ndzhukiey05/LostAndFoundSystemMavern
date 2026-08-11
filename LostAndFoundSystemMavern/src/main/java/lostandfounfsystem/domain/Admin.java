package lostandfounfsystem.domain;

//230939023

public class Admin extends Staff {

    // AccessLevel is an int (0 || null) : 1
    // (0 || null) : change personal posts
    // 1 : change all posts   
    private int accessLevel;

    public Admin() {
        super();
    }

    public Admin(
            int id,
            String name,
            String surname,
            String password,
            String secQuestion,
            String secAnswer,
            String employeeId,
            String department,
            int accessLevel
    ) {
        super(id, name, surname, password, secQuestion, secAnswer, employeeId, department);
        this.accessLevel = 1;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    @Override
    public String toString() {
        return "Admin{"
                + "personId=" + getPersonId()
                + ", name='" + getName() + '\''
                + ", surname='" + getSurname() + '\''
                + ", employeeId='" + getEmployeeId() + '\''
                + ", accessLevel=" + accessLevel
                + '}';
    }
}
