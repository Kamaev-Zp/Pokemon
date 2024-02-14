import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PokemonTest {

        @Test
        public void testAttack() {

            Pokemon.Pokemon2 attacker = new Pokemon.Pokemon2("Attacker", 100, 200, 50, 60, 70, 20);
            Pokemon.Pokemon2 opponent = new Pokemon.Pokemon2("Opponent", 80, 180, 40, 50, 60, 10);


            int opponentHealthBeforeAttack = opponent.currentHp;


            attacker.attack(opponent);


            int expectedDamage = attacker.attack - opponent.defence;
            if (expectedDamage <= 0) {

                Assertions.assertEquals(opponentHealthBeforeAttack, opponent.currentHp, "Урон должен быть нулевым");
            } else {

                int expectedHealthAfterAttack = opponentHealthBeforeAttack + (int)opponent.additionalHP - expectedDamage;
                Assertions.assertEquals(expectedHealthAfterAttack, opponent.currentHp, "Урон должен быть нанесен корректно");
            }
        }
    }



