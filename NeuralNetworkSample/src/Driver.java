public class Driver {

    public static void main(String[] args)
    {
        int[][][] data = Perceptron.andData;
        double[] weights= Perceptron.INITIAL_WEIGHT;
        Driver driver =new Driver();
        Perceptron perceptron=new Perceptron();
        int epochNum=0;
        boolean errFlag=true;
        double error=0;
        double[] adjweights=null;
        System.out.println(data.length);
        while(errFlag)
        {
            System.out.println("Epoch Number"+(++epochNum));
            errFlag=false;
            for(int x=0;x<data.length;x++)
            {
                double weightedSum=perceptron.calculateWeightedSum(data[x][0],weights);
                int result=perceptron.activationFuction(weightedSum);
                error=data[x][1][0] - result;
                if(error!=0) errFlag=true;
                adjweights=perceptron.adjustWeights(data[x][0],weights,error);
                weights=adjweights;
                System.out.println(result);
            }
        }
    }
}
