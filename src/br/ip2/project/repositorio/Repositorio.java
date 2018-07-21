package br.ip2.project.repositorio;

//import weka.core.stopwords.Null;

import java.io.*;

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
            try{
                File file = new File(filePath);
                boolean b = file.createNewFile();
                boolean b1 = file.setWritable(true);
            }catch (Exception f){
                System.out.println("O arquivo não pode ser criado em " + filePath);
            }

        }catch (EOFException  e){

            System.out.println("problema na escrita do arquivo em " + filePath);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
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
