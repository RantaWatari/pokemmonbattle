package battle5;

public class Pokemon006 extends Pokemon {
	/*　attack_1　*/
	void attack_1(Pokemon Pokemon){
		if(0 < this.pp_1) {
			System.out.println("　"+ super.getName() +"は「"+this.skill_name_1+"」を繰り出した!!");
			this.pp_1 -= 1;
			Pokemon.hp -=25;
		}else{
			System.out.println("　技のppが足りません!!");
		}
	}

/*　attack_2　*/
	void attack_2(Pokemon Pokemon){
		if(0 < this.pp_2) {
			System.out.println("　"+ super.getName() +"は、「"+this.skill_name_2+"」を繰り出した!!");
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
				if(i == 0){System.out.println("　"+ super.getName() +"は「"+this.skill_name_3+"」を繰り出した!!");}
				if(i != 0){System.out.println("　"+ super.getName() +"の攻撃は続いている...。");}
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
			System.out.println("　"+ super.getName() +"は、「"+this.skill_name_4+"」を繰り出した!!");
			int randomHit =new java.util.Random().nextInt(10);
			if(1 < randomHit){
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
	Pokemon006(){
		super.setName("リザードン");
		super.setHp(85);
		super.setMaxHp(85);
		super.setChargeSkill(0);
		super.setCondition(true);
		this.skill_name_1 = "きりさく";
		this.skill_name_2 = "しっぽをふる";
		this.skill_name_3 = "ほのうのうず";
		this.skill_name_4 = "だいもんじ";
		this.pp_1 = 20;
		this.pp_2 = 30;
		this.pp_3 = 20;
		this.pp_4 = 5;
	}
}
