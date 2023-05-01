package com.demo;

public enum JobId {
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
	
	private JobId(String jobId) {
        this.jobId = jobId;
    }
 
    public String getJobId() {
        return jobId;
    }
 
    public static JobId fromJobId(String shortName) {
        switch (shortName) {
        case "FI_MGR":
            return JobId.FI_MGR;
 
        case "SA_MAN":
            return JobId.SA_MAN;
 
        case "ST_MAN":
            return JobId.ST_MAN;
 
        case "AC_ACCOUNT":
            return JobId.AC_ACCOUNT;
 
        case "HR_REP":
            return JobId.HR_REP;
            
        case "PU_MAN":
            return JobId.PU_MAN;
            
        case "SA_REP":
            return JobId.SA_REP;
            
        case "SH_CLERK":
            return JobId.SH_CLERK;
            
        case "PR_REP":
            return JobId.PR_REP;
            
        case "PU_CLERK":
            return JobId.PU_CLERK;
            
        case "AD_ASST":
            return JobId.AD_ASST;
            
        case "MK_MAN":
            return JobId.MK_MAN;
            
        case "AC_MGR":
            return JobId.AC_MGR;
            
        case "AD_PRES":
            return JobId.AD_PRES;
            
        case "FI_ACCOUNT":
            return JobId.FI_ACCOUNT;
            
        case "IT_PROG":
            return JobId.IT_PROG;
            
        case "AD_VP":
            return JobId.AD_VP;
            
        case "MK_REP":
            return JobId.MK_REP;
            
        case "ST_CLERK":
            return JobId.ST_CLERK;
        
        default:
            throw new IllegalArgumentException("JobId [" + shortName + "] not supported.");
        }
    }
}
