package org.example;

import java.net.URI;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class Main {






public static List<String> getdata(){
    String logged=Main.login_api();
    List<String> dataList=new ArrayList();

    HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10))
            .build();
    HttpResponse response = null;
    String name = null;
    try {
        String api = "http://localhost:8081/employees";
        name = "Talib";
        String pass = "talib12";
        URI uri = URI.create(api + logged);
        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
        response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JSONArray jsonArray = new JSONArray(response.body().toString());

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String propertyValue = jsonObject.getString("name");
            dataList.add(propertyValue);
        }


    } catch (Exception e) {
        e.printStackTrace();

    }
    System.out.println("The Response:" + response.statusCode());
    System.out.println("The Response Body:" + response.body());
return dataList;
}
    public static String login_api(){
        {

            HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10))
                    .build();
            HttpResponse response = null;
            String name = "Talib";
            String pass = "talib12";
            try {
                String api = "http://localhost:8081/login";

                URI uri = URI.create(api + "?name=" + name + "&password=" + pass);
                HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
                response = client.send(request, HttpResponse.BodyHandlers.ofString());


            } catch (Exception e) {
                e.printStackTrace();

            }
            System.out.println("The Response:" + response.statusCode());
            System.out.println("The Response Body:" + response.body());
            String token = response.body().toString();
            return ("?userToken=" + token + "&logged="+name);

        }}



    public static void main(String[] args) {


      getdata();
    }}
