package coding;


interface Base { public String test();}

class  BaseImpl implements Base {
	@Override
	public String test() {		
		return "Hello";
	}	
}

class DecoratorClass extends BaseImpl {
	private Base base;
	private String name;
	DecoratorClass(Base base, String name) {
		this.base = base;
		this.name = name;
	}
	
	public String test() {
		return base.test() + " " + name;
	}
}


public class DecoratorTest {

	public static void main(String[] args) {
		Base base = new BaseImpl();		
		DecoratorClass  decorator = new DecoratorClass(base, "Dennis");
		System.out.print(decorator.test());
	}

}
