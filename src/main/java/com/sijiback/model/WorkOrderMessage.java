package com.sijiback.model;

import lombok.Data;

@Data
public class WorkOrderMessage {
    private int id;
    private String maintenance_time;
    private int status;
    private UserMessage maintenance_person;
    private FaultMessage fault;

    public WorkOrderMessage(int id, String maintenance_time, int status, UserMessage maintenance_person, FaultMessage fault) {
        this.id = id;
        this.maintenance_time = maintenance_time;
        this.status = status;
        this.maintenance_person = maintenance_person;
        this.fault = fault;
    }
}
