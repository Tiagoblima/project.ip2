package br.ip2.project.repositorio;

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

            this.oos = new ObjectOutputStream(this.fout);

            this.oos.writeObject(this.object);
            this.oos.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não Encontrado");
            e.printStackTrace();
        }catch (EOFException  e){

            System.out.println("problema na escrita do arquivo");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public T ler(String filePath){

        try {

            this.fInput = new FileInputStream(filePath);

            this.ois = new ObjectInputStream(fInput);

            T object =  (T) this.ois.readObject();
            this.ois.close();
            return object;

        } catch (FileNotFoundException e) {

            System.out.println("Arquivo não Encontrado\nCriando novo arquivo...");




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
