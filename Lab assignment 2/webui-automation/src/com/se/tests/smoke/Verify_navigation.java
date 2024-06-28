package com.se.tests.smoke;

import com.se.rolesbase.StudentLoginBase;
import com.se.utils.UtilsSet;
import com.se.config.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Verify_navigation extends StudentLoginBase {

    @Test
    public void verifyStudentIsLoggedIn() {
        System.out.println("A Student is now logged in");
    }

    @Test
    public void verifyWelcomeToTrainStudent() {
        // Add implementation for verifying welcome message if needed
    }

    @Test
    public void TC_SA_007_VerifyExamSummaryNavigation() {
        // Step 1: Navigate to the Dashboard
        UtilsSet.clickOnElement(Constants.Dashboard.BY_ThreeDots);

        // Step 2: Click on the Exams button
        UtilsSet.clickOnElement(Constants.Dashboard.BY_ExamsButton);

        // Step 3: Click on the first quiz and get its title
        UtilsSet.clickOnElement(Constants.Dashboard.BY_Quiz1);
        String examTitle1 = UtilsSet.getElementText(Constants.Exams.BY_QuizTitle);

        UtilsSet.clickOnElement(Constants.Dashboard.BY_Quiz2);
        // Step 4: Wait for 5 seconds before clicking on the second quiz
        try {
            Thread.sleep(5000); // Sleep for 5 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Step 5: Click on the second quiz and get its title

        String examTitle2 = UtilsSet.getElementText(Constants.Exams.BY_QuizTitle);

        // Verify that the two titles are different
        Assert.assertNotEquals(examTitle1, examTitle2, "The titles of the two exams are the same. The test should fail if they are the same.");
    }
}
