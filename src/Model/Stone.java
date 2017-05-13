package Model;

public class Stone implements IMeasurable{
	double weight;
	public Stone(double weight){
		this.weight = weight;
	}
	
	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return weight;
	}
}
