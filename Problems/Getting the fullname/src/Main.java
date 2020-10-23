class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        this.firstName = makeNullStringEmpty(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = makeNullStringEmpty(lastName);
    }

    public String getFullName() {
        String fullName;

        if (firstName.length() < 1 && lastName.length() < 1) {
            fullName = "Unknown";
        } else if (firstName.length() < 1) {
            fullName = lastName;
        } else if (lastName.length() < 1) {
            fullName = firstName;
        } else {
            fullName = firstName + " " + lastName;
        }

        return fullName;
    }

    private String makeNullStringEmpty(String string) {
        String newString = string;

        if (string == null) {
            newString = "";
        }

        return newString;
    }
}