
package weka;

import java.util.Locale;

public class ClassifyComment {
    
    public ClassifyComment(){};

    //método que retorna un string con la clasificación de un comentario ingresado como parámetro, ya sea "Positivo", "Negativo" o "Neutral"
    public String classify(String comment) throws Exception {
        String ruta_modelo = "/home/ian/Escritorio/PPB/WEKA/svm.model";
        String ruta_attr = "/home/ian/Escritorio/PPB/WEKA/attrs.dat";
        TrainModelForSerialize tmfs = new TrainModelForSerialize();
        CommentClassifier cs;
        Tokenizer tokenizer = new SimpleTokenizer(new Locale("ES"));
        StopWordsRemoval stopWordsRemoval = new StopWordsRemoval();
        double classif;

        cs = new CommentClassifier(ruta_modelo, ruta_attr, tokenizer, stopWordsRemoval);
        classif = cs.classify(comment);

        if (classif == 0.0) {
            return "Positivo";
        } else {
            if (classif == 1.0) {
                return "Negativo";
            } else {
                return "Neutral";
            }
        }

    }

}
