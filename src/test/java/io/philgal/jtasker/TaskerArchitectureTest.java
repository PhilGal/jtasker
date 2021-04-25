package io.philgal.jtasker;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import com.tngtech.archunit.lang.syntax.elements.MethodsShouldConjunction;
import org.junit.jupiter.api.Test;

public class TaskerArchitectureTest {

  private final JavaClasses importedClasses = new ClassFileImporter().importPackages("io.philgal");

  @Test
  void testTheAreNotStaticMethods() {
    MethodsShouldConjunction noStaticMethods = ArchRuleDefinition.methods().should().notBeStatic();
    noStaticMethods.check(importedClasses);
  }
}
