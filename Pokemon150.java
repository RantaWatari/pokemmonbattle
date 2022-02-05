package battle5;

public class Pokemon150 extends Pokemon {

	/*　attack_1　*/
	void attack_1(Pokemon Pokemon){
		if(0 < this.pp_1) {
			System.out.println("　"+super.getName()+"は「"+this.skill_name_1+"」を繰り出した!!");
			this.pp_1 -= 1;
			Pokemon.hp -=30;
		}else{
			System.out.println("　技のppが足りません!!");
		}
	}

/*　attack_2　*/
	void attack_2(Pokemon Pokemon){
		if(0 < this.pp_2) {
			System.out.println("　"+super.getName()+"は、「"+this.skill_name_2+"」を繰り出した!!");
			this.pp_2 -= 1;
			Pokemon.hp -=45;
		}else{
			System.out.println("　技のppが足りません!!");
		}
	}

/*　attack_3　*/
	void attack_3(Pokemon Pokemon){
		if(0 < this.pp_3) {
			if(0 == super.getChargeSkill()){
				System.out.println("　"+super.getName()+"は、「"+this.skill_name_3+"」を繰り出した!!");
				this.pp_3 -= 1;
				Pokemon.hp -= 75;
				System.out.println("　強烈な光線が" + Pokemon.getName() +"に直撃する!!");
				super.setChargeSkill(2);
			}else{
				System.out.println("　"+super.getName()+"は反動で動けない。");
				super.setChargeSkill(0);
			}

		}else{
			System.out.println("　技のppが足りません!!");
		}
	}

/*　attack_4　*/
	void attack_4(Pokemon Pokemon){
		if(0 < this.pp_4) {

			System.out.println("　"+super.getName()+"は、「"+this.skill_name_4+"」を繰り出した!!");
			this.hp += this.maxHp/2;
			if(this.hp > this.maxHp) this.hp -= (this.hp - this.maxHp);
			System.out.println("　"+super.getName()+"は回復した。");
			this.pp_4 -= 1;
		}else{
			System.out.println("　技のppが足りません!!");
		}
	}

/*　ステータスと技（初期化）　*/
	Pokemon150(){
		super.setName("ミュウツー");
		super.setHp(106);
		super.setMaxHp(106);
		super.setChargeSkill(0);
		super.setCondition(true);
		this.skill_name_1 = "スピードスター";
		this.skill_name_2 = "サイコキネシス";
		this.skill_name_3 = "はかいこうせん";
		this.skill_name_4 = "じこさいせい";
		this.pp_1 = 30;
		this.pp_2 = 10;
		this.pp_3 = 5;
		this.pp_4 = 10;
	}
}
