package battle5;

public class Pokemon130 extends Pokemon{

/*　attack_1　*/
	void attack_1(Pokemon Pokemon){
		if(0 < this.pp_1) {
			System.out.println("　"+ super.getName() +"は、「"+this.skill_name_1+"」を繰り出した!!");
		}else{
			System.out.println("　技のppが足りません!!");
		}
	}

/*　attack_2　*/
	void attack_2(Pokemon Pokemon){
		if(0 < this.pp_2) {

			if(0 == super.getChargeSkill()){
				System.out.println("　"+super.getName()+"は、「"+this.skill_name_2+"」を繰り出した!!");
				Pokemon.hp -= 75;
				System.out.println("　強烈な光線が" + Pokemon.getName() +"に直撃する!!");
				super.setChargeSkill(1);
			}else{
				System.out.println("　"+super.getName()+"は反動で動けない。");
				this.pp_2 -= 1;
				super.setChargeSkill(0);
			}

		}else{
			System.out.println("　技のppが足りません!!");
		}
	}

/*　attack_3　*/
	void attack_3(Pokemon Pokemon){
		if(0 < this.pp_3) {
			System.out.println("　"+super.getName()+"は、「"+this.skill_name_3+"」を繰り出した!!");
			int randomHit =new java.util.Random().nextInt(10);
			if(1 < randomHit){
				this.pp_3 -= 1;
				Pokemon.hp -= 60;
			}else{
				this.pp_3 -= 1;
				System.out.println("　" + super.getName() + "の技ははずれた...。");
			}
		}else{
			System.out.println("　技のppが足りません!!");
		}
	}

/*　attack_4　*/
	void attack_4(Pokemon Pokemon){
		if(0 < this.pp_4) {
			System.out.println("　"+ super.getName() +"は、「"+this.skill_name_4+"」を繰り出した!!");
			this.pp_4 -= 1;
			Pokemon.hp -= 20;
		}else{
			System.out.println("　技のppが足りません!!");
		}
	}

/*　ステータスと技（初期化）　*/
	Pokemon130(){
		super.setName("ギャラドス");
		super.setHp(95);
		super.setMaxHp(95);
		super.setChargeSkill(0);
		super.setCondition(true);
		this.skill_name_1 = "にらみつける";
		this.skill_name_2 = "はかいこうせん";
		this.skill_name_3 = "ハイドロポンプ";
		this.skill_name_4 = "りゅうのいかり";
		this.pp_1 = 35;
		this.pp_2 = 5;
		this.pp_3 = 5;
		this.pp_4 = 1;
	}
}