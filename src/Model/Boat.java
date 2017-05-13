package Model;

import java.util.ArrayList;
import java.util.List;

public class Boat implements IMeasurable {
	private double bear = 0d;
	private double maxBear = 16000d;
	private double depthCoef = 0.01;
	private double selfWeight = 1000d;
	private double maxDepth = 0d;
	private List<IMeasurable> somethings;
	
	public Boat(){
		somethings = new ArrayList<IMeasurable>();
		maxDepth = depthCoef * (maxBear + selfWeight);
	}
	public Boat(double maxBear, double selfWeight){
		this();
		this.maxBear = maxBear;
		this.selfWeight = selfWeight;
	}
	
	public Boolean put(IMeasurable something){
		double evaBear = bear + something.getWeight();
		if(evaBear > maxBear) return false;
		somethings.add(something);
		bear = evaBear;
		return true;
	}
	
	public Boolean remove(IMeasurable something){
		if(!somethings.contains(something)) return false;
		else {
			bear -= something.getWeight();
			somethings.remove(something);
		}
		return true;
	}
	
	public Boolean removeLast(){
		if(somethings.size() < 1) return false;
		return remove(somethings.get(somethings.size() - 1));
	}
	
	public void clear(){
		bear = 0;
		somethings.clear();
	}
	
	public Boolean hasSomething(){
		return bear > 0;
	}
	
	public double getMaxDepth(){
		return maxDepth;
	}
	
	public double getMaxBear(){
		return this.maxBear;
	}
	
	public double getDepth(){
		return depthCoef * (bear + selfWeight);
	}

	public double getBear(){
		return bear;
	}
	
	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return selfWeight;
	}
}
