package fidd.capabilities;

import fidd.Fidd;
import fidd.characters.Gladiator;
import fidd.network.ManaMessage;

public class GladiatorInfo implements IGladiatorInfo

{
	private int current = 0;
	private float mana;
	private int maxMana;
	private Gladiator[] gladiators = new Gladiator[]{
			new Gladiator()
	};
	public GladiatorInfo(){
		this(100);
	}
	public GladiatorInfo(int maxMana){
		this.maxMana = maxMana;
		this.mana = maxMana;
	}
	
	public boolean consume(float points){
		if (mana < points)return false;
		this.mana -= points;
		if (this.mana < 0.0F) this.mana = 0;
		Fidd.network.sendToAll(new ManaMessage(mana, maxMana));
		return true;
	}
	
	
	
	public void fill(float points){

		this.mana += points;
		if (mana > maxMana)mana = maxMana;
		Fidd.network.sendToAll(new ManaMessage(mana, maxMana));
	}



	public void set(float points){
		this.mana = points;
		if (mana > maxMana)mana = maxMana;
		Fidd.network.sendToAll(new ManaMessage(mana, maxMana));
	}



	public float getMana(){
		return this.mana;
	}

	@Override
	public int getMax() {
		// TODO Auto-generated method stub
		return maxMana;
	}

	@Override
	public void setMax(int max) {
		// TODO Auto-generated method stub
		this.maxMana = max;
		Fidd.network.sendToAll(new ManaMessage(mana, maxMana));
	}
	@Override
	public Gladiator getGladiator() {
		// TODO Auto-generated method stub
		return gladiators[current];
	}
	@Override
	public void setCurrentGladiator(int gladiator) {
		current = gladiator;
		// TODO Auto-generated method stub
		
	}
	@Override
	public Gladiator[] getGladiators() {
		// TODO Auto-generated method stub
		return gladiators;
	}
	@Override
	public int getCurrent() {
		// TODO Auto-generated method stub
		return current;
	}
	

}
