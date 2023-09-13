package in.co.hsbc.bts.controller;

import in.co.hsbc.bts.view.impl.BtsViewImpl;

public class BtsController{

	public static void main(String[] args) {

		try(BtsViewImpl view = new BtsViewImpl()){

			int option = 0;

			do {
				option=view.showRoles();
				switch(option) {
				case 1:
					//it will take all the details of PM
				}	
			}while(option!=-1);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
