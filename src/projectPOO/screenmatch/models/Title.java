package projectPOO.screenmatch.models;

import projectPOO.screenmatch.Interfaces.Classifcation;
import projectPOO.screenmatch.enums.EmployeePosition;
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
        this.yearOfRelease = initYear(titleOmdb.year());
        this.review = initRating(titleOmdb.imdbRating());
        this.totalReviews = initVotes(titleOmdb.imdbVotes());
        this.initEmployeeOmdb(titleOmdb.director(),EmployeePosition.DIRECTOR);
        this.initEmployeeOmdb(titleOmdb.writer(),EmployeePosition.WRITER);
        this.initEmployeeOmdb(titleOmdb.actors(),EmployeePosition.ACTOR);
    }

    private int initVotes(String votes){
        if(votes.contains(",")){
            int n = 0;
            String[] votesList = votes.split(",");
            for (String vote : votesList){
                n += Integer.parseInt(vote);
            }
            return n;
        } else if(votes.equals("N/A")){
            return  0;
        } else {
            return Integer.parseInt(votes);
        }
    }

    private double initRating(String rating){
        if(rating.equals("N/A")){
            return 0.0;
        } else {
            return Double.parseDouble(rating);
        }
    }

    private int initYear(String year){
        if(year.contains("–")){
            return Integer.parseInt(year.substring(0,year.indexOf("–")));
        } else {
            return Integer.parseInt(year.replaceAll("([^0-9]+)",""));
        }
    }

    private void initEmployeeOmdb(String employees,EmployeePosition employeePosition){
        if (employees.contains(",")){
            String[] employeesList = employees.split(", ");
            for(String employee : employeesList){
                Employee emp = new Employee(employeePosition, employee);
                this.employees.add(emp);
            }
        } else {
            Employee employee = new Employee(employeePosition, employees);
            this.employees.add(employee);
        }
    }

    public String printEmployees(){
        String msg = "",
                directors = "Director(s): \n",
                writers = "Writer(s): \n",
                actors = "Actor(s): \n";
        for(Employee employee: employees){
            if(employee.getEmployeePosition() == EmployeePosition.DIRECTOR){
                directors += employee.getName() + "\n";
            }
            if(employee.getEmployeePosition() == EmployeePosition.WRITER){
                writers += employee.getName() + "\n";
            }
            if(employee.getEmployeePosition() == EmployeePosition.ACTOR){
                actors += employee.getName() + "\n";
            }
        }
        msg += directors;
        msg += writers;
        msg += actors;
        return msg;
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
                        "Sinopse: \n" + this.getSinopse() + "\n" +
                        this.printEmployees();
    }

    @Override
    public String toString() {
        return  "Name: " + this.getName() + "\n" +
                "Genre(s): " + this.getGenres() + "\n" +
                "Year of release: " + this.getYearOfRelease() + "\n" +
                "Review: " + this.getReview() + "\n" +
                "Total of Reviews: " + this.getTotalReviews() + "\n" +
                "Popularity: " + this.getPopularity() + "\n" +
                "Sinopse: \n" + this.getSinopse() + "\n" +
                this.printEmployees();
    }

    @Override
    public int getClassification() {
        double review = this.getReview();
        return (int)(review/2);
    }
}
