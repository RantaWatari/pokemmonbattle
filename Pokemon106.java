package battle5;

public class Pokemon106 extends Pokemon{

/*　attack_1　*/
	void attack_1(Pokemon Pokemon){
		if(0 < this.pp_1) {
			System.out.println("　"+super.getName()+"は、「"+this.skill_name_1+"」を繰り出した!!");
			this.pp_1 -= 1;
			Pokemon.hp -= 5;
			Pokemon.hp -= 5;
			System.out.println("　2回当たった!!");
		}else{
			System.out.println("　技のppが足りません!!");
		}
	}

/*　attack_2　*/
	void attack_2(Pokemon Pokemon){
		if(0 < this.pp_2) {
			System.out.println("　"+super.getName()+"は、「"+this.skill_name_2+"」を繰り出した!!");
			this.pp_2 -= 1;
			System.out.println("　" + super.getName()+ "は、体をほぐした!!");
		}else{
			System.out.println("　技のppが足りません!!");
		}
	}

/*　attack_3　*/
	void attack_3(Pokemon Pokemon){
		if(0 < this.pp_3) {
			System.out.println("　"+super.getName()+"は、「"+this.skill_name_3+"」を繰り出した!!");
			int randomHit =new java.util.Random().nextInt(10);
			if(0 != randomHit){
				this.pp_3 -= 1;
				Pokemon.hp -= 35;
			}else{
				this.pp_3 -= 1;
				System.out.println("　" + super.getName() + "の技ははずれた...。");
				System.out.println("　" + super.getName() + "は誤って膝を地面にぶつけてしまった!!");
				this.hp -= 17.5;
			}

		}else{
			System.out.println("　技のppが足りません!!");
		}
	}

/*　attack_4　*/
	void attack_4(Pokemon Pokemon){
		if(0 < this.pp_4) {
			System.out.println("　"+ super.getName() +"は、「"+this.skill_name_4+"」を繰り出した!!");
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
	Pokemon106(){
		super.setName("サワムラー");
		super.setHp(70);
		super.setMaxHp(70);
		super.setChargeSkill(0);
		super.setCondition(true);
		this.skill_name_1 = "にどげり";
		this.skill_name_2 = "ヨガのポーズ";
		this.skill_name_3 = "とびげり";
		this.skill_name_4 = "メガトンキック";
		this.pp_1 = 30;
		this.pp_2 = 30;
		this.pp_3 = 10;
		this.pp_4 = 5;
	}
}