
public interface AirConditioning {

}

interface Heater extends AirConditioning{
	
}

interface A{
	public int doSomething();
}
interface B extends A{
	public int doSomething();
}
interface C extends A{
	public int doSomething();
}
class D implements B, C{
	public int doSomething(){
		return 0;
	}
}