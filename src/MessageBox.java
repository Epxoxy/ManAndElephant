import java.awt.Component;

import javax.swing.JOptionPane;

public class MessageBox {
	
	public static void showDialog(Component component, String value){
		JOptionPane.showMessageDialog(component, value);
	}
	public static int showConfirmDialog(Component component, String title, String value){
		return JOptionPane.showConfirmDialog(component, value,title,JOptionPane.YES_NO_OPTION);
	}
	
	public static void show(String value){
		JOptionPane.showMessageDialog(null, value);
	}
}
class Console{
	public static void Write(String value){
		System.out.print(value);
	}
	public static void WriteLine(String value){
		System.out.println(value);
	}
}
