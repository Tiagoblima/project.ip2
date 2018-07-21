package br.ip2.project.repositorio;

//import weka.core.stopwords.Null;

import java.io.*;

public class Repositorio <T> {


    private T object;

    public void setObject(T object) {
        this.object = object;
    }




    public void salvar(T object, String filePath){

        try{

            FileOutputStream  fout  =  new FileOutputStream(filePath);

            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(object);
            oos.close();
            fout.close();

        }catch (FileNotFoundException e){

            try{
                File file = new File(filePath);
                boolean b = file.createNewFile();

                boolean b1 = file.setWritable(true);
            }catch (Exception f){
                System.out.println("O arquivo não pode ser criado");
            }

        }catch (EOFException  e){

            System.out.println("problema na escrita do arquivo");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public void salvar(String filePath){

        try{

            FileOutputStream  fout  =  new FileOutputStream(filePath);

            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(this.object);
            oos.close();
            fout.close();

        }catch (FileNotFoundException e){

            try{
                File file = new File(filePath);
                boolean b = file.createNewFile();

                boolean b1 = file.setWritable(true);
            }catch (Exception f){
                System.out.println("O arquivo não pode ser criado");
            }

        }catch (EOFException  e){

            System.out.println("problema na escrita do arquivo");
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
            System.out.println("problema na leitura do arquivo");
             e.printStackTrace();
        } catch (IOException e) {
             e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return object;
    }

}
