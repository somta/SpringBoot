package net.somta.springboot.scheduled.task;


import net.somta.springboot.scheduled.core.AbstractTask;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DbTask extends AbstractTask {

	@Override
	public void run() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date());
		System.out.println(date+" --- : 清洗DB数据");
	}

}
