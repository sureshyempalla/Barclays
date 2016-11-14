package com.example.sureshreddy.barclays.common;

import java.util.HashMap;


public class EntityHelper {
    private static EntityHelper ourInstance = new EntityHelper();

    private HashMap<String, String> entityMap;

    public static EntityHelper getInstance() {
        return ourInstance;
    }

    private EntityHelper() {
        entityMap = new HashMap<>();
        entityMap.put("Movie", "movie");
        entityMap.put("Podcast", "podcast");
        entityMap.put("Music", "music");
        entityMap.put("Music Video", "musicVideo");
        entityMap.put("Audio Book", "audiobook");
        entityMap.put("Short Film", "shortFilm");
        entityMap.put("TV Show", "tvShow");
        entityMap.put("Software", "software");
        entityMap.put("eBook", "ebook");
        entityMap.put("All", "all");
    }

    public String getEntity(String key){
        return entityMap.get(key);
    }

}
