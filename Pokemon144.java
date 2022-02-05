package battle5;

public class Pokemon144 extends Pokemon {

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
			System.out.println("　自分の素早さがぐーんと上がった。");
			this.pp_2 -= 1;
		}else{
			System.out.println("　技のppが足りません!!");
		}
	}

/*　attack_3　*/
	void attack_3(Pokemon Pokemon){
		if(0 < this.pp_3) {
			System.out.println("　"+super.getName()+"は「"+this.skill_name_3+"」を繰り出した!!");
			this.pp_3 -= 1;
			Pokemon.hp -= 45;
		}else{
			System.out.println("　技のppが足りません!!");
		}
	}

/*　attack_4　*/
	void attack_4(Pokemon Pokemon){
		if(0 < this.pp_4) {
			System.out.println("　"+super.getName()+"は、「"+this.skill_name_4+"」を繰り出した!!");
			int randomHit =new java.util.Random().nextInt(10);
			if(2 < randomHit){
				this.pp_4 -= 1;
				Pokemon.hp -= 60;
			}else{
				this.pp_4 -= 1;
				System.out.println("　" + super.getName() + "の技ははずれた...。");
			}
		}else{
			System.out.println("　技のppが足りません!!");
		}
	}

/*　ステータスと技（初期化）　*/
	Pokemon144(){
		super.setName("フリーザー");
		super.setHp(90);
		super.setMaxHp(90);
		super.setChargeSkill(0);
		super.setCondition(true);
		this.skill_name_1 = "つつく";
		this.skill_name_2 = "こうそくいどう";
		this.skill_name_3 = "れいとうビーム";
		this.skill_name_4 = "ふぶき";
		this.pp_1 = 30;
		this.pp_2 = 30;
		this.pp_3 = 10;
		this.pp_4 = 5;
	}
}
