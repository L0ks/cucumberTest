package org.example.runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/wikipedia")
@ConfigurationParameter(key = "cucumber.plugin", value = "html:target/wikipedia-report.html")
@ConfigurationParameter(key = "cucumber.glue", value = "org.example.core,org.example.steps.wikipedia")
public class WikipediaTestRunner { }