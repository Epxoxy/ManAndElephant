package Controller;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import Model.BoatType;
import Model.Elephant;

public class CacheSettings {

	public BoatType selectedType = BoatType.Big;
	public double selectedWeight = 1d;
	public Elephant elephantCache;
	//
	public JProgressBar elephantDepthBar;
	public JProgressBar stoneDepthBar;
	public JLabel eleBoatDepthLB;
	public JLabel stoneBoatDepthLB;
	public JLabel eleNameLB;
	public JLabel stonesLB;
	//
	public JLabel elephantLB;
	public JLabel eleBoatLB;
	public JLabel stoneBoatLB;
	public JPanel eleNamePanel;
	public JLabel eleWeightLB;
	public JLabel eleWeightLB2;
	public JLabel stoneWeightLB;
	public JComboBox stoneBox;
}
