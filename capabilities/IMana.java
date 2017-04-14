package fidd.capabilities;

public interface IMana

{

	public boolean consume(float points);
	
	public void fill(float points);
	
	public void set(float points);
	
	public int getMax();
	public void setMax(int max);
	
	public float getMana();

}
