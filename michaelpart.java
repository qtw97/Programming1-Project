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













        public static String[] validEmail(String[] emails) {                                                    // this method checks to see if the email is valid, and adds it to an arraylist if it is
                List<String> validEmails = new ArrayList<>();                                                   // this line creates a list to store valid email address
                for (String email : emails) {                                                                   // this line iterates through each email address
                    if (isEmail(email)){                                                                        // checks if the email is valid using isEmail
                        validEmails.add(email);                                                                 // adds the email to the list if it is valid
                    }
                }
                return validEmails.toArray(new String[0]);                                                      // returns the array of valid emails
            }
