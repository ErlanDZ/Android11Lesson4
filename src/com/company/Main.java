package com.company;

import java.util.Random;

public class Main {
  public static int bossHealth = 700;
  public static int bossDamage = 50;
  public static int[] heroesHealth = {270, 260, 250};
  public static int[] heroesDamage = {20, 15, 25};
  public static String[] heroesAttackType = {"Physical", "Magical", "Kinetic"};

  public static String bossDefenceType = "";


  public static int round = 0;



  public static void main(String[] args) {
    printStatistics();

    while (!isGameOver()){
      round();
    }
  }

  public static void printStatistics() {
    System.out.println("Round " + round + " ***********************");
    System.out.println("Boss health " + bossHealth + "; damage: " + "(" + bossDamage + ");");

    for (int i = 0; i < heroesHealth.length; i++) {
      System.out.println("Hero health " + heroesAttackType[i] + "health " + heroesHealth[i] +
              "; damage: " + "(" + heroesDamage[i] + ");");
    }
    System.out.println("***********************");
  }

  public static boolean isGameOver() {
    if (bossHealth <= 0) {
      System.out.println("HEROES WIN!!!");
      return true;
    }
    boolean allHeroesDead = true;
    for (int i = 0; i < heroesHealth.length; i++) {
      if (heroesHealth[i] > 0) {
        allHeroesDead = false;
        break;
      }
    }

    if (allHeroesDead) {
      System.out.println("Boss WIN!!");
    }
    return allHeroesDead;
  }

  public static void round(){
    round++;
    choseBossDefence();
    bossHits();
    heroesHits();
    printStatistics();
  }

  public static void bossHits(){
    for (int i = 0; i < heroesHealth.length; i++) {
      if (heroesHealth[i] > 0){
        if (heroesHealth[i] < bossDamage){
          heroesHealth[i] = 0;
        }else {
      heroesHealth[i] = heroesHealth[i] - bossDamage;
        }
      }
    }
  }

  public  static void heroesHits(){
    for (int i = 0; i < heroesHealth.length; i++){
      if (heroesHealth[i] > 0 && bossHealth > 0){

        if (bossHealth < heroesDamage[i]){
          bossHealth = 0;
        }else{
      bossHealth = bossHealth - heroesDamage[i];
        }
        if (bossDefenceType == heroesAttackType[i]){
          bossHealth = bossHealth + heroesDamage[i];
        }
      }
    }
  }
 public static void choseBossDefence(){
   Random random = new Random();
   int randomIndex = random.nextInt(heroesAttackType.length);
   bossDefenceType = heroesAttackType[randomIndex];
   System.out.println("Boss choose: " + bossDefenceType);
 }

}
