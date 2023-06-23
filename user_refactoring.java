mport org.apache.commons.lang3.StringUtils;
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
