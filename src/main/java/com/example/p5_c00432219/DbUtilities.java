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
        String url = "jdbc:h2:tcp://localhost/~/world";

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
        String url = "jdbc:h2:tcp://localhost/~/world";

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

            String countries = "";
            while (result.next()) {
                countries += result.getString(1) + "\n";
            }
            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> showCityInfo(String cityName) {
        // connect to db
        String url = "jdbc:h2:tcp://localhost/~/world";

        // query database
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            ResultSet result = null;
            try {
                result = statement.executeQuery("" +
                        "SELECT CITY.NAME, CITY.POPULATION, CITY.DISTRICT, CITY.COUNTRYCODE " +
                        "FROM CITY " +
                        "WHERE CITY.NAME = '" + cityName + "'");
            } catch (Exception e) {
                e.printStackTrace();
            }

            String cityInfo = "";

            while (result.next()) {
                String countryCode = result.getString("COUNTRYCODE");
                String countryName = getCountryName(countryCode);
                cityInfo += String.format("%s%s%s%s%s\n",
                        "Name: " + result.getString(1) + "\n",
                        "Population: " + result.getString(2) + "\n",
                        "District: " + result.getString(3) + "\n",
                        "Country-code: " + countryCode + "\n",
                        // FIX THIS
                        "Country name: " + countryName + "\n");


            }
            System.out.println(cityInfo);
            return null;


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> showCitiesInCountry(String country) {
        // ******************************************************
        // ****************  Connecting to datatbase  ***********
        // ******************************************************

        // URL for local database
        String url = "jdbc:h2:tcp://localhost/~/world";

        // make a connection and statement objects linked to the DBMS
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {


            // ******************************************************
            // ****************  Querying datatbase  ****************
            // ******************************************************

            ResultSet result = null;
            try {
                result = statement.executeQuery("" +
                        "SELECT CITY.NAME " +
                        "FROM CITY, COUNTRY " +
                        "WHERE COUNTRY.NAME='" + country + "' AND COUNTRY.CODE=CITY.COUNTRYCODE");
            } catch (Exception e) {
                e.printStackTrace();
            }

            //List<String> cities = new ArrayList<>();
            String cities = "";
            while (result.next()) {
                cities += String.format("%s \n",
                        result.getString(1));

            }
            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> showCountriesStartingWithLetter(String letter) {
        // connect to db
        String url = "jdbc:h2:tcp://localhost/~/world";

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

            String countries = "";
            while (result.next()) {
                countries += result.getString(1) + "\n";
            }

            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}