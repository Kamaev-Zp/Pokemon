import java.util.Scanner;

public  class  Pokemon {
    //    Cоздал константу и с помощью статического инициализатора - сканнера записываю в статическое название
//    (переменную additionalHP) Добавляю нашу переменную статическую в экземпляр (объект),
//    в класс и конструктор, дальше дописываю в методе файт
//    следующие строки opponent.currentHp += opponent.additionalHP;
//    opponent.currentHp -= damage; тем самым,
//    Сначала здоровье покемона прибавляю к нашему бонусному и присваиваю сразу = currentHp
//    потом отнимая урон который нанес покемон  currentHp -= damage и переписываю
//    также еще дописал to string  что бы выводить значение покемона пикачу.
//    После битвы группы покимонов
//    Отображается их здоровья  + бонусным = Здоровья
//
    private final static double additionalHP;

    static {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите дополнительное количество HP для всех бойцов : ");
        additionalHP = Double.parseDouble(scanner.nextLine());

    }


    public static void main(String[] args) {
        Pokemon2 pikachu = new Pokemon2("Picachu", 195, 150, 92, 110, 54,  additionalHP );
        Pokemon2 kurilka = new Pokemon2("Kurilka", 122, 99, 90, 111, 54,  additionalHP);
        Pokemon2 falen = new Pokemon2("falen", 43, 70, 65, 54, 65,  additionalHP);
        Pokemon2 tutur = new Pokemon2("tutur", 111, 76, 43, 87, 43,  additionalHP);
        Pokemon2 rubin = new Pokemon2("rubin", 85, 222, 65, 43, 76,  additionalHP);
        Pokemon2 liras = new Pokemon2("liras", 54, 322, 33, 6, 100,  additionalHP);
//        System.out.println(pikachu);
//        kurilka.attack(pikachu);
//        System.out.println(pikachu);



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
        double additionalHP ;



        public Pokemon2(String name, int attack, int
                maxHP, int defence, int specialAttack, int specialDefense , double additionalHP) {

            this.name = name;
            this.attack = attack;
            this.maxHP = maxHP;
            this.defence = defence;
            this.specialAttack = specialAttack;
            this.specialDefense = specialDefense;
            this.currentHp = maxHP;
            this.additionalHP = additionalHP;


        }


        public void attack(Pokemon2 opponent) {
            int damage = this.attack - opponent.defence;
            if (damage > 0) {
//                Тут
                opponent.currentHp += opponent.additionalHP;
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

// и Тут
        public String toString(){
            return  " Имя бойца : " + name  +  "\n" +
                    " Атака : " + attack + "\n" +
                    " Здоровья бойца : " + maxHP + "\n" +
                    " Защита : " + defence + "\n" +
                    " Cпец Атака : " + specialAttack + "\n" +
                    " Спец Защита : " + specialDefense + "\n" +
                    " Бонус Здоровья Бойца : " + additionalHP + "\n";
        }
    }
}

//   this.name = name;
//           this.attack = attack;
//           this.maxHP = maxHP;
//           this.defence = defence;
//           this.specialAttack = specialAttack;
//           this.specialDefense = specialDefense;
//           this.currentHp = maxHP;
//           this.additionalHP = additionalHP;
//            private final static double additionalHP;
//            static {
//                Scanner scanner = new Scanner(System.in);
//                // Здесь может быть код для чтения значения additionalHP
//            }




