package br.ip2.easylend.repositorio;

import br.ip2.easylend.model.Cliente;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonController {
    private static JsonController ourInstance = new JsonController();

    public static JsonController getInstance() {
        return ourInstance;
    }

    private JsonController() {
    }

    public Object getJson(){


        String filePath = "src\\br\\ip2\\easylend\\repositorio\\files\\cliente.json";

        JsonParser jsonParser = new JsonParser();
        Object parse = null;
        try{
            parse = jsonParser.parse(new FileReader(filePath));
        }catch (Exception e){
            e.printStackTrace();
        }
        return parse;
    }


    public void salveJson(Cliente cliente){

        String filePath = "src\\br\\ip2\\easylend\\repositorio\\files\\cliente.json";
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting().serializeNulls();
        Gson gson = builder.create();
        System.out.println();
        System.out.println("JSON: " + gson.toJson(cliente));

        try{
            File file = new File(filePath);
            boolean b = file.createNewFile();
            boolean b1 = file.setWritable(true);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(gson.toJson(cliente));
            fileWriter.close();
        }catch (Exception e){
            System.out.println("Arquivo não encontrado\nCriando novo arquivo em " + filePath);
        }


    }
}
