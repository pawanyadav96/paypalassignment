package com.paypal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class task {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	    
	    @NotNull
	    private String title;
	    
	    @NotNull
	    private String description;
	    
	    @NotNull
        private String type; // bug, feature, story
	    
	    @NotNull
	    private String status; 
	    
	   
	    @JsonIgnore
	    @ManyToOne(fetch = FetchType.LAZY)
	    private sprint sprint;
	    
	    @JsonIgnore
	    @ManyToOne
	    private user user;
	    

}
