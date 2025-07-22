package org.example.runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/demoqa/main")
@ConfigurationParameter(key = "cucumber.plugin", value = "html:target/demoqa-report.html")
@ConfigurationParameter(key = "cucumber.glue", value = "org.example.core,org.example.steps.demoqa")
public class DemoQATestRunner {}
