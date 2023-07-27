package com.example.bai1.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

public class DtoUser implements Validator {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    @Min(value = 18,message ="> 18 ok?" )
    private Integer age;
    @Email()
    private String email;

    public DtoUser() {
    }

    public DtoUser(String firstName, String lastName, String phoneNumber, Integer age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
    DtoUser dtoUser = (DtoUser) target;
    if (dtoUser.getFirstName().equals("")){
        errors.rejectValue("firstName",null,"not empty");
    } else if (!dtoUser.getFirstName().matches("^[a-zA-z]{3,45}")) {
        errors.rejectValue("firstName",null,"not Match regex");
    }


    if (dtoUser.getLastName().equals("")){
        errors.rejectValue("lastName",null,"not empty");
    } else if (!dtoUser.getLastName().matches("^[a-zA-z]{3,45}")) {
        errors.rejectValue("lastName",null,"not Match regex");
    }

    if (dtoUser.getPhoneNumber().equals("")){
        errors.rejectValue("phoneNumber",null,"not empty");
    }  else if (!dtoUser.getPhoneNumber().matches("^(84|0[3|5|7|8|9])+([0-9]{8})")) {
        errors.rejectValue("phoneNumber",null,"not Match regex");
    }
//        if (dtoUser.getPhoneNumber().equals("")){
//            errors.rejectValue("email",null,"not empty");
//        }  else if (!dtoUser.getPhoneNumber().matches("^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6})*$")) {
//            errors.rejectValue("email",null,"not Match regex");
//        }

    }
}
