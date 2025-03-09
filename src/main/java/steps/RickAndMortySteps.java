package steps;

import api.rickandmorty.RickAndMortyApi;
import config.ConfigReader;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Allure;
import models.rickandmorty.Character;
import models.rickandmorty.Episode;
import org.apache.http.HttpStatus;

import java.util.List;

public class RickAndMortySteps {
    private static final RickAndMortyApi rickAndMortyApi = new RickAndMortyApi();
    private Character character;
    private Episode lastEpisodeOfCharacter;
    private Character lastCharacterOfEpisode;

    public List<Character> getCharacters() {
        return rickAndMortyApi.getCharacters()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .jsonPath()
                .getList(ConfigReader.getProp("rickandmorty.api.jsonpath"), Character.class);
    }

    @Допустим("из сервиса получен герой по имени {string}")
    public void getCharacterByName(String name) {
        character = getCharacters().stream()
                .filter(character -> character.getName().equals(name))
                .findFirst()
                .orElseThrow(NullPointerException::new);
        Allure.addAttachment("Герой с именем " + name, character.toString());
    }

    public Episode getEpisodeById(String id) {
        return rickAndMortyApi.getEpisodeById(id)
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .as(Episode.class);
    }

    public Character getCharacterById(String id) {
        return rickAndMortyApi.getCharacterById(id)
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .as(Character.class);
    }

    @Когда("получить последний эпизод, в котором встретился данный герой")
    public void getLastEpisodeOfCharacter() {
        String lastEpisodeUrlOfCharacter = character.getEpisode().get(character.getEpisode().size() - 1);
        lastEpisodeOfCharacter = getEpisodeById(
                lastEpisodeUrlOfCharacter
                        .split("/")[lastEpisodeUrlOfCharacter.split("/").length - 1]
        );
        Allure.addAttachment("Последний эпизод, в котором встретился герой с именем " +
                character.getName(), lastEpisodeOfCharacter.toString());
    }

    @И("получить последнего героя из списка, появляющихся в данном эпизоде героев")
    public void getLastCharacterOfEpisode() {
        String lastCharacterUrlOfEpisode = lastEpisodeOfCharacter
                .getCharacters()
                .get(lastEpisodeOfCharacter
                        .getCharacters().size() - 1);
        lastCharacterOfEpisode = getCharacterById(
                lastCharacterUrlOfEpisode
                        .split("/")[lastCharacterUrlOfEpisode.split("/").length - 1]
        );
        Allure.addAttachment("Последний герой из списка, появляющихся в эпизоде со ссылкой " +
                lastCharacterUrlOfEpisode, lastCharacterOfEpisode.toString());
    }

    @Тогда("проверить, что раса или местонахожднеие у искомого героя и последнего героя в последнем эпизоде, в котором встретился искомый герой, не совпадают")
    public void checkEqualityOfLocationOrSpecies() {
        boolean areNotEqualsSpeciesOrLocation = !lastCharacterOfEpisode.getSpecies().equals(character.getSpecies()) ||
                !lastCharacterOfEpisode.getLocation().equals(character.getLocation());

        Allure.addAttachment("Искомый герой", character.toString());
        Allure.addAttachment("Последний герой в последнем эпизоде, в котором встретился искомый герой", lastCharacterOfEpisode.toString());

        if (!areNotEqualsSpeciesOrLocation) {
            throw new AssertionError(
                    "раса или местонахожднеие у искомого героя и последнего героя " +
                            "в последнем эпизоде, в котором встретился искомый герой, не совпадают.\n" +
                            "Искомый герой\n" +
                            "Раса: " + character.getSpecies() + "\nМестонахождения: " + character.getLocation() +
                            "\n*****************\n" +
                            "Последний герой\n" +
                            "Раса: " + lastCharacterOfEpisode.getSpecies() + "\n" +
                            "Местонахождения: " + lastCharacterOfEpisode.getLocation());
        }
    }
}
