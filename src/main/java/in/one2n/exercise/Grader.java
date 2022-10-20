package in.one2n.exercise;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Grader {
	    public List<Student> parseCSV(String filepath) {
	    	//Supplier Function
	        Supplier<Stream<String>> supplier = () -> {
	            try {
	                return Files.lines(Paths.get(filepath));
	            } catch (IOException e) {
	                e.printStackTrace();
	                return null;
	            }
	        };
	        
	        
	        //CSV 
	        List<Student> students = new ArrayList<Student>((int) supplier.get().count());
	        supplier.get().skip(1).forEach((s -> {
	            String[] data = s.split(",");
	            Student student = new Student(data[0], data[1], data[2],
	                    Double.parseDouble(data[3]),
	                    Double.parseDouble(data[4]),
	                    Double.parseDouble(data[5]),
	                    Double.parseDouble(data[6]));
	           students.add(student);
	        }));
	        return students;
	    }

	    public List<Student> calculateGrade(List<Student> students) {
	        students.forEach(Student::calculateGrades);
	        return students;
	    }

	    public Student findOverallTopper(List<Student> gradedStudents) {
	        Student topper = gradedStudents.stream()
	                .max(Comparator.comparing(Student::getFinalScore))
	                .get();
	        return new Student(topper.getFirstname(), topper.getLastname(), topper.getUniversity());
	    }


	    public Map<String, Student> findTopperPerUniversity(List<Student> gradedStudents) {
	        Map<String, Student> toppers = new HashMap<>();
	        gradedStudents.stream()
	                .collect(Collectors.groupingBy(Student::getUniversity))
	                .forEach((k, v) -> {
	                    toppers.put(k, findOverallTopper(v));
	                });
	        return toppers;
	    }
}
