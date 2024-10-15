package projectPOO.screenmatch.models;

public class Episode {
    private String title;
    private Integer episodeNumber;
    private Integer duration;

    public Episode(Integer duration, String title, Integer episodeNumber) {
        this.duration = duration;
        this.title = title;
        this.episodeNumber = episodeNumber;
    }

    public Integer getDuration() {
        return duration;
    }

    public Integer getEpisodeNumber() {
        return episodeNumber;
    }

    public String getTitle() {
        return title;
    }

}
