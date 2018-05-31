
public class DataAccessLayer implements IFace {
	
	@Override
	public Object gatData() {
		ConcreteClass cc =  new ConcreteClass();
		cc.printMyVersion();
		return cc.getVersion();
	}

}
