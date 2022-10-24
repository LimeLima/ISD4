package com.lime.DB;

import java.sql.*;
import java.util.ArrayList;
/*
 * by Alima Amantay
 * on 08.04.2021, 20:18
 */
public class DBManager {
    static Connection connection = null;
    static PreparedStatement preparedStatement;
    static ResultSet resultSet;

    static void db() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/audiobooks_service?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root", "qwerty");
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    static public void addUser (User user) {
        db();
        try {
            preparedStatement = connection.prepareStatement(
                    "" + "INSERT INTO users(id, fullName, email, password, phoneNumber) " +
                            "VALUES(NULL, ?, ?, ?, ?)" + "");
            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    static public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        try {
            db();
            PreparedStatement getStatement = connection.prepareStatement("SELECT * from users");
            resultSet = getStatement.executeQuery();
            while (resultSet.next()) {
                users.add(new User(resultSet.getInt("id"), resultSet.getString("fullName"),
                        resultSet.getString("email"), resultSet.getString("password"),
                        resultSet.getString("phoneNumber")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    static public User getUser(int id) {
        for (User u : getUsers()){
            if (u.getId() == id) return u;
        }
        return null;
    }

    static public void deleteUser(int id) {
        db();
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    static public void updateUser (int id, User user) {
        db();
        try {
            preparedStatement = connection.prepareStatement(
                    "UPDATE users SET fullName = ?, email = ?, password = ?, phoneNumber = ? WHERE id = ?");
            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    static public void addAudioBook (AudioBook book) {
        db();
        try {
            preparedStatement = connection.prepareStatement(
                    "" + "INSERT INTO audiobook(id, title, author, book_year, language_id, voice_id) " +
                            "VALUES(NULL, ?, ?, ?, ?, ?)" + "");
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setInt(3, book.getBook_year());
            preparedStatement.setInt(4, book.getLanguage_id());
            preparedStatement.setInt(5, book.getVoice_id());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    static public ArrayList<AudioBook> getBooks() {
        ArrayList<AudioBook> books = new ArrayList<>();
        try {
            db();
            PreparedStatement getStatement = connection.prepareStatement("SELECT * from audiobook");
            resultSet = getStatement.executeQuery();
            while (resultSet.next()) {
                books.add(new AudioBook(
                        resultSet.getInt("id"),  resultSet.getString("title"),
                        resultSet.getString("author"), resultSet.getInt("book_year"),
                        resultSet.getInt("language_id"), resultSet.getInt("voice_id")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return books;
    }

    static public AudioBook getBook (int id) {
        for (AudioBook a : getBooks()){
            if (a.getId() == id) return a;
        }
        return null;
    }

    static public void deleteBook (int id) {
        db();
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM audiobook WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    static public void updateBook (int id, AudioBook book) {
        db();
        try {
            preparedStatement = connection.prepareStatement("UPDATE audiobook SET title = ?, author = ?, book_year = ?, language_id = ?, voice_id = ? WHERE id = ?");
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setInt(3, book.getBook_year());
            preparedStatement.setInt(4, book.getLanguage_id());
            preparedStatement.setInt(5, book.getVoice_id());
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    static public void addLanguage (String language) {
        db();
        try {
            preparedStatement = connection.prepareStatement(
                    "" + "INSERT INTO language (id, language ) " +
                            "VALUES(NULL, ?)" + "");
            preparedStatement.setString(1, language);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    static public ArrayList<Language> getLanguages() {
        ArrayList<Language> languages = new ArrayList<>();
        try {
            db();
            PreparedStatement getStatement = connection.prepareStatement("SELECT * from language");
            resultSet = getStatement.executeQuery();
            while (resultSet.next()) {
                languages.add(new Language(resultSet.getInt("id"), resultSet.getString("language")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return languages;
    }

    static public Language getLanguage (int id) {
        for (Language language : getLanguages()){
            if (language.getId() == id) return language;
        }
        return null;
    }

    static public void deleteLanguage (int id) {
        db();
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM language WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    static public void addVoice (String voice) {
        db();
        try {
            preparedStatement = connection.prepareStatement(
                    "" + "INSERT INTO voice (id, voice) " +
                            "VALUES(NULL, ?)" + "");
            preparedStatement.setString(1, voice);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    static public ArrayList<Voice> getVoices() {
        ArrayList<Voice> voices = new ArrayList<>();
        try {
            db();
            PreparedStatement getStatement = connection.prepareStatement("SELECT * from voice");
            resultSet = getStatement.executeQuery();
            while (resultSet.next()) {
                voices.add(new Voice(resultSet.getInt("id"),  resultSet.getString("voice")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return voices;
    }

    static public Voice getVoice (int id) {
        for (Voice voice : getVoices()){
            if (voice.getId() == id) return voice;
        }
        return null;
    }

    static public void deleteVoice (int id) {
        db();
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM voice WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
