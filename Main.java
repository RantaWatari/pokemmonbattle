package battle5;

public class Main{
	public static void main(String[] args){

		/*　Pokemonをnewでインスタンス化と同時にpoketteMyPokemon（配列）に入れる。 -> 手持ちのポケモンを指定。　*/
		/*　配列の宣言とポケモンインスタンスの代入において、空の要素があると、
		 * Exception in thread "main" java.lang.NullPointerExceptionとなるので注意（改善の要検討が必須）。　*/
		Pokemon[] poketteMyPokemon = new Pokemon[5];
		poketteMyPokemon[0] = new Pokemon003();
		poketteMyPokemon[1] = new Pokemon006();
		poketteMyPokemon[2] = new Pokemon009();
		poketteMyPokemon[3] = new Pokemon106();
		poketteMyPokemon[4] = new Pokemon149();
//		poketteMyPokemon[5] = new Pokemon130();
		Pokemon battleOnMyPokemon = poketteMyPokemon[0];

		/*　EnemyPokemonの配列初期化。　*/
		Pokemon[] poketteEnemyPokemon = new Pokemon[6];
		poketteEnemyPokemon[0] = new Pokemon150();
		poketteEnemyPokemon[1] = new Pokemon144();
		poketteEnemyPokemon[2] = new Pokemon145();
		poketteEnemyPokemon[3] = new Pokemon146();
		poketteEnemyPokemon[4] = new Pokemon149();
		poketteEnemyPokemon[5] = new Pokemon150();
		Pokemon battleOnEnemyPokemon = poketteEnemyPokemon[0];

		/*　戦闘開始　*/
		battleStart(battleOnMyPokemon,battleOnEnemyPokemon);

		/*　戦闘中-戦闘終了（do-while）　*/
		battle(poketteMyPokemon,battleOnMyPokemon,poketteEnemyPokemon,battleOnEnemyPokemon);

	}


//　戦闘開始の画面
	public static void battleStart(Pokemon battleOnMyPokemon,Pokemon battleOnEnemyPokemon){
		System.out.println("---------------------------");
		System.out.println("　相手は"+battleOnEnemyPokemon.getName()+"　を繰り出してきた!!");
		System.out.println("　行け!!"+battleOnMyPokemon.getName()+"!!");
		System.out.println("---------------------------");
	}


//　戦闘中-戦闘終了（do-while）
	public static void battle(Pokemon[] poketteMyPokemon,Pokemon battleOnMyPokemon,Pokemon[] poketteEnemyPokemon,Pokemon battleOnEnemyPokemon){
		boolean escapeBattle = true;		short count = 1;
		byte battle_OR_change_OR_escape = 1;		int Preceding ;
		int EnemyreserveLength = poketteEnemyPokemon.length;		final int maxEnemyreserveLength = poketteEnemyPokemon.length;
		int MyreserveLength = poketteMyPokemon.length;		final int maxMyreserveLength = poketteMyPokemon.length;

		/*　戦闘のloop処理（do-while）　*/
		/*　do-while　START*/
		do{
			System.out.println("< turn " + count + " >" );

			/*　戦う、ポケモンの入れ替え、逃げるを選ぶ画面とそのコマンド（swith）　*/
			battle_2_1_SelectScreen(EnemyreserveLength,maxEnemyreserveLength,MyreserveLength,maxMyreserveLength
									,battleOnMyPokemon,battleOnEnemyPokemon);
			battle_OR_change_OR_escape = battleOrChangeOrEscape(battleOnMyPokemon,battleOnEnemyPokemon,battle_OR_change_OR_escape);

			speaceSreen_timeStop();

			switch(battle_OR_change_OR_escape){

			/*　戦うを選択　*/
			case 1:
				/*　ポケモンの技を選ぶ（戦うを選んだ後の処理）　*/
				MyPokemonSkillSelectScreen(battleOnMyPokemon,battleOnEnemyPokemon);
				int skillSelect = 0;
				boolean ppZero = false;

				skillSelect = skillSelectScanner(skillSelect,ppZero,battleOnMyPokemon,battleOnEnemyPokemon);

					/*　5を入力した場合、"戦闘のloop処理"の最初に戻る（ひとつ前の画面に戻る）　*/
					if(4 == skillSelect){
						speaceSreen_timeStop();
						continue;
					}

				/*　プレイヤーと敵プレイヤーが攻撃を行なう。Precedingで先功と後攻を決定する。（戦うを選んだ後の処理）　*/

				Preceding =new java.util.Random().nextInt(2);

					if(0 == Preceding){				/*　プレイヤー側の先功　*/
						speaceSreen_timeStop();
						System.out.println("---------------------------");
						count++;

						/*　プレイヤー側の攻撃　*/
						MyPokemonSkill(skillSelect,battleOnMyPokemon,battleOnEnemyPokemon);
						/*　敵プレイヤーのポケモンのHP<=0になった時の処理　*/
						if(battleOnEnemyPokemon.hp <=0){
							battleOnMyPokemon.win(battleOnEnemyPokemon);
							battleOnEnemyPokemon.setCondition(false);
							/*　敵プレイヤーが別のポケモンに交換する or 戦闘の終了（"戦闘のloop処理"の終了）　*/
							if(EnemyreserveLength > 1){
								EnemyreserveLength -=1 ;
								battleOnEnemyPokemon = ChangeOnEnemyPokemon(poketteEnemyPokemon,battleOnEnemyPokemon);
								System.out.println("　相手は" + battleOnEnemyPokemon.getName() + "　を繰り出してきた。");
								System.out.println("---------------------------");
								continue;
							}else{
								System.out.println("　相手の全てのポケモンを倒しました。\nプレイヤーの勝ちです!!");
								System.out.println("---------------------------");
								EnemyreserveLength -=1 ;
								continue;
								}
							}

						/*　敵プレイヤー側の攻撃　*/
						EnemyPokemonSkill(battleOnMyPokemon,battleOnEnemyPokemon);
						/*　プレイヤーのポケモンのHP<=0になった時の処理　*/
						if(battleOnMyPokemon.hp <=0){
							battleOnEnemyPokemon.win(battleOnMyPokemon);
							battleOnMyPokemon.setCondition(false);
							System.out.println("---------------------------");
							/*　プレイヤーが別のポケモンに交換する or 戦闘の終了（"戦闘のloop処理"の終了）　*/
							if(MyreserveLength > 1){
								MyreserveLength -=1 ;
								battleOnMyPokemon = ChangeOnMyPokemon(poketteMyPokemon,battleOnMyPokemon);
								continue;
							}else{
								System.out.println("　これ以上味方はいない!!\nプレイヤーの負けです。");
								MyreserveLength -=1 ;
								System.out.println("---------------------------");
								continue;
							}
						}

						System.out.println("---------------------------");

					}else{			/*　敵プレイヤー側の先功（プレイヤーの先功とは逆の手順で進行する）　*/
						speaceSreen_timeStop();
						System.out.println("---------------------------");
						count++;

						EnemyPokemonSkill(battleOnMyPokemon,battleOnEnemyPokemon);

						if(battleOnMyPokemon.hp <=0){
							battleOnEnemyPokemon.win(battleOnMyPokemon);
							battleOnMyPokemon.setCondition(false);
							System.out.println("---------------------------");

							if(MyreserveLength > 1){
								MyreserveLength -=1 ;
								battleOnMyPokemon = ChangeOnMyPokemon(poketteMyPokemon,battleOnMyPokemon);
								continue;
							}else{
								System.out.println("　これ以上味方はいない!!\nプレイヤーの負けです。");
								MyreserveLength -=1 ;
								System.out.println("---------------------------");
								continue;
							}
						}

						MyPokemonSkill(skillSelect,battleOnMyPokemon,battleOnEnemyPokemon);

						if(battleOnEnemyPokemon.hp <=0){
							battleOnMyPokemon.win(battleOnEnemyPokemon);
							battleOnEnemyPokemon.setCondition(false);

							if(EnemyreserveLength > 1){
								EnemyreserveLength -=1 ;
								battleOnEnemyPokemon = ChangeOnEnemyPokemon(poketteEnemyPokemon,battleOnEnemyPokemon);
								System.out.println("　相手は" + battleOnEnemyPokemon.getName() + "　を繰り出してきた。");
								System.out.println("---------------------------");
								continue;
							}else{
								System.out.println("　相手の全てのポケモンを倒しました。\nプレイヤーの勝ちです!!");
								EnemyreserveLength -=1 ;
								System.out.println("---------------------------");
								continue;
							}
						}

					System.out.println("---------------------------");
					}
				break;

			/*　入れ替えを選択　*/
			case 2:
				/*　ポケモンの入れ替え（戦うポケモンを交代する処理(if)）　*/
					Pokemon now_battleOnMyPokemon = battleOnMyPokemon;
					MyPokemonChangeSelectScreen(poketteMyPokemon,battleOnMyPokemon,now_battleOnMyPokemon);
					battleOnMyPokemon = MyPokemonChangeSelect(poketteMyPokemon,battleOnMyPokemon,now_battleOnMyPokemon);

					/*　ポケモンの入れ替えた後なら(if)、敵からの攻撃をすぐ受ける　*/
						if(now_battleOnMyPokemon != battleOnMyPokemon){
							count++;

							EnemyPokemonSkill(battleOnMyPokemon,battleOnEnemyPokemon);

							if(battleOnMyPokemon.hp <=0){
								battleOnEnemyPokemon.win(battleOnMyPokemon);
								battleOnMyPokemon.setCondition(false);
								System.out.println("---------------------------");
									if(MyreserveLength > 1){
										MyreserveLength -=1 ;
										battleOnMyPokemon = ChangeOnMyPokemon(poketteMyPokemon,battleOnMyPokemon);
										continue;
									}else{
										System.out.println("　これ以上味方はいない!!\nプレイヤーの負けです。");
										MyreserveLength -=1 ;
										System.out.println("---------------------------");
										continue;
									}
							}
						}
					System.out.println("---------------------------");
				break;

			/*　逃げるを選択　*/
			case 3:
				/*　逃げるを選択した場合(if)　*/
					System.out.println("---------------------------");
					battleOnMyPokemon.escape();
					System.out.println("---------------------------");
					escapeBattle = false;
				break;

			default:
				System.out.println("　1～3の数字で指示してください!!");
				break;

			}
		}while(escapeBattle && EnemyreserveLength > 0 && MyreserveLength > 0);
		/*　do-while　END*/
	}


//　たたかう、交代、逃げるを選ぶ画面
	public static void battle_2_1_SelectScreen(int EnemyreserveLength,final int maxEnemyreserveLength,int MyreserveLength
			,final int maxMyreserveLength,Pokemon battleOnMyPokemon,Pokemon battleOnEnemyPokemon){
		System.out.println("　相手の手持ち" + EnemyreserveLength + "/" + maxEnemyreserveLength);
//		System.out.println("　"+battleOnEnemyPokemon.name + "  HP："+(int)battleOnEnemyPokemon.hp);
		System.out.print("　"+battleOnEnemyPokemon.getName());
		enemyHpGauge(battleOnEnemyPokemon);
		System.out.println("　自分のの手持ち" + MyreserveLength + "/" + maxMyreserveLength);
//		System.out.println("　"+battleOnMyPokemon.name + "  HP："+(int)battleOnMyPokemon.hp);
		System.out.print("　"+battleOnMyPokemon.getName());
		MyHpGauge(battleOnMyPokemon);
		System.out.println("===========================");
	 	System.out.println("戦う、ポケモンを入れ替える、逃げるか選択してください。(数字で選択して、Enterで決定)");
		System.out.println("1：戦う");
		System.out.println("2：ポケモン入れ替え");
		System.out.println("3：逃げる");
		System.out.println("===========================");
		}


//　たたかう、交代、逃げるを選ぶ処理(Scanner,switch)
	public static byte battleOrChangeOrEscape(Pokemon battleOnMyPokemon,Pokemon battleOnEnemyPokemon,byte battle_OR_change_OR_escape){
		int CommandNumber;

		do{
			System.out.print("入力値:");
			CommandNumber = new java.util.Scanner(System.in).nextInt();
		}while(CommandNumber <0 ||  3 < CommandNumber);


		switch(CommandNumber){
		case 1:
			battle_OR_change_OR_escape = 1;
			break;
		case 2:
			battle_OR_change_OR_escape = 2;
			break;
		case 3:
			battle_OR_change_OR_escape = 3;
			break;
		default:
			System.out.println("　1～3の数字で指示してください!!");
			break;
		}
		return battle_OR_change_OR_escape;
	}


//　ポケモンを交代するか否かを選ぶ画面
	public static void MyPokemonChangeSelectScreen(Pokemon[] poketteMyPokemon,Pokemon battleOnMyPokemon,Pokemon now_battleOnMyPokemon){

		int pokettelenght = poketteMyPokemon.length;
		int num = 1;
		System.out.println("===========================");
		System.out.println("交代するポケモンを選んでください。（数字で選択）");

		for(int i = 0; i < pokettelenght; i++){

			if(poketteMyPokemon[i].getCondition() == true && poketteMyPokemon[i] != battleOnMyPokemon){
				System.out.println("　" + num + ":" + poketteMyPokemon[i].getName() + "　に交代する。　HP:" + (int)poketteMyPokemon[i].hp);
			}else if(poketteMyPokemon[i] == now_battleOnMyPokemon){
				System.out.println("　" + num + ":" + poketteMyPokemon[i].getName() + "　は既にバトル場に出ています。　HP:" + (int)poketteMyPokemon[i].hp);
			}else{
				poketteMyPokemon[i].hp = poketteMyPokemon[i].hp + (poketteMyPokemon[i].hp * -1);
				System.out.println("　  " + poketteMyPokemon[i].getName() + "　は交代できません。　HP:" + (int)poketteMyPokemon[i].hp);
			}
			num++;
		}

		System.out.println("　" + num + ":ひとつ前の画面に戻る。");
		System.out.println("===========================");

	}


//　ポケモンを交代する処理（Scanner,if）
	public static Pokemon MyPokemonChangeSelect(Pokemon[] poketteMyPokemon,Pokemon battleOnMyPokemon,Pokemon now_battleOnMyPokemon){
		int pokettelenght = poketteMyPokemon.length;
		int changeNum;

		/*　1-pokettelenghtまでの入力を受け付ける（配列が0から始まるので"changeNum-1"）　*/
		do{
			System.out.print("入力値:");
			changeNum = new java.util.Scanner(System.in).nextInt()-1;
		}while(changeNum < 0 || pokettelenght < changeNum);

			/*　"ひとつ前の画面に戻る"の処理にする(poketteLength==Array[MAX+1])　*/
			if(pokettelenght ==  changeNum){
				speaceSreen_timeStop();
				return battleOnMyPokemon;
			}
			speaceSreen_timeStop();
			/*　交換するポケモンが既にバトル場に出ているポケモンではなく、状態がTRUEならば交換する。状態がFALSEならば戦闘に出すことはできず,
			 * 既にバトル場に出ているなら交換しない。　*/
			if(poketteMyPokemon[changeNum] != now_battleOnMyPokemon && true == poketteMyPokemon[changeNum].getCondition()){
				battleOnMyPokemon = poketteMyPokemon[changeNum];
				System.out.println("---------------------------");
				System.out.println("　行け!!" + poketteMyPokemon[changeNum].getName() + "　!!");
				return battleOnMyPokemon;
			}else if(false == poketteMyPokemon[changeNum].getCondition()){
				System.out.println("---------------------------");
				System.out.println("　" + poketteMyPokemon[changeNum].getName() + "は戦闘に出すことはできません。");
				return battleOnMyPokemon;
			}else{
				System.out.println("---------------------------");
				System.out.println("　" + poketteMyPokemon[changeNum].getName() + "は既にバトル場に出ています。");
				return battleOnMyPokemon;
			}

	}


//　ポケモンの技を選択する画面　
	public static void MyPokemonSkillSelectScreen(Pokemon battleOnMyPokemon,Pokemon battleOnEnemyPokemon){
//		System.out.println(battleOnEnemyPokemon.name + "  HP："+(int)battleOnEnemyPokemon.hp);
		System.out.print("　"+battleOnEnemyPokemon.getName());
		enemyHpGauge(battleOnEnemyPokemon);
//		System.out.println(battleOnMyPokemon.name + "  HP："+(int)battleOnMyPokemon.hp);
		System.out.print("　"+battleOnMyPokemon.getName());
		MyHpGauge(battleOnMyPokemon);
		System.out.println("===========================");
	 	System.out.println("ポケモンに技を指示してください。(数字で選択して、Enterで決定)");
		System.out.println("1："+battleOnMyPokemon.skill_name_1+"　pp："+battleOnMyPokemon.pp_1);
		System.out.println("2："+battleOnMyPokemon.skill_name_2+"　pp："+battleOnMyPokemon.pp_2);
		System.out.println("3："+battleOnMyPokemon.skill_name_3+"　pp："+battleOnMyPokemon.pp_3);
		System.out.println("4："+battleOnMyPokemon.skill_name_4+"　pp："+battleOnMyPokemon.pp_4);
		System.out.println("5：ひとつ前の画面に戻る");
		System.out.println("===========================");
	}


//　自分のポケモンの技を選ぶ処理（switch）
	public static void MyPokemonSkill(int skillSelect,Pokemon battleOnMyPokemon,Pokemon battleOnEnemyPokemon){

		/*　chargeされている技があればそれを選択。　*/
		if(battleOnMyPokemon.chargeSkill != 0){
			skillSelect =battleOnMyPokemon.chargeSkill;
		}

		/*　switch　START　*/
		switch(skillSelect){
			case 0:
				battleOnMyPokemon.attack_1(battleOnEnemyPokemon);
				break;
			case 1:
				battleOnMyPokemon.attack_2(battleOnEnemyPokemon);
				break;
			case 2:
				battleOnMyPokemon.attack_3(battleOnEnemyPokemon);
				break;
			case 3:
				battleOnMyPokemon.attack_4(battleOnEnemyPokemon);
				break;
			case 4:
				break;
			default:
				System.out.println("　1～5の数字で指示してください!!");
				break;
		}
		/*　switch　END　*/
	}


//　相手のポケモンの技を選ぶ処理（switch）
	public static void EnemyPokemonSkill(Pokemon battleOnMyPokemon,Pokemon battleOnEnemyPokemon){
		int randomSkillSelect;
		int reRandomSkillSelect;
		int skillSelect;
		boolean ppZero = false;

		/*　chargeされている技があればそれを選択。無ければ技をRandom().nextInt()で選択。　*/
		if(battleOnEnemyPokemon.chargeSkill != 0){
			skillSelect =battleOnEnemyPokemon.chargeSkill;
		}else{
			randomSkillSelect = new java.util.Random().nextInt(4);
			skillSelect = randomSkillSelect;
//			skillSelect = 1;
		}

		/*　switch　START　*/
		do{
			switch(skillSelect){
			case 0:
				if(battleOnEnemyPokemon.pp_1 <= 0){
				 	reRandomSkillSelect = new java.util.Random().nextInt(3);
					skillSelect = (skillSelect + reRandomSkillSelect + 1)%4;
					ppZero = true;
				}
				battleOnEnemyPokemon.attack_1(battleOnMyPokemon);
				ppZero = false;
				break;
			case 1:
				if(battleOnEnemyPokemon.pp_2 <= 0){
				 	reRandomSkillSelect = new java.util.Random().nextInt(3);
					skillSelect = (skillSelect + reRandomSkillSelect + 1)%4;
					ppZero = true;
				}
				battleOnEnemyPokemon.attack_2(battleOnMyPokemon);
				ppZero = false;
				break;
			case 2:
				if(battleOnEnemyPokemon.pp_3 <= 0){
				 	reRandomSkillSelect = new java.util.Random().nextInt(3);
					skillSelect = (skillSelect + reRandomSkillSelect + 1)%4;
					ppZero = true;
				}
				battleOnEnemyPokemon.attack_3(battleOnMyPokemon);
				ppZero = false;
				break;
			case 3:
				if(battleOnEnemyPokemon.pp_4 <= 0){
				 	reRandomSkillSelect = new java.util.Random().nextInt(3);
					skillSelect = (skillSelect + reRandomSkillSelect + 1)%4;
					ppZero = true;
				}
				battleOnEnemyPokemon.attack_4(battleOnMyPokemon);
				ppZero = false;
				break;
			default:
				System.out.println(battleOnMyPokemon.getName() + "　技が出せない!!");
				break;
		}
		/*　switch　END　*/
		}while(ppZero == true);
	}


