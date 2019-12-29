package com.wawrzacz.mgrtaskbackend.Model;

public enum UpdateStatus {
    STATUS_NOT_SET,
    SAVE_OK, DELETE_OK, UPDATE_OK,
    SAVE_FAILED, DELETE_FAILED, UPDATE_FAILED,
    COULD_NOT_BE_SAVED, ALREADY_EXISTS, NOT_EXISTS;
}
