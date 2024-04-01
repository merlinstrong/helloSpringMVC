package kr.ac.hansung.cse.service;

import kr.ac.hansung.cse.dao.OfferDao;
import kr.ac.hansung.cse.dao.UserDao;
import kr.ac.hansung.cse.model.Offer;
import kr.ac.hansung.cse.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    //service -> dao
    @Autowired
    private UserDao userDao;

    public List<User> getAllUsers(){
        return userDao.getUsers();
    }


}