	public static Pokemon ChangeOnEnemyPokemon(Pokemon[] poketteEnemyPokemon,Pokemon battleOnEnemyPokemon){
		battleOnEnemyPokemon.setCondition(false);
		int pokettelenght = poketteEnemyPokemon.length;
		for(int i = 0; i < pokettelenght; i++){
			if(poketteEnemyPokemon[i].getCondition() == true){
				battleOnEnemyPokemon = poketteEnemyPokemon[i];
				break;
			}
		}
		return battleOnEnemyPokemon;
	}


	public static Pokemon ChangeOnMyPokemon(Pokemon[] poketteMyPokemon,Pokemon battleOnMyPokemon){
		int pokettelenght = poketteMyPokemon.length;
		int changeNum;

		do{
			int num = 1;
			System.out.println("===========================");
			System.out.println("交代するポケモンを選んでください。（数字で選択）");

			for(int i = 0; i < pokettelenght; i++){

				if(poketteMyPokemon[i].getCondition() == true && poketteMyPokemon[i] != battleOnMyPokemon){
					System.out.println("　" + num + ": " + poketteMyPokemon[i].getName() + "　に交代する。　HP:" + (int)poketteMyPokemon[i].hp);
				}else{
					poketteMyPokemon[i].hp = poketteMyPokemon[i].hp + (poketteMyPokemon[i].hp * -1);
					System.out.println("　   " + poketteMyPokemon[i].getName() + "　は交代できません。　HP:" + (int)poketteMyPokemon[i].hp);
				}
				num++;
			}

			System.out.println("===========================");
			changeNum = new java.util.Scanner(System.in).nextInt() -1;

			speaceSreen_timeStop();
		}while(changeNum < 0 || pokettelenght <= changeNum || false == poketteMyPokemon[changeNum].getCondition());

		battleOnMyPokemon = poketteMyPokemon[changeNum];
		System.out.println("---------------------------");
		System.out.println("　行け!!　" + battleOnMyPokemon.getName() + "　!!");
		System.out.println("---------------------------");

		return battleOnMyPokemon;
	}


