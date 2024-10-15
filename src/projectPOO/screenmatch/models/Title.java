package projectPOO.screenmatch.models;

import projectPOO.screenmatch.models.Interfaces.Classifcation;
import projectPOO.screenmatch.models.enums.Popularity;

public class Title implements Classifcation {
    private final String name;
    private final Integer yearOfRelease;
    private String sinopse;
    private Boolean included;
    private Double review;
    private Double reviewSum;
    private Integer totalReviews;
    private Popularity popularity;

    public Title(String name, String sinopse, Boolean included, Integer yearOfRelease) {
        this.review = 0.0;
        this.totalReviews = 0;
        this.reviewSum = 0.0;
        this.name = name;
        this.sinopse = sinopse;
        this.included = included;
        this.yearOfRelease = yearOfRelease;
        this.popularity = this.getPopularity();
    }

    public Boolean getIncluded() {
        return included;
    }

    public String getName() {
        return name;
    }

    public Double getReview() {
        return review;
    }

    public String getSinopse() {
        return sinopse;
    }

    public Integer getTotalReviews() {
        return totalReviews;
    }

    public Integer getYearOfRelease() {
        return yearOfRelease;
    }

    public void setIncluded(Boolean included) {
        this.included = included;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public void rate(double rating){
        totalReviews++;
        reviewSum += rating;
        review = reviewSum/totalReviews;
    }

    public Popularity getPopularity(){
        RecommendedFilter rf = new RecommendedFilter();
        return rf.filter(this);
    }

    public String showTechnicalSheet(){
        return  "Name: " + this.getName() + "\n" +
                        "Year of release: " + this.getYearOfRelease() + "\n" +
                        "Review: " + this.getReview() + "\n" +
                        "Total of Reviews: " + this.getTotalReviews() + "\n" +
                        "Popularity: " + this.getPopularity() + "\n" +
                        "Sinopse: \n" + this.getSinopse() + "\n";
    }

    @Override
    public int getClassification() {
        double review = this.getReview();
        return (int)(review/2);
    }
}
