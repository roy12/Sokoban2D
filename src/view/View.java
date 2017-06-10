package view;

import javafx.beans.property.IntegerProperty;
import levels.Level;

public interface View {
	void displayLevel(Level lvl);
	void displayError(String msg);
	void start();
	public void bindSteps(IntegerProperty steps);
	public void bindTimer(IntegerProperty timer);
}
