//package com.se.tests.smoke;
//
//import com.se.TestBase;
//import com.se.utils.UtilsSet;
//import com.se.config.Constants;
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class VerifyExamFunctionalityTest extends TestBase {
//
//    @BeforeMethod
//    public void checkTestStatus() {
//        System.out.println("Ensure internet is working for remote testing ...");
//    }
//
//    @Test
//    public void TC_SA_001_VerifyExamDetailsDisplay() {
//        // Preconditions: User is logged in and on the Exams page
//        UtilsSet.goToUrl("https://demo.subexpert.com/exams");
//
//        // Step 1: Verify the display of exam details: title, duration, examiner, course, start time
//        String actualTitle = UtilsSet.getElementText(Constants.Exams.BY_ExamTitle);
//        String actualDuration = UtilsSet.getElementText(Constants.Exams.BY_ExamDuration);
//        String actualExaminer = UtilsSet.getElementText(Constants.Exams.BY_Examiner);
//        String actualCourse = UtilsSet.getElementText(Constants.Exams.BY_Course);
//        String actualStartTime = UtilsSet.getElementText(Constants.Exams.BY_StartTime);
//
//        Assert.assertEquals(actualTitle, "Expected Exam Title");
//        Assert.assertEquals(actualDuration, "Expected Duration");
//        Assert.assertEquals(actualExaminer, "Expected Examiner");
//        Assert.assertEquals(actualCourse, "Expected Course");
//        Assert.assertEquals(actualStartTime, "Expected Start Time");
//    }
//
//    @Test
//    public void TC_SA_002_VerifyExamSchedule() {
//        // Preconditions: User is logged in and on the Exam Summary page
//        UtilsSet.goToUrl("https://demo.subexpert.com/exam-summary");
//
//        // Step 1: Verify the display of start time, end time, and duration
//        String actualStartTime = UtilsSet.getElementText(Constants.ExamSummary.BY_StartTime);
//        String actualEndTime = UtilsSet.getElementText(Constants.ExamSummary.BY_EndTime);
//        String actualDuration = UtilsSet.getElementText(Constants.ExamSummary.BY_Duration);
//
//        Assert.assertEquals(actualStartTime, "Expected Start Time");
//        Assert.assertEquals(actualEndTime, "Expected End Time");
//        Assert.assertEquals(actualDuration, "Expected Duration");
//    }
//
//    @Test
//    public void TC_SA_003_VerifyQuestionTypesAndMarksDistribution() {
//        // Preconditions: User is logged in and on the Exam Summary page
//        UtilsSet.goToUrl("https://demo.subexpert.com/exam-summary");
//
//        // Step 1: Verify the display of number of MCQs, true/false questions, marks per question, total marks
//        String actualMCQs = UtilsSet.getElementText(Constants.ExamSummary.BY_MCQs);
//        String actualTrueFalse = UtilsSet.getElementText(Constants.ExamSummary.BY_TrueFalseQuestions);
//        String actualMarksPerQuestion = UtilsSet.getElementText(Constants.ExamSummary.BY_MarksPerQuestion);
//        String actualTotalMarks = UtilsSet.getElementText(Constants.ExamSummary.BY_TotalMarks);
//
//        Assert.assertEquals(actualMCQs, "Expected Number of MCQs");
//        Assert.assertEquals(actualTrueFalse, "Expected Number of True/False Questions");
//        Assert.assertEquals(actualMarksPerQuestion, "Expected Marks Per Question");
//        Assert.assertEquals(actualTotalMarks, "Expected Total Marks");
//    }
//
//    @Test
//    public void TC_SA_004_VerifyExamSettings() {
//        // Preconditions: User is logged in and on the Exam Summary page
//        UtilsSet.goToUrl("https://demo.subexpert.com/exam-summary");
//
//        // Step 1: Verify the display of negative marks setting, question time-bound, exam time-bound, skip questions, results visibility
//        String actualNegativeMarks = UtilsSet.getElementText(Constants.ExamSummary.BY_NegativeMarks);
//        String actualQuestionTimeBound = UtilsSet.getElementText(Constants.ExamSummary.BY_QuestionTimeBound);
//        String actualExamTimeBound = UtilsSet.getElementText(Constants.ExamSummary.BY_ExamTimeBound);
//        String actualSkipQuestions = UtilsSet.getElementText(Constants.ExamSummary.BY_SkipQuestions);
//        String actualResultsVisibility = UtilsSet.getElementText(Constants.ExamSummary.BY_ResultsVisibility);
//
//        Assert.assertEquals(actualNegativeMarks, "Expected Negative Marks Setting");
//        Assert.assertEquals(actualQuestionTimeBound, "Expected Question Time-Bound Setting");
//        Assert.assertEquals(actualExamTimeBound, "Expected Exam Time-Bound Setting");
//        Assert.assertEquals(actualSkipQuestions, "Expected Skip Questions Setting");
//        Assert.assertEquals(actualResultsVisibility, "Expected Results Visibility Setting");
//    }
//
//    @Test
//    public void TC_SA_005_VerifyExamResultsVisibilityToggle() {
//        // Preconditions: User is logged in and on the Exam Summary page
//        UtilsSet.goToUrl("https://demo.subexpert.com/exam-summary");
//
//        // Step 1: Toggle the exam results visibility between public and private
//        UtilsSet.clickOnElement(Constants.ExamSummary.BY_ResultsVisibilityToggle);
//        String actualResultsVisibility = UtilsSet.getElementText(Constants.ExamSummary.BY_ResultsVisibility);
//
//        // Step 2: Assert that the visibility has been toggled correctly
//        Assert.assertEquals(actualResultsVisibility, "Expected Results Visibility Setting After Toggle");
//    }
//
//    @Test
//    public void TC_SA_007_VerifyExamSummaryNavigation() {
//        // Preconditions: User is logged in and on the Exams page
//        UtilsSet.goToUrl("https://demo.subexpert.com/exams");
//
//        // Step 1: Click on the title of an exam
//        UtilsSet.clickOnElement(Constants.Exams.BY_ExamTitle);
//
//        // Step 2: Verify navigation to the Exam Summary page for the selected exam
//        String actualPageTitle = UtilsSet.getPageTitle();
//        Assert.assertEquals(actualPageTitle, "Expected Exam Summary Page Title");
//    }
//
//    @Test
//    public void TC_SA_008_VerifyQuestionNavigationFunctionality() {
//        // Preconditions: User is logged in and on the Exam Summary page
//        UtilsSet.goToUrl("https://demo.subexpert.com/exam-summary");
//
//        // Step 1: Navigate through questions using the navigation panel
//        UtilsSet.clickOnElement(Constants.ExamSummary.BY_QuestionNavigation);
//
//        // Step 2: Verify the correct question text is displayed
//        String actualQuestionText = UtilsSet.getElementText(Constants.ExamSummary.BY_QuestionText);
//        Assert.assertEquals(actualQuestionText, "Expected Question Text");
//    }
//
//    @Test
//    public void TC_SA_009_VerifyAnswerSelectionAndSubmission() {
//        // Preconditions: User is logged in and on the Exam Summary page
//        UtilsSet.goToUrl("https://demo.subexpert.com/exam-summary");
//
//        // Step 1: Select an answer option for a question
//        UtilsSet.selectAnswer(Constants.ExamSummary.BY_AnswerOption);
//
//        // Step 2: Submit the answer and verify the submission confirmation
//        UtilsSet.clickOnElement(Constants.ExamSummary.BY_SubmitButton);
//        String actualSubmissionConfirmation = UtilsSet.getElementText(Constants.ExamSummary.BY_SubmitConfirmation);
//        Assert.assertEquals(actualSubmissionConfirmation, "Expected Submission Confirmation Text");
//    }
//
//    @Test
//    public void TC_SA_010_VerifyTimeLimitFunctionality() {
//        // Preconditions: User is logged in and on the Exam Summary page
//        UtilsSet.goToUrl("https://demo.subexpert.com/exam-summary");
//
//        // Step 1: Verify time limit message is displayed correctly
//        String actualTimeLimitMessage = UtilsSet.getElementText(Constants.ExamSummary.BY_TimeLimitMessage);
//        Assert.assertEquals(actualTimeLimitMessage, "Expected Time Limit Message");
//    }
//
//    @Test
//    public void TC_SA_011_VerifyResultSummary() {
//        // Preconditions: User is logged in and on the Exam Summary page
//        UtilsSet.goToUrl("https://demo.subexpert.com/exam-summary");
//
//        // Step 1: Complete the exam and submit answers
//        UtilsSet.clickOnElement(Constants.ExamSummary.BY_StartExamButton);
//        UtilsSet.selectAnswer(Constants.ExamSummary.BY_AnswerOption);
//        UtilsSet.clickOnElement(Constants.ExamSummary.BY_SubmitButton);
//
//        // Step 2: Verify result summary is generated correctly
//        String actualResultSummary = UtilsSet.getElementText(Constants.ExamSummary.BY_ResultSummary);
//        Assert.assertNotNull(actualResultSummary, "Result summary should not be null");
//        Assert.assertEquals(actualResultSummary, "Expected Result Summary Text");
//}
//}