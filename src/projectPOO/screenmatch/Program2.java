package projectPOO.screenmatch;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import projectPOO.screenmatch.models.*;
import projectPOO.screenmatch.models.TitleOmdb;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        String search = "";
        List<Title> titleList = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (true) {
            System.out.println("Digite o nome de um filme: ");
            search = sc.nextLine();

            if(search.equalsIgnoreCase("left")){
                break;
            }

            String address = "https://www.omdbapi.com/?t=" + search.replace(" ", "+") + "&apikey=34451d52";

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(address))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                TitleOmdb titleOmdb = gson.fromJson(json, TitleOmdb.class);
                Title title = new Title(titleOmdb);
                System.out.println(title.showTechnicalSheet());

                titleList.add(title);

            } catch (NumberFormatException e) {
                System.out.println("Error!");
                System.out.println(e.getMessage());
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.println("title was not found!");
            }
        }
        System.out.println(titleList);

        FileWriter fw = new FileWriter("titles.json");
        fw.write(gson.toJson(titleList));
        fw.close();
    }
}
