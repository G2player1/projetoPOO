package projectPOO.screenmatch.models;

public class Movie extends Title{
    private final Integer movieTime;

    public Movie(String name, String sinopse, Integer yearOfRelease, Integer movieTime,String genres) {
        super(name, sinopse, yearOfRelease,genres);
        this.movieTime = movieTime;
    }

    public Integer getMovieTime() {
        return movieTime;
    }

    @Override
    public String showTechnicalSheet(){

        return "Name: " + this.getName() + "\n" +
                        "Year of release: " + this.getYearOfRelease() + "\n" +
                        "Genre(s): " + this.getGenres() + "\n" +
                        "Review: " + this.getReview() + "\n" +
                        "Total of Reviews: " + this.getTotalReviews() + "\n" +
                        "Viewing time: " + this.movieTime + "\n" +
                        "Popularity: " + this.getPopularity() + "\n" +
                        "Sinopse: \n" + this.getSinopse() + "\n";
    }
}
