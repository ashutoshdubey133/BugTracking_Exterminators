package in.co.hsbc.bts.controller;

import in.co.hsbc.bts.view.BtsView;
import in.co.hsbc.bts.view.impl.BtsViewImpl;

public class BtsController{

	public static void main(String[] args) {

		try(BtsView view = new BtsViewImpl()){

			int option = 0;
			do {
				option=view.showRoles();

				switch(option) {

				//ProjectManager
				case 1:
					handleProjectManager(view);
					break;

					//Developer
				case 2:
					handleDeveloper(view);
					break;

					//Tester
				case 3:
					handleTester(view);
					break;

				case -1:
					break;
				}	
			}while(option!= -1);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void handleProjectManager(BtsView view) {
		int pmOption = 0;
		do {
			pmOption = view.displayProjectManagerOptions();

			switch(pmOption) {
			case 1:
				break;
				
			case -1:
				break;
			
			}
		}while(pmOption != -1);
	}
	
	private static void handleDeveloper(BtsView view) {
		int devOption = 0;
		do {
			devOption = view.displayDeveloperOptions();

			switch(devOption) {
			
			case -1:
				break;
			
			}
		}while(devOption != -1);
	}
	
	private static void handleTester(BtsView view) {
		int testerOption = 0;
		do {
			testerOption = view.displayTesterOptions();

			switch(testerOption) {
			
			case -1:
				break;
			
			}
		}while(testerOption != -1);
	}
}
