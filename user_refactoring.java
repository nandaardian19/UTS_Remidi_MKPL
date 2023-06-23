import org.apache.commons.lang3.StringUtils;
import java.time.Year;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.logging.Logger;

public class User {
    private final String userID;
    private String programStudy;
    private String faculty;
    private int enrollmentYear;
    private String email;
    private String password;
    private String userName;
    private String gender;
    private String firstName;
    private String lastName;
    private String studentIdentifierNumber;
    private static final Logger logger = Logger.getLogger(User.class.getName());

    public User() {
        this.userID = UUID.randomUUID().toString();
    }

    /**
     * Sets the user's school identifier.
     *
     * @param programStudy The user's program of study.
     * @param faculty The user's faculty.
     * @param enrollmentYear The user's enrollment year.
     * @throws Exception If programStudy, faculty, or enrollmentYear is null, empty, or blank.
     */
    public void setSchoolIdentifier(String programStudy, String faculty, int enrollmentYear) throws Exception {
        if (StringUtils.isBlank(programStudy)) {
            logger.severe("Program study should not be null, empty, or blank.");
            throw new Exception("Program study should not be null, empty, or blank.");
        }
        if (StringUtils.isBlank(faculty)) {
            logger.severe("Faculty should not be null, empty, or blank.");
            throw new Exception("Faculty should not be null, empty, or blank.");
        }
        if (enrollmentYear <= 0 || enrollmentYear >= Integer.MAX_VALUE) {
            logger.severe("Enrollment year should be a positive integer.");
            throw new Exception("Enrollment year should be a positive integer.");
        }

        this.programStudy = programStudy;
        this.faculty = faculty;
        this.enrollmentYear = enrollmentYear;
    }

    /**
     * Sets the user's school account.
     *
     * @param email The user's email.
     * @param password The user's password.
     * @param userName The user's username.
     * @throws Exception If email, password, or userName is null, empty, or blank.
     */
    public void setSchoolAccount(String email, String password, String userName) throws Exception {
        if (StringUtils.isBlank(email)) {
            logger.severe("Email should not be null, empty, or blank.");
            throw new Exception("Email should not be null, empty, or blank.");
        }
        if (StringUtils.isBlank(password)) {
            logger.severe("Password should not be null, empty, or blank.");
            throw new Exception("Password should not be null, empty, or blank.");
        }
        if (StringUtils.isBlank(userName)) {
            logger.severe("User name should not be null, empty, or blank.");
            throw new Exception("User name should not be null, empty, or blank.");
        }

        this.email = email;
        this.password = password;
        this.userName = userName;
    }

    /**
     * Sets the user's general information.
     *
     * @param firstName The user's first name.
     * @param lastName The user's last name.
     * @param gender The user's gender.
     * @param studentIdentifierNumber The user's student identifier number.
     * @throws Exception If firstName, lastName, gender, or studentIdentifierNumber is null, empty, or blank.
     */
    public void setGeneralInformation(String firstName, String lastName, String gender, String studentIdentifierNumber) throws Exception {
        if (StringUtils.isBlank(firstName)) {
            logger.severe("First name should not be null, empty, or blank.");
            throw new Exception("First name should not be null, empty, or blank.");
        }
        if (StringUtils.isBlank(lastName)) {
            logger.severe("Last name should not be null, empty, or blank.");
            throw new Exception("Last name should not be null, empty, or blank.");
        }
        if (StringUtils.isBlank(gender)) {
            logger.severe("Gender should not be null, empty, or blank.");
            throw new Exception("Gender should not be null, empty, or blank.");
        }
        if (StringUtils.isBlank(studentIdentifierNumber)) {
            logger.severe("Student identifier number should not be null, empty, or blank.");
            throw new Exception("Student identifier number should not be null, empty, or blank.");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.studentIdentifierNumber = studentIdentifierNumber;
    }

    /**
     * Calculates the user's enrollment year.
     *
     * @return The user's enrollment year.
     */
    public int calculateEnrollmentYear() {
        int currentYear = Year.now().getValue();
        return currentYear - this.enrollmentYear;
    }

    /**
     * Validates the user's email address.
     *
     * @param email The user's email address.
     * @return True if the email address is valid, false otherwise.
     */
    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pattern = Pattern.compile(emailRegex);
        if (email == null) {
            return false;
        }
        return pattern.matcher(email).matches();
    }

    /**
     * Checks if the user's password is strong enough.
     *
     * @param password The user's password.
     * @return True if the password is strong enough, false otherwise.
     */
    public boolean isStrongPassword(String password) {
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

        Pattern pattern = Pattern.compile(passwordRegex);
        if (password == null) {
            return false;
        }
        return pattern.matcher(password).matches();
    }

    /**
     * Updates the user's profile.
     *
     * @param firstName The user's first name.
     * @param lastName The user's last name.
     * @param gender The user's gender.
     * @param studentIdentifierNumber The user's student identifier number.
     * @param programStudy The user's program of study.
     * @param faculty The user's faculty.
     * @param enrollmentYear The user's enrollment year.
     * @param email The user's email.
     * @param password The user's password.
     * @param userName The user's username.
     * @throws Exception If studentIdentifierNumber is not a 10-digit number, or if email or password is invalid.
     */
   
    /**
	 * Fungsi untuk update profile
	
	 */
    
    public void updateProfile(String firstName, String lastName, String gender, String studentIdentifierNumber,
                              String programStudy, String faculty, int enrollmentYear, String email,
                              String password, String userName) throws Exception {

        if(studentIdentifierNumber.length() != 10 || !StringUtils.isNumeric(studentIdentifierNumber)){
            logger.severe("Input is not valid.");
            throw new Exception("Input is not valid.");
        }

        boolean isValidEmail = isValidEmail(email);
        boolean isStrongPassword = isStrongPassword(password);

        this.setSchoolIdentifier(programStudy, faculty, enrollmentYear);
        this.setSchoolAccount(email, password, userName);
        this.setGeneralInformation(firstName, lastName, gender, studentIdentifierNumber);
        int calculateYear = this.calculateEnrollmentYear();

        String emailStatus = "", passwordStatus = "";

        if(isValidEmail){
            emailStatus = "VALID";
        }else{
            emailStatus = "INVALID";
        }
        if(isStrongPassword){
            password= "Strong";
