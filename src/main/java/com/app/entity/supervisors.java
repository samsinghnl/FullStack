package com.app.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class supervisors implements Comparable<supervisors> {
    int id; //"id":"1",
    String phone;
    String jurisdiction;
    String identificationNumber;
    String firstName;
    String lastName;


    public supervisors() {
    }

    public supervisors(int id, String phone, String jurisdiction, String identificationNumber, String firstName, String lastName) {
        this.id = id;
        this.phone = phone;
        this.jurisdiction = jurisdiction;
        this.identificationNumber = identificationNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public static List<supervisors> sortTheList(List<supervisors> supervisor) {
        for (int i = 0; i < supervisor.size(); i++) {
            for (int j = i + 1; j < supervisor.size(); j++) {
                if (supervisor.get(i).jurisdiction.compareTo(supervisor.get(j).jurisdiction) > 0) {
                    supervisors temp = supervisor.get(i);
                    supervisor.set(i, supervisor.get(j));
                    supervisor.set(j, temp);
                }else if (supervisor.get(i).jurisdiction.compareTo(supervisor.get(j).jurisdiction) == 0){
                    if (supervisor.get(i).lastName.compareTo(supervisor.get(j).lastName) > 0) {
                        supervisors temp = supervisor.get(i);
                        supervisor.set(i, supervisor.get(j));
                        supervisor.set(j, temp);
                    }else if (supervisor.get(i).lastName.compareTo(supervisor.get(j).lastName) == 0){
                        if (supervisor.get(i).firstName.compareTo(supervisor.get(j).firstName) > 0) {
                            supervisors temp = supervisor.get(i);
                            supervisor.set(i, supervisor.get(j));
                            supervisor.set(j, temp);
                        }
                    }
                }
            }
        }
        return supervisor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "supervisors{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", jurisdiction='" + jurisdiction + '\'' +
                ", identificationNumber='" + identificationNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public String getvalue() {
        return jurisdiction + "-" + lastName + " " + firstName;
    }

    @Override
    public int compareTo(supervisors o) {
        return o.getJurisdiction().compareTo(getJurisdiction()) != 0 ? o.getJurisdiction().compareTo(getJurisdiction()) : o.getLastName().compareTo(getLastName()) != 0 ? o.getLastName().compareTo(getLastName()) : o.getFirstName().compareTo(getFirstName());
    }
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
    public static List<supervisors> RemoveNumber(List<supervisors> supervisor) {
        List<supervisors> supervisorss=new ArrayList<>();
        for (supervisors s : supervisor) {
            if (supervisors.isInteger(s.getJurisdiction().trim()) == false){
                supervisorss.add(s);
            }
        }
        return supervisorss;
    }

}
