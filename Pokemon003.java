package battle5;

public class Pokemon003 extends Pokemon {
	/*　attack_1　*/
	void attack_1(Pokemon Pokemon){
		if(0 < this.pp_1) {
			System.out.println("　"+super.getName()+"は「"+this.skill_name_1+"」を繰り出した!!");
			this.pp_1 -= 1;
			Pokemon.hp -=25;

			int randomHit =new java.util.Random().nextInt(10);
			if(3 > randomHit){
				Pokemon.hp -= 25;
				System.out.println("　急傷に当たった!!");
			}

		}else{
			System.out.println("　技のppが足りません!!");
		}
	}

/*　attack_2　*/
	void attack_2(Pokemon Pokemon){
		if(0 < this.pp_2) {
			System.out.println("　"+super.getName()+"は、「"+this.skill_name_2+"」を繰り出した!!");
			System.out.println("　相手の攻撃力が一段階下がった。");
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
				Pokemon.hp -=25;
				this.hp += 12.5;
				if(this.hp > this.maxHp) this.hp -= (this.hp - this.maxHp);
				System.out.println("　"+super.getName()+"は力を吸い取った。");
		}else{
			System.out.println("　技のppが足りません!!");
		}
	}

/*　attack_4　*/
	void attack_4(Pokemon Pokemon){
		if(0 < this.pp_4) {
			if(0 == super.getChargeSkill()){
				System.out.println("　"+super.getName()+"は光を吸収し始めた。");
				super.setChargeSkill(3);
			}else{
				System.out.println("　"+super.getName()+"は「"+this.skill_name_4+"」を繰り出した!!");
				this.pp_4 -= 1;
				Pokemon.hp -=60;
				super.setChargeSkill(0);
			}
		}else{
			System.out.println("　技のppが足りません!!");
		}
	}

/*　ステータスと技（初期化）　*/
	Pokemon003(){
		super.setName("フシギバナ");
		super.setHp(85);
		super.setMaxHp(85);
		super.setChargeSkill(0);
		super.setCondition(true);
		this.skill_name_1 = "はっぱカッター";
		this.skill_name_2 = "なきごえ";
		this.skill_name_3 = "メガドレイン";
		this.skill_name_4 = "ソーラービーム";
		this.pp_1 = 25;
		this.pp_2 = 30;
		this.pp_3 = 10;
		this.pp_4 = 10;
	}
}