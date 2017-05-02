/**
 * 
 */
package com.kpg.diary;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kpg.diary.config.DiaryApplication;

/**
 * BaseTest.java
 * 
 * @author Nikhil Mahajan
 * @since Dec 3, 2016
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DiaryApplication.class)
public abstract class BaseTest {

}
