/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zipi.core.annotation;


import com.zipi.modules.contract.utils.IncrementalValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 *
 * 用来限定最小/最大值且是按照一定数递增 如最小为100，且按照50递增的数
 *
 * @author rooseek
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {IncrementalValidator.class})
public @interface IncrementalInteger {

    String message() default "{common.incrementalInteger.Pattern}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * @return value the element must be larger or equal to
     */
    int min();
    
    /**
     * @return value the element must be smaller or equal to 
     */
    int max();

    /**
     * @return value must be incremental
     */
    int increment();

    /**
     * Defines several {@link com.rmbbox.constraints.IncrementalInteger} annotations on the same
     * element.
     *
     * @see com.rmbbox.constraints.IncrementalInteger
     */
    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
    @Retention(RUNTIME)
    @Documented
    @interface List {

        IncrementalInteger[] value();
    }
}
