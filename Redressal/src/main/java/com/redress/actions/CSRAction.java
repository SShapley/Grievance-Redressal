package com.redress.actions;

import com.redress.dao.CSRDAO;
import com.redress.interfaces.CSRInterface;
import com.redress.models.Complaint;
import com.redress.models.CustomerDefect;
import com.redress.models.Department;
import com.redress.models.Technician;
import com.redress.models.User;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CSRAction implements CSRInterface{

	 private List<User> customerList = null;
	 private List<Complaint> complaintList = null;
	 private List<Department> departmentList = null;
	 private List<CustomerDefect> customerdefect = null;
	 private List<Technician> technicianList = null;

	 private String submitType;
	 private String firstname;
	 private String lastname;	 
     private String compltime;
     private String subject;
     private String description;
     private String prodname;
     private String prodmodel;
     private String startprog;
     private String ongoingprog;
     private String endprog;	    
     private int pid;
     private int techid;
     private int complid;
     private int compl_status;
     private int res_status;
     
	 private String msg = "";
	 private int ctr;
	    
	 
	 
	 private int deptid;
	 
	 CSRDAO csr = new CSRDAO();
	 private boolean noData = false;
	
	@Override
	public String showAllCustomers() {
		try {
            setCustomerList(new ArrayList<User>());
            setCustomerList(csr.customerList());
            if (!customerList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ALLCUSTOMERLIST";
	}

	@Override
	public String showActiveCustomers() {
		try {
            setCustomerList(new ArrayList<User>());
            setCustomerList(csr.customerList().stream().filter(user -> user.getUserstatus() == 1).collect(Collectors.toList()));
            if (!customerList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ACTIVECUSTOMERLIST";
	}

	@Override
	public String showInactiveCustomers() {
		try {
            setCustomerList(new ArrayList<User>());
            setCustomerList(csr.customerList().stream().filter(user -> user.getUserstatus() == 0).collect(Collectors.toList()));
            if (!customerList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "INACTIVECUSTOMERLIST";
	}

	@Override
	public String showDeletedCustomers() {
		try {
            setCustomerList(new ArrayList<User>());
            setCustomerList(csr.customerList().stream().filter(user -> user.getUserstatus() == 2).collect(Collectors.toList()));
            if (!customerList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "DELETEDCUSTOMERLIST";
	}

	@Override
	public String showAllTechnicians() {
		try {
            setTechnicianList(new ArrayList<Technician>());
            setTechnicianList(csr.getAllTechnician());
            if (!technicianList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SHOWALLTECHNICIANS";
	}

	@Override
	public String showActiveTechnicians() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String showInactiveTechnicians() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String showTechniciansByDeptID() {
		try {
            setTechnicianList(new ArrayList<Technician>());
            setTechnicianList(csr.fetchTechnician(getDeptid()));

            if (!technicianList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "TECHNICIANSBYDEPTID";
	}

	@Override
	public String showAllDepartments() {
		try {
            setDepartmentList(new ArrayList<Department>());
            setDepartmentList(csr.departmentList());

            if (!departmentList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ALLDEPARTEMNTLIST";
	}

	@Override
	public String showActiveDepartments() {
		try {
            setDepartmentList(new ArrayList<Department>());
            setDepartmentList(csr.departmentList().stream().filter(dept -> dept.getDeptstatus() == 1).collect(Collectors.toList()));

            if (!departmentList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ACTIVEDEPARTEMNTLIST";
	}

	@Override
	public String showInactiveDepartments() {
		try {
            setDepartmentList(new ArrayList<Department>());
            setDepartmentList(csr.departmentList().stream().filter(dept -> dept.getDeptstatus() == 0).collect(Collectors.toList()));

            if (!departmentList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "INACTIVEDEPARTEMNTLIST";
	}

	@Override
	public String showAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String showActiveProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String showInactiveProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String showAllComplaints() {
		try {
            setComplaintList(new ArrayList<Complaint>());
            setComplaintList(csr.complaintList());

            if (!complaintList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ALLCOMPLAINTLIST";
	}

	@Override
	public String showResolvedComplaints() {
		try {
            setComplaintList(new ArrayList<Complaint>());
            setComplaintList(csr.complaintList().stream().filter(complaint -> (complaint.getCompl_status() == 1)&&(complaint.getRes_status() == 1)).collect(Collectors.toList()));

            if (!complaintList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "RESOLVEDCOMPLAINTLIST";
	}

	@Override
	public String showUnresolvedComplaints() {
		try {
            setComplaintList(new ArrayList<Complaint>());
            setComplaintList(csr.complaintList().stream().filter(complaint -> (complaint.getCompl_status() == 1)&&(complaint.getRes_status() == 0)).collect(Collectors.toList()));

            if (!complaintList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "UNRESOLVEDCOMPLAINTLIST";
	}

	@Override
	public String showInitiatedComplaints() {
		try {
            setComplaintList(new ArrayList<Complaint>());
            setComplaintList(csr.complaintList().stream().filter(complaint -> (complaint.getCompl_status() == 0)).collect(Collectors.toList()));

            if (!complaintList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "INITIATEDCOMPLAINTLIST";
	}

	@Override
	public String showRejectedComplaints() {
		try {
            setComplaintList(new ArrayList<Complaint>());
            setComplaintList(csr.complaintList().stream().filter(complaint -> (complaint.getCompl_status() == 2)).collect(Collectors.toList()));

            if (!complaintList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "REJECTEDCOMPLAINTLIST";
	}

	@Override
	public String showComplaintByComplaintID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String showComplaintsByUserID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String showAllCustomerDefects() {
		try {
            setCustomerdefect(new ArrayList<CustomerDefect>());
            setCustomerdefect(csr.customerDefect());

            if (!customerdefect.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ALLCUSTOMERDEFECTS";
	}

	@Override
	public String showCustomerDefectByOwnerID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateComplaint() {
		try {
            if (getSubmitType().equals("updatedata")) {
                Complaint complaint = csr.fetchComplaintDetails(getComplid());
                if (complaint != null) {
                    setFirstname(complaint.getFirstname());
                    setLastname(complaint.getLastname());
                    setComplid(complaint.getComplid());
                    setCompltime(complaint.getCompltime());
                    setSubject(complaint.getSubject());
                    setDescription(complaint.getDescription());
                    setProdname(complaint.getProdname());
                    setProdmodel(complaint.getProdmodel());
                    setPid(complaint.getPid());
                    setTechid(complaint.getTechid());
                    setCompl_status(complaint.getCompl_status());
                    setStartprog(complaint.getStartprog());
                    setOngoingprog(complaint.getOngoingprog());
                    setEndprog(complaint.getEndprog());
                    setRes_status(complaint.getRes_status());
                }
            } else {
                setCtr(csr.updateComplaintDetails(complid, getTechid(), getCompl_status(), getStartprog(), getOngoingprog(), getEndprog(), getRes_status()));
                if (ctr > 0) {
                    setMsg("Record Updated Successfuly");
                } else {
                    setCtr(-1);
                    setMsg("some error occured.. Try again!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "UPDATECOMPLAINT";
	}



	public List<Technician> getTechnicianList() {
		return technicianList;
	}

	public void setTechnicianList(List<Technician> technicianList) {
		this.technicianList = technicianList;
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public List<CustomerDefect> getCustomerdefect() {
		return customerdefect;
	}

	public void setCustomerdefect(List<CustomerDefect> customerdefect) {
		this.customerdefect = customerdefect;
	}

	public List<Department> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}

	public List<Complaint> getComplaintList() {
		return complaintList;
	}

	public void setComplaintList(List<Complaint> complaintList) {
		this.complaintList = complaintList;
	}

	public List<User> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<User> customerList) {
		this.customerList = customerList;
	}

	public boolean isNoData() {
		return noData;
	}

	public void setNoData(boolean noData) {
		this.noData = noData;
	}

	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getComplid() {
		return complid;
	}

	public void setComplid(int complid) {
		this.complid = complid;
	}

	public String getCompltime() {
		return compltime;
	}

	public void setCompltime(String compltime) {
		this.compltime = compltime;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public String getProdmodel() {
		return prodmodel;
	}

	public void setProdmodel(String prodmodel) {
		this.prodmodel = prodmodel;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getTechid() {
		return techid;
	}

	public void setTechid(int techid) {
		this.techid = techid;
	}

	public int getCompl_status() {
		return compl_status;
	}

	public void setCompl_status(int compl_status) {
		this.compl_status = compl_status;
	}

	public String getStartprog() {
		return startprog;
	}

	public void setStartprog(String startprog) {
		this.startprog = startprog;
	}

	public String getOngoingprog() {
		return ongoingprog;
	}

	public void setOngoingprog(String ongoingprog) {
		this.ongoingprog = ongoingprog;
	}

	public String getEndprog() {
		return endprog;
	}

	public void setEndprog(String endprog) {
		this.endprog = endprog;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCtr() {
		return ctr;
	}

	public void setCtr(int ctr) {
		this.ctr = ctr;
	}

	public int getRes_status() {
		return res_status;
	}

	public void setRes_status(int res_status) {
		this.res_status = res_status;
	}
	
}
/*
    

   

    private String submitType;
    private String msg = "";
    private int complid;
    private String compltime;
    private String subject;
    private String description;
    private int pid;
    private int techid;
    private int compl_status;
    private String startprog;
    private String ongoingprog;
    private String endprog;
    private String prodname;
    private String prodmodel;
    private String firstname;
    private String lastname;
    private int ctr;
    private int res_status;

    public String updateComplaints() throws Exception {

        try {
            if (getSubmitType().equals("updatedata")) {
                Complaint complaint = csr.fetchComplaintDetails(getComplid());
                if (complaint != null) {
                    setFirstname(complaint.getFirstname());
                    setLastname(complaint.getLastname());
                    setComplid(complaint.getComplid());
                    setCompltime(complaint.getCompltime());
                    setSubject(complaint.getSubject());
                    setDescription(complaint.getDescription());
                    setProdname(complaint.getProdname());
                    setProdmodel(complaint.getProdmodel());
                    setPid(complaint.getPid());
                    setTechid(complaint.getTechid());
                    setCompl_status(complaint.getCompl_status());
                    setStartprog(complaint.getStartprog());
                    setOngoingprog(complaint.getOngoingprog());
                    setEndprog(complaint.getEndprog());
                    setRes_status(complaint.getRes_status());
                }
            } else {
                setCtr(csr.updateComplaintDetails(complid, getTechid(), getCompl_status(), getStartprog(), getOngoingprog(), getEndprog(), getRes_status()));
                if (ctr > 0) {
                    setMsg("Record Updated Successfuly");
                } else {
                    setCtr(-1);
                    setMsg("some error occured.. Try again!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "UPDATECOMPLAINT";
    }
    */
    