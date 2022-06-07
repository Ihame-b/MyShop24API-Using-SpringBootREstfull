package Student;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    private StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    //display
    @GetMapping("/")
    List<Student> all(){
     // return new Student("ihame", "gilbert", 23, "male", "student");
   return repository.findAll();
   }


   //find by id
    @GetMapping("/sstudent/{id}")
    Student getbyId(@PathVariable Long id){
        return repository.findById(id)
        .orElseThrow(() -> new StudentNotFoundException(id));
    }

    //save
    @PostMapping("/addstudent")
    Student save(@RequestBody Student newStudent){
        return repository.save(newStudent);
    }

    //update
    @PutMapping("/student/{id}")
   Optional<Student> update(@PathVariable Long id, @RequestBody Student newStudent){
      return   repository.findById(id).map(student -> {
            student.setAge(newStudent.getAge());
            student.setCategory(newStudent.getCategory());
            student.setFirstname(newStudent.getFirstname());
            student.setLastname(newStudent.getLastname());
            student.setGender(newStudent.getGender());
            return student;
        });
    }



    //delete
    @DeleteMapping("/delstudent/{id}")
    void delete(@PathVariable Long id){
        repository.deleteById(id);
    }

}
