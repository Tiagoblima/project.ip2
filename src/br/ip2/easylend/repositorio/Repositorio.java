package br.ip2.easylend.repositorio;

//import weka.core.stopwords.Null;

import br.ip2.easylend.model.Cliente;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class Repositorio <T> {


    private static Repositorio<Object> repositorio = new Repositorio<>();

    private Repositorio(){

    }

    public static <T> T getInstance () {
        return (T) repositorio;
    }

    public void salvar(T object, String filePath){

        try{

            FileOutputStream  fout  =  new FileOutputStream(filePath);

            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(object);
            oos.close();
            fout.close();

        }catch (FileNotFoundException e){

            System.out.println("Arquivo não encontrado\nCriando novo arquivo em " + filePath);
            exceptionHandle(filePath);

        }catch (EOFException  e){

            System.out.println("problema na escrita do arquivo em " + filePath);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }


    }


    public void jsonSalve(T object){

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting().serializeNulls();
        Gson gson = builder.create();
        System.out.println();
        System.out.println("JSON: " + gson.toJson(object));

    }

    public T jsonRead(Class<T> tClass, String filePath){

            Gson gson = new Gson();

            T object = null;

            try{

                Type type = new TypeToken<T>(){}.getType();
                String content = new String(Files.readAllBytes(Paths.get(filePath)));
                 object = gson.fromJson(content, type);



                object = gson.fromJson(content, tClass);
            //    System.out.println(object.toString());
            }catch (Exception e){

                System.out.println("Arquivo não encontrado\nCriando novo arquivo em " + filePath);
                exceptionHandle(filePath);

            }

            return object;
    }

    private void exceptionHandle(String filePath) {
        try{
            File file = new File(filePath);
            boolean b = file.createNewFile();
            boolean b1 = file.setWritable(true);
        }catch (Exception f){
            System.out.println("O arquivo não pode ser criado em " + filePath);

        }
    }

    public T ler(String filePath) throws Exception{

        T object = null;
        try {

            FileInputStream fInput = new FileInputStream(filePath);

            ObjectInputStream ois = new ObjectInputStream(fInput);

             object =  (T) ois.readObject();
            ois.close();
            fInput.close();
            return object;

        } catch (FileNotFoundException e) {

            System.out.println("Arquivo não Encontrado em " + filePath);
            throw new Exception();
        }catch (EOFException  e){
            System.out.println("problema na leitura do arquivo em " + filePath);
             e.printStackTrace();
        } catch (IOException e) {
             e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return object;
    }

}
