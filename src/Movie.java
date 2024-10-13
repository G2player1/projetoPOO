public class Movie {
    private String name;
    private Integer yearOfRelease;
    private Boolean included;
    private Double review;
    private Double reviewSum;
    private Integer totalReviews;
    private Integer movieTime;

    public Movie(String name,Integer yearOfRelease,Boolean included,Integer movieTime) {
        this.review = 0.0;
        this.reviewSum = 0.0;
        this.totalReviews = 0;
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.included = included;
        this.movieTime = movieTime;
    }

    public void showTechnicalSheet(){
        String technicalSheet = """
                Name: %s
                Year of release: %d
                Review: %.1f
                Total of Reviews: %d
                Viewing Time: %d \n
                """;
        System.out.printf(technicalSheet,name,yearOfRelease,review,totalReviews,movieTime);
    }

    public void rateMovie(double rating){
        totalReviews++;
        reviewSum += rating;
        review = reviewSum/totalReviews;
    }
}
