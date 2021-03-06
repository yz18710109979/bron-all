package com.jy.bron.core;

import java.lang.annotation.*;

//将方法标记为非线程安全的注释。
@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface NotThreadSafe {
}
