package com.demo;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/*
 * @Converter(autoApply = true) means, we tell the JPA provider to use it to map all Job enums. 
 * So we don’t need to use @Convert(converter = JobConverter.class) above entities field. 
 */
@Converter(autoApply = true)
public class JobConverter implements AttributeConverter<JobId, String> {

	@Override
	public String convertToDatabaseColumn(JobId job) {
		return job.getJobId();
	}

	@Override
	public JobId convertToEntityAttribute(String dbData) {
		return JobId.fromJobId(dbData);
	}

}
