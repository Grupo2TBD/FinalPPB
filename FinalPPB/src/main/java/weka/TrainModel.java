
package weka;


public class TrainModel {
    
    public TrainModel(){};
    
    public void train() throws Exception{
        TrainModelForSerialize tmfs = new TrainModelForSerialize();
        tmfs.train();
        
    }
}
