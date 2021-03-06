package br.ip2.easylend.controller;


import br.ip2.easylend.model.Filme;
import br.ip2.easylend.model.GeneroFilme;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.lazy.IBk;
import weka.core.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Random;

import static weka.core.converters.ConverterUtils.*;

public class KnnController {

    private static KnnController ourInstance = new KnnController();
    public static KnnController getInstance() {
        return ourInstance;
    }


    private KnnController() {

    }

    public void gerarDataSet(ArrayList<String> features){

        String relation = "@relation filmes\n";
        String attibutes = "\n@attribute adquiriu {false, true}\n" +
                "@attribute generoFilme {DRAMA, ACAO, FAMILIA, NACIONAIS, TERROR, COMEDIA, ROMANCE, AVENTURA}\n";

        String data = "\n@data";

        String path = "src\\main\\resources\\files\\easylend.arff";

        ArrayList<GeneroFilme> generos = new ArrayList <>();

        generos.add(GeneroFilme.DRAMA);
        generos.add(GeneroFilme.AVENTURA);
        generos.add(GeneroFilme.ACAO);
        generos.add(GeneroFilme.COMEDIA);
        generos.add(GeneroFilme.FAMILIA);
        generos.add(GeneroFilme.NACIONAIS);


        boolean[] b = new boolean[]{true, false};
        Random random = new Random();
        for(int i = 0; i < 200; i++){
            features.add(String.format("\n%s,%s" , b[random.nextInt(2)],  generos.get(random.nextInt(6)).toString() ));
        }


        try{

            File file = new File(path);
            boolean delete = file.delete();
            file.createNewFile();
            boolean b1 = file.setWritable(true);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(relation);
            fileWriter.write(attibutes);
            fileWriter.write(data);

            for (String f: features) {
                fileWriter.write(f);
            }
            fileWriter.close();
        }catch (Exception e){

        }

    }

    public GeneroFilme getpredGenero(){

        ArrayList<GeneroFilme> generos = new ArrayList <>();

        generos.add(GeneroFilme.DRAMA);
        generos.add(GeneroFilme.AVENTURA);
        generos.add(GeneroFilme.ACAO);
        generos.add(GeneroFilme.COMEDIA);
        generos.add(GeneroFilme.FAMILIA);
        generos.add(GeneroFilme.NACIONAIS);


        int predIndex = 0;

        KnnController pred = KnnController.getInstance();
        try {
            double[][] knn = new double[6][];

            int i = 0;
            for (GeneroFilme genero: generos) {
                knn[i++] = pred.predictGenero(genero);
            }

            double maior = -1;

            i = 0;


            for (double k[]: knn) {

                if(k[1] > maior){
                    maior = k[1];
                    predIndex  = i;
                }

                i++;
            }


        }catch (Exception e){
            e.printStackTrace();
        }

        return generos.get(predIndex);
    }

    public double[] predictGenero(GeneroFilme predGenero) throws Exception{

        gerarDataSet(new ArrayList <>());
        String path = "src\\main\\resources\\files\\easylend.arff";

        DataSource dataScource = new DataSource(path);
        Instances dataSet = dataScource.getDataSet();
        dataSet.setClassIndex(0);

        DenseInstance instances = new DenseInstance(2);
        instances.setDataset(dataSet);

        String genero = predGenero.toString();

        IBk iBk = new IBk();
        iBk.buildClassifier(dataSet);

        instances.setValue(1, genero);
        double[] probabilidade = iBk.distributionForInstance(instances);

        return  probabilidade;
    }






}



