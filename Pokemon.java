package battle5;

public abstract class Pokemon {
	/*　フィールド値　*/
	private String name = null;
	double hp = 0;
	double maxHp = 0;
	String skill_name_1 = null;
	String skill_name_2 = null;
	String skill_name_3 = null;
	String skill_name_4 = null;
	int pp_1 = 0;
	int pp_2 = 0;
	int pp_3 = 0;
	int pp_4 = 0;
	boolean charge = false;
	int chargeSkill = 0;
	boolean condition = true;

	/*　attack_1　*/
	abstract void attack_1(Pokemon x);
	/*　attack_2　*/
	abstract void attack_2(Pokemon x);
	/*　attack_3　*/
	abstract void attack_3(Pokemon x);
	/*　attack_4　*/
	abstract void attack_4(Pokemon x);

	/* 勝利　*/
	public void win(Pokemon x){
		x.lose();
	}
	/* 負け　*/
	public void lose (){
		System.out.println("　"+this.name+"は倒れた!!");
	}
	/*　逃げる　*/
	public void escape(){
		System.out.println("　"+this.name+"は逃げ出した...。");
	}

// getメソッド and setメソッド
	// name
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	// hp
	public double getHp(){
		return this.hp;
	}
	public void setHp(double hp){
		this.hp = hp;
	}
	// maxHp
	public double getMaxHp(){
		return this.maxHp;
	}
	public void setMaxHp(double maxHp){
		this.maxHp = maxHp;
	}
	// chargeSkill
	public int getChargeSkill(){
		return this.chargeSkill;
	}
	public void setChargeSkill(int chargeSkill){
		this.chargeSkill = chargeSkill;
	}
	// condition
	public boolean getCondition(){
		return this.condition;
	}
	public void setCondition(boolean condition){
		this.condition = condition;
	}



}
