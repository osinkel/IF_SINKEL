package models.rickandmorty;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class Episode {
    private int id;
    private String name;
    private String air_date;
    private String episode;
    private ArrayList<String> characters;
    private String url;
    private Date created;
}
