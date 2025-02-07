package com.workintech.members;

import java.util.HashSet;
import java.util.Set;

public abstract class MemberRecord {
    private static long idCounter = 0;
    private long memberId;
    private MemberType memberType;
    private String dateOfMembership;
    private int noBooksIssued=0;
    //private int maxBookLimit; //MemberType'da kullandım.
    private String name;
    private String address;
    private String phoneNo;
    private static Set<MemberRecord> memberList = new HashSet<>();

    public MemberRecord(MemberType memberType, String name, String address, String phoneNo) {
        this.memberId = ++idCounter ;
        this.memberType = memberType;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
        memberList.add(this);
    }

    public static Set<MemberRecord> getMemberList() {
        return memberList;
    }

    public static void setMemberList(Set<MemberRecord> memberList) {
        MemberRecord.memberList = memberList;
    }

    public static long getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(long idCounter) {
        MemberRecord.idCounter = idCounter;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

    public String getDateOfMembership() {
        return dateOfMembership;
    }

    public void setDateOfMembership(String dateOfMembership) {
        this.dateOfMembership = dateOfMembership;
    }

    public int getNoBooksIssued() {
        return noBooksIssued;
    }

    public void setNoBooksIssued(int noBooksIssued) {
        this.noBooksIssued = noBooksIssued;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }


    public abstract void getMember();
    public abstract void incBookIssued();
    public abstract void decBookIssued();
    public abstract void borrowList();
    public abstract void payBill();

}
