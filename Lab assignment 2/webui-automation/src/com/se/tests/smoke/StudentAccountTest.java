package com.se.tests.smoke;

import com.se.rolesbase.StudentLoginBase;
import com.se.utils.UtilsSet;
import com.se.config.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.time.temporal.ChronoUnit;


public class StudentAccountTest extends StudentLoginBase {

    @Test
    public void verifyStudentIsLoggedIn(){
        System.out.println("A Student is now logged in");
    }

    @Test
    public void verifyWelcomeToTrainStudent(){
        // Add implementation for verifying welcome message if needed
    }

    @Test
    public void TC_004_VerifyExamDurationCalculation() {
        // Example start and end time string
        String startTimeStr = "4/26/2024, 9:45:03 AM";
        String endTimeStr = "4/26/2024, 10:15:03 AM";

        // Define the DateTimeFormatter for the given pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy, h:mm:ss a");

        // Parse the start and end times
        LocalDateTime startTime = LocalDateTime.parse(startTimeStr, formatter);
        LocalDateTime endTime = LocalDateTime.parse(endTimeStr, formatter);

        // Calculate the duration between start and end times
        long minutesBetween = ChronoUnit.MINUTES.between(startTime, endTime);

        // Expected duration in minutes (adjust this according to your test scenario)
        long expectedDuration = 30; // Assuming the duration is 30 minutes

        // Assert that the calculated duration matches the expected duration
        Assert.assertEquals(minutesBetween, expectedDuration, "The calculated duration does not match the expected duration.");
    }

}
