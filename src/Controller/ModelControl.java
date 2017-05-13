package Controller;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

import Model.Boat;
import Model.Elephant;
import Model.IMeasurable;
import Model.Stone;

public class ModelControl {
	//One elephant
	private Elephant elephant;
	//Stone Boat
	private Boat eleBoat;
	private Boat stoneBoat;
	//Stone measure size
	private double eleBoatDepth;
	private double stoneBoatDepth;
	//For create elephant
	private double minWeight = 0.7d;
	private double rangeWeight = 13500d;
	private Boolean isCompleted = false;
	//Depth bar
	private List<Stone> stones;
	private String[] names = new String[]{"A","B","C","D"};
	private CacheSettings mySettings;
	
	public ModelControl(CacheSettings settings){
		if(settings == null) settings = new CacheSettings();
		else this.mySettings = settings;
		init();
	}
	
	private void init(){
		stones = new ArrayList<Stone>();
		isCompleted = false;
		this.setEleBoatDepth(0);
		this.setStoneBoatDepth(0);
	}

	public Elephant RandomCreateElephant(){
		//Random a range
		java.util.Random random = new java.util.Random();
		double range = random.nextDouble();
		//Calculate weight
		double evaWeight = range * rangeWeight + minWeight;
		int weight = (int)evaWeight;
		//Create elephant
		Elephant eleRandom = new Elephant(weight);
		return eleRandom;
	}
	
	public Boolean getIsCompleted(){
		return isCompleted;
	}
	public void setIsCompleted(Boolean isCompleted){
		this.isCompleted = isCompleted;
	}
	
	public Elephant getElephant(){
		return elephant;
	}
	public void setElephant(Elephant elephant){
		if(this.elephant == elephant) return;
		this.elephant = elephant;
		if(this.mySettings.eleNameLB != null){
			java.util.Random random = new java.util.Random();
			int index = random.nextInt(4);
			int nameindex = random.nextInt(100);
			this.mySettings.eleNameLB.setText(names[index] + nameindex);
		}
	}

	public Boat getEleBoat(){
		return this.eleBoat;
	}
	public void setEleBoat(Boat boat){
		if(this.eleBoat == boat) return;
		this.eleBoat = boat;
		if(eleBoat == null) init();
		else{
			this.setEleBoatDepth(eleBoat.getDepth());
		}
	}

	public Boat getStoneBoat(){
		return this.stoneBoat;
	}
	public void setStoneBoat(Boat boat){
		if(this.stoneBoat == boat) return;
		this.stoneBoat = boat;
		if(stoneBoat == null) init();
		else{
			this.setStoneBoatDepth(stoneBoat.getDepth());
		}
	}

	public void putawayElephant(){
		if(getEleBoat() !=null){
			getEleBoat().clear();
			isCompleted = false;
			this.setEleBoatDepth(getEleBoat().getDepth());
		}
	}

	public Boolean putElephantOnBoat(){
		if(getElephant() == null) return false;
		if(getEleBoat() == null) return false;
		if(getEleBoat().hasSomething()) return false;
		if(getEleBoat().put(getElephant()) == true){
			this.setEleBoatDepth(getEleBoat().getDepth());
			return true;
		}
		return false;
	}
	
	public double getStoneBoatDepth(){
		return stoneBoatDepth;
	}
	
	public void setStoneBoatDepth(double stoneBoatDepth){
		if(this.stoneBoatDepth == stoneBoatDepth) return;
		this.stoneBoatDepth = stoneBoatDepth;
		if(this.mySettings.stonesLB != null){
			StringBuilder sbuilder = new StringBuilder();
			for(int i = 0; i < stones.size(); ++i){
				sbuilder.append(stones.get(i).getWeight()+ " ");
			}
			this.mySettings.stonesLB.setText("<html>" + sbuilder.toString() + "</html>");
		}
		//Update show
		if(this.mySettings.stoneBoatDepthLB != null){
			this.mySettings.stoneBoatDepthLB.setText(new DecimalFormat("#.00").format(stoneBoatDepth));
		}
		//Update progress
		if(this.mySettings.stoneDepthBar == null) return;
		double progress = 0d;
		if( this.getStoneBoat() != null){
			double max = this.getStoneBoat().getMaxDepth();
			progress = stoneBoatDepth / max * 100;
		}
		this.mySettings.stoneDepthBar.setValue((int)progress);
	}

	public double getEleBoatDepth(){
		return eleBoatDepth;
	}
	public void setEleBoatDepth(double eleBoatDepth){
		if(this.eleBoatDepth == eleBoatDepth) return;
		this.eleBoatDepth = eleBoatDepth;
		//Update show
		if(this.mySettings.eleBoatDepthLB != null){
			this.mySettings.eleBoatDepthLB.setText(new DecimalFormat("#.00").format(this.eleBoatDepth));
		}
		//Update progress
		if(this.mySettings.elephantDepthBar == null) return;
		double progress = 0d;
		if( this.getEleBoat() != null){
			double max = this.getEleBoat().getMaxDepth();
			progress = eleBoatDepth / max * 100;
		}
		this.mySettings.elephantDepthBar.setValue((int)progress);
	}

	public void handAndCheckSuccess(){
		double value = this.stoneBoat.getDepth() - this.getEleBoat().getDepth();
		if(Math.abs(value) < 0.05){
			this.setIsCompleted(true);
		}
	}
	
	public Boolean addStoneToStoneBoat(double weight){
		Boat stoneBoat = this.getStoneBoat();
		if(stoneBoat == null) return false;
		Stone stone = new Stone(weight);
		System.out.println("addStoneToStoneBoat with"+stone.getWeight());
		//Put stone
		if(stoneBoat.put(stone) == true){
			stones.add(stone);
			this.setStoneBoatDepth(stoneBoat.getDepth());
			return true;
		}
		return false;
	}
	
	public double getTotalStoneWeight(){
		int size =stones.size();
		if(size < 1) return 0;
		double total = 0d;
		for(Stone stone : stones){
			total += stone.getWeight();
		}
		return total;
	}
	
	public Boolean removeStoneFromStoneBoat(){
		int size =stones.size();
		if(size < 1) return false;
		Boat stoneBoat = this.getStoneBoat();
		Stone stone = stones.get(size - 1);
		if(stoneBoat.remove(stone)){
			stones.remove(stone);
			this.setStoneBoatDepth(stoneBoat.getDepth());
			return true;
		}
		return false;
	}
}
