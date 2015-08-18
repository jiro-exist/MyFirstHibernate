package com.exist.manio.myfirsthibernate.core.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.text.ParseException;

import com.exist.manio.myfirsthibernate.core.model.ContactType;
import com.exist.manio.myfirsthibernate.core.model.Constants;
import com.exist.manio.myfirsthibernate.core.model.GenderEnum;
import com.exist.manio.myfirsthibernate.core.dao.ContactTypeDao;

public class ContactTypeMenuService {

    public List<ContactType> getContactTypes() {
        ContactTypeDao contactTypeDao = new ContactTypeDao();
        List<ContactType> contactTypeList = contactTypeDao.queryContactType();
        return contactTypeList;
    }

}