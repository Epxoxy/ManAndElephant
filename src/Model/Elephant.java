package Model;

public class Elephant implements IMeasurable{
	public double weight;

	public Elephant(double weight){
		this.weight = weight;
	}
	
	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return weight;
	}
}