	public static void speaceSreen_timeStop(){

		try{
//			java.util.concurrent.TimeUnit.SECONDS.sleep(1);
			Thread.sleep(500);
		}catch(InterruptedException e){
		}

		for(int i = 1; i <= 20; i++){
			System.out.print("\n");
		}

	}


	public static void enemyHpGauge(Pokemon battleOnEnemyPokemon){
		/* maxHp/iにおいて、maxHp<iならばException in thread "main" java.lang.ArithmeticException: / by zeroになるので注意。（改善の要検討が必須）*/

		double enemyHpGauge = ((battleOnEnemyPokemon.hp)/(battleOnEnemyPokemon.maxHp/20));
		double enemyHpMaxGauge = ((battleOnEnemyPokemon.maxHp)/(battleOnEnemyPokemon.maxHp/20));
		System.out.print("　HP:");
		for(int i = 0;i < enemyHpGauge;i++ ){
			System.out.print("#");
		}
		for(int i = 0;i < enemyHpMaxGauge - enemyHpGauge;i++ ){
			System.out.print("-");
		}
		System.out.print("\n");

	}


	public static void MyHpGauge(Pokemon battleOnMyPokemon){
		/* maxHp/iにおいて、maxHp<iならばException in thread "main" java.lang.ArithmeticException: / by zeroになるので注意。（改善の要検討が必須） */

		double myHpGauge = ((battleOnMyPokemon.hp)/(battleOnMyPokemon.maxHp/20));
		double myHpMaxGauge = ((battleOnMyPokemon.maxHp)/(battleOnMyPokemon.maxHp/20));
		System.out.print("　HP:");
		for(int i = 0;i < myHpGauge;i++ ){
			System.out.print("#");
		}
		for(int i = 1;i < myHpMaxGauge - myHpGauge;i++ ){
			System.out.print("-");
		}
		System.out.print("\n");

	}


