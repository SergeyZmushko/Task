package by.epam.task.dao.impl;

import by.epam.task.bean.User;
import by.epam.task.dao.DAOException;
import by.epam.task.dao.UserDAO;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class SourceUserDAO implements UserDAO {
    @Override
    public boolean authorization(String login, String password) throws DAOException {
        boolean result = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("E://Epam/JavaOnlineTraining/Modul06/Task01/source", "Users.txt")))) {
            String s = "";
            while ((s = reader.readLine()) != null) {
                String[] s1 = s.split(" : ");
                if (s1[0].equalsIgnoreCase(login) && s1[2].equalsIgnoreCase(password)) {
                    result = true;
                }
            }
        } catch (FileNotFoundException e) {
            throw new DAOException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean registration(User user) throws DAOException {
        boolean result = false;
        try (FileWriter fw = new FileWriter("E://Epam/JavaOnlineTraining/Modul06/Task01/source/Users.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            String userData = "" + user.getLogin() + " : " + user.getUsername() + " : " + user.getPassword() + " : " + user.getEmail() + " : " + user.getUserType();
            out.println(userData);
            result = true;
        } catch (FileNotFoundException e) {
            throw new DAOException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }

    @Override
    public User searchUser(String login, String password) throws DAOException {
        User user = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("E://Epam/JavaOnlineTraining/Modul06/Task01/source", "Users.txt")))) {
            String s = "";
            while ((s = reader.readLine()) != null) {
                String[] s1 = s.split(" : ");
                if (s1[0].equalsIgnoreCase(login) && s1[2].equalsIgnoreCase(password)) {
                    user = new User.Builder().withLogin(s1[0]).withUsername(s1[1]).withPassword(s1[2]).withEmail(s1[3]).withUserType(User.UserType.valueOf(s1[4])).build();
                }
            }
        } catch (FileNotFoundException e) {
            throw new DAOException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getUsers() throws DAOException {
        List<User> users = new ArrayList<>();
        File file = new File("E://Epam/JavaOnlineTraining/Modul06/Task01/source", "Users.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String s = "";
            while ((s = br.readLine()) != null) {
                String[] line = s.split(" : ");
                User user = new User.Builder().withLogin(line[0]).withUsername(line[1]).withPassword(line[2]).withEmail(line[3]).withUserType(User.UserType.valueOf(line[4])).build();
                users.add(user);
            }
        } catch (FileNotFoundException e) {
            throw new DAOException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}







