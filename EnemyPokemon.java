package battle5;

public abstract class EnemyPokemon{
/*　フィールド値　*/
	String name; double hp; double maxHp;
	String skill_name_1; String skill_name_2; String skill_name_3; String skill_name_4;
	int pp_1; int pp_2; int pp_3; int pp_4; boolean charge = false; int chargeSkill = 0;
	boolean conditions = true;

	/*　attack_1　*/
	abstract void attack_1(MyPokemon battleOnMyPokemon);
	/*　attack_2　*/
	abstract void attack_2(MyPokemon battleOnMyPokemon);
	/*　attack_3　*/
	abstract void attack_3(MyPokemon battleOnMyPokemon);
	/*　attack_4　*/
	abstract void attack_4(MyPokemon battleOnMyPokemon);
	/* 勝利　*/
	void win(MyPokemon battleOnMyPokemon){
		battleOnMyPokemon.lose();
	}
	/* 負け　*/
	void lose(){
		System.out.println("　"+this.name+"は倒れた!!");
	}
}