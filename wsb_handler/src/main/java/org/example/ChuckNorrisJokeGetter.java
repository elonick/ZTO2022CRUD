package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class ChuckNorrisJokeGetter {
    public static String getJoke() {
        try {
            // Tworzenie obiektu URL i otwieranie połączenia
            URL url = new URL("https://api.chucknorris.io/jokes/random");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Ustawienie metody żądania na GET
            conn.setRequestMethod("GET");

            // Pobieranie odpowiedzi z serwera
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();

            // Wypisywanie żartu na konsolę
            //System.out.println(result.toString());

            // Parsowanie odpowiedzi za pomocą biblioteki JSON
            JSONObject obj = new JSONObject(result.toString());
            String joke = obj.getString("value");

            // Wypisywanie żartu na konsolę
            //System.out.println(joke);

            return joke;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
