/**
 * 
 */

package com.pyongjjeom.test.scheduling;

import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * <pre>
 * com.pyongjjeom.test.scheduling 
 *    |_ QuartzTest.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
public class QuartzTest2 extends QuartzJobBean {

	private Logger log = Logger.getLogger(this.getClass());

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

		long time = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

		System.out.println("Cron trigger 2 (1 second): current time = " + sdf.format(time));
	}

}
