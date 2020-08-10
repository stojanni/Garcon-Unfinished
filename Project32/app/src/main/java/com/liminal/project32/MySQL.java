package com.liminal.project32;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MySQL {

    public void login(String user, String pass){

        URL url;
        HttpURLConnection urlConnection = null;

        try {

            url = new URL("http://localhost/php/login.php?user=" + user + "&pass=" + pass);

            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = urlConnection.getInputStream();

            InputStreamReader isw = new InputStreamReader(in);

            int data = isw.read();

            while (data != -1) {
                char current = (char) data;
                data = isw.read();
                System.out.print(current);
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            if (urlConnection != null) {
                urlConnection.disconnect();
            }

        }

    }

}
