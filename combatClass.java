import java.util.Scanner;
import java.util.Random;

public class combatClass 

{	
	                                                //settings/variable set ups
	public static void main(String[] args)
	{
		int playerHP = 30; int playerATK = 1; 
		int playerPotions = 3;
		int magicATK = 1; int mana = 5; int manaPotions = 5;
		int defends = 3;
	 
		int enemyHP = 300; int enemyATK = 1; int enemyPotions = 3;
	 
		int healAmount = 5;
		int magicRegen = 3;
		int roundNumber = 1;
	 
		Random random = new Random();
	 
		System.out.println("What is your name?");
		Scanner scanner = new Scanner(System.in);
		String playerName = scanner.nextLine();

		System.out.println("what is your class");
		System.out.println("F for fighter");
		System.out.println("D for Defender");
		System.out.println("M for mage");
	
		String playerClass = scanner.nextLine();
	
		if(playerClass.equals("f") || playerClass.equals("F"))
			{
				playerClass = "Fighter";
				playerATK = 3;
				playerHP= 10;
				playerPotions = 3;
			}
			else
			if(playerClass.equals("D")||playerClass.equals("d"))
			{
				playerClass = "Defender";
				playerATK = 3;
				playerHP= 15;
				playerPotions = 3;
			}
			else
			if(playerClass.equals("M")||playerClass.equals("m"))
			{
				playerClass = "Mage";
				playerATK = 3;
			    magicATK = 15;
				playerHP= 8;
				playerPotions = 3;
				mana = 5;
				manaPotions=5;		
			}
		
		System.out.println("welcome to the game " + playerName +" the "+ playerClass);
		
		
		//actual game
		
		while (playerHP > 0 && enemyHP > 0) 
		{
			System.out.println("--------------------- round " + roundNumber + "------------------------");
			System.out.println("---------------- "+ playerName +" HP : " + playerHP+ "--------ENEMY HP: " +enemyHP );
			System.out.println("---------------- MP : " + mana + " ----------");
			System.out.println("---------------- Defends : " + defends+ " ----------");
			System.out.println("----" + playerName + "'s TURN--");
			
			
			System.out.println("enter A to attack");
			
			if(playerClass == "Defender" && defends >0)
			{
				System.out.println("enter D to defend");
			}
			
			if(playerClass.equals("Mage")&& mana >0)
			{
				System.out.println("Enter M for magic");
			}
			
			
			if(playerPotions >0)  
			{
			System.out.println("enter H to heal"); //<-- heal option
			}
			if(playerClass.equals("Mage")&& manaPotions >0)
			{
				System.out.println("enter P for mana potion");
			}
			
			Scanner scanner2 = new Scanner(System.in);
			String combatChoice = scanner2.nextLine();
			
			
			
			
			
			if(combatChoice.equals("a")|| combatChoice.equals("A")) //<-- attacks
			{
				System.out.println("you attack for " + playerATK +" dmg");
				enemyHP = enemyHP - playerATK;
			}
			if(playerPotions >0 &&combatChoice.equals("h") ||combatChoice.equals("H")) //<-- heals
			{
				playerPotions = playerPotions - 1;
				System.out.println(playerName +" uses a potion and heals for " + healAmount + " hp ");
				playerHP = playerHP + healAmount;
			}
			else
			if(playerPotions <=0 &&combatChoice.equals("h") ||combatChoice.equals("H"))
			{
				System.out.println("you have no potions left, loss of turn");
				
			}
			if(playerClass.equals("Defender") && combatChoice.equals("d")|| combatChoice.equals("D"))
			{
				defends = defends -1;
				System.out.println("you block this turn, you have " + defends + " left");
				
			}
			if(playerClass.equals("Mage") &&combatChoice.equals("m")||combatChoice.equals("M"))
			{
				mana=mana-1;
				System.out.println("you cast a magic spell dealing " +magicATK + " dmg");
				
				enemyHP = enemyHP - magicATK;
				
			}
			if(playerClass.equals("Mage")&& mana <0)
			{
				System.out.println("you are out of mana, try attacking or using a mana potion");
				enemyHP = enemyHP +magicATK;
			}
			if(combatChoice.equals("p")||combatChoice.equals("P"))
			{
				mana = mana+magicRegen;
			}
			
			
			
			//enemy turn
			int enemyChoice = random.nextInt(2);
			
			if (enemyHP > 0)
            {
				
				if(enemyChoice == 0 && combatChoice.equals("d") ) //<-- attacks
				{
					System.out.println("player blocked ur atk");		 
				}
				else
				if(enemyChoice ==0 && defends <0 || combatChoice !="d")
				{
					 playerHP = playerHP - enemyATK;
					 System.out.println("-- emeny attacks dealing " + enemyATK + " damage to " +playerName);
					 System.out.println("----------------------------------------------");
				}
				
				else
				if(enemyChoice ==1 && enemyPotions >0  ) //<-- heals if able
				{
					enemyPotions = enemyPotions - 1;
					System.out.println( "The enemy uses a potion and heals for " + healAmount + " hp ");
					enemyHP = enemyHP + healAmount;
					System.out.println("----------------------------------------------");
				}
				else
				if(enemyChoice ==1 && enemyPotions <=0  )
				{
						System.out.println("emeny tries to use a potion but attacks anywyas dealing " + enemyATK + " dmg" );
						System.out.println("----------------------------------------------");
						
				}
			}
			roundNumber++;
          }		
	}
	}	
