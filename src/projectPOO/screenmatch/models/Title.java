package projectPOO.screenmatch.models;

import projectPOO.screenmatch.Interfaces.Classifcation;
import projectPOO.screenmatch.enums.Popularity;

import java.util.ArrayList;
import java.util.List;

public class Title implements Classifcation {
    private List<Employee> employees;
    private String genres;
    private final String name;
    private final Integer yearOfRelease;
    private String sinopse;
    private Double review;
    private Double reviewSum;
    private Integer totalReviews;
    private Popularity popularity;

    public Title(String name, String sinopse, Integer yearOfRelease, String genres) {
        employees = new ArrayList<Employee>();
        this.genres = genres;
        this.review = 0.0;
        this.totalReviews = 0;
        this.reviewSum = 0.0;
        this.name = name;
        this.sinopse = sinopse;
        this.yearOfRelease = yearOfRelease;
        this.popularity = this.getPopularity();
    }

    public Title(TitleOmdb titleOmdb){
        employees = new ArrayList<Employee>();
        this.name = titleOmdb.title();
        this.sinopse = titleOmdb.plot();
        this.genres = titleOmdb.genre();
        if(titleOmdb.year().contains("–")){
            this.yearOfRelease = Integer.parseInt(titleOmdb.year().substring(0,titleOmdb.year().indexOf("–")));
        } else {
            this.yearOfRelease = Integer.parseInt(titleOmdb.year().replaceAll("([^0-9]+)",""));
        }
        if(titleOmdb.imdbRating().equals("N/A")){
            this.review = 0.0;
        } else {
            this.review = Double.parseDouble(titleOmdb.imdbRating());
        }
        if(titleOmdb.imdbVotes().contains(",")){
            this.totalReviews = Integer.parseInt(titleOmdb.imdbVotes().substring(0,titleOmdb.imdbVotes().indexOf(",")));
        } else if(titleOmdb.imdbVotes().equals("N/A")){
            this.totalReviews = null;
        } else {
            this.totalReviews = Integer.parseInt(titleOmdb.imdbVotes());
        }
    }

    public String getGenres() {
        return genres;
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

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String addEmployee(Employee employee){
        if(employee != null){
            for(Employee employee1 : employees){
                if (employee1.getName().equals(employee.getName()) && employee1.getEmployeePosition() == employee.getEmployeePosition()) {
                    return "Employee already exists";
                }
            }
            employees.add(employee);
            return "Employee has been added";
        } else {
            return "Employee is null";
        }
    }

    public String removeEmployee(Employee employee){
        for (Employee employee1 : employees){
            if (employee1.getName().equals(employee.getName()) && employee1.getEmployeePosition() == employee.getEmployeePosition()){
                employees.remove(employee1);
                return "employee has been removed";
            }
        }
        return "employee do not exists in the list";
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
                        "Genre(s): " + this.getGenres() + "\n" +
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
