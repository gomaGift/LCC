package Lcc.PayrollBatchService.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table (name="leaveRecords")
public class EmployeeLeaveRecord {
    public EmployeeLeaveRecord(LeaveRecordCompositeKey key, int commuted, LeaveType leaveType) {
        this.key = key;
        this.commuted = commuted;
        this.leaveType = leaveType;
    }

    public LeaveRecordCompositeKey getKey() {
        return key;
    }

    public void setKey(LeaveRecordCompositeKey key) {
        this.key = key;
    }

    public EmployeeLeaveRecord() {
    }

    public int getCommuted() {
        return commuted;
    }

    public void setCommuted(int commuted) {
        this.commuted = commuted;
    }

    @EmbeddedId
    private LeaveRecordCompositeKey key;
    private int commuted;
    private  LeaveType leaveType;

    public LeaveType getLeaveType() {
        return leaveType;
    }
    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }
}
