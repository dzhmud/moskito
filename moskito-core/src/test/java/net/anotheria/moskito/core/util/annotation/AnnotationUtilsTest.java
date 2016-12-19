package net.anotheria.moskito.core.util.annotation;

import org.junit.Test;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static net.anotheria.moskito.core.util.annotation.AnnotationUtils.findAnnotation;
import static net.anotheria.moskito.core.util.annotation.AnnotationUtils.findTypeAnnotation;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * @author bvanchuhov
 */
public class AnnotationUtilsTest {

    @Test
    public void testFindAnnotation_simpleAnnotation() throws Exception {
        @Config
        class MyClass {}

        assertTrue(findAnnotation(MyClass.class, Config.class).annotationType() == Config.class);
    }

    @Test
    public void testFindAnnotation_simpleAnnotation_classInheritance() throws Exception {
        @Config
        class Parent {}

        class Child extends Parent {}

        assertTrue(findAnnotation(Child.class, Config.class).annotationType() == Config.class);
    }

    @Test
    public void testFindAnnotation_annotationInheritance() throws Exception {
        @ChildConfig
        class MyClass {}

        assertTrue(findAnnotation(MyClass.class, Config.class).annotationType() == Config.class);
    }

    @Test
    public void testFindAnnotation_annotationInheritance_classInheritance() throws Exception {
        @ChildConfig
        class Parent {}

        class Child extends Parent {}

        assertTrue(findAnnotation(Child.class, Config.class).annotationType() == Config.class);
    }

    @Test
    public void testFindAnnotation_recursiveAnnotation() throws Exception {
        @RecursiveAnnotation
        class MyClass {}

        assertTrue(findAnnotation(MyClass.class, RecursiveAnnotation.class).annotationType() == RecursiveAnnotation.class);
    }

    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    private @interface Config {
    }

    @Config
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    private @interface ChildConfig {
    }

    @RecursiveAnnotation
    @Retention(RetentionPolicy.RUNTIME)
    private @interface RecursiveAnnotation {
    }


	@Retention(RetentionPolicy.RUNTIME)
	private @interface TypeAnnotation {
	}
	@Retention(RetentionPolicy.RUNTIME)
	private @interface ParentTypeAnnotation {
	}
	@Retention(RetentionPolicy.RUNTIME)
	private @interface SuperParentTypeAnnotation {
	}

	@Test
	public void testFindAnnotation_typeAnnotation() throws Exception {
		@SuperParentTypeAnnotation
		@ChildConfig
		class SuperParentTestClass {}
		@ParentTypeAnnotation
		class ParentTestClass extends SuperParentTestClass{}
		@TypeAnnotation
		class MyTestClass extends ParentTestClass {}

		assertTrue(findTypeAnnotation(MyTestClass.class, TypeAnnotation.class).annotationType() == TypeAnnotation.class);
		assertTrue(findTypeAnnotation(MyTestClass.class, ParentTypeAnnotation.class).annotationType() == ParentTypeAnnotation.class);
		assertTrue(findTypeAnnotation(MyTestClass.class, SuperParentTypeAnnotation.class).annotationType() == SuperParentTypeAnnotation.class);

		assertThat("Found absent annotation!", findTypeAnnotation(MyTestClass.class, Deprecated.class), nullValue());

		assertTrue(findTypeAnnotation(ChildConfig.class, Config.class).annotationType() == Config.class);
		assertTrue(findTypeAnnotation(MyTestClass.class, Config.class).annotationType() == Config.class);
	}
}