package br.ip2.easylend.controller;


import weka.classifiers.bayes.NaiveBayes;
import weka.core.*;

import java.io.FileNotFoundException;
import java.util.Enumeration;

import static weka.core.converters.ConverterUtils.*;

public class KnnController {

    private static KnnController ourInstance = new KnnController();
    public static KnnController getInstance() {
        return ourInstance;
    }


    private KnnController() {

    }

    public void data() throws Exception{

        String path = "src\\br\\ip2\\easylend\\repositorio\\files\\easylend.arff";

        DataSource dataScource = new DataSource(path);
        Instances dataSet = dataScource.getDataSet();

        dataSet.setClassIndex(1);
        NaiveBayes naiveBayes = new NaiveBayes();
        naiveBayes.buildClassifier(dataSet);
        DenseInstance instances = new DenseInstance(2);

        instances.setDataset(dataSet);

        instances.setValue(0, "true");

        Attribute attribute = new Attribute("duracao",2);

        instances.setValue(attribute, 1);
        double[] probabilidade = naiveBayes.distributionForInstance(instances);

        System.out.println("genero: " + probabilidade[1]);

    }






}



