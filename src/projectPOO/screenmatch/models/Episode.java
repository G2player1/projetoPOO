package projectPOO.screenmatch.models;

public class Episode {
    private String title;
    private Integer seasonOfEpisode;
    private Integer episodeNumber;
    private Integer duration;
    private Serie serie;
    private Season season;

    public Episode(Integer duration, String title, Integer seasonOfEpisode, Integer episodeNumber, Serie serie, Season season) {
        this.duration = duration;
        this.title = title;
        this.seasonOfEpisode = seasonOfEpisode;
        this.episodeNumber = episodeNumber;
        this.serie = serie;
        this.season = season;
    }

    public Integer getDuration() {
        return duration;
    }

    public Integer getEpisodeNumber() {
        return episodeNumber;
    }

    public Integer getSeasonOfEpisode() {
        return seasonOfEpisode;
    }

    public String getTitle() {
        return title;
    }

    public Season getSeason() {
        return season;
    }

    public Serie getSerie() {
        return serie;
    }
}
