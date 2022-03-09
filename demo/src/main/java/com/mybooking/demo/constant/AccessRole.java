package com.mybooking.demo.constant;

public enum AccessRole {

    CUSTOMER(1), ADMIN(2), PARTNER(3);
    int roleId;

    AccessRole(int roleId) {
        this.roleId = roleId;
    }

    public int getValue() {
        return this.roleId;
    }

    public static AccessRole getByType(int inType) {
        AccessRole retEnum = null;
        for (AccessRole ar : AccessRole.values()) {
            if (ar.getValue() == inType) {
                retEnum = ar;
                break;
            }
        }
        return retEnum;
    }
}
