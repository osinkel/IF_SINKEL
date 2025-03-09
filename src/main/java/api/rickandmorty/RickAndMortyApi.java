package api.rickandmorty;

import api.BaseApi;
import config.ConfigReader;
import constants.EnvConstants;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class RickAndMortyApi extends BaseApi {

    public RickAndMortyApi() {
        super(EnvConstants.RICKANDMORTY_URL);
    }

    private static final String CHARACTER_ENDPOINT = ConfigReader.getProp("rickandmorty.api.endpoints.character");
    private static final String EPISODE_ENDPOINT = ConfigReader.getProp("rickandmorty.api.endpoints.episode");

    public ValidatableResponse getCharacters() {
        return given()
                .when()
                .get(CHARACTER_ENDPOINT)
                .then();
    }

    public ValidatableResponse getEpisodeById(String id) {
        return given()
                .when()
                .get(EPISODE_ENDPOINT + "/" + id)
                .then();
    }

    public ValidatableResponse getCharacterById(String id) {
        return given()
                .when()
                .get(CHARACTER_ENDPOINT + "/" + id)
                .then();
    }

}
