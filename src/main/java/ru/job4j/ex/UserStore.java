package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        int rs = -1;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername().equals(login)) {
                rs = i;
                break;
            }
        }
        if (rs == -1) {
            throw new UserNotFoundException("User not found");
        } else {
            return users[rs];
        }
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("User is not valid");
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Andrew", true)
        };
        try {
            User user = findUser(users, "Andrew");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            e.printStackTrace();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }

    }


}
