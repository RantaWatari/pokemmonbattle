package battle5;

public class Pokemon146 extends Pokemon {

	/*　attack_1　*/
	void attack_1(Pokemon Pokemon){
		if(0 < this.pp_1) {
			System.out.println("　"+super.getName()+"は「"+this.skill_name_1+"」を繰り出した!!");
			this.pp_1 -= 1;
			Pokemon.hp -=17.5;
		}else{
			System.out.println("　技のppが足りません!!");
		}
	}

/*　attack_2　*/
	void attack_2(Pokemon Pokemon){
		if(0 < this.pp_2) {
			System.out.println("　"+super.getName()+"は、「"+this.skill_name_2+"」を繰り出した!!");
			System.out.println("　相手の防御力が一段階下がった。");
			this.pp_2 -= 1;
		}else{
			System.out.println("　技のppが足りません!!");
		}
	}

/*　attack_3　*/
	void attack_3(Pokemon Pokemon){
		if(0 < this.pp_3) {
			int randomAttack =new java.util.Random().nextInt(5);
			for(int i = 0; i <= randomAttack; i++){
				if(i == 0){System.out.println("　"+super.getName()+"は「"+this.skill_name_3+"」を繰り出した!!");}
				if(i != 0){System.out.println("　"+super.getName()+"の攻撃は続いている...。");}
				Pokemon.hp -=10;
			}
			this.pp_3 -= 1;
		}else{
			System.out.println("　技のppが足りません!!");
		}
	}

/*　attack_4　*/
	void attack_4(Pokemon Pokemon){
		if(0 < this.pp_4) {
			if(0 == super.getChargeSkill()){
				System.out.println("　"+super.getName()+"は激しい光をまとう");
				super.setChargeSkill(3);
			}else{
				System.out.println("　"+super.getName()+"は「"+this.skill_name_4+"」を繰り出した!!");
				this.pp_4 -= 1;
				Pokemon.hp -=70;
				super.setChargeSkill(0);
			}
		}else{
			System.out.println("　技のppが足りません!!");
		}
	}

/*　ステータスと技（初期化）　*/
	Pokemon146(){
		super.setName("ファイヤー");
		super.setHp(90);
		super.setMaxHp(90);
		super.setChargeSkill(0);
		super.setCondition(true);
		this.skill_name_1 = "つつく";
		this.skill_name_2 = "にらみつけるwww";
		this.skill_name_3 = "ほのうのうず";
		this.skill_name_4 = "ゴッドバード";
		this.pp_1 = 30;
		this.pp_2 = 30;
		this.pp_3 = 20;
		this.pp_4 = 5;
	}
}
