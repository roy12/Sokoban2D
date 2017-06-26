package view;

import java.util.List;

import javafx.beans.property.IntegerProperty;
import levels.Level;

public interface View {
	void displayLevel(Level lvl);
	void displayError(String msg);
	void start();
	public void bindSteps(IntegerProperty steps);
	public void bindTimer(IntegerProperty timer);
	
	//hibernate
	public void getUserDetails();
	public void getCurrentLevelSession();
	public void displaySessionsList(List list);
	public void displayRecord(int record);
}
