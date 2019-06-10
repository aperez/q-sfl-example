package qsfl.example;

import pt.up.fe.qsfl.annotations.LandmarkWith;
import pt.up.fe.qsfl.annotations.SkipChecker;
import pt.up.fe.qsfl.annotations.dispatchers.DefaultDispatcher;

// @LandmarkWith Instructs Q-SFL to use a specific landmark dispatcher.
// Since we are using the DefaultDispatcher, this annotation could be omitted. 
@LandmarkWith(DefaultDispatcher.class)
public class Calculator {

	double mul(double x, double y) {
		return y * x;
	}

	// Use custom landmark handler MyCustomHandler to partition method return type.
	// Equivalent to: @ObjectChecker(handler = MyCustomHandler.class)
	@MyCustomAnnotation
	double div(double x, double y) {
		return x / y;
	}

	// The SkipChecker annotation instructs Q-SFL not to landmark the return type.
	@SkipChecker
	double add(double x, double y) {
		return x + y;
	}

	// SkipChecker can also be used to annotate parameters.
	double sub(double x, @SkipChecker double y) {
		return x - y;
	}

}
