import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validator {

	public static void main(String[] args) {
		// Test cases for isAlphaNum()
		System.out.println(Validator.isAlphaNum('h')); // true
		System.out.println(Validator.isAlphaNum('D')); // true
		System.out.println(Validator.isAlphaNum('3')); // true
		System.out.println(Validator.isAlphaNum('!')); // false
		System.out.println(Validator.isAlphaNum('*')); // false

		// Test cases for isSpecialChar()
		System.out.println(Validator.isSpecialChar('_', true)); // true
		System.out.println(Validator.isSpecialChar('-', true)); // true
		System.out.println(Validator.isSpecialChar('-', false)); // true
		System.out.println(Validator.isSpecialChar('_', false)); // false
		System.out.println(Validator.isSpecialChar('@', false)); // false
		System.out.println(Validator.isSpecialChar('!', false)); // false

		// Test cases for isPrefixChar()
		System.out.println(Validator.isPrefixChar('-')); // true
		System.out.println(Validator.isPrefixChar('F')); // true
		System.out.println(Validator.isPrefixChar('8')); // true
		System.out.println(Validator.isPrefixChar('&')); // false
		System.out.println(Validator.isPrefixChar(' ')); // false

		// Test cases for isDomainChar()
		System.out.println(Validator.isDomainChar('-')); // true
		System.out.println(Validator.isDomainChar('s')); // true
		System.out.println(Validator.isDomainChar('9')); // true
		System.out.println(Validator.isDomainChar('_')); // false

		// Test cases for singleAtSign()
		System.out.println(Validator.singleAtSign("username@domain.com")); // true
		System.out.println(Validator.singleAtSign("@gmail.com")); // true
		System.out.println(Validator.singleAtSign("A@b@c@d")); // false

		// Test cases for fetchBeforeAt()
		System.out.println(Validator.fetchBeforeAt("username@domain.com")); // "username"
		System.out.println(Validator.fetchBeforeAt("you@regreat")); // "you"
		System.out.println(Validator.fetchBeforeAt("@gmail.com")); // ""

		// Test cases for fetchAfterAt()
		System.out.println(Validator.fetchAfterAt("username@domain.com")); // "domain.com"
		System.out.println(Validator.fetchAfterAt("you@regreat")); // "regreat"
		System.out.println(Validator.fetchAfterAt("@gmail.com")); // "gmail.com"

		// Test cases for isPrefix()
		System.out.println(Validator.isPrefix("you_me")); // true
		System.out.println(Validator.isPrefix("to.bcc")); // true
		System.out.println(Validator.isPrefix("and..so")); // false
		System.out.println(Validator.isPrefix("thebest!")); // false

		// Test cases for isDomain()
		System.out.println(Validator.isDomain("gmail.com")); // true
		System.out.println(Validator.isDomain("ac-133.yul")); // true
		System.out.println(Validator.isDomain("and..so ")); // false
		System.out.println(Validator.isDomain(".com")); // false
		System.out.println(Validator.isDomain(".x")); // false

		// Test cases for isEmail()
		System.out.println(Validator.isEmail("user..name@fakemail.com")); // false
		System.out.println(Validator.isEmail("user#name@fakemail.com")); // false
		System.out.println(Validator.isEmail("user.name@fakemail")); // false
		System.out.println(Validator.isEmail("user.name@fakemail..com")); // false
		System.out.println(Validator.isEmail("user_n@fakemail.com")); // true
		System.out.println(Validator.isEmail("user.nm@fakemail.com")); // true
		System.out.println(Validator.isEmail("user@fakemail.com")); // true
		System.out.println(Validator.isEmail("user.name@fake-mail.com")); // true
		System.out.println(Validator.isEmail("user-name.yul@yahoo.com")); // true

		// Test cases for isUsername()
		System.out.println(Validator.isUsername("-User2")); // _user2
		System.out.println(Validator.isUsername(".cc123")); // .cc123
		System.out.println(Validator.isUsername("userName")); // ""
		System.out.println(Validator.isUsername("#sd99")); // ""

		// Test cases for safePassword()
		System.out.println(Validator.safePassword("H3l10-WoRld")); // true
		System.out.println(Validator.safePassword("W0w.Pr0ject")); // true
		System.out.println(Validator.safePassword("A1.b2-")); // false
		System.out.println(Validator.safePassword("D1nn3r-T1m3")); // false
		System.out.println(Validator.safePassword("Pa55w0RDis0k")); // false

		// Test cases for validEmails()
		String[] emails = { "user..name@fakemail.com", "user#name@fakemail.com", "user.name@fakemail",
				"user.name@fakemail..com", "user_n@fakemail.com", "user.nm@fakemail.com", "user@fakemail.com",
				"user.name@fake-mail.com", "user-name.yul@yahoo.com" };
		System.out.println(Validator.validEmails(emails)); // [user_n@fakemail.com, user.nm@fakemail.com,
															// user@fakemail.com, user.name@fake-mail.com,
															// user-name.yul@yahoo.com]

		// Test cases for validUsernames()
		String[] usernames = { "-User2", ".cc123", "userName", "#sd99" };
		System.out.println(Validator.validUsernames(usernames)); // [_user2, .cc123]

		// Test cases for validPasswords()
		String[] passwords = { "H3l10-WoRld", "W0w.Pr0ject", "A1.b2-", "D1nn3r-T1m3", "Pa55w0RDis0k" };
		System.out.println(Validator.validPasswords(passwords)); // [H3l10-WoRld, W0w.Pr0ject]
	}

	
	/**
	 * Checks if the given character is alphanumeric.
	 * 
	 * @param c The character to be checked.
	 * @return True if the character is alphanumeric, false otherwise.
	 */
	public static boolean isAlphaNum(char c) {
		// Using Java's built-in method to check if the character is alphanumeric
		return Character.isLetterOrDigit(c);
	}
	
	/**
	 * Checks if the given character is a special character, optionally including
	 * the underscore character.
	 * 
	 * @param c                 The character to be checked.
	 * @param includeUnderscore Whether to include the underscore character.
	 * @return True if the character is a special character, false otherwise.
	 */
	public static boolean isSpecialChar(char c, boolean includeUnderscore) {
		// Checking if the character matches any of the specified special characters
		return c == '-' || c == '.' || (includeUnderscore && c == '_');
	}
	
	/**
	 * Validates a username.
	 * 
	 * @param username The username to be validated.
	 * @return The validated username or an empty string if invalid.
	 */
	public static String isUsername(String username) {
		// Checking if the username is empty or exceeds the maximum length
		if (username.isEmpty() || username.length() > 7)
			return "";
	
		char firstChar = username.charAt(0);
		// Ensuring the first character is either '.' or '-'
		if (firstChar != '.' && firstChar != '-')
			return "";
	
		boolean hasAlphanumeric = false;
		StringBuilder result = new StringBuilder();
		result.append(Character.toLowerCase(firstChar));
	
		// Iterating through each character of the username
		for (int i = 1; i < username.length(); i++) {
			char c = username.charAt(i);
			// Checking if the character is valid or not
			if (!Character.isLetterOrDigit(c) && c != '.' && c != '-') {
				return "";
			} else if ((c == '.' || c == '-') && !hasAlphanumeric) {
				return "";
			} else if (Character.isLetterOrDigit(c)) {
				result.append(Character.toLowerCase(c));
				hasAlphanumeric = true;
			} else {
				result.append(Character.toLowerCase(c));
			}
		}
	
		return result.toString();
	}
	
	/**
	 * Checks if the given password meets the safety criteria.
	 * 
	 * @param password The password to be checked.
	 * @return True if the password is safe, false otherwise.
	 */
	public static boolean safePassword(String password) {
		// Checking if the password length is within the specified range
		if (password.length() < 7 || password.length() > 15)
			return false;
	
		boolean hasUppercase = false;
		boolean hasLowercase = false;
		boolean hasNumber = false;
		boolean hasSpecialChar = false;
		char prevChar = '\0';
	
		// Iterating through each character of the password
		for (char c : password.toCharArray()) {
			// Checking if the character is alphanumeric or special character
			if (!isAlphaNum(c) && !isSpecialChar(c, true))
				return false;
			// Tracking if the password contains uppercase, lowercase, number, and special characters
			if (Character.isUpperCase(c))
				hasUppercase = true;
			if (Character.isLowerCase(c))
				hasLowercase = true;
			if (Character.isDigit(c))
				hasNumber = true;
			if (isSpecialChar(c, true))
				hasSpecialChar = true;
			// Checking for consecutive identical characters
			if (c == prevChar)
				return false;
			prevChar = c;
		}
	
		// Ensuring all required criteria are met
		return hasUppercase && hasLowercase && hasNumber && hasSpecialChar;
	}
	
	public static boolean isPrefixChar(char input){                                                     // this method checks to see if the prefix contains a valid special character
        return isAlphaNum(input) || isSpecialChar(input, true);
    }
    
    public static boolean isPrefix(String input){                                                       // this method checks to see if the entire prefix is valid
        if (input.isEmpty()) {                                                                          // if the input is empty, return false                                      
            return false;
        }
        char firstChar = input.charAt(0);                                                               // this part checks to see if the first character is valid
        if (!isAlphaNum(firstChar)) {
            return false;
        }
        for (int i = 1; i < input.length(); i++) {                                                      // this part checks to see if the rest of the string is valid
            char currentChar = input.charAt(i);
            char previousChar = input.charAt(i - 1);
            if (!isPrefixChar(currentChar)) {
                return false;
            } 
            if (isSpecialChar(previousChar, true) && !isAlphaNum(currentChar)) {        // denies the check if the previous character is an invalid special character AND if the current character is not a letter or number
                return false;
            }
        } 
        return true;                                                                                    // return true if the entire prefix is valid
    }

    public static boolean isDomainChar(char input){                                                     // this method checks if the characters in the domain are valid
        return isAlphaNum(input) || isSpecialChar(input, false);
    }

    public static boolean singleAtSign (String email){                                                  // this method checks to see if there is only one @ symbol in the email address
        int count = 0;
        for (int i = 0; i < email.length(); i++){                                                       // counts the number of @ symbols
            if (email.charAt(i) == '@'){
                count++;
            }
        }
        return count == 1;
    }

    public static String fetchBeforeAt(String email){                                                   // this method fetches the portion before the @ symbol
        int atIndex = email.indexOf('@');
        if (atIndex == -1){
            throw new IllegalArgumentException("Invalid email address format.  Missing @ symbol.");     // throw creates a custom error 
        }
        return email.substring(0, atIndex);                                                             // returns the string portion before the @ symbol
    }

    public static String fetchAfterAt(String email){                                                    // this method fetches the portion after the @ symbol
        int atIndex = email.indexOf('@');
        if (atIndex == -1){
            throw new IllegalArgumentException("Invalid email address format.  Missing @ symbol.");     // throw creates a custom error 
        }
        return email.substring(atIndex + 1, email.length());                                            // returns the string portion after the @ symbol
    }

    public static boolean isDomain (String domain){
        String[] portions = domain.split("\\.");                                                        // this line splits the domain into 2 parts, which is seprated by a period
        if (portions.length != 2){                                                                      // checks to see if there actually are 2 parts
            return false;
        }
        String firstPortion = portions[0];
        if (firstPortion.isEmpty() || !Character.isLetterOrDigit(firstPortion.charAt(0))){              // checks to see if the domain is empty or not
            return false;
        }
        for (int i = 1; i < firstPortion.length(); i++){                                                // this part checks to see if the valid is valid only if the first part of the domain is not empty
            char c = firstPortion.charAt(i);
            if (!isDomainChar(c)) {
                return false;
            }
            if ((c == '.' || c == '-') && !Character.isLetterOrDigit(firstPortion.charAt(i + 1))){      // checks to see if there are valid special characters in the domain
                return false;
            }
        }
        String secondPortion = portions[1];
        if (secondPortion.length() < 2 || !secondPortion.matches("[a-zA-Z]+")){                         // checks to see if the second portion after the period is valid
            return false;
        }
        return true;                                                                                    // returns true if all the checks pass
    }

    public static boolean isEmail (String email) {                                                      // this method checks to see if the email address is valid   (final method for email validation)                                  
        if (!singleAtSign(email)){                                                                      // calls back the method to see if there is only one @ symbol in the email address
            return false;
        }
        String prefix = fetchBeforeAt(email);                                                           // calls back the method to fetch the portion before the @ symbol to use later in the isEmail method
        String domain = fetchAfterAt(email);                                                            // calls back the method to fetch the portion after the @ symbol to use later in the isEmail method
        return isPrefix(prefix) && isDomain(domain);                                                    // returns true if all the checks pass
    }

	public static String[] validEmails(String[] emails) {                                                    // this method checks to see if the email is valid, and adds it to an arraylist if it is
			List<String> validEmails = new ArrayList<>();                                                   // this line creates a list to store valid email address
			for (String email : emails) {                                                                   // this line iterates through each email address
				if (isEmail(email)){                                                                        // checks if the email is valid using isEmail
					validEmails.add(email);                                                                 // adds the email to the list if it is valid
				}
			}
			return validEmails.toArray(new String[0]);                                                      // returns the array of valid emails
		}

	/**
	 * Returns a list of valid usernames from the given array.
	 * 
	 * @param usernames The array of usernames to be validated.
	 * @return A list containing valid usernames.
	 */
	public static ArrayList<String> validUsernames(String[] usernames) {
		ArrayList<String> validUsernameList = new ArrayList<>();
		// Iterating through each username in the array
		for (String username : usernames) {
			// Validating the username and adding it to the list if it's valid
			String validUsername = isUsername(username);
			if (!validUsername.isEmpty())
				validUsernameList.add(validUsername);
		}
		return validUsernameList;
	}
	
	/**
	 * Returns a list of valid passwords from the given array.
	 * 
	 * @param passwords The array of passwords to be validated.
	 * @return A list containing valid passwords.
	 */
	public static ArrayList<String> validPasswords(String[] passwords) {
		ArrayList<String> validPasswordList = new ArrayList<>();
		// Iterating through each password in the array
		for (String password : passwords) {
			// Validating the password and adding it to the list if it's valid
			if (safePassword(password))
				validPasswordList.add(password);
		}
		return validPasswordList;
	}
}