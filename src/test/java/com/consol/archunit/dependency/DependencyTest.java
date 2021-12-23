/*
package com.consol.archunit.dependency;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@SpringBootTest()
public class DependencyTest {

    @Test
    public void some_architecture_rule() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.consol.archunit.activity");

        ArchRule rule = classes().that().areAnnotatedWith(Component.class).or().haveNameMatching("*BA").should().resideInAnyPackage("..activity..");
        rule.check(importedClasses);
    }
}
*/
