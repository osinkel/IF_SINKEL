package steps;

import api.rickandmorty.RickAndMortyApi;
import config.ConfigReader;
import models.rickandmorty.Character;
import models.rickandmorty.Episode;
import org.apache.http.HttpStatus;

import java.util.List;

public class RickAndMortySteps {
    private static final RickAndMortyApi rickAndMortyApi = new RickAndMortyApi();

    public List<Character> getCharacters() {
        return rickAndMortyApi.getCharacters()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .jsonPath()
                .getList(ConfigReader.getProp("rickandmorty.api.jsonpath"), Character.class);
    }

    public Character getCharacterByName(String name) {
        return getCharacters().stream()
                .filter(character -> character.getName().equals(name))
                .findFirst()
                .orElseThrow(NullPointerException::new);
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

}
