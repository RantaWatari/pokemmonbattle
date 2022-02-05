package battle5;

public class Pokemon149 extends Pokemon {

	int ryuuseigun ;

	/*　attack_1　*/
	void attack_1(Pokemon Pokemon){
		if(0 < this.pp_1) {
			System.out.println("　"+super.getName()+"は、「"+this.skill_name_1+"」を繰り出した!!");
			int randomHit =new java.util.Random().nextInt(10);
			if(1 < randomHit){
				this.pp_1 -= 1;
				Pokemon.hp -= 40;
			}else{
				this.pp_1 -= 1;
				System.out.println("　" + super.getName() + "の技ははずれた...。");
			}
		}else{
			System.out.println("　技のppが足りません!!");
		}
	}

/*　attack_2　*/
	void attack_2(Pokemon Pokemon){
		if(0 < this.pp_2) {
			System.out.println("　"+ super.getName() +"は、「"+this.skill_name_2+"」を繰り出した!!");
			System.out.println("　自分の素早さがぐーんと上がった。");
			this.pp_2 -= 1;
		}else{
			System.out.println("　技のppが足りません!!");
		}
	}

/*　attack_3　*/
	void attack_3(Pokemon Pokemon){
		if(0 < this.pp_3) {
				System.out.println("　"+ super.getName() +"は、「"+this.skill_name_3+"」を繰り出した!!");
				this.pp_3 -= 1;

				if(ryuuseigun == 1){
					Pokemon.hp -= 70/this.ryuuseigun ;
					this.ryuuseigun += 1;
				}else if(ryuuseigun == 2){
					Pokemon.hp -= 70/this.ryuuseigun ;
					this.ryuuseigun += 1;
				}else{
					Pokemon.hp -= 70/this.ryuuseigun ;
				}

				System.out.println("　" + super.getName() +"の特殊能力はがっくと下がった");
		}else{
			System.out.println("　技のppが足りません!!");
		}
	}

/*　attack_4　*/
	void attack_4(Pokemon Pokemon){
		if(0 < this.pp_4) {

			if(0 == super.getChargeSkill()){
				System.out.println("　"+ super.getName() +"は、「"+this.skill_name_4+"」を繰り出した!!");
				this.pp_4 -= 1;
				Pokemon.hp -= 75;
				System.out.println("　強烈な光線が" + Pokemon.getName() +"に直撃する!!");
				super.setChargeSkill(3);
			}else{
				System.out.println("　"+ super.getName() +"は反動で動けない。");
				super.setChargeSkill(0);
			}

		}else{
			System.out.println("　技のppが足りません!!");
		}
	}

/*　ステータスと技（初期化）　*/
	Pokemon149(){
		super.setName("カイリュー");
		super.setHp(91);
		super.setMaxHp(91);
		super.setChargeSkill(0);
		super.setCondition(true);
		this.skill_name_1 = "たたきつける";
		this.skill_name_2 = "こうそくいどう";
		this.skill_name_3 = "りゅうせいぐん";
		this.skill_name_4 = "はかいこうせん";
		this.pp_1 = 20;
		this.pp_2 = 30;
		this.pp_3 = 5;
		this.ryuuseigun = 1;
		this.pp_4 = 5;
	}
}