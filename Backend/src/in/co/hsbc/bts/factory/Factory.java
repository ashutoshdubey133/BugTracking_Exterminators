package in.co.hsbc.bts.factory;

import in.co.hsbc.bts.service.BtsService;
import in.co.hsbc.bts.service.impl.BtsServiceImpl;
import in.co.hsbc.bts.view.BtsView;
import in.co.hsbc.bts.view.impl.BtsViewImpl;

public class Factory {
	
	public static BtsService getBtsService() {
		return new BtsServiceImpl();
	}
	
	public static BtsView getBtsView() {
		return new BtsViewImpl();
	}
}
