//import java.util.*;
//////////////////               Основная логика !!! //////////////////
//public class UserManager {
//    private Map<Integer, String> users;
//    private int nextId;
//
//    public UserManager() {
//        users = new HashMap<>();
//        nextId = 1;
//    }
//
//    public int addUser(String name) {
//        int id = nextId++;
//        users.put(id, name);
//        return id;
//    }
//
//    public String getUser(int id) {
//        return users.getOrDefault(id, null);
//    }
//
//    public boolean deleteUser(int id) {
//        if (users.containsKey(id)) {
//            users.remove(id);
//            return true;
//        }
//        return false;
//    }
//
//    public List<Integer> findUserByName(String name) {
//        List<Integer> userIds = new ArrayList<>();
//        for (Map.Entry<Integer, String> entry : users.entrySet()) {
//            if (entry.getValue().equals(name)) {
//                userIds.add(entry.getKey());
//            }
//        }
//        return userIds;
//    }
//
//    public static void main(String[] args) {
//        UserManager userManager = new UserManager();
//
//        // Добавление пользователей////////////////
//        int id1 = userManager.addUser("Нурсултан");
//        int id2 = userManager.addUser("Султан");
//        int id3 = userManager.addUser("Галия");
//
//        // Поиск пользователей по идентификатору////////////////////
//        System.out.println(" ID пользователя " + id1 + ": " + userManager.getUser(id1));
//        System.out.println("ID пользователя " + id2 + ": " + userManager.getUser(id2));
//
//        // Поиск пользователей по имени///////////////////
//        System.out.println("Пользователь Нурсултан: " + userManager.findUserByName("Нурсултан"));
//
//        // Удаление пользователя
//        System.out.println("Удаление пользователя " + id1 + ": " + userManager.deleteUser(id1));
//        System.out.println("Пользователь с ID " + id1 + ": " + userManager.getUser(id1));
//    }
//}
