package qsfl.example;

import pt.up.fe.qsfl.annotations.handlers.LandmarkHandler;

public class MyCustomHandler implements LandmarkHandler {

	Double pivot = new Double(20);
	
	@Override
	public int handle(Object o) {
		Double d = (Double) o;
		return d < pivot ? 0 : 1;
	}

	@Override
	public int landmarks() {
		return 2;
	}

	@Override
	public String getLandmarkName(int l) {
		return l == 0 ? "MyCustomHandler: lt pivot" : "MyCustomHandler: ge pivot";
	}

}
