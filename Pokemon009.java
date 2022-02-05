package battle5;

public class Pokemon009 extends Pokemon {
	/*　attack_1　*/
	void attack_1(Pokemon Pokemon){
		if(0 < this.pp_1) {
			System.out.println("　"+super.getName()+"は「"+this.skill_name_1+"」を繰り出した!!");
			this.pp_1 -= 1;
			Pokemon.hp -=25;
		}else{
			System.out.println("　技のppが足りません!!");
		}
	}

/*　attack_2　*/
	void attack_2(Pokemon Pokemon){
		if(0 < this.pp_2) {
			System.out.println("　"+super.getName()+"は、「"+this.skill_name_2+"」を繰り出した!!");
			System.out.println("　自分の防御力が上がった。");
			this.pp_2 -= 1;
		}else{
			System.out.println("　技のppが足りません!!");
		}
	}

/*　attack_3　*/
	void attack_3(Pokemon Pokemon){
		if(0 < this.pp_3) {
			if(0 == super.getChargeSkill()){
				System.out.println("　"+super.getName()+"は首をひっこめた。");
				super.setChargeSkill(2);
			}else{
				System.out.println("　"+super.getName()+"は「"+this.skill_name_3+"」を繰り出した!!");
				this.pp_3 -= 1;
				Pokemon.hp -=50;
				super.setChargeSkill(0);
			}
		}else{
			System.out.println("　技のppが足りません!!");
		}
	}

/*　attack_4　*/
	void attack_4(Pokemon Pokemon){
		if(0 < this.pp_4) {
				System.out.println("　"+super.getName()+"は「"+this.skill_name_4+"」を繰り出した!!");
				this.pp_4 -= 1;
				Pokemon.hp -=40;
		}else{
			System.out.println("　技のppが足りません!!");
		}
	}

/*　ステータスと技（初期化）　*/
	Pokemon009(){
		super.setName("カメックス");
		super.setHp(85);
		super.setMaxHp(85);
		super.setChargeSkill(0);
		super.setCondition(true);
		this.skill_name_1 = "かみつく";
		this.skill_name_2 = "からにこもる";
		this.skill_name_3 = "ロケットずつき";
		this.skill_name_4 = "なみのり";
		this.pp_1 = 25;
		this.pp_2 = 30;
		this.pp_3 = 10;
		this.pp_4 = 15;
	}
}
