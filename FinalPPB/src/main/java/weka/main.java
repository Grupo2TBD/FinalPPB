
package weka;




public class main {
    
    public static void main(String[] args) throws Exception{
        
        
        ClassifyComment cc = new ClassifyComment();
        
        //tm.train();
        
        String comment = "hola";
        String clasif = cc.classify(comment);
        
        System.out.println(clasif);
        


    }
}
