package main.java.br.ip2.project.repositorio;

import java.io.*;

public class Repositorio <T> implements Serializable{


    private T object;
    private FileOutputStream fout;
    private FileInputStream fInput;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    public T getHashMap() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }


    public void salvar(String filePath){

        try {

            this.fout = new FileOutputStream(filePath);

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não Encontrado \n Criando arquivo");
            File file = new File(filePath);

            try {
                file.createNewFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

        try{

            this.oos = new ObjectOutputStream(this.fout);
            this.oos.writeObject(this.object);
            this.oos.close();

        } catch (EOFException  e){

            System.out.println("problema na escrita do arquivo");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public T ler(String filePath) throws Exception{

        try {

            this.fInput = new FileInputStream(filePath);

            this.ois = new ObjectInputStream(fInput);

            T object =  (T) this.ois.readObject();
            this.ois.close();
            return object;

        } catch (FileNotFoundException e) {

            System.out.println("Arquivo não Encontrado\nCriando novo HashMap arquivo...");
            throw new Exception();
        }catch (EOFException  e){
            System.out.println("problema na leitura do arquivo");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

}
