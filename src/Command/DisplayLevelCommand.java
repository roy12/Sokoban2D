package Command;

import Model.Model;
import Model.MyModel;
import view.View;

public class DisplayLevelCommand extends Command{

	private MyModel model;
	private View view;
	
	public DisplayLevelCommand(MyModel model, View view) {
		this.model = model;
		this.view = view;
	}	
	
	@Override
	public void execute() {
		model.display();
	}
	public boolean isExit()
	{
		return false;
	}

}