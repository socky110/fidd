package fidd.capabilities;

import fidd.characters.Gladiator;

public interface IGladiatorInfo

{

	public boolean consume(float points);
	public Gladiator getGladiator();
	public void setCurrentGladiator(int gladiator);
	
	public Gladiator[] getGladiators();
	
	public int getCurrent();
	
	public void fill(float points);
	
	public void set(float points);
	
	public int getMax();
	public void setMax(int max);
	
	public float getMana();

}
