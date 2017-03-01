package view;

import Model.Level;
import javafx.beans.property.IntegerProperty;

public interface View {
	void displayLevel(Level lvl);
	void displayError(String msg);
	void start();
	public void bindSteps(IntegerProperty steps);
}
