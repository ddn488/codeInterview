package coding;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//	Creating Custom Annotations
//	
//	Annotations are created by using @interface, followed by annotation name 
//	An annotation can have elements as well. They look like methods. For example in the below code, we have four elements. We should not provide implementation for these elements.
//	All annotations extends java.lang.annotation.Annotation interface. Annotations cannot include any extends clause.
//	defined the target type as METHOD which means the below annotation can only be used on methods

@Documented
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@interface CustomAnnotation {
	int studentAge() default 18;
	String studentName();
}

@CustomAnnotation(
		studentAge=20,
		studentName="Dennis Nguyen"
)
class CustomAnnotationTest {
	
	int studentAge;

	public static void main(String[] args) {
		CustomAnnotationTest test = new CustomAnnotationTest();
		System.out.println(test.studentAge);
	}
}
