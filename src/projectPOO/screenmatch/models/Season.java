package projectPOO.screenmatch.models;

import java.util.ArrayList;
import java.util.List;

public class Season {
    private List<Episode> episodes;
    private String title;
    private Integer episodesNumber;
    private Serie serie;

    public Season(Serie serie, String title) {
        episodes = new ArrayList<Episode>();
        this.episodesNumber = this.getEpisodesNumber();
        this.serie = serie;
        this.title = title;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public Integer getEpisodesNumber() {
        return episodes.size();
    }

    public Serie getSerie() {
        return serie;
    }

    public String getTitle() {
        return title;
    }

    public String addEpisode(Episode episode){
        this.episodes.add(episode);

        return "episode has been added";
    }

    public String removeEpisode(Episode episode) {
        this.episodes.remove(episode);
        return "episode has been removed";
    }

    public String showEpisodes(){
        String msg = "";
        for(Episode episode : episodes){
            msg += "Episode: " + episode.getTitle() + "\n";
        }
        return msg;
    }
}
