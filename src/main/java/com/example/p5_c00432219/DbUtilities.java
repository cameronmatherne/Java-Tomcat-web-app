package com.example.p5_c00432219;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbUtilities {


    public String getCountryName(String countryCode) {

        try {
            Class.forName("org.h2.Driver");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        // URL for local database
        String url = "jdbc:h2:tcp://localhost:9092/~/world";

        // make a connection and statement objects linked to the DBMS
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            // ******************************************************
            // ****************  Querying datatbase  ****************
            // ******************************************************

            ResultSet result = null;
            try {
                result = statement.executeQuery("" +
                        "SELECT COUNTRY.NAME " +
                        "FROM COUNTRY " +
                        "WHERE COUNTRY.CODE ='" + countryCode + "'");
            } catch (Exception e) {
                e.printStackTrace();
            }

            String countryName = "";
            while (result.next()) {
                countryName += String.format("%s \n",
                        result.getString(1));

            }
            return countryName;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> showCountriesSpeaking(String language) {
        // connect to db
        String url = "jdbc:h2:tcp://localhost:9092/~/world";
        try {
            Class.forName("org.h2.Driver");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        // query database
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            ResultSet result = null;
            try {
                result = statement.executeQuery("" +
                        "SELECT COUNTRY.NAME " +
                        "FROM COUNTRY, COUNTRYLANGUAGE " +
                        "WHERE COUNTRY.CODE = COUNTRYLANGUAGE.COUNTRYCODE " +
                        "AND COUNTRYLANGUAGE.LANGUAGE = '" + language + "'");
            } catch (Exception e) {
                e.printStackTrace();
            }

            List<String> countries = new ArrayList<>();
            while (result.next()) {
                countries.add(result.getString(1));
            }
            return countries;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }




    public ArrayList<String> showCitiesInCountry(String country) {
        // URL for local database
        String url = "jdbc:h2:tcp://localhost:9092/~/world";
        try {
            Class.forName("org.h2.Driver");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery("" +
                    "SELECT CITY.NAME " +
                    "FROM CITY, COUNTRY " +
                    "WHERE COUNTRY.NAME='" + country + "' AND COUNTRY.CODE=CITY.COUNTRYCODE");

            ArrayList<String> cities = new ArrayList<>();
            while (result.next()) {
                cities.add(result.getString(1));
            }
            return cities;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> showCountriesStartingWithLetter(String letter) {
        // connect to db
        String url = "jdbc:h2:tcp://localhost:9092/~/world";
        try {
            Class.forName("org.h2.Driver");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        // query database
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            ResultSet result = null;
            try {
                result = statement.executeQuery("" +
                        "SELECT NAME " +
                        "FROM COUNTRY " +
                        "WHERE LEFT (NAME, 1) = '" + letter + "'");
            } catch (Exception e) {
                e.printStackTrace();
            }

            List<String> countries = new ArrayList<>();
            while (result.next()) {
                countries.add(result.getString(1));
            }

            return countries;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



}