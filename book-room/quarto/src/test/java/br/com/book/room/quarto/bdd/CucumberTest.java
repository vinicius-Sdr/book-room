package br.com.book.room.quarto.bdd;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CucumberTest {

}
