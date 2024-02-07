import java.util.Scanner;

public class Pokemon {



        public static void main(String[] args) {
            Pokemon2 pikachu = new Pokemon2("Picachu", 195, 150, 92, 110, 54);
            Pokemon2 kurilka = new Pokemon2("Kurilka", 122, 99, 90, 111, 54);
            Pokemon2 falen = new Pokemon2("falen", 43, 70, 65, 54, 65);
            Pokemon2 tutur = new Pokemon2("tutur", 111, 76, 43, 87, 43);
            Pokemon2 rubin = new Pokemon2("rubin", 85, 222, 65, 43, 76);
            Pokemon2 liras = new Pokemon2("liras", 54, 322, 33, 6, 100);

            Pokemon2[] Team1 = {pikachu, kurilka, falen};
            Pokemon2[] Team2 = {tutur, rubin, liras};

            Scanner scanner = new Scanner(System.in);
            System.out.println("Сколько боев?");
            int s = Integer.parseInt(scanner.nextLine());

            for (int k = 0; k < s; k++) {
                teamFight(Team1, Team2);
                teamRelax(Team1, Team2);
            }
        }

        public static void teamRelax(Pokemon2[] team1, Pokemon2[] team2) {
            for (int i = 0; i < team1.length; i++) {
                team1[i].sleep();
                team2[i].sleep();
            }
        }

        public static void teamFight(Pokemon2[] team1, Pokemon2[] team2) {
            for (int i = 0; i < team1.length; i++) {
                if (team1[i].currentHp > 0 || team2[i].currentHp > 0) {
                    team1[i].attack(team2[i]);
                } else {
                    System.out.println("Атака не состоялась");
                }
            }
        }


        static class Pokemon2 {
            String name;
            int attack;
            int maxHP;
            int defence;
            int specialAttack;
            int specialDefense;
            int currentHp = 0;


            public Pokemon2(String name, int attack, int
                    maxHP, int defence, int specialAttack, int specialDefense) {

                this.name = name;
                this.attack = attack;
                this.maxHP = maxHP;
                this.defence = defence;
                this.specialAttack = specialAttack;
                this.specialDefense = specialDefense;
                this.currentHp = maxHP;


            }


            public void attack(Pokemon2 opponent) {
                int damage = this.attack - opponent.defence;
                if (damage > 0) {
                    opponent.currentHp -= damage;
                    System.out.println(this.name + " атакует " + opponent.name + " и наносит " + damage + " урона!");
                    System.out.println("Здоровье " + opponent.name + ": " + opponent.currentHp);
                    opponent.sleep();
                } else {
                    System.out.println(this.name + " атакует " + opponent.name + ", но не наносит урона.");
                }
            }


            public void sleep() {
                Scanner scanner = new Scanner(System.in);
                int nocheinMall = 0;


                if (currentHp < maxHP / 10) {
                    System.out.println(this.name + ": Что-то мне плохо надо поспать! ");
                    currentHp += maxHP / 10;
                    System.out.println("Оооу я проснулся класс, погнали гасить!" + "\n" + " Здоровье : " + currentHp);
                    System.out.println(" Поспасть еще : " + "\n" + "1. Да " + "\n" + "2. Нет ");

                    nocheinMall = scanner.nextInt();
                    if (nocheinMall == 1) {
                        currentHp += maxHP / 10;
                        System.out.println("Оооу проснулся класс, погнали гасить!" + "\n" + " Здоровье : " + currentHp);

                    }

                    if (nocheinMall == 2) {
                        System.out.println("Тогда в бой, брат?");

                    }
                }
            }
        }
    }




