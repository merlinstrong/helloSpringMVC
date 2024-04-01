package kr.ac.hansung.cse.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class Offer {
    private int year;

    private int semester;

    @Size(min=2, max=100, message = "subject_code must be between 2 and 100 chars")
    private String subject_code;

    @Email(message="Please provide a valid Subject_name address")
    private String subject_name;

    @Size(min=5, max=100, message="Subject_classification must be between 5 and 100 chars")
    private String subject_classification;

    private String professor;

    private int grades;
}
