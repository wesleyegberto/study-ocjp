package interfaces;

public abstract interface ITest {
	public void doStuff();

	public abstract void doDof();
	
	ITest getInstance();
}

interface ITestF extends ITest {
	public abstract void doBuf();
}

class T1 implements ITestF {
	ITest t;

	@Override
	public void doStuff() {

	}

	@Override
	public void doDof() {

	}

	@Override
	public void doBuf() {

	}

	public ITestF getInstance() {
		return null;
	}
}

class T2 implements ITest {
	@Override
	public void doDof() {

	}

	@Override
	public void doStuff() {

	}

	public T1 getInstance() {
		return null;
	}
}
