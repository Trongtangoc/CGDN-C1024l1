public class UserManager {
    private User[] listUser;
    private int limit;
    private int currentSize = 0; // Thêm biến theo dõi số user hiện có

    public UserManager(int limit) {
        this.listUser = new User[limit];
        this.limit = limit;
    }

    public void addUser(User user) {
        if (currentSize < limit) {
            listUser[currentSize] = user;
            currentSize++;
        } else {
            System.out.println("User list is full. Cannot add more users.");
        }
    }
    public void removeUser(int id) {
        boolean found = false;
        int totalCurrentUser = listUser.length;

        for (int i = 0; i < totalCurrentUser; i++) {
            if (listUser[i].getId() == id) {
                found = true;
                for (int j = i; j < totalCurrentUser - 1; j++) {
                    listUser[j] = listUser[j + 1];
                }
                listUser[totalCurrentUser - 1] = null;
                totalCurrentUser--;
                System.out.println("User with ID " + id + " has been removed.");
                break;
            }
        }
        if (!found) {
            System.out.println("User with ID " + id + " not found.");
        }
    }
    public void showListUser() {
//        int totalCurrentUser = listUser.length;
//        if (totalCurrentUser == 0 ) {
//            System.out.println("The user list is empty.");
//        } else {
//            for (User user : listUser) {
//                if (user != null) {
//                    System.out.println(user.toString());
//                }
//
//            }
//        }
        boolean hasUser = false;
        for (User user : listUser) {
            if (user != null) {
                hasUser = true;
                System.out.println(user.toString());
                break;
            }
        }
        if (!hasUser) {
            System.out.println("The user list is empty1.");

        }
    }

    @Override
    public String toString() {
        return "Danh sach";
    }
}
