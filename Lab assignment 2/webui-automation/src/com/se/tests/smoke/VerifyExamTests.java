//package com.se.tests.smoke;
//
//import com.se.TestBase;
//import com.se.config.Constants;
//import com.se.utils.UtilsSet;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class VerifyExamTests extends TestBase {
//
//
//    private WebDriver driver;
//
//    @BeforeMethod
//    public void setUp() {
//        driver = getDriver(); // Assumes getDriver() initializes the WebDriver instance
//        login();
//    }
//
//
//    @Test
//    public void verifyExamDetailsDisplay() {
//        navigateToExamsPage();
//
//        WebElement examTitle = findElement(By.id("examTitle"));
//        WebElement examDuration = findElement(By.id("examDuration"));
//        WebElement examiner = findElement(By.id("examiner"));
//        WebElement course = findElement(By.id("course"));
//        WebElement startTime = findElement(By.id("startTime"));
//
//        Assert.assertTrue(examTitle.isDisplayed(), "Exam title is not displayed");
//        Assert.assertTrue(examDuration.isDisplayed(), "Exam duration is not displayed");
//        Assert.assertTrue(examiner.isDisplayed(), "Examiner is not displayed");
//        Assert.assertTrue(course.isDisplayed(), "Course is not displayed");
//        Assert.assertTrue(startTime.isDisplayed(), "Start time is not displayed");
//    }
//
//    @Test
//    public void verifyExamSchedule() {
//        navigateToExamSummaryPage();
//
//        WebElement startTime = findElement(By.id("startTime"));
//        WebElement endTime = findElement(By.id("endTime"));
//        WebElement duration = findElement(By.id("duration"));
//
//        Assert.assertTrue(startTime.isDisplayed(), "Start time is not displayed");
//        Assert.assertTrue(endTime.isDisplayed(), "End time is not displayed");
//        Assert.assertTrue(duration.isDisplayed(), "Duration is not displayed");
//    }
//
//    @Test
//    public void verifyQuestionTypesAndMarksDistribution() {
//        navigateToExamSummaryPage();
//
//        WebElement numMCQs = findElement(By.id("numMCQs"));
//        WebElement numTrueFalse = findElement(By.id("numTrueFalse"));
//        WebElement marksPerQuestion = findElement(By.id("marksPerQuestion"));
//        WebElement totalMarks = findElement(By.id("totalMarks"));
//
//        Assert.assertTrue(numMCQs.isDisplayed(), "Number of MCQs is not displayed");
//        Assert.assertTrue(numTrueFalse.isDisplayed(), "Number of True/False questions is not displayed");
//        Assert.assertTrue(marksPerQuestion.isDisplayed(), "Marks per question is not displayed");
//        Assert.assertTrue(totalMarks.isDisplayed(), "Total marks are not displayed");
//    }
//
//    @Test
//    public void verifyExamSettings() {
//        navigateToExamSummaryPage();
//
//        WebElement negativeMarksSetting = findElement(By.id("negativeMarksSetting"));
//        WebElement questionTimeBound = findElement(By.id("questionTimeBound"));
//        WebElement examTimeBound = findElement(By.id("examTimeBound"));
//        WebElement skipQuestions = findElement(By.id("skipQuestions"));
//        WebElement resultsVisibility = findElement(By.id("resultsVisibility"));
//
//        Assert.assertTrue(negativeMarksSetting.isDisplayed(), "Negative marks setting is not displayed");
//        Assert.assertTrue(questionTimeBound.isDisplayed(), "Question time-bound setting is not displayed");
//        Assert.assertTrue(examTimeBound.isDisplayed(), "Exam time-bound setting is not displayed");
//        Assert.assertTrue(skipQuestions.isDisplayed(), "Skip questions setting is not displayed");
//        Assert.assertTrue(resultsVisibility.isDisplayed(), "Results visibility setting is not displayed");
//    }
//
//    @Test
//    public void verifyExamResultsVisibilityToggle() {
//        navigateToExamSummaryPage();
//
//        WebElement resultsVisibility = findElement(By.id("resultsVisibility"));
//        resultsVisibility.click();
//        Assert.assertTrue(resultsVisibility.isSelected(), "Results visibility toggle to public failed");
//
//        resultsVisibility.click();
//        Assert.assertFalse(resultsVisibility.isSelected(), "Results visibility toggle to private failed");
//    }
//
//    @Test
//    public void verifyExamSummaryNavigation() {
//        navigateToExamsPage();
//
//        WebElement examTitle = findElement(By.xpath("//exam-title"));
//        examTitle.click();
//
//        WebElement examSummaryPage = findElement(By.id("examSummaryPage"));
//        Assert.assertTrue(examSummaryPage.isDisplayed(), "Navigation to Exam Summary page failed");
//    }
//
//    @Test
//    public void verifyQuestionNavigationFunctionality() {
//        navigateToExamSummaryPage();
//        startExam();
//
//        WebElement navigationPanel = findElement(By.id("navigationPanel"));
//        WebElement question = navigationPanel.findElement(By.id("question1"));
//        question.click();
//
//        WebElement answerBox = findElement(By.id("answerBox"));
//        answerBox.sendKeys("Test Answer");
//
//        WebElement nextQuestion = findElement(By.id("nextQuestion"));
//        nextQuestion.click();
//
//        Assert.assertTrue(answerBox.isDisplayed(), "Navigation between questions failed");
//    }
//
//    @Test
//    public void verifyAnswerSubmission() {
//        navigateToExamSummaryPage();
//        startExam();
//
//        WebElement answerBox = findElement(By.id("answerBox"));
//        answerBox.sendKeys("Test Answer");
//
//        WebElement submitButton = findElement(By.id("submitButton"));
//        submitButton.click();
//
//        WebElement completionMessage = findElement(By.id("completionMessage"));
//        Assert.assertTrue(completionMessage.isDisplayed(), "Answer submission failed");
//    }
//
//    @Test
//    public void verifyTimeBoundFunctionality() {
//        navigateToExamSummaryPage();
//        startExam();
//
//        waitForTimeLimit();
//
//        WebElement answerBox = findElement(By.id("answerBox"));
//        answerBox.sendKeys("Test Answer");
//
//        WebElement submitButton = findElement(By.id("submitButton"));
//        submitButton.click();
//
//        WebElement timeLimitMessage = findElement(By.id("timeLimitMessage"));
//        Assert.assertTrue(timeLimitMessage.isDisplayed(), "Time limit enforcement failed");
//    }
//
//    @Test
//    public void verifyNegativeMarkingForIncorrectAnswers() {
//        navigateToExamSummaryPage();
//        startExamWithNegativeMarking();
//
//        WebElement incorrectAnswer = findElement(By.id("incorrectAnswer"));
//        incorrectAnswer.click();
//
//        WebElement marksDeducted = findElement(By.id("marksDeducted"));
//        Assert.assertTrue(marksDeducted.isDisplayed(), "Negative marking for incorrect answers failed");
//    }
//
//    @Test
//    public void verifyExamReviewFunctionality() {
//        completeExam();
//        navigateToCompletedExamsSection();
//
//        WebElement completedExam = findElement(By.id("completedExam"));
//        completedExam.click();
//
//        WebElement reviewPage = findElement(By.id("reviewPage"));
//        Assert.assertTrue(reviewPage.isDisplayed(), "Exam review functionality failed");
//    }
//
//    @Test
//    public void verifyRetryExamFunctionality() {
//        completeExam();
//        navigateToCompletedExamsSection();
//
//        WebElement completedExam = findElement(By.id("completedExam"));
//        completedExam.click();
//
//        WebElement retryButton = findElement(By.id("retryButton"));
//        retryButton.click();
//
//        WebElement startExam = findElement(By.id("startExam"));
//        Assert.assertTrue(startExam.isDisplayed(), "Retry exam functionality failed");
//    }
//
//    @Test
//    public void verifyExamAccessibilityAcrossDevices() {
//        navigateToExamSummaryPage();
//
//        // Test on desktop
//        WebElement examPageDesktop = findElement(By.id("examPageDesktop"));
//        Assert.assertTrue(examPageDesktop.isDisplayed(), "Exam interface on desktop failed");
//
//        // Test on tablet
//        switchToDevice("tablet");
//        WebElement examPageTablet = findElement(By.id("examPageTablet"));
//        Assert.assertTrue(examPageTablet.isDisplayed(), "Exam interface on tablet failed");
//
//        // Test on mobile
//        switchToDevice("mobile");
//        WebElement examPageMobile = findElement(By.id("examPageMobile"));
//        Assert.assertTrue(examPageMobile.isDisplayed(), "Exam interface on mobile failed");
//    }
//
//    @Test
//    public void verifyPerformanceUnderLoad() {
//        simulateHighUserLoad();
//
//        WebElement startExam = findElement(By.id("startExam"));
//        Assert.assertTrue(startExam.isDisplayed(), "System response under high load failed");
//
//        WebElement completeExam = findElement(By.id("completeExam"));
//        Assert.assertTrue(completeExam.isDisplayed(), "System stability under high load failed");
//    }
//
//    private void login() {
//        UtilsSet.launchBrowserAndUrl("https://demo.subexpert.com/", Constants.Login.BY_LOGIN_BUTTON);
//        // Add login steps here
//    }
//
//    private void navigateToExamsPage() {
//        // Add navigation steps to Exams page
//    }
//
//    private void navigateToExamSummaryPage() {
//        // Add navigation steps to Exam Summary page
//    }
//
//    private void startExam() {
//        // Add steps to start the exam
//    }
//
//    private void waitForTimeLimit() {
//        // Add steps to wait until the time limit is reached
//    }
//
//    private void startExamWithNegativeMarking() {
//        // Add steps to start an exam with negative marking enabled
//    }
//
//    private void completeExam() {
//        // Add steps to complete the exam
//    }
//
//    private void navigateToCompletedExamsSection() {
//        // Add navigation steps to Completed Exams section
//    }
//
//    private void switchToDevice(String device) {
//        // Add steps to switch to a specific device (desktop, tablet, mobile)
//    }
//
//    private void simulateHighUserLoad() {
//        // Add steps to simulate high user load
//    }
//}
