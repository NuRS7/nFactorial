package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
// Сделал с использованием framework Swing на основе GUI вся логика находится в классе main
public class UserManagerGUI extends JFrame {
    private UserManager userManager;
    private JTextField nameField, idField, searchNameField;
    private JTextArea outputArea;

    public UserManagerGUI() {
        userManager = new UserManager();

        setTitle("User Manager");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Верхняя панель для ввода имени и добавления пользователя
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(3, 2));

        topPanel.add(new JLabel("Имя:"));
        nameField = new JTextField();
        topPanel.add(nameField);

        JButton addButton = new JButton("Добавить пользователя");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                if (!name.isEmpty()) {
                    int id = userManager.addUser(name);
                    outputArea.append("Пользователь добавлен: " + name + " с ID: " + id + "\n");
                    nameField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Введите имя пользователя.");
                }
            }
        });
        topPanel.add(addButton);

        // Панель для ввода ID и удаления пользователя
        topPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        topPanel.add(idField);

        JButton deleteButton = new JButton("Удалить пользователя");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    boolean success = userManager.deleteUser(id);
                    if (success) {
                        outputArea.append("Пользователь с ID: " + id + " удален.\n");
                    } else {
                        outputArea.append("Пользователь с ID: " + id + " не найден.\n");
                    }
                    idField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Введите корректный ID.");
                }
            }
        });
        topPanel.add(deleteButton);

        add(topPanel, BorderLayout.NORTH);

        // Центральная панель для вывода результатов
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Нижняя панель для поиска пользователей по имени
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 3));

        bottomPanel.add(new JLabel("Поиск по имени:"));
        searchNameField = new JTextField();
        bottomPanel.add(searchNameField);

        JButton searchButton = new JButton("Найти пользователей");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = searchNameField.getText();
                List<Integer> ids = userManager.findUserByName(name);
                if (!ids.isEmpty()) {
                    outputArea.append("Пользователи с именем " + name + ": " + ids + "\n");
                } else {
                    outputArea.append("Пользователи с именем " + name + " не найдены.\n");
                }
                searchNameField.setText("");
            }
        });
        bottomPanel.add(searchButton);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                UserManagerGUI frame = new UserManagerGUI();
                frame.setVisible(true);
            }
        });
    }
}


// Я участовал в TechOrda в прошлом году на платном основе в этот год хочу выиграть грант!!!
// В целом медленно иду к цели и прохожу курс по JavaRUSH
// В данный проект добавлен ArrayList для хранения данных AWT абстрактный виджет tool инструмент для реализации GUI
//Swing это фреймворк для GUI с помощью JFrame верстаем GUI
// Спасибо