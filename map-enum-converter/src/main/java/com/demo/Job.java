package com.demo;

public enum Job {
	FI_MGR("FI_MGR"),
	SA_MAN("SA_MAN"),
	ST_MAN("ST_MAN"),
	AC_ACCOUNT("AC_ACCOUNT"),
	HR_REP("HR_REP"),
	PU_MAN("PU_MAN"),
	SA_REP("SA_REP"),
	SH_CLERK("SH_CLERK"),
	PR_REP("PR_REP"),
	PU_CLERK("PU_CLERK"),
	AD_ASST("AD_ASST"),
	MK_MAN("MK_MAN"),
	AC_MGR("AC_MGR"),
	AD_PRES("AD_PRES"),
	FI_ACCOUNT("FI_ACCOUNT"),
	IT_PROG("IT_PROG"),
	AD_VP("AD_VP"),
	MK_REP("MK_REP"),
	ST_CLERK("ST_CLERK");

	private String jobId;
	
	private Job(String jobId) {
        this.jobId = jobId;
    }
 
    public String getJobId() {
        return jobId;
    }
 
    public static Job fromJobId(String shortName) {
        switch (shortName) {
        case "FI_MGR":
            return Job.FI_MGR;
 
        case "SA_MAN":
            return Job.SA_MAN;
 
        case "ST_MAN":
            return Job.ST_MAN;
 
        case "AC_ACCOUNT":
            return Job.AC_ACCOUNT;
 
        case "HR_REP":
            return Job.HR_REP;
            
        case "PU_MAN":
            return Job.PU_MAN;
            
        case "SA_REP":
            return Job.SA_REP;
            
        case "SH_CLERK":
            return Job.SH_CLERK;
            
        case "PR_REP":
            return Job.PR_REP;
            
        case "PU_CLERK":
            return Job.PU_CLERK;
            
        case "AD_ASST":
            return Job.AD_ASST;
            
        case "MK_MAN":
            return Job.MK_MAN;
            
        case "AC_MGR":
            return Job.AC_MGR;
            
        case "AD_PRES":
            return Job.AD_PRES;
            
        case "FI_ACCOUNT":
            return Job.FI_ACCOUNT;
            
        case "IT_PROG":
            return Job.IT_PROG;
            
        case "AD_VP":
            return Job.AD_VP;
            
        case "MK_REP":
            return Job.MK_REP;
            
        case "ST_CLERK":
            return Job.ST_CLERK;
        
        default:
            throw new IllegalArgumentException("JobId [" + shortName + "] not supported.");
        }
    }
}
