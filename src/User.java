public class User {
    private String firstName;
    private String lastName;
    private int age;
    private int imagesCount;
    private int videosCount;
    private User[] following;
    private User[] followers;
    private static final int MINIMUM_IMAGES_VIP = 10;
    private static final int MINIMUM_VIDEOS_VIP = 10;
    private static int MINIMUM_FOLLOWERS_VIP = 10;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private boolean isValidName() {
        boolean isValid = true;
        for (int i = 0; i < this.firstName.length(); i++) {
            if (this.firstName.charAt(i) >= '0' && this.firstName.charAt(i) <= '9') {
                isValid = false;
            }
        }
        for (int i = 0; i < this.lastName.length(); i++) {
            if (this.lastName.charAt(i) >= '0' && this.lastName.charAt(i) <= '9') {
                isValid = false;
            }
        }
        return isValid;
    }

    private boolean isVip() {
        boolean isVip = true;
        if (isValidName() && this.imagesCount >= MINIMUM_IMAGES_VIP && this.videosCount >= MINIMUM_VIDEOS_VIP) {
            if (this.followers.length >= MINIMUM_FOLLOWERS_VIP) {
                for (int i = 0; i < this.followers.length; i++) {
                    if (!this.followers[i].isValidName()) {
                        isVip = false;
                        break;
                    }
                }
            }
        }
        return isVip;
    }

    private int countMutualConnections() {
        int mutualCount = 0;
        for (int i = 0; i < this.following.length; i++) {
            for (int j = 0; j < this.followers.length; j++) {
                if (this.following[i].equals(this.followers[j])) {
                    mutualCount++;
                }
            }
        }
        return mutualCount;
    }

    private void removeFakeUsers() {
        boolean isFake = false;
        int counter = 0;
        for (int i = 0; i < this.following.length; i++) {
            if (!isValidName()) {
                counter++;
            }
            if (imagesCount == 0) {
                counter++;
            }
            if (videosCount == 0) {
                counter++;
            }
            if (countMutualConnections() == 0) {
                counter++;
            }
            if (counter >= 3) {
                this.following[i] = null;
            }
        }
        for (int i = 0; i < this.followers.length; i++) {
            if (!isValidName()) {
                counter++;
            }
            if (imagesCount == 0) {
                counter++;
            }
            if (videosCount == 0) {
                counter++;
            }
            if (countMutualConnections() == 0) {
                counter++;
            }
            if (counter >= 3) {
                this.followers[i] = null;
            }
        }
    }
}
