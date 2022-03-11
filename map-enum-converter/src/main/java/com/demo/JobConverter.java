package com.demo;

import javax.persistence.AttributeConverter;

public class JobConverter implements AttributeConverter<Job, String> {

	@Override
	public String convertToDatabaseColumn(Job job) {
		return job.getJobId();
	}

	@Override
	public Job convertToEntityAttribute(String dbData) {
		return Job.fromJobId(dbData);
	}

}
