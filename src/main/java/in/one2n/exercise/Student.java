package in.one2n.exercise;



import java.util.Objects;

public class Student {

	 private String firstname;
	    private String lastname;
	    private String university;
	    private Double test1Score;
	    private Double test2Score;
	    private Double test3Score;
	    private Double test4Score;

	   
	    private Double finalScore;
	    private Grade grade;

	    public Student(String firstname, String lastname, String university) {
	        this.firstname = firstname;
	        this.lastname = lastname;
	        this.university = university;
	    }

	    public Student(String firstname, String lastname, String university, Double test1Score, Double test2Score, Double test3Score, Double test4Score) {
	       this.firstname = firstname;
	       this.lastname = lastname;
	       this.university = university;
	       this.test1Score = test1Score;
	       this.test2Score =  test2Score;
	       this.test3Score = test3Score;
	       this.test4Score = test4Score;
	    }

	    public String getFirstname() {
	        return firstname;
	    }

	    public String getLastname() {
	        return lastname;
	    }

	    public String getUniversity() {
	        return university;
	    }

	    public Double getFinalScore() {
	        return finalScore;
	    }

	    public Grade getGrade() {
	        return grade;
	    }

	    public void calculateGrades(){
	        calculateFinalScore();
	        if(finalScore < 35)
	            grade = Grade.F;
	        else if(finalScore >= 35 && finalScore < 50)
	            grade = Grade.C;
	        else if(finalScore >= 50 && finalScore < 70)
	            grade = Grade.B;
	        else
	            grade = Grade.A;
	    }

	    public void calculateFinalScore(){
	        finalScore = ((test1Score+test2Score+test3Score+test4Score))/ 4;
	    }

	    
	    

	    @Override
	    public int hashCode() {
	        return Objects.hash(firstname, lastname, university);
	    }
	    
	    
	    
	    
	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Student student = (Student) o;
	        return firstname.equals(student.firstname) && lastname.equals(student.lastname) && university.equals(student.university);
	    }

}