	public static int skillSelectScanner(int skillSelect,boolean ppZero,Pokemon battleOnMyPokemon,Pokemon battleOnEnemyPokemon){

		/*　1-5までの入力で選択（既定外の数値はdo-whileから抜け出せない。）　*/
		do{
			System.out.print("入力値:");
			skillSelect = new java.util.Scanner(System.in).nextInt()-1;

			switch(skillSelect){
			case 0:
				ppZero = false;
				if(battleOnMyPokemon.pp_1 <=0){
					speaceSreen_timeStop();
					System.out.println("---------------------------");
					System.out.println("　技のppが足りません。");
					System.out.println("---------------------------");
					MyPokemonSkillSelectScreen(battleOnMyPokemon,battleOnEnemyPokemon);
					ppZero = true;
				}
				continue;
			case 1:
				ppZero = false;
				if(battleOnMyPokemon.pp_2 <=0){
					speaceSreen_timeStop();
					System.out.println("---------------------------");
					System.out.println("　技のppが足りません。");
					System.out.println("---------------------------");
					MyPokemonSkillSelectScreen(battleOnMyPokemon,battleOnEnemyPokemon);
					ppZero = true;
				}
				continue;
			case 2:
				ppZero = false;
				if(battleOnMyPokemon.pp_3 <=0){
					speaceSreen_timeStop();
					System.out.println("---------------------------");
					System.out.println("　技のppが足りません。");
					System.out.println("---------------------------");
					MyPokemonSkillSelectScreen(battleOnMyPokemon,battleOnEnemyPokemon);
					ppZero = true;
				}
				continue;
			case 3:
				ppZero = false;
				if(battleOnMyPokemon.pp_4 <=0){
					speaceSreen_timeStop();
					System.out.println("---------------------------");
					System.out.println("　技のppが足りません。");
					System.out.println("---------------------------");
					MyPokemonSkillSelectScreen(battleOnMyPokemon,battleOnEnemyPokemon);
					ppZero = true;
				}
				continue;
			default:
				ppZero = false;
				break;
			}
		}while(skillSelect < 0 || 4 < skillSelect || ppZero);

		return skillSelect;
	}



}
