package com.wildcodeschool.wildandwizard.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wildcodeschool.wildandwizard.entity.Course;
import com.wildcodeschool.wildandwizard.entity.Wizard;
import com.wildcodeschool.wildandwizard.repository.CourseRepository;

@Controller
public class CourseController {

	@Autowired
	private CourseRepository courseRepository;
	
	// route to a course by id 
	@GetMapping("/course")
	public String getParticipants(Model out, @RequestParam Long idCourse) {
		
		Optional<Course> optionalCourse = courseRepository.findById(idCourse);
		Course course = new Course();
		if (optionalCourse.isPresent()) {
			course = optionalCourse.get();
		}
		// add course to the model
		out.addAttribute("course", course);
		
        // call the method getWizards in Course
		List<Wizard> wizards = course.getWizards();

//		method call via reflection removed
//        List<Wizard> wizards = new ArrayList<>();
//        Method method = getMethod(course, "getWizards",
//                new Class[]{});
//        if (method != null) {
//            try {
//                wizards = (List<Wizard>) method.invoke(course);
//            } catch (IllegalAccessException | InvocationTargetException e) {
//                e.printStackTrace();
//            }
//        }
      
        // add the participating wizards to the model
        out.addAttribute("courseWizards", wizards);
		
		return "course";
		


		
	}
	
//    public Method getMethod(Object obj, String methodName, Class[] args) {
//        Method method;
//        try {
//            method = obj.getClass().getDeclaredMethod(methodName, args);
//            return method;
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
