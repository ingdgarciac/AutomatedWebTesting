package com.automation.core.base;

import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/** Class to model the listeners for testng. */
@Slf4j
public class Listener implements ITestListener {

  @Override
  public void onTestStart(ITestResult result) {
    log.info(String.format("On test start %s", result.getName()));
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    log.info(String.format("On test success %s", result.getName()));
  }

  @Override
  public void onTestFailure(ITestResult result) {
    log.info(String.format("On test failure %s", result.getName()));
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    log.info(String.format("On test skipped %s", result.getName()));
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    log.info(String.format("On test failure with success percentage %s", result.getName()));
  }

  @Override
  public void onTestFailedWithTimeout(ITestResult result) {
    this.onTestFailure(result);
    log.info(String.format("On test failure with timeout %s", result.getName()));
  }

  @Override
  public void onStart(ITestContext context) {
    log.info(String.format("On start %s", context.getName()));
  }

  @Override
  public void onFinish(ITestContext context) {
    log.info(String.format("On finish %s", context.getName()));
  }
}
