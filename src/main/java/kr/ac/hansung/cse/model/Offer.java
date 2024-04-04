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

    private String subject_code;

    private String subject_name;

    private String subject_classification;

    private String professor;

    private int grades;
}
