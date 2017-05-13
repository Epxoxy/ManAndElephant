import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Panel;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import Controller.CacheSettings;
import Controller.ModelControl;
import Model.Boat;
import Model.BoatType;

public class MainWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}
	
	public static Font createYaHeiFont(int size){
		return new Font("Microsoft YaHei", Font.PLAIN, size);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		elephantImg = new ImageIcon(MainWindow.class.getResource("/Resources/Elephant.jpg"));
		boatImg = new ImageIcon(MainWindow.class.getResource("/Resources/Boat.jpg"));
		frame = new JFrame();
		frame.setBounds(100, 100, 663, 569);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton putStoneBtn = new JButton("\u653E\u77F3\u5934");
		putStoneBtn.setBounds(470, 460, 72, 23);
		frame.getContentPane().add(putStoneBtn);
		
		JButton putEleBtn = new JButton("\u62C9\u8C61");
		putEleBtn.setBounds(10, 441, 72, 23);
		frame.getContentPane().add(putEleBtn);
		
		JComboBox<Object> stoneTypeBox = new JComboBox<Object>();
		stoneTypeBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"1", "2", "4", "8", "16", "32", "64", "128", "256", "512", "1024"}));
		stoneTypeBox.setBounds(375, 461, 59, 20);
		frame.getContentPane().add(stoneTypeBox);
		
		JPanel elePanelRoot = new JPanel();
		elePanelRoot.setBounds(10, 40, 265, 390);
		frame.getContentPane().add(elePanelRoot);
		
		JProgressBar elephantDepthBar = new JProgressBar();
		elephantDepthBar.setOrientation(SwingConstants.VERTICAL);
		elephantDepthBar.setBounds(280, 40, 11, 390);
		frame.getContentPane().add(elephantDepthBar);
		
		JPanel stonePanelRoot = new JPanel();
		stonePanelRoot.setBounds(350, 40, 265, 390);
		frame.getContentPane().add(stonePanelRoot);
		stonePanelRoot.setLayout(new BorderLayout(0, 0));
		
		Panel stoneBoatDetailPanel = new Panel();
		stonePanelRoot.add(stoneBoatDetailPanel, BorderLayout.NORTH);
		
		JLabel lblValue = new JLabel("Scale : ");
		stoneBoatDetailPanel.add(lblValue);
		lblValue.setFont(createYaHeiFont(20));
		
		JLabel stoneBoatDepthLB = new JLabel("0");
		stoneBoatDetailPanel.add(stoneBoatDepthLB);
		stoneBoatDepthLB.setFont(createYaHeiFont(20));
		
		JLabel cmLB2 = new JLabel("cm");
		stoneBoatDetailPanel.add(cmLB2);
		cmLB2.setFont(createYaHeiFont(20));
		
		JProgressBar stoneDepthBar = new JProgressBar();
		stoneDepthBar.setOrientation(SwingConstants.VERTICAL);
		stoneDepthBar.setBounds(620, 40, 11, 390);
		frame.getContentPane().add(stoneDepthBar);
		
		JLabel label = new JLabel("\u66F9\u51B2\u79F0\u8C61");
		label.setFont(createYaHeiFont(18));
		label.setBounds(285, 0, 72, 31);
		frame.getContentPane().add(label);
		
		JLabel lblKg = new JLabel("KG");
		lblKg.setBounds(437, 464, 22, 14);
		frame.getContentPane().add(lblKg);
		
		JButton rmLastBtn = new JButton("\u79FB\u9664\u4E0A\u4E2A");
		rmLastBtn.setBounds(554, 460, 78, 23);
		frame.getContentPane().add(rmLastBtn);
		
		JButton sureBtn = new JButton("\u5B8C\u6210");
		sureBtn.setBounds(350, 500, 281, 26);
		frame.getContentPane().add(sureBtn);
		
		JButton eleGoBoatBtn = new JButton("\u4E0A\u8239");
		eleGoBoatBtn.setBounds(10, 500, 280, 23);
		frame.getContentPane().add(eleGoBoatBtn);
		
		JComboBox<Object> boatTypeComboBox = new JComboBox<Object>();
		boatTypeComboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"\u5927", "\u4E2D", "\u5C0F"}));
		boatTypeComboBox.setBounds(145, 442, 57, 20);
		frame.getContentPane().add(boatTypeComboBox);
		
		JButton putBoatBtn = new JButton("\u653E\u8239");
		putBoatBtn.setBounds(219, 441, 72, 23);
		frame.getContentPane().add(putBoatBtn);
		
		JButton leaveElephanttBtn = new JButton("\u62C9\u4E0B\u5927\u8C61");
		leaveElephanttBtn.setBounds(10, 473, 135, 23);
		frame.getContentPane().add(leaveElephanttBtn);
		
		JButton leaveBoatBtn = new JButton("\u79FB\u8D70\u8239");
		leaveBoatBtn.setBounds(156, 473, 135, 23);
		frame.getContentPane().add(leaveBoatBtn);
		
		JLabel boatTypeLB = new JLabel("\u8239\u7C7B\u578B");
		boatTypeLB.setBounds(109, 445, 40, 14);
		frame.getContentPane().add(boatTypeLB);
		
		JLabel stoneLB = new JLabel("\u77F3\u5934");
		stoneLB.setBounds(350, 464, 25, 14);
		frame.getContentPane().add(stoneLB);
		elePanelRoot.setLayout(new BorderLayout());
		
		JPanel eleDetailPanel = new JPanel();
		elePanelRoot.add(eleDetailPanel, BorderLayout.NORTH);
		
		JLabel lblScale = new JLabel("Scale : ");
		eleDetailPanel.add(lblScale);
		lblScale.setFont(createYaHeiFont(20));
		
		JLabel eleBoatDepthLB = new JLabel("0");
		eleDetailPanel.add(eleBoatDepthLB);
		eleBoatDepthLB.setFont(createYaHeiFont(20));
		
		JLabel cmLB = new JLabel("cm");
		eleDetailPanel.add(cmLB);
		cmLB.setFont(createYaHeiFont(20));
		
		JLabel eleBoatLB = new JLabel("");
		eleBoatLB.setHorizontalAlignment(SwingConstants.CENTER);
		elePanelRoot.add(eleBoatLB, BorderLayout.SOUTH);
		
		JPanel elephantPanel = new JPanel();
		elePanelRoot.add(elephantPanel, BorderLayout.CENTER);
		elephantPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel elephantLB = new JLabel("");
		elephantPanel.add(elephantLB, BorderLayout.CENTER);
		elephantLB.setVerticalAlignment(SwingConstants.BOTTOM);
		elephantLB.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel eleNamePanel = new JPanel();
		elephantPanel.add(eleNamePanel, BorderLayout.SOUTH);
		
		JLabel elephantExplainLB = new JLabel("\u6CA1\u4E0A\u8239\u7684\u8C61");
		eleNamePanel.add(elephantExplainLB);
		elephantExplainLB.setVerticalAlignment(SwingConstants.BOTTOM);
		elephantExplainLB.setHorizontalAlignment(SwingConstants.CENTER);
		elephantExplainLB.setVerticalAlignment(SwingConstants.BOTTOM);
		elephantExplainLB.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel elephantNameLB = new JLabel("");
		eleNamePanel.add(elephantNameLB);
		
		JLabel eleWeightLB = new JLabel("0");
		eleNamePanel.add(eleWeightLB);
		
		JLabel lblNewLabel = new JLabel("kg");
		eleNamePanel.add(lblNewLabel);
		JLabel eleWeightLB2 = new JLabel("0kg");
		eleWeightLB2.setFont(createYaHeiFont(20));
		eleWeightLB2.setHorizontalAlignment(SwingConstants.CENTER);
		eleWeightLB2.setVerticalAlignment(SwingConstants.BOTTOM);
		elephantPanel.add(eleWeightLB2, BorderLayout.NORTH);
		
		JPanel stoneBoatPanel = new JPanel();
		stonePanelRoot.add(stoneBoatPanel, BorderLayout.CENTER);
		stoneBoatPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel stonesLB = new JLabel("stones");
		stoneBoatPanel.add(stonesLB, BorderLayout.CENTER);
		stonesLB.setVerticalAlignment(SwingConstants.BOTTOM);
		stonesLB.setHorizontalAlignment(SwingConstants.CENTER);
		mySettings.stonesLB = stonesLB;
		
		JLabel stoneBoatLB = new JLabel("");
		stoneBoatPanel.add(stoneBoatLB, BorderLayout.SOUTH);
		stoneBoatLB.setHorizontalAlignment(SwingConstants.CENTER);
		mySettings.stoneBoatLB = stoneBoatLB;
		
		JLabel stoneWeightLB = new JLabel("0kg");
		stoneWeightLB.setVerticalAlignment(SwingConstants.BOTTOM);
		stoneWeightLB.setHorizontalAlignment(SwingConstants.CENTER);
		stoneWeightLB.setFont(createYaHeiFont(20));
		stoneBoatPanel.add(stoneWeightLB, BorderLayout.NORTH);

		//Add listeners
		putEleBtn.addActionListener(new CreateElephantListener());
		putStoneBtn.addActionListener(new AddStoneListener());
		stoneTypeBox.addItemListener(new WeightItemListener());
		rmLastBtn.addActionListener(new RemoveLastStoneListener());
		sureBtn.addActionListener(new EnsureHandListener());
		eleGoBoatBtn.addActionListener(new ElephantGoBoatListener());
		boatTypeComboBox.addItemListener(new BoatTypeItemListener());
		putBoatBtn.addActionListener(new PutBoatListener());
		leaveElephanttBtn.addActionListener(new PutawayElephantListener());
		leaveBoatBtn.addActionListener(new PutawayBoatListener());
		//Cache to settings
		mySettings.elephantDepthBar = elephantDepthBar;
		mySettings.stoneDepthBar = stoneDepthBar;
		mySettings.eleBoatDepthLB = eleBoatDepthLB;
		mySettings.eleNameLB = elephantNameLB;
		mySettings.stoneBoatDepthLB = stoneBoatDepthLB;
		mySettings.eleBoatLB = eleBoatLB;
		mySettings.elephantLB = elephantLB;
		mySettings.eleNamePanel = eleNamePanel;
		mySettings.eleWeightLB = eleWeightLB;
		mySettings.eleWeightLB2 = eleWeightLB2;
		mySettings.stoneWeightLB = stoneWeightLB;
		mySettings.stoneBox = stoneTypeBox;
	}
	
	private class CreateElephantListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			mySettings.elephantCache = controller.RandomCreateElephant();
			controller.setElephant(mySettings.elephantCache);
			mySettings.elephantLB.setIcon(elephantImg);
			mySettings.eleNamePanel.setVisible(true);
			if(mySettings.eleWeightLB != null){
				mySettings.eleWeightLB.setText(String.valueOf(mySettings.elephantCache.getWeight()));
			}
			if(mySettings.eleWeightLB2 != null){
				mySettings.eleWeightLB2.setText(mySettings.elephantCache.getWeight() + "kg");
			}
			if(mySettings.stoneBox != null){
				mySettings.stoneBox.removeAllItems();
				double weight = mySettings.elephantCache.getWeight();
				//int maxIndex = mySettings.stoneBox.getItemCount() - 1;
				int value = 1;
				for(int i = 0; value <= weight; ++i ){
					int newValue = value;
					mySettings.stoneBox.addItem(newValue);
					value += value;
				}
			}
		}
		
	}
	
	private class BoatTypeItemListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED){
				String newType = e.getItem().toString();
				switch(newType){
				case "\u5927" : {
					mySettings.selectedType = BoatType.Big;
				}break;
				case "\u4E2D" : {
					mySettings.selectedType = BoatType.Medium;
				}break;
				case "\u5C0F" : {
					mySettings.selectedType = BoatType.Small;
				}break;
				default:break;
				}
			}
		}
		
	}
	
	private class PutawayBoatListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(controller.getEleBoat() == null){
				MessageBox.showDialog(frame, "No boat here!");
			}
			else if(controller.getEleBoat().hasSomething()){
				MessageBox.showDialog(frame, "Elephant is still on boat!");
			}else{
				controller.setEleBoat(null);
				controller.setStoneBoat(null);
				mySettings.eleBoatLB.setIcon(null);
				mySettings.stoneBoatLB.setIcon(null);
			}
		}
		
	}
	
	private class PutBoatListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(controller.getEleBoat() == null || controller.getStoneBoat() == null){
				double maxBar = 0d;
				double selfWeight = 0d;
				switch(mySettings.selectedType){
				case Big: {
					maxBar = 16000d;
					selfWeight = 1000d;
				}break;
				case Medium: {
					maxBar = 10000d;
					selfWeight = 800d;
				}break;
				case Small: {
					maxBar = 6000d;
					selfWeight = 500d;
				}break;
				default:break;
				}
				if(maxBar <= 0 || selfWeight <= 0) return;
				controller.setEleBoat(new Boat(maxBar,selfWeight));
				controller.setStoneBoat(new Boat(maxBar,selfWeight));
				mySettings.eleBoatLB.setIcon(boatImg);
				mySettings.stoneBoatLB.setIcon(boatImg);
			}else{
				MessageBox.showDialog(frame, "Already has boat!");
			}
		}
		
	}
	
	private class ElephantGoBoatListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(controller.getElephant() == null) {
				MessageBox.showDialog(frame, "Need elephant!");
				return;
			}
			else if(controller.getEleBoat() == null){
				MessageBox.showDialog(frame, "Add boat first!");
			}else{
				if(controller.getEleBoat().hasSomething() == false){
					controller.putElephantOnBoat(); 
					mySettings.eleNamePanel.setVisible(false);
				}else{
					MessageBox.showDialog(frame, "There is already a elephant!");
				}
			}
		}
		
	}

	private class PutawayElephantListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			controller.putawayElephant();
			mySettings.eleNamePanel.setVisible(true);
		}
	}
	
	private class WeightItemListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED){
				double weight = Double.valueOf(e.getItem().toString());
				System.out.println(weight);
				mySettings.selectedWeight = weight;
			}
		}
		
	}
	
	private class AddStoneListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(controller.getIsCompleted() == true) {
				MessageBox.showDialog(frame, "Measure is already completed!");
				return;
			}
			if(controller.getElephant() == null){
				MessageBox.showDialog(frame, "Please choose a elephant!");
				return;
			}
			if(controller.addStoneToStoneBoat(mySettings.selectedWeight) == true){
				//REGION Debug option
				System.out.println("Add to stone(" + mySettings.selectedWeight + " kg) to boat");
				mySettings.stoneWeightLB.setText(controller.getTotalStoneWeight() + "kg");
				//ENDREGION
			}
			else MessageBox.showDialog(frame, "Can't add more!");
		}
	}

	private class RemoveLastStoneListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(controller.removeStoneFromStoneBoat() == true){
				//REGION Debug option
				Console.WriteLine("Remove successful!");
				//ENDREGION
				mySettings.stoneWeightLB.setText(controller.getTotalStoneWeight() + "kg");
			}else{
				//REGION Debug option
				Console.WriteLine("Remove fail!");
				//ENDREGION
			}
		}
		
	}
	
	private class EnsureHandListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(controller.getElephant() == null){
				MessageBox.showDialog(frame, "Ensure you pick up one elephant!"); 
				return;
			}
			double totalWeight = controller.getTotalStoneWeight();
			if(controller.getIsCompleted() == true) {
				MessageBox.showDialog(frame, "Measure is completed with weight of " + totalWeight);
				return;
			}
			if(totalWeight <= 0) {
				MessageBox.showDialog(frame, "Please add stone first!"); 
				return;
			}
			int dialogResult = MessageBox.showConfirmDialog(frame,"Sure",
					"It shows that you add " + totalWeight 
					+ " kg stone in total. "
					+ "Are you sure this is what you want?");
			if(dialogResult == JOptionPane.YES_OPTION){
				controller.handAndCheckSuccess();
				if(controller.getIsCompleted() == true){
					MessageBox.showDialog(frame, "Completed! Your result is " 
					+ totalWeight + " kg.");
				}else{
					MessageBox.showDialog(frame, "Unfortunately, the weight not match with " 
					+ totalWeight + " kg.");
				}
			}
		}
		
	}

	private ImageIcon elephantImg,boatImg;
	private CacheSettings mySettings = new CacheSettings();
	private ModelControl controller = new ModelControl(mySettings);
}
