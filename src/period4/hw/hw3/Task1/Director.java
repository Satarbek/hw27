package period4.hw.hw3.Task1;

public class Director {

    private String fullName;

    public Director(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Director{" +
                "fullname='" + getFullName() + '\'' +
                '}';
    }
}
