package com.wildcodeschool.wildandwizard.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    // now let's implement the two-way relationship from Course to Wizard:
    @ManyToMany(mappedBy = "courses")
    private List<Wizard> wizards = new ArrayList<Wizard>();

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    /**
	 * @return the wizards
	 */
	public List<Wizard> getWizards() {
		return wizards;
	}

	/**
	 * Not necessary for this example, since the list of relations is only read from database
	 * @param wizards the wizards to set
	 */
//	public void setWizards(List<Wizard> wizards) {
//		this.wizards = wizards;
//	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
