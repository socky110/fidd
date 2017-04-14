package fidd.capabilities;



public class Mana implements IMana

{

	private float mana;
	private int maxMana;
	public Mana(int maxMana){
		this.maxMana = maxMana;
		this.mana = maxMana;
	}
	
	public boolean consume(float points){
		if (mana < points)return false;
		this.mana -= points;
		if (this.mana < 0.0F) this.mana = 0.0F;
		return true;
	}
	
	
	
	public void fill(float points){

		this.mana += points;
		if (mana > maxMana)mana = maxMana;
	}



	public void set(float points){
		this.mana = points;
		if (mana > maxMana)mana = maxMana;
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
	}

}
