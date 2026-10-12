package com.example.ashiquir.Entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassReshedulingRequest {

    @Id
    private String id;

    @NotBlank(message = "Course Code is required")
    private String courseCode;

    @Size(min = 3, message = "Teacher name must be at least 3 characters")
    private String teacherName;
    
    private String reasonType;
    private String rescheduleDetails;

}
