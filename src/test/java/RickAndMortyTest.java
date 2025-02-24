import config.ConfigReader;
import models.rickandmorty.Character;
import models.rickandmorty.Episode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.RickAndMortySteps;

public class RickAndMortyTest {

    RickAndMortySteps rickAndMortySteps = new RickAndMortySteps();

    @Test
    @DisplayName("Проверить не совпадают ли раса или местонахожднеие у искомого героя и последнего героя в последнем " +
            "эпизоде, в котором встретился искомый герой")
    public void checkSpeciesOrLocationAreNotEquals() {
        Character character = rickAndMortySteps.getCharacterByName(ConfigReader.getProp("rickandmorty.character.name"));
        String lastEpisodeUrlOfCharacter = character.getEpisode().get(character.getEpisode().size() - 1);
        Episode lastEpisode = rickAndMortySteps
                .getEpisodeById(lastEpisodeUrlOfCharacter.split("/")[lastEpisodeUrlOfCharacter.split("/").length - 1]);
        String lastCharacterUrlOfEpisode = lastEpisode.getCharacters().get(lastEpisode.getCharacters().size() - 1);
        Character lastCharacterOfEpisode = rickAndMortySteps
                .getCharacterById(lastCharacterUrlOfEpisode.split("/")[lastCharacterUrlOfEpisode.split("/").length - 1]);

        Boolean areNotEqualsSpeciesOrLocation = !lastCharacterOfEpisode.getSpecies().equals(character.getSpecies()) ||
                !lastCharacterOfEpisode.getLocation().equals(character.getLocation());

        Assertions.assertEquals(true, areNotEqualsSpeciesOrLocation);
    }

}
