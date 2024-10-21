package projectPOO.screenmatch.models;

import com.google.gson.annotations.SerializedName;

public record TitleOmdb(String title, String year, String plot,
                        String rated, String released, String genre,
                        String director, String writer, String actors,
                        String language, String country, @SerializedName("imdbRating") String imdbRating,
                        @SerializedName("imdbVotes") String imdbVotes,
                        String type, @SerializedName("totalSeasons") String totalSeasons) {
}
